package org.dani.medicbook.base;

import java.util.Date;

public class Visit
{
    private int id;
    private String report;
    private String medicalCentre;
    private Date visitdate;
    private int idmedic;
    private int idpatient;
    private int idanalysis;
    private int idepisode;
    private int idradiography;
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

    public int getIdmedic()
    {
        return idmedic;
    }

    public void setIdmedic(int idmedic)
    {
        this.idmedic = idmedic;
    }

    public int getIdpatient()
    {
        return idpatient;
    }

    public void setIdpatient(int idpatient)
    {
        this.idpatient = idpatient;
    }

    public int getIdanalysis()
    {
        return idanalysis;
    }

    public void setIdanalysis(int idanalysis)
    {
        this.idanalysis = idanalysis;
    }

    public int getIdepisode()
    {
        return idepisode;
    }

    public void setIdepisode(int idepisode)
    {
        this.idepisode = idepisode;
    }

    public int getIdradiography()
    {
        return idradiography;
    }

    public void setIdradiography(int idradiography)
    {
        this.idradiography = idradiography;
    }

    public int getIdpharmacotherapy()
    {
        return idpharmacotherapy;
    }

    public void setIdpharmacotherapy(int idpharmacotherapy)
    {
        this.idpharmacotherapy = idpharmacotherapy;
    }
}