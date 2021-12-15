/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beuvron.web.amour.vues;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import fr.insa.beuvron.web.amour.VuePrincipale;
import fr.insa.beuvron.web.amour.bdd.Aime;
import fr.insa.beuvron.web.amour.model.Utilisateur;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author francois
 */
public class NouvelUtilisateur extends FormLayout {
    
    private VuePrincipale main;
    
    private TextField vtNom;
    private PasswordField vtPass;
    private Button vbValidate;

    public NouvelUtilisateur(VuePrincipale main) {
        this.main = main;
        this.vtNom = new TextField("nom");
        this.vtPass = new PasswordField("pass");
        this.vbValidate = new Button("Valider");
        this.vbValidate.addClickListener((event) -> {
            Connection con = this.main.getSessionInfo().getConBdD();
            String nom = this.vtNom.getValue();
            String pass = this.vtPass.getValue();
            try {
                if (Aime.nomUtilisateurExiste(con, nom)) {
                    Notification.show("Ce nom existe déjà, choississez en un autre");
                } else {
                    int id = Aime.createUtilisateur(con, nom,pass);
                    Utilisateur curU = new Utilisateur(id, nom, pass);
                    this.main.getSessionInfo().setCurUser(Optional.of(curU));
                    Notification.show("Utilisateur " + nom + " créé");
                    this.main.setMainContent(new MainAfterLogin(this.main));
                    this.main.setEntete(new EnteteAfterLogin(this.main));
                }
            } catch (SQLException ex) {
                Notification.show("Problème BdD : " + ex.getLocalizedMessage());
            }
        });
        this.add(this.vtNom,this.vtPass,this.vbValidate);
    }
    
    
    
}
