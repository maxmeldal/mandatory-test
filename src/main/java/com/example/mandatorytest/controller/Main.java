package com.example.mandatorytest.controller;

import com.example.mandatorytest.services.PersonRegister;

public class Main {

    public static void main(String[] args) {

        var personRegister = new PersonRegister("F");

        System.out.println(personRegister.GetBirthDate());

        System.out.println(personRegister.GetCPR());

        System.out.println(personRegister.GetSerialNumber());


        for (int i = 0; i < 1000; i++) {



        }


    }

}