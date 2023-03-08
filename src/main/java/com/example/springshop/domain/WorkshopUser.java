package com.example.springshop.domain;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "workshopusers")
public class WorkshopUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String voornaam;
    @NotNull
    private String familienaam;
    @NotNull
    private String email;
    @NotNull
    private long leeftijd;

    protected WorkshopUser() {
    }

    public WorkshopUser(String voornaam, String familienaam, String email, long leeftijd) {
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.email = email;
        this.leeftijd = leeftijd;
    }


    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public void setFamilienaam(String familienaam) {
        this.familienaam = familienaam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(long leeftijd) {
        this.leeftijd = leeftijd;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
