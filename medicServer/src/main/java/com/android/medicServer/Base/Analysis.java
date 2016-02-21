package com.android.medicServer.Base;

import java.io.Serializable;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "analysis")
public class Analysis implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    @Column(name = "analysistype")
    private String analysistype;
    @Column(name = "report")
    private String report;
    @Temporal(TemporalType.DATE)
    @Column(name = "analysisdate")
    private Date analysisdate;
    @Temporal(TemporalType.DATE)
    @Column(name = "reportdate")
    private Date reportDate;

    public Analysis()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnalysistype() {
        return analysistype;
    }

    public void setAnalysistype(String analysistype) {
        this.analysistype = analysistype;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public Date getAnalysisdate() {
        return analysisdate;
    }

    public void setAnalysisdate(Date analysisdate) {
        this.analysisdate = analysisdate;
    }

    public Date getReportDate()
    {
        return reportDate;
    }

    public void setReportDate(Date reportDate)
    {
        this.reportDate = reportDate;
    }
}