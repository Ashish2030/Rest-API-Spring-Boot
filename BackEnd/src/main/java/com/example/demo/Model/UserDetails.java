package com.example.demo.Model;
import javax.persistence.*;

@Entity
public class UserDetails {
    public UserDetails() {

    }

    public UserDetails(String firstName, String lastName, String number, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)   //unique id khudh generate karo
    public Integer id;
    private String firstName;
    private String lastName;
    private String number;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


