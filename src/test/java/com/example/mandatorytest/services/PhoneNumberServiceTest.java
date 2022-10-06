package com.example.mandatorytest.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberServiceTest {
    PhoneNumberService sut;

    @BeforeEach
    void setUp(){
        sut = new PhoneNumberService();
    }

    @RepeatedTest(20)
    void test_generate_phone_number_length_equals_8() {

        int phoneNumber = sut.generatePhoneNumber();
        assertEquals(String.valueOf(phoneNumber).length(), 8);
    }

    @RepeatedTest(20)
    void test_generate_phone_number_correct_prefix() {

        String phoneNumber = String.valueOf(sut.generatePhoneNumber());

        boolean correctPrefix = false;

        for (int number : PhoneNumberService.START_NUMBERS) {
            if(phoneNumber.startsWith(String.valueOf(number))){
                correctPrefix = true;
            }
        }
        assertTrue(correctPrefix);
    }
}
