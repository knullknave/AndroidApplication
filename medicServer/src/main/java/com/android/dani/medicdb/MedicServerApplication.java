package com.android.dani.medicdb;

import javafx.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class MedicServerApplication
{
    private static final Logger log = LoggerFactory.getLogger(MedicServerApplication.class);

    @Bean
    CommandLineRunner init(MedicRepository repository)
    {
        return (args) ->
        {
                 SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
                 Date fecha = new Date(System.currentTimeMillis());
                 try
                 {
                     repository.save(new Medic("a", "a", "a", "a", "a", "a", "a", "a", "a", dt.parse(dt.format(fecha))));
                 }
                 catch (ParseException e)
                 {
                     e.printStackTrace();
                 }
        };
    }

    public static void main(String[] args)
    {
        SpringApplication.run(MedicServerApplication.class, args);
    }
}

@Component
class MedicCommandLineRunner implements CommandLineRunner
{
    @Override
    public void run(String... args) throws Exception
    {
        medicRepository.findAll();
    }

    @Autowired MedicRepository medicRepository;

}

@RestController
class MedicRestController
{
    @RequestMapping("/Medic")
    Collection<Medic> medic()
    {
        return this.medicRepository.findAll();
    }

    @Autowired MedicRepository medicRepository;
}

interface MedicRepository extends JpaRepository<Medic, Long>
{
    Collection<Medic> findByName(String name);
}

@Entity
@Table(name = "medic")
class Medic
{
    @Id
    @GeneratedValue
    private int collegiateNumber;
    @Column
    private String userName;
    @Column
    private String userPassword;
    @Column
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column
    private String adress;
    @Column
    private String medicalCentre;
    @Column
    private String email;
    @Column
    private String medicalSpeciality;
    @Column
    private String telephone;
    @Column
    private Date birthDate;

    public Medic(String userName, String userPassword, String name, String surname, String adress, String medicalCentre, String email, String medicalSpeciality, String telephone, Date birthDate)
    {
        this.userName = userName;
        this.userPassword = userPassword;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.medicalCentre = medicalCentre;
        this.email = email;
        this.medicalSpeciality = medicalSpeciality;
        this.telephone = telephone;
        this.birthDate = birthDate;
    }

    public int getCollegiateNumber()
    {
        return collegiateNumber;
    }

    public void setCollegiateNumber(int collegiateNumber)
    {
        this.collegiateNumber = collegiateNumber;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserPassword()
    {
        return userPassword;
    }

    public void setUserPassword(String userPassword)
    {
        this.userPassword = userPassword;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getAdress()
    {
        return adress;
    }

    public void setAdress(String adress)
    {
        this.adress = adress;
    }

    public String getMedicalCentre()
    {
        return medicalCentre;
    }

    public void setMedicalCentre(String medicalCentre)
    {
        this.medicalCentre = medicalCentre;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getMedicalSpeciality()
    {
        return medicalSpeciality;
    }

    public void setMedicalSpeciality(String medicalSpeciality)
    {
        this.medicalSpeciality = medicalSpeciality;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public Date getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }

    public String toString()
    {
        return userName + " " + userPassword + " " + name + " " + surname + " " + adress + " " + medicalCentre + " " + email + " " + medicalSpeciality + " " + telephone + " " + birthDate;
    }
}
