/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beuvron.web.amour.vues;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import fr.insa.beuvron.web.amour.VuePrincipale;
import fr.insa.beuvron.web.amour.bdd.Aime;
import fr.insa.beuvron.web.amour.model.Utilisateur;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author francois
 */
public class PanneauShowAime extends MyVerticalLayout {

    private VuePrincipale main;

    public PanneauShowAime(VuePrincipale main) {
        this.main = main;
        this.add(new Paragraph("Note : normalement, on n'affiche pas les ids"));
        MyHorizontalLayout hlAime = new MyHorizontalLayout();
        hlAime.setWidthFull();
        MyVerticalLayout vlAime = new MyVerticalLayout();
        vlAime.add(new H3("vous aimez"));
        try {
            List<Utilisateur> datas = Aime.quiSontAimesPar(
                    this.main.getSessionInfo().getConBdD(), this.main.getSessionInfo().getCurUser().orElseThrow());
            vlAime.add(new UtilisateurGrid(datas));
        } catch (SQLException ex) {
            vlAime.add(new H1("Probleme BdD"));
        }
        hlAime.add(vlAime);
        MyVerticalLayout vlAimePar = new MyVerticalLayout();
        vlAimePar.add(new H3("vous êtes aimé par"));
        try {
            List<Utilisateur> datas = Aime.quiAiment(
                    this.main.getSessionInfo().getConBdD(), this.main.getSessionInfo().getCurUser().orElseThrow());
            vlAimePar.add(new UtilisateurGrid(datas));
        } catch (SQLException ex) {
            vlAimePar.add(new H1("Probleme BdD"));
        }
        hlAime.add(vlAimePar);
        this.add(hlAime);
        MyHorizontalLayout hlAime2 = new MyHorizontalLayout();
        hlAime2.setWidthFull();
        MyVerticalLayout vlPasAimes = new MyVerticalLayout();
        vlPasAimes.add(new H3("vous n'aimez pas"));
        try {
            List<Utilisateur> datas = Aime.quiNeSontPasAimesPar(
                    this.main.getSessionInfo().getConBdD(), this.main.getSessionInfo().getCurUser().orElseThrow());
            vlPasAimes.add(new UtilisateurGrid(datas));
        } catch (SQLException ex) {
            vlPasAimes.add(new H1("Probleme BdD"));
        }
        hlAime2.add(vlPasAimes);
        MyVerticalLayout vlAmis = new MyVerticalLayout();
        vlAmis.add(new H3("vos vrai amis"));
        try {
            List<Utilisateur> datas = Aime.vraiAmisDe(
                    this.main.getSessionInfo().getConBdD(), this.main.getSessionInfo().getCurUser().orElseThrow());
            vlAmis.add(new UtilisateurGrid(datas));
        } catch (SQLException ex) {
            vlAmis.add(new H1("Probleme BdD"));
        }
        hlAime2.add(vlAmis);
        this.add(hlAime2);
    }

}
