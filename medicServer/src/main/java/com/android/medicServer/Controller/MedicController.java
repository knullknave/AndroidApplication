package com.android.medicServer.Controller;

import com.android.medicServer.Base.Medic;
import com.android.medicServer.Repository.MedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class MedicController
{
    @Autowired
    private MedicRepository repository;

    @RequestMapping("/medicos")
    public List<Medic> getMedics()
    {
        List<Medic> listaMedicos = repository.findAll();
        return listaMedicos;
    }

    @RequestMapping("/medico")
    public List<Medic> findById(int id)
    {
        List<Medic> listaMedicos = repository.findById(id);
        return listaMedicos;
    }

    @RequestMapping("/add_medic")
    public void addMedic(
                         @RequestParam(value = "username", defaultValue = "nada") String userName,
                         @RequestParam(value = "userpassword", defaultValue = "nada") String userPassword,
                         @RequestParam(value = "name", defaultValue = "nada") String name,
                         @RequestParam(value = "surname", defaultValue = "nada") String surname,
                         @RequestParam(value = "adress", defaultValue = "nada") String adress,
                         @RequestParam(value = "medicalcentre", defaultValue = "nada") String medicalCentre,
                         @RequestParam(value = "email", defaultValue = "nada") String email,
                         @RequestParam(value = "medicalspeciality", defaultValue = "nada") String medicalSpeciality,
                         @RequestParam(value = "telephone", defaultValue = "nada") String telephone)
    {
        Medic m = new Medic();
        m.setUsername(userName);
        m.setPas(userPassword);
        m.setName(name);
        m.setSurname(surname);
        m.setAdress(adress);
        m.setMed(medicalCentre);
        m.setEmail(email);
        m.setSpec(medicalSpeciality);
        m.setTelephone(telephone);

        repository.save(m);
    }

    @RequestMapping("/delete_medic")
    public void deleteMedic2(int id)
    {
        repository.delete(id);
    }
}
