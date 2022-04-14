package ru.kharpukhaev.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "client_id",unique=true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private Passport passport;

    public Client() {
    }

    public Client(String name, Passport passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }
}
