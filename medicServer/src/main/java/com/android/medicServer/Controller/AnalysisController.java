package com.android.medicServer.Controller;

import com.android.medicServer.Base.Analysis;
import com.android.medicServer.Repository.AnalysisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class AnalysisController
{
    @Autowired
    private AnalysisRepository repository;

    @RequestMapping("/analisis")
    public List<Analysis> getAnalysis()
    {
        List<Analysis> listaAnalisis = repository.findAll();
        return listaAnalisis;
    }

    @RequestMapping("/analis")
    List<Analysis> findById(int id)
    {
        List<Analysis> listaAnalisis = repository.findById(id);
        return listaAnalisis;
    }

    @RequestMapping("/add_analysis")
    public void addAnalysis(
            @RequestParam(value = "analysisdate", defaultValue = "nada") String analysisDate,
            @RequestParam(value = "analysistype", defaultValue = "nada") String analysistype,
            @RequestParam(value = "report", defaultValue = "nada") String report,
            @RequestParam(value = "reportdate", defaultValue = "nada") String reportDate)
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Analysis a = new Analysis();
        try
        {
            a.setAnalysisdate(df.parse(analysisDate));
            a.setAnalysistype(analysistype);
            a.setReport(report);
            a.setReportDate(df.parse(reportDate));
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        repository.save(a);
    }

    @RequestMapping("/delete_analysis")
    public void deleteAnalysis(int id)
    {
        repository.delete(id);
    }
}
