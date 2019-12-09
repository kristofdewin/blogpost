package be.intecbrussel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;

    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String street;
    private String houseNr;
    private String city;
    private String zip;
    private String telephone;

    public int getAuthorId() {
        return authorId;
    }


    public String getUserName() {
        return userName;
    }

    public Author setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Author setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Author setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Author setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Author setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Author setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getHouseNr() {
        return houseNr;
    }

    public Author setHouseNr(String houseNr) {
        this.houseNr = houseNr;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Author setCity(String city) {
        this.city = city;
        return this;
    }

    public String getZip() {
        return zip;
    }

    public Author setZip(String zip) {
        this.zip = zip;
        return this;
    }

    public String getTelephone() {
        return telephone;
    }

    public Author setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }
}