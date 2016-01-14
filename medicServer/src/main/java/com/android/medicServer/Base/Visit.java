package com.android.medicServer.Base;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "visit")
public class Visit implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "report")
    private String report;
    @Column(name = "medicalcentre")
    private String medicalCentre;
    @Temporal(TemporalType.DATE)
    @Column(name = "visitdate")
    private Date visitdate;
    @Column(name = "idmedic")
    private int idmedic;
    @Column(name = "idpatient")
    private int idpatient;
    @Column(name = "idanalysis")
    private int idanalysis;
    @Column(name = "idepisode")
    private int idepisode;
    @Column(name = "idradiography")
    private int idradiography;
    @Column(name = "idpharmacotherapy")
    private int idpharmacotherapy;

    public Visit()
    {

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getReport()
    {
        return report;
    }

    public void setReport(String report)
    {
        this.report = report;
    }

    public String getMedicalCentre()
    {
        return medicalCentre;
    }

    public void setMedicalCentre(String medicalCentre)
    {
        this.medicalCentre = medicalCentre;
    }

    public Date getVisitDate()
    {
        return visitdate;
    }

    public void setVisitDate(Date visitdate)
    {
        this.visitdate = visitdate;
    }

    public int getIdmedic() {
        return idmedic;
    }

    public void setIdmedic(int idmedic) {
        this.idmedic = idmedic;
    }

    public int getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(int idpatient) {
        this.idpatient = idpatient;
    }

    public int getIdanalysis() {
        return idanalysis;
    }

    public void setIdanalysis(int idanalysis) {
        this.idanalysis = idanalysis;
    }

    public int getIdepisode() {
        return idepisode;
    }

    public void setIdepisode(int idepisode) {
        this.idepisode = idepisode;
    }

    public int getIdradiography() {
        return idradiography;
    }

    public void setIdradiography(int idradiography) {
        this.idradiography = idradiography;
    }

    public int getIdpharmacotherapy() {
        return idpharmacotherapy;
    }

    public void setIdpharmacotherapy(int idpharmacotherapy) {
        this.idpharmacotherapy = idpharmacotherapy;
    }
}
