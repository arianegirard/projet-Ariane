/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beuvron.web.amour;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import fr.insa.beuvron.web.amour.bdd.Aime;
import fr.insa.beuvron.web.amour.vues.BdDNonAccessible;
import fr.insa.beuvron.web.amour.vues.BienvenueMainVue;
import fr.insa.beuvron.web.amour.vues.InitialLoginEntete;
import fr.insa.beuvron.web.amour.vues.MyHorizontalLayout;
import fr.insa.beuvron.web.amour.vues.MyVerticalLayout;
import java.sql.SQLException;

/**
 * vue principale.
 * pour les composants vaadin, voir https://vaadin.com/docs/latest/ds/components
 * @author francois
 */
@Route(value = "")
@PageTitle("Amours")
public class VuePrincipale extends MyVerticalLayout {
    

    private SessionInfo sessionInfo;

    private MyHorizontalLayout entete;
    private MyVerticalLayout mainContent;

    public void setEntete(Component c) {
        this.entete.removeAll();
        this.entete.add(c);
    }

    public void setMainContent(Component c) {
        this.mainContent.removeAll();
        this.mainContent.add(c);
    }

    public VuePrincipale() {
        this.sessionInfo = new SessionInfo();
        this.entete = new MyHorizontalLayout();
        this.entete.setWidthFull();
        this.add(this.entete);

        this.mainContent = new MyVerticalLayout();
        this.mainContent.setWidthFull();
        this.mainContent.setHeightFull();
        this.add(this.mainContent);
        try {
            this.sessionInfo.setConBdD(Aime.defautConnect());
            this.setEntete(new InitialLoginEntete(this));
            this.setMainContent(new BienvenueMainVue(this));
        } catch (ClassNotFoundException | SQLException ex) {
            this.setMainContent(new BdDNonAccessible(this));
        }

    }

    
    /**
     * @return the sessionInfo
     */
    public SessionInfo getSessionInfo() {
        return sessionInfo;
    }

}
