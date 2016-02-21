package org.dani.medicbook.base;

public class Medic
{
    private int id;
    private String username;
    private String pas;
    private String name;
    private String surname;
    private String adress;
    private String med;
    private String email;
    private String spec;
    private String telephone;
    private int idFoto;

    public Medic()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPas() {
        return pas;
    }

    public void setPas(String pas) {
        this.pas = pas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getMed() {
        return med;
    }

    public void setMed(String med) {
        this.med = med;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String toString()
    {
        return this.surname + ", " + this.name + "(" + this.id + ")";
    }

    public int getIdFoto()
    {
        return idFoto;
    }

    public void setIdFoto(int idFoto)
    {
        this.idFoto = idFoto;
    }
}