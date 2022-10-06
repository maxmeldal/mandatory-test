package com.example.mandatorytest.services;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberServiceTest {
    PhoneNumberService sut;

    @Test
    void generatePhoneNumber() {
        //Assign
        sut = new PhoneNumberService();

        //Act
        System.out.println(sut.generatePhoneNumber());
        System.out.println(sut.generatePhoneNumber());
        System.out.println(sut.generatePhoneNumber());
        System.out.println(sut.generatePhoneNumber());
        System.out.println(sut.generatePhoneNumber());
        System.out.println(sut.generatePhoneNumber());
        System.out.println(sut.generatePhoneNumber());
        System.out.println(sut.generatePhoneNumber());
        System.out.println(sut.generatePhoneNumber());
        System.out.println(sut.generatePhoneNumber());


        //Assert
    }

}
