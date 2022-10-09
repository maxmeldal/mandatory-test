package com.example.mandatorytest.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonRegisterTests {

    private PersonRegister PR;

    @BeforeEach
    void setUp(){

        // Arrange
        PR = new PersonRegister();

    }

    @ParameterizedTest
    @CsvSource({"F"})
    <T> void GenerateCPR_PositiveCases_Pass (T expectedResult){

        // Act
        var result = PR.GetCPR("F");

        // Assert
        assertEquals(expectedResult, result);

    }

   /* @ParameterizedTest
    <T> void GenerateCPR_NegativeCases_Fail (T expectedResult){

        // Act

        // Assert

        assertNotNull(expectedResult);

    }*/

}
