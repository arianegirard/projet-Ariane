/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beuvron.web.amour.vues;

import com.vaadin.flow.component.button.Button;
import fr.insa.beuvron.web.amour.VuePrincipale;

/**
 *
 * @author francois
 */
public class InitialLoginEntete extends MyHorizontalLayout {
    
    private VuePrincipale main;
    
    private Button vbLogin;
    private Button vbNouvelUtilisateur;
    
    public InitialLoginEntete(VuePrincipale main) {
        this.main = main;
        
        this.vbLogin = new Button("Login");
        this.vbLogin.addClickListener((event) -> {
            this.main.setMainContent(new LoginForm(this.main));
        });
        this.vbNouvelUtilisateur = new Button("Nouvel utilisateur");
        this.vbNouvelUtilisateur.addClickListener((t) -> {
            this.main.setMainContent(new NouvelUtilisateur(this.main));
        });
        this.add(this.vbLogin,this.vbNouvelUtilisateur);
    }
    
}
