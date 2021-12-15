/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beuvron.web.amour.vues;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import fr.insa.beuvron.web.amour.VuePrincipale;

/**
 *
 * @author francois
 */
public class BienvenueMainVue extends MyVerticalLayout{
    
    private VuePrincipale main;
    
    public BienvenueMainVue(VuePrincipale main) {
        this.main = main;
        this.add(new H1("bienvenu dans ce super programme"));
        this.add(new Paragraph("merci de vous connecter"));
        if (ConfigGenerale.AFFICHE_RAZ_DATABASE) {
            this.add(new InitOrResetDatabase(this.main));
        }
    }
    
}
