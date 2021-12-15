/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beuvron.web.amour.vues;

import fr.insa.beuvron.web.amour.VuePrincipale;
import fr.insa.beuvron.web.amour.model.Utilisateur;
import java.util.List;

/**
 *
 * @author francois
 */
public class UtilisateurSelectGrid extends UtilisateurGrid{ 
    
    public UtilisateurSelectGrid(VuePrincipale main,List<Utilisateur> datas) {
        super(main,datas);
        this.setSelectionMode(SelectionMode.MULTI);
    }
        
}
