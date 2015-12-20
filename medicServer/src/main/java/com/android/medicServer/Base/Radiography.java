package com.android.medicServer.Base;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "radiography")
@Component("Radiography")
public class Radiography implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "study")
    private String study;
    @Column(name = "report")
    private String report;
    @Column(name = "controldone")
    private String controldone;
    @Temporal(TemporalType.DATE)
    @Column(name = "reportdate")
    private Date reportdate;
    @Temporal(TemporalType.DATE)
    @Column(name = "receptiondate")
    private Date receptiondate;
    @Temporal(TemporalType.DATE)
    @Column(name = "radiographydate")
    private Date radiographydate;
    @Column(name = "idvisit")
    private int idvisit;

    public Radiography()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getControldone() {
        return controldone;
    }

    public void setControldone(String controldone) {
        this.controldone = controldone;
    }

    public Date getReportdate() {
        return reportdate;
    }

    public void setReportdate(Date reportdate) {
        this.reportdate = reportdate;
    }

    public Date getReceptiondate() {
        return receptiondate;
    }

    public void setReceptiondate(Date receptiondate) {
        this.receptiondate = receptiondate;
    }

    public Date getRadiographydate() {
        return radiographydate;
    }

    public void setRadiographydate(Date radiographydate) {
        this.radiographydate = radiographydate;
    }

    public int getIdvisit() {
        return idvisit;
    }

    public void setIdvisit(int idvisit) {
        this.idvisit = idvisit;
    }
}
