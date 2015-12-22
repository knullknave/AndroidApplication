package com.android.medicServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MedicServerApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(MedicServerApplication.class, args);
        System.out.println("hello world");
    }
}
