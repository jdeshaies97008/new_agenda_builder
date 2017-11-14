/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newagendabuilder;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author Sun
 */
public final class MeetingPane extends BorderPane {
    
    private HBox innerTopBox;
    
    public MeetingPane (Node Content) {
        super();
        display();
    }
    
    public void display() {
        innerTopBox = new HBox(10);
        innerTopBox.getChildren().add(new Label("Meetings"));
        this.setTop(innerTopBox);
        //this.getChildren().add(innerTopBox);
    }
}
