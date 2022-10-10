package com.example.mandatorytest.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonRegisterTestsFemale {

    PersonRegister PR;

    @BeforeEach
    void setUp(){
        PR = new PersonRegister("f");
    }

    @RepeatedTest(1000)
    void GenerateSerialNumber_IsFemale_True (){

        // Act
        var result = PR.GetSerialNumber() % 2;

        var expectedResult = 0;

        // Assert
        assertEquals(expectedResult, result);

    }

    @RepeatedTest(1000)
    void GeneratedMonth_1To12_IsTrue() {

        // Act

        var result = PR.GetBirthMonth();

        var min = 0;

        var max = 13;

        // Assert

        // Testing that Month Range is within 1 to 12

        assertTrue(result > min && result < max);


    }

    @RepeatedTest(1000)
    void GeneratedDate_WithinMonth_isTrue() {

    }


   /* @ParameterizedTest
    <T> void GenerateCPR_NegativeCases_Fail (T expectedResult){

        // Act

        // Assert

        assertNotNull(expectedResult);

        @CsvSource({
    "F, 0"})

    }*/

}
