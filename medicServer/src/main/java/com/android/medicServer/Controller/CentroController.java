package com.android.medicServer.Controller;


import com.android.medicServer.Base.Centro;
import com.android.medicServer.Repository.CentroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CentroController
{
    @Autowired
    private CentroRepository repository;

    @RequestMapping("/centros")
    public List<Centro> getCentros()
    {
        List<Centro> listaCentros = repository.findAll();
        return listaCentros;
    }

    @RequestMapping("/centro")
    public List<Centro> findById(int id)
    {
        List<Centro> listaCentros = repository.findById(id);
        return listaCentros;
    }

    @RequestMapping("/add_centro")
    public void addPatient(
            @RequestParam(value = "id") int id,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "positionx", defaultValue = "nada") float positionx,
            @RequestParam(value = "positiony", defaultValue = "nada") float positiony,
            @RequestParam(value = "icon") String icon)

    {
        Centro c = new Centro();
        if(id != 0)
            c.setId(id);
        c.setName(name);
        c.setPositionx(positionx);
        c.setPositiony(positiony);
        c.setIcon(icon);
        repository.save(c);
    }

    @RequestMapping("/delete_centro")
    public void deletePatient( @RequestParam(value = "id") int id)
    {
        repository.delete(id);
    }
}
