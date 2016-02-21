package com.android.medicServer.Base;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import java.io.Serializable;

@Entity
@Table(name = "pharmacotherapy")
public class Pharmacotherapy implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "descript")
    private String descript;
    @Column(name = "dosage")
    private String dosage;
    @Temporal(TemporalType.DATE)
    @Column(name = "startdate")
    private Date startdate;
    @Temporal(TemporalType.DATE)
    @Column(name = "enddate")
    private Date enddate;
    @Column(name = "initialweight")
    private float initialWeight;
    @Column(name = "finalweight")
    private float finalWeight;
    @Column(name = "medicament")
    private String medicament;

    public Pharmacotherapy()
    {

    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getDescript()
    {
        return descript;
    }

    public void setDescript(String descript)
    {
        this.descript = descript;
    }

    public String getDosage()
    {
        return dosage;
    }

    public void setDosage(String dosage)
    {
        this.dosage = dosage;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getMedicament() {
        return medicament;
    }

    public void setMedicament(String medicament) {
        this.medicament = medicament;
    }

    public float getInitialWeight()
    {
        return initialWeight;
    }

    public void setInitialWeight(float initialWeight)
    {
        this.initialWeight = initialWeight;
    }

    public float getFinalWeight()
    {
        return finalWeight;
    }

    public void setFinalWeight(float finalWeight)
    {
        this.finalWeight = finalWeight;
    }
}