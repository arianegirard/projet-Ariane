/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beuvron.web.amour.vues;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import fr.insa.beuvron.web.amour.VuePrincipale;
import fr.insa.beuvron.web.amour.bdd.Aime;
import fr.insa.beuvron.web.amour.model.Utilisateur;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

/**
 *
 * @author francois
 */
public class LoginForm extends MyVerticalLayout{
    
    private VuePrincipale main;
    
    private TextField vnom;
    private PasswordField vpass;
    private Button vbLogin;
    
    public LoginForm(VuePrincipale main) {
        this.main = main;
        this.vnom = new TextField("nom");
        this.vpass = new PasswordField("pass");
        this.vbLogin = new Button("login");
        this.add(this.vnom,this.vpass,this.vbLogin);
        this.vbLogin.addClickListener((event) -> {
            this.doLogin();
        });
    }
    
    public void doLogin() {
        String nom = this.vnom.getValue();
        String pass = this.vpass.getValue();
        try {
            Connection con = this.main.getSessionInfo().getConBdD();
            Optional<Utilisateur> user = Aime.login(con, nom, pass);
            if(user.isEmpty()) {
                Notification.show("Utilisateur ou pass invalide");
            } else {
                this.main.getSessionInfo().setCurUser(user);
                this.main.setEntete(new EnteteAfterLogin(this.main));
                this.main.setMainContent(new MainAfterLogin(this.main));
            }
        } catch (SQLException ex) {
            Notification.show("Problème interne : " + ex.getLocalizedMessage());
        }        
    }
}
