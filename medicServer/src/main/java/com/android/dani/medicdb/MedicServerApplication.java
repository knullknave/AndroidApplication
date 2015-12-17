package com.android.dani.medicdb;

import com.android.dani.medicdb.Controller.MedicController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class MedicServerApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(MedicServerApplication.class, args);

        MedicController mc = new MedicController();
        Date date= Calendar.getInstance().getTime();
        mc.addMedic("b", "b", "b", "b", "b", "b", "b", "b", "b", date);
    }
}
