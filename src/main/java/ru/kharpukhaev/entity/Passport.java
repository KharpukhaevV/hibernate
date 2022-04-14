package ru.kharpukhaev.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "passports")
public class Passport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "passport_id",unique=true, nullable = false)
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "serial")
    private String serial;

    @Column(name = "number")
    private String number;

    @OneToOne(mappedBy = "passport", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Client client;

    public Passport() {
    }

    public Passport(String firstName, String lastName, String serial, String number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.serial = serial;
        this.number = number;
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

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Passport:" +
                " serial=" + serial +
                ", number=" + number;
    }
}
