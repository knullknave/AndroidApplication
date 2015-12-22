package com.android.medicServer.Controller;

import com.android.medicServer.Base.Medicament;
import com.android.medicServer.Repository.MedicamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicamentController
{
    @Autowired
    private MedicamentRepository repository;

    @RequestMapping("/medicamentos")
    public List<Medicament> getMedicaments()
    {
        List<Medicament> listaMedicamentos = repository.findAll();
        return listaMedicamentos;
    }
}
