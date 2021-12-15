/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beuvron.web.amour.vues;

import com.vaadin.flow.component.grid.Grid;
import fr.insa.beuvron.web.amour.VuePrincipale;
import fr.insa.beuvron.web.amour.model.Utilisateur;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author francois
 */
public class UtilisateurGrid extends Grid<Utilisateur>{ 
    
    private List<Utilisateur> datas;
    
    public UtilisateurGrid(List<Utilisateur> datas) {
        this.datas = datas;
        
        Column<Utilisateur> cID = this.addColumn(Utilisateur::getId)
                .setHeader("ID");
        cID.setWidth("3em");
        Column<Utilisateur> cNom = this.addColumn(Utilisateur::getNom)
                .setHeader("Nom");
        cNom.setSortable(true);
        
        this.setItems(datas);
        // pour affichage compact pour transparents
        // this.setMaxHeight("12em");
    }
    
    public void addUtilisateurs(Collection<Utilisateur> toAdd) {
        this.datas.addAll(toAdd);
        this.setItems(this.datas);
    }
    
    public void removeUtilisateurs(Collection<Utilisateur> toRemove) {
        this.datas.removeAll(toRemove);
        this.setItems(this.datas);
    }

    /**
     * @return the datas
     */
    public List<Utilisateur> getDatas() {
        return datas;
    }
    


    
}
