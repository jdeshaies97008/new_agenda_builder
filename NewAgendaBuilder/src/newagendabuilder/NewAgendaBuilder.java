/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newagendabuilder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Sun
 */
public class NewAgendaBuilder extends Application {
    
    private BorderPane root;
    private MeetingPane meetingPane;
    private MemberPane memberPane;
    
    private Button meetingButton;
    private Button memberButton;
    
    private HBox outerTopBox;
    private VBox outerLeftBox;

    private static final String GUI_STYLE = "-fx-padding: 10;-fx-border-style: solid inside;-fx-border-width: 2;-fx-border-insets: 5;-fx-border-radius: 5;";
    private static final String GUI_COLOR_BLACK = "-fx-border-color: black;";
    private static final String GUI_COLOR_BLUE = "-fx-border-color: blue;";
    private static final String GUI_COLOR_RED = "-fx-border-color: red;";
    
    private void initObjects () {
        
        // Instantiate GUI Panes
        root = new BorderPane();
        meetingPane = new MeetingPane(null);
        meetingPane.setStyle(GUI_STYLE+GUI_COLOR_BLUE);
        
        memberPane = new MemberPane(null);
        memberPane.setStyle(GUI_STYLE+GUI_COLOR_RED);
        
        // Instantiate Buttons and Set Event Handlers Using Lambda
        meetingButton = new Button("Meetings");
        meetingButton.setOnAction(e -> root.setCenter(meetingPane));
        memberButton = new Button("Members");
        memberButton.setOnAction(e -> root.setCenter(memberPane));
        
        outerTopBox = new HBox(10);
        outerTopBox.setStyle(GUI_STYLE+GUI_COLOR_BLACK);
        outerLeftBox = new VBox(10);
        outerLeftBox.setStyle(GUI_STYLE+GUI_COLOR_BLACK);
        
    }
    
    @Override
    public void start(Stage primaryStage) {

        initObjects();
        
        // refactor
        Label appTitle = new Label("New Agenda Builder");
        outerTopBox.getChildren().add(appTitle);

        Label navLabel = new Label("Navigation");
        outerLeftBox.getChildren().addAll(navLabel, meetingButton, memberButton);
        
        root.setTop(outerTopBox);
        root.setLeft(outerLeftBox);
        
        // change to initial view at app start
        root.setCenter(meetingPane);
        
        Scene scene = new Scene(root, 1200, 800);
        
        primaryStage.setTitle("New Agenda Builder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
