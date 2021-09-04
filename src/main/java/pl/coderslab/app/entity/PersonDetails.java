package pl.coderslab.app.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "personDetails")
public class PersonDetails {

    @OneToOne
    private Person person;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private int streetNumber;
    private String street;
    private String city;

    public PersonDetails(String firstName, String lastName, int streetNumber, String street, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetNumber = streetNumber;
        this.street = street;
        this.city = city;
    }

    public PersonDetails() {

    }
}
