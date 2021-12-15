/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beuvron.web.amour.vues;

import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import fr.insa.beuvron.web.amour.VuePrincipale;

/**
 *
 * @author francois
 */
public class MainAfterLogin extends MyVerticalLayout {

    private VuePrincipale main;

    private Tab aimeCurrentUser;
    private Tab changeAime;
    private Tabs allTabs;

    private MyVerticalLayout tabContent;

    public MainAfterLogin(VuePrincipale main) {
        this.main = main;

        this.aimeCurrentUser = new Tab("Amours de "
                + this.main.getSessionInfo().getUserName());

        this.changeAime = new Tab("modifier");
        this.allTabs = new Tabs(this.aimeCurrentUser, this.changeAime);
        this.allTabs.addSelectedChangeListener(event
                -> setTabContent(event.getSelectedTab())
        );
        this.tabContent = new MyVerticalLayout();
        this.tabContent.setHeightFull();
        this.tabContent.setWidthFull();
        this.tabContent.getStyle().set("border", "1px solid black");
        this.add(this.allTabs, this.tabContent);
        this.allTabs.setSelectedTab(this.aimeCurrentUser);
        this.tabContent.add(new PanneauShowAime(this.main));
    }

    public void setTabContent(Tab curTab) {
        this.tabContent.removeAll();
        if (curTab == this.aimeCurrentUser) {
            this.tabContent.add(new PanneauShowAime(this.main));
        } else if (curTab == this.changeAime) {
            this.tabContent.add(new PanneauModifyAime(this.main));
        }

    }
}
