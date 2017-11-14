/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newagendabuilder;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Sun
 */
public final class MemberPane extends BorderPane {
    
    private HBox innerTopBox;
    private VBox innerCenterBox;
    
    private final TableView<Member> memberTableView = new TableView<>();
    
    //private TableView<Person> personTableView = new TableView<Person>();
    //private TableColumn<Person,String> nameColumn = new TableColumn<>();
    
    private final TableColumn<Member,Integer> memberIDColumn = new TableColumn<>("Member ID");
    private final TableColumn<Member,SimpleStringProperty> firstNameColumn = new TableColumn<>("First Name");
    private final TableColumn<Member,String> lastNameColumn = new TableColumn<>("Last Name");
    private final TableColumn<Member,LocalDate> memberSinceDateColumn = new TableColumn<>("Member Since");
    
    public MemberPane (Node content) {
        super();
        display();
    }
    
    public void display() {
        innerTopBox = new HBox(10);
        innerTopBox.getChildren().add(new Label("Members"));
        
        
        memberIDColumn.setCellValueFactory(new PropertyValueFactory<>("memberID"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        memberSinceDateColumn.setCellValueFactory(new PropertyValueFactory<>("memberSinceDate"));

        //memberTableView = new TableView<Member>();
        
        memberTableView.setItems(populateMemberData());
        
        //nameColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("name"));
        
        memberTableView.getColumns().addAll(memberIDColumn, firstNameColumn, lastNameColumn, memberSinceDateColumn);
        
        
        innerCenterBox = new VBox(10);
        //innerCenterBox.getChildren().add(memberTableView);
        innerCenterBox.getChildren().add(memberTableView);
        
        this.setTop(innerTopBox);
        this.setCenter(innerCenterBox);
        
        //this.getChildren().add(innerTopBox);       
    }
    
    // to be refactored with embedded Java DB
    public ObservableList<Member> populateMemberData() {
        ObservableList<Member> members = FXCollections.observableArrayList();
        
        members.add(new Member("Tom", "Cronkite", LocalDate.now()));
        members.add(new Member("Jennifer", "Anderson", LocalDate.now()));
        members.add(new Member("Hilary", "Greenbaum", LocalDate.now()));
        members.add(new Member("Chris", "Aedo", LocalDate.now()));
        members.add(new Member("Steve", "Schmitt", LocalDate.now()));
        
        return members;
    }
}
