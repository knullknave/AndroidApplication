package com.android.medicServer.Base;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "episodes")
public class Episode implements Serializable
{
    private static final long serialVersionUID = 1L;
    public Episode()
    {

    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "descript")
    private String descript;
    @Temporal(TemporalType.DATE)
    @Column(name = "startdate")
    private Date startdate;
    @Temporal(TemporalType.DATE)
    @Column(name = "enddate")
    private Date enddate;
    @Column(name = "evolution")
    private String evolution;
    @Column(name = "disease")
    private String disease;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descr) {
        this.descript = descr;
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

    public String getEvolution() {
        return evolution;
    }

    public void setEvolution(String evolution) {
        this.evolution = evolution;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
}