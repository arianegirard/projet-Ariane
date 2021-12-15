/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beuvron.web.amour.vues;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import fr.insa.beuvron.web.amour.VuePrincipale;
import fr.insa.beuvron.web.amour.bdd.Aime;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author francois
 */
public class InitOrResetDatabase extends MyVerticalLayout {

    private VuePrincipale main;
    
    private Button vbInitDatabase;

    public InitOrResetDatabase(VuePrincipale main) {
        this.main = main;

        Paragraph note = new Paragraph("Note : normalement ce panneau ne devrait pas faire partie "
                + "de l'interface web : la création de la base de donnée se fait une fois pour "
                + "toute par l'administrateur système, en général hors de l'interface web");
        note.getStyle().set("font-family", "Monospace")
                .set("font-size", "0.8em").set("color", "red")
                .set("font-style", "italic");
        this.add(note);
        this.getStyle().set("border", "2px solid " + "red");
        
        this.vbInitDatabase = new Button("Initialisation ou ré-initialisation de la base de donnée");
        this.vbInitDatabase.addClickListener((event) -> {
            Connection con = this.main.getSessionInfo().getConBdD();
            try {
                Aime.recreeTout(con);
                Notification.show("OK : BdD (ré)-initialisée");
            } catch (SQLException ex) {
                Notification.show("Problème : "+ex.getLocalizedMessage());
            }
        });
        this.add(this.vbInitDatabase);

    }
}
