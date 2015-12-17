package com.android.dani.medicdb.Controller;

import com.android.dani.medicdb.Medic;
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

    @RequestMapping("/medic")
    public List<Medic> getMedics()
    {
        List<Medic> listaMedicos = repository.findAll();
        return listaMedicos;
    }

    @RequestMapping("/medic/collegiateNumber")
    public List<Medic> getCollegiateNumber(int collegiateNumber)
    {
        List<Medic> listaCollegiateNumber = repository.findByCollegiateNumber(collegiateNumber);
        return listaCollegiateNumber;
    }

    @RequestMapping("/add_medic")
    public void addMedic(@RequestParam(value = "userName", defaultValue = "nada") String userName,
                         @RequestParam(value = "userPassword", defaultValue = "nada") String userPassword,
                         @RequestParam(value = "name", defaultValue = "nada") String name,
                         @RequestParam(value = "surname", defaultValue = "nada") String surname,
                         @RequestParam(value = "adress", defaultValue = "nada") String adress,
                         @RequestParam(value = "medicalCentre", defaultValue = "nada") String medicalCentre,
                         @RequestParam(value = "email", defaultValue = "nada") String email,
                         @RequestParam(value = "medicalSpeciality", defaultValue = "nada") String medicalSpeciality,
                         @RequestParam(value = "telephone", defaultValue = "nada") String telephone,
                         @RequestParam(value = "birthDate") Date birthDate)
    {
        Medic m = new Medic();
        m.setUserName(userName);
        m.setUserPassword(userPassword);
        m.setName(name);
        m.setSurname(surname);
        m.setAdress(adress);
        m.setMedicalCentre(medicalCentre);
        m.setEmail(email);
        m.setMedicalSpeciality(medicalSpeciality);
        m.setTelephone(telephone);
        m.setBirthDate(birthDate);

        repository.save(m);
    }
}
