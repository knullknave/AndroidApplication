package com.android.medicServer.Controller;

import com.android.medicServer.Base.Pharmacotherapy;
import com.android.medicServer.Repository.PharmacotherapyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PharmacotherapyController
{
    @Autowired
    private PharmacotherapyRepository repository;

    @RequestMapping("/tratamientos")
    public List<Pharmacotherapy> getPharmacotherapys()
    {
        List<Pharmacotherapy> listaTratamientos = repository.findAll();
        return listaTratamientos;
    }
}
