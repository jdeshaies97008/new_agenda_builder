/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newagendabuilder;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Sun
 */
public class Member {
    
    private final Integer memberID;
    private SimpleStringProperty firstName, lastName;
    private LocalDate memberSinceDate;
    
    private static Integer memberCount = 1;
    
    public Member (String firstName, String lastName, LocalDate memberSinceDate) {

        this.memberID = memberCount++;
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.memberSinceDate = memberSinceDate;
    }

    public Integer getMemberID () {
        return memberID;
    }
  
    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(SimpleStringProperty firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(SimpleStringProperty lastName) {
        this.lastName = lastName;
    }

    public LocalDate getMemberSinceDate() {
        return memberSinceDate;
    }

    public void setMemberSinceDate(LocalDate memberSinceDate) {
        this.memberSinceDate = memberSinceDate;
    }
    
    
}
