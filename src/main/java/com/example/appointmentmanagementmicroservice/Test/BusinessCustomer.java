package com.example.appointmentmanagementmicroservice.Test;

public class BusinessCustomer extends Customer {
    private String LastName;

    public BusinessCustomer(String name, String lastName) {
        super(name);
        this.LastName = lastName;
    }

    @Override
    public String toString() {
        return "BusinessCustomer{" +
                super.toString() +
                "LastName='" + LastName + '\'' +
                '}';
    }
}
