/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vaadinstarter;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 *
 * @author francois
 */
@Route(value = "")
public class VuePrincipale extends VerticalLayout {

    private Button vbCoucou;

    public VuePrincipale() {
        this.vbCoucou = new Button("dis coucou");
        this.vbCoucou.addClickListener((t) -> {
            Notification.show("coucou !");
        });
        this.add(this.vbCoucou);
    }

}
