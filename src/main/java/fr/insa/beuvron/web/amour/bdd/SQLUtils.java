/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beuvron.web.amour.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author francois
 */
public class SQLUtils {

    public static class ResultSetAsList {

        private final List<String> entetes;
        private final List<List<Object>> valeurs;

        public ResultSetAsList(List<String> entetes, List<List<Object>> valeurs) {
            this.entetes = entetes;
            this.valeurs = valeurs;
        }

    }

    public static ResultSetAsList asLists(Connection con, PreparedStatement pst) throws SQLException {
        try ( ResultSet rs = pst.executeQuery()) {
            ResultSetMetaData meta = rs.getMetaData();
            List<String> entetes = new ArrayList<>(meta.getColumnCount());
            for (int c = 1; c <= meta.getColumnCount(); c++) {
                entetes.add(meta.getColumnName(c));
            }
            List<List<Object>> datas = new ArrayList<>(meta.getColumnCount());
            while (rs.next()) {
                List<Object> ligne = new ArrayList<>();
                for (int c = 1; c <= meta.getColumnCount(); c++) {
                    ligne.add(rs.getObject(c));
                }
                datas.add(ligne);
            }
            return new ResultSetAsList(entetes, datas);
        }
    }

}
