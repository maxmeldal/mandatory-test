package com.example.mandatorytest.controller;

import com.example.mandatorytest.services.PersonRegister;

public class Main {

    public static void main(String[] args) {




        for (int i = 0; i < 1000; i++) {

            var personRegister = new PersonRegister("f");

            System.out.println(personRegister.GetBirthDate());

            System.out.println(personRegister.GetCPR());

            System.out.println("Modulus: " + personRegister.GetSerialNumber() % 2);

        }


    }

}
