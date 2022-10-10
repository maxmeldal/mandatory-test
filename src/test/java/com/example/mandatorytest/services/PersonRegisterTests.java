package com.example.mandatorytest.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonRegisterTests {

    private PersonRegister PR;

    @BeforeEach
    void setUp(){

    }

    @ParameterizedTest
    @CsvSource({
    "F, F",
    "M, M",
    "K, K"})
    <T> void GenerateCPR_PositiveScenario_Pass (String input, T expectedResult){

        // Arrange
        PR = new PersonRegister(input);

       /* // Act
        var result = PR.GetCPR(input);

        // Assert
        assertEquals(expectedResult, result);*/

    }

   /* @ParameterizedTest
    <T> void GenerateCPR_NegativeCases_Fail (T expectedResult){

        // Act

        // Assert

        assertNotNull(expectedResult);

    }*/

}
