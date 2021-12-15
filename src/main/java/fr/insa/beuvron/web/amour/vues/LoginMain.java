/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beuvron.web.amour.vues;

import com.vaadin.flow.component.login.LoginForm;

/**
 *
 * @author francois
 */
public class LoginMain extends LoginForm {
    
    public LoginMain() {
        this.addLoginListener((event) -> {
            String nom = event.getUsername();
            String pass = event.getPassword();
        });
        
    }
    
}
