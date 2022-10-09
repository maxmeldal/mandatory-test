package com.example.mandatorytest.controller;

import com.example.mandatorytest.services.PersonRegister;

public class Main {

    public static void main(String[] args) {

        var personRegister = new PersonRegister();

        //personRegister.birthDayGenerator();

        for (int i = 0; i < 1000; i++ ) {

            System.out.println(personRegister.randomWithRange(1, 30));

        }

    }

}
