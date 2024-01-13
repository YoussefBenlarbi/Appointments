package com.example.appointmentmanagementmicroservice;

import com.example.appointmentmanagementmicroservice.Test.BusinessCustomer;
import com.example.appointmentmanagementmicroservice.Test.Customer;
import com.example.appointmentmanagementmicroservice.entity.Appointment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class AppointmentManagementMicroserviceApplication {

    public static void main(String[] args) {

        SpringApplication.run(AppointmentManagementMicroserviceApplication.class, args);
        System.out.println("Appointment Management Microservice is running...");
//        Appointment[] appointment = new Appointment[5];
//        System.out.println(Arrays.toString(appointment));
    }

}
