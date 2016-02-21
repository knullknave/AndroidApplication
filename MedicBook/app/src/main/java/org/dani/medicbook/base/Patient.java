package org.dani.medicbook.base;

import java.util.Date;

public class Patient
{
    private int id;
    private String username;
    private String pas;
    private String name;
    private String surname;
    private char sex;
    private String adress;
    private Date birthdate;
    private String telephone;
    private char bloodtype;
    private int idFoto;

    public Patient()
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

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public char getBloodtype()
    {
        return bloodtype;
    }

    public void setBloodtype(char bloodtype)
    {
        this.bloodtype = bloodtype;
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