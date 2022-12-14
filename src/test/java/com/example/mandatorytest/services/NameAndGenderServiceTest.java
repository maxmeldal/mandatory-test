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

    @Test
    void test_null_value_returns_null_pointer_exception(){
        assertThrows(NullPointerException.class,
                ()->sut.getRandomName(null));
    }
}