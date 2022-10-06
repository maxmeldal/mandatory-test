package com.example.mandatorytest.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator sut;

    @Test
    void sum() {
        //Assign
        sut = new Calculator();

        //Act
        var result = sut.sum(1,2);

        //Assert
        assertEquals(result,3);
    }
}