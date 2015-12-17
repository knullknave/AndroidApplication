package com.android.dani.medicdb;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "medic")
public class Medic
{
    @Id
    @GeneratedValue
    private int collegiateNumber;
    @Column
    private String userName;
    @Column
    private String userPassword;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String adress;
    @Column
    private String medicalCentre;
    @Column
    private String email;
    @Column
    private String medicalSpeciality;
    @Column
    private String telephone;
    @Column
    private Date birthDate;

    public Medic()
    {

    }

    public int getCollegiateNumber()
    {
        return collegiateNumber;
    }

    public void setCollegiateNumber(int collegiateNumber)
    {
        this.collegiateNumber = collegiateNumber;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserPassword()
    {
        return userPassword;
    }

    public void setUserPassword(String userPassword)
    {
        this.userPassword = userPassword;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getAdress()
    {
        return adress;
    }

    public void setAdress(String adress)
    {
        this.adress = adress;
    }

    public String getMedicalCentre()
    {
        return medicalCentre;
    }

    public void setMedicalCentre(String medicalCentre)
    {
        this.medicalCentre = medicalCentre;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getMedicalSpeciality()
    {
        return medicalSpeciality;
    }

    public void setMedicalSpeciality(String medicalSpeciality)
    {
        this.medicalSpeciality = medicalSpeciality;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public Date getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }
}