package com.android.medicServer.Controller;

import com.android.medicServer.Base.Patient;
import com.android.medicServer.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public class PatientController
{
    @Autowired
    private PatientRepository repository;
	private static SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    @RequestMapping("/pacientes")
    public List<Patient> getPatients()
    {
        List<Patient> listaPacientes = repository.findAll();
        return listaPacientes;
    }
	
	@RequestMapping("/paciente")
    public List<Patient> findById(int id)
    {
        List<Patient> listaPacientes = repository.findById(id);
        return listaPacientes;
    }

    @RequestMapping("/add_patient")
    public void addPatient(
            @RequestParam(value = "username") String userName,
            @RequestParam(value = "userpassword") String userPassword,
            @RequestParam(value = "name", defaultValue = "nada") String name,
            @RequestParam(value = "surname", defaultValue = "nada") String surname,
            @RequestParam(value = "sex", defaultValue = "H") String sex,
            @RequestParam(value = "adress", defaultValue = "nada") String adress,
            @RequestParam(value = "birthdate", defaultValue = "nada") String birth,
            @RequestParam(value = "telephone", defaultValue = "nada") String telephone,
            @RequestParam(value = "idfoto") String idFoto)

    {
        Patient p = new Patient();
        p.setUsername(userName);
        p.setPas(userPassword);
        p.setName(name);
        p.setSurname(surname);
        p.setSex(sex.charAt(0));
        p.setAdress(adress);
        try
        {
            p.setBirthdate(df.parse(birth.replace("/", "-")));
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        p.setTelephone(telephone);
        p.setIdFoto(Integer.valueOf(idFoto));

        repository.save(p);
    }

    @RequestMapping("/update_patient")
    public void addPatient(
            @RequestParam(value = "id") String id,
            @RequestParam(value = "username") String userName,
            @RequestParam(value = "userpassword") String userPassword,
            @RequestParam(value = "name", defaultValue = "nada") String name,
            @RequestParam(value = "surname", defaultValue = "nada") String surname,
            @RequestParam(value = "sex", defaultValue = "H") String sex,
            @RequestParam(value = "adress", defaultValue = "nada") String adress,
            @RequestParam(value = "birthdate", defaultValue = "nada") String birth,
            @RequestParam(value = "telephone", defaultValue = "nada") String telephone,
            @RequestParam(value = "idfoto") String idFoto)

    {
        Patient p = new Patient();
        p.setId(Integer.parseInt(id));
        p.setUsername(userName);
        p.setPas(userPassword);
        p.setName(name);
        p.setSurname(surname);
        p.setSex(sex.charAt(0));
        p.setAdress(adress);
        try
        {
            p.setBirthdate(df.parse(birth.replace("/", "-")));
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        p.setTelephone(telephone);
        p.setIdFoto(Integer.valueOf(idFoto));

        repository.save(p);
    }

    @RequestMapping("/delete_patient")
    public void deletePatient(int id)
    {
        repository.delete(id);
    }
}
