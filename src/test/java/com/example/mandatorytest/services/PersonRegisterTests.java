package com.example.mandatorytest.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonRegisterTests {

    PersonRegister PR;

    @BeforeEach
    void setUp(){
        PR = new PersonRegister("f");
    }
    
    @RepeatedTest(1000)
    void GenerateSerialNumber_Female_isEVEN (){

        var PR = new PersonRegister("f");

        // Acts
        var result = PR.GetSerialNumber() % 2;

        var expectedResult = 0;

        // Assert
        assertEquals(expectedResult, result);

    }

    @RepeatedTest(1000)
    void GenerateSerialNumber_Male_isODD (){

        var PR = new PersonRegister("m");

        // Acts
        var result = PR.GetSerialNumber() % 2;

        var expectedResult = 1;

        // Assert
        assertEquals(expectedResult, result);

    }

    // Testing that Month Range is within 1 to 12

    @RepeatedTest(1000)
    void GeneratedMonth_JanuaryToDecember_IsTrue() {

        // Act

        var result = PR.GetBirthMonth();

        var min = 0;

        var max = 13;

        // Assert

        assertTrue(result > min && result < max);


    }

    @RepeatedTest(1000)
    void GeneratedDay_isWithinMonth_isTrue() {

        var month = PR.GetBirthMonth();
        var day = PR.GetBirthDay();

        switch (month) {

            case 1:
                // Days in January 1-31
                assertTrue(day > 0 && day < 32);
                break;
            case 2:
                // Days in February 1-28
                Assertions.assertTrue(day > 0 && day < 29);
                break;
            case 3:
                // Days in March 1-31
                Assertions.assertTrue(day > 0 && day < 32);
                break;
            case 4:
                // Days in April 1-30
                Assertions.assertTrue(day > 0 && day < 31);
                break;
            case 5:
                // Days in May 1-31
                Assertions.assertTrue(day > 0 && day < 32);
                break;
            case 6:
                // Days in June 1-30
                Assertions.assertTrue(day > 0 && day < 31);
                break;
            case 7:
                // Days in July 1-31
                Assertions.assertTrue(day > 0 && day < 32);
                break;
            case 8:
                // Days in August 1-31
                Assertions.assertTrue(day > 0 && day < 32);
                break;
            case 9:
                // Days in September 1-30
                Assertions.assertTrue(day > 0 && day < 31);
                break;
            case 10:
                // Days in October 1-31
                Assertions.assertTrue(day > 0 && day < 32);
                break;
            case 11:
                // Days in November 1-30
                Assertions.assertTrue(day > 0 && day < 31);
                break;
            case 12:
                // Days in December 1-31
                Assertions.assertTrue(day > 0 && day < 32);
                break;

        }

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
