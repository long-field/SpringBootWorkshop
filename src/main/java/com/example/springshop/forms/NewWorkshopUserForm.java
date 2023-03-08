package com.example.springshop.forms;

public class NewWorkshopUserForm {


    private String voornaam;

    private String familienaam;

    private String email;

    private long leeftijd;

    public NewWorkshopUserForm(String voornaam, String familienaam, String email, long leeftijd) {
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.email = email;
        this.leeftijd = leeftijd;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public String getEmail() {
        return email;
    }

    public long getLeeftijd() {
        return leeftijd;
    }
}
