package com.example.mandatorytest.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.*;


class AddressServiceTest {

    AddressService sut;

    @BeforeEach
    void setUp() {sut = new AddressService();
    }

    //Tests of the getStreet() function

    @RepeatedTest(20)
    void test_get_street_is_not_null() {
        String street = sut.getStreet();
        assertNotNull(street);
    }

    @RepeatedTest(20)
    void test_get_street_is_not_numbers() {
        String street = sut.getStreet();
        assertFalse(street.matches("123456789"));
    }

    @RepeatedTest(20)
    void test_get_street_is_letter() {
        String street = sut.getStreet();
        assertTrue(street.matches("[a-zA-Z]+"));
    }

    @RepeatedTest(20)
    void test_get_street_string_length_equals_6() {
        String street = sut.getStreet();
        assertEquals((street).length(), 6);
    }

    //Tests of the getNumber() function

    @RepeatedTest(20)
    void test_get_number_is_not_null() {
        int number = sut.getNumber();
        assertNotNull(number);
    }

    @RepeatedTest(20)
    void test_get_number_is_number() {
        String number = String.valueOf(sut.getNumber());
        assertTrue(number.matches(".*\\d.*"));
    }

    @RepeatedTest(20)
    void test_get_number_is_inside_scope() {
        int street = sut.getNumber();
        int low = 1;
        int high = 999;
        assertTrue(street <= high && street >= low);
    }

    //Tests of the getFloor() function
    @RepeatedTest(20)
    void test_get_floor_is_not_null() {
        String floor = sut.getfloor();
        assertNotNull(floor);
    }

    @RepeatedTest(20)
    void test_get_floor_is_number_or_st() {
        String floor = sut.getfloor();
        assertTrue(floor.matches(".*\\d.*") || floor.matches("st"));
    }

    //Tests of the getDoor() function
    @RepeatedTest(20)
    void test_get_door_is_not_null() {
        String door = sut.getDoor();
        assertNotNull(door);
    }

    @RepeatedTest(20)
    void test_get_door_is_inside_scope() {
        String door = sut.getDoor();
        String[] parts = door.split(" ", 2);
        assertTrue(parts[0].matches("th") || parts[0].matches("mf") || parts[0].matches("tv") && parts[1].matches("^([1-9]|[1-4]\\d|50)$"));
    }
}