/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beuvron.web.amour.vues;

import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import fr.insa.beuvron.web.amour.VuePrincipale;
import fr.insa.beuvron.web.amour.bdd.Aime;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author francois
 */
public class ListeDesUtilisateurs extends VerticalLayout {
    
    private VuePrincipale main;
    
    private UtilisateurGrid vgAllUsers;

    public ListeDesUtilisateurs(VuePrincipale main) {
        this.main = main;
        this.add(new H3("liste de tous les utilisateurs"));
        try {
            this.vgAllUsers = new UtilisateurGrid(
                    Aime.tousLesUtilisateurs(this.main.getSessionInfo().getConBdD()));
            this.add(this.vgAllUsers);
        } catch (SQLException ex) {
            this.add(new H3("Problème BdD : " + ex.getLocalizedMessage()));
        }
    }
}
