/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beuvron.web.amour.vues;

import com.vaadin.flow.component.html.H1;
import fr.insa.beuvron.web.amour.VuePrincipale;

/**
 *
 * @author francois
 */
public class BdDNonAccessible extends MyVerticalLayout {
    
    private VuePrincipale main;
    
    public BdDNonAccessible(VuePrincipale main) {
        this.main = main;
        this.add(new H1("Base de donnée non accessible"));
        if (ConfigGenerale.AFFICHE_PANNEAU_CONNEXION_BDD) {
            this.add(new DefConnectionBDD(main));
        }
    }
    
}
