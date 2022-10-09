package com.example.mandatorytest.controller;

import com.example.mandatorytest.services.PersonRegister;

public class Main {

    public static void main(String[] args) {

        var personRegister = new PersonRegister();

        for (int i = 0; i < 1000; i++) {

            personRegister.birthDayGenerator();

        }





    }

}
