/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beuvron.web.amour.vues;

import com.vaadin.flow.component.button.Button;
import fr.insa.beuvron.web.amour.VuePrincipale;
import java.util.Optional;

/**
 *
 * @author francois
 */
public class EnteteAfterLogin extends MyHorizontalLayout {
    private VuePrincipale main;
    
    private Button vbLogout;
    private Button vbListeDesUtilisateurs;
    private Button vbGestionAmours;
    
    public EnteteAfterLogin(VuePrincipale main) {
        this.main = main;
        
        this.vbLogout = new Button("logout");
        this.vbLogout.addClickListener((event) -> {
            this.doLogout();
        });
        this.vbListeDesUtilisateurs = new Button("liste des utilisateurs");
        this.vbListeDesUtilisateurs.addClickListener((event) -> {
            this.main.setMainContent(new ListeDesUtilisateurs(this.main));
        });
        this.vbGestionAmours = new Button("Gérer vos amours");
        this.vbGestionAmours.addClickListener((event) -> {
            this.main.setMainContent(new MainAfterLogin(this.main));
        });
        this.add(this.vbLogout,this.vbListeDesUtilisateurs,this.vbGestionAmours);
    }
    
    public void doLogout() {
        this.main.getSessionInfo().setCurUser(Optional.empty());
        this.main.setEntete(new InitialLoginEntete(this.main));
        this.main.setMainContent(new BienvenueMainVue(this.main));
    }
    
}
