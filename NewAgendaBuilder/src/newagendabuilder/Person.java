/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newagendabuilder;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Sun
 */
public class Person {
    
    private SimpleStringProperty name;
    
    public Person (String name) {
        this.name = new SimpleStringProperty(name);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }
    
    
}
