package com.example.mandatorytest.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class NameAndGenderServiceTest {

    NameAndGenderService sut;

    @BeforeEach
    void setUp(){
        sut = new NameAndGenderService();
    }

    @ParameterizedTest
    @CsvSource({
            "male",
            "Male",
            "MALE",
            "female",
            "Female",
            "FEMALE",
            "m",
            "M",
            "f",
            "F"
    })
    void test_not_null_with_correct_input(String gender) {
        var result = sut.getRandomName(gender);

        assertNotNull(result);
    }

    @ParameterizedTest
    @CsvSource({
            "male",
            "Male",
            "MALE",
            "m",
            "M",
    })
    void test_correct_gender_male(String gender){
        var result = sut.getRandomName(gender);

        assertEquals("male", result.gender());
    }

    @ParameterizedTest
    @CsvSource({
            "female",
            "Female",
            "FEMALE",
            "f",
            "F",
    })
    void test_correct_gender_female(String gender){
        var result = sut.getRandomName(gender);

        assertEquals("female", result.gender());
    }

    @ParameterizedTest
    @CsvSource({
            "ADCB",
            "123",
            "ÆØÅ",
            "malef",
            ".",
    })
    void test_assert_throws_exception_with_bad_input(String gender){
        assertThrows(IllegalArgumentException.class,
                ()->sut.getRandomName(gender));
    }
}