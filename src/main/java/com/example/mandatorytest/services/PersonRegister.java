package com.example.mandatorytest.services;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

public class PersonRegister {

    private String CPR;
    private String birtDate;
    private int day;
    private int month;
    private int year;
    private enum Months {
        JANUARY,
        FEBRUARY,
        MARCH,
        APRIL,
        MAY,
        JUNE,
        JULY,
        AUGUST,
        SEPTEMBER,
        OCTOBER,
        NOVEMBER,
        DECEMBER
    }

    public PersonRegister(String sex) {

        birthDayGenerator();
        generateCPR(sex);

    }

    public String GetCPR() {

        return CPR;

    }


    public String GetBirthDate() {

        // Return the birthdate in format DD:MM:YY

        return birtDate;

    }

    private void generateCPR(String sex) {

        int serialNumber = 1000;

        if (sex == "F") {

            serialNumber = randomWithRange(1000, 9998);

            if (serialNumber % 2 == 0) {
                serialNumber =+ 1;
            }

        }

        if (sex == "M") {

            serialNumber = randomWithRange(1000, 9999);

            if (serialNumber % 2 != 0) {

                serialNumber =- 1;

            }

        }

        String formattedDay = String.format("%02d", day);

        String formattedMonth = String.format("%02d", month);

        String yearString = String.valueOf(year);

        String yearWithoutHundred = yearString.substring(2, 4);

        CPR = MessageFormat.format("{0}{1}{2}{3,number,#}", formattedDay, formattedMonth, yearWithoutHundred, serialNumber);

    }


    private void birthDayGenerator() {

        // PICK A RANDOM MONTH based on the enum Months
        // As enums start at index 0. I add + 1.

        month = randomEnum().ordinal() + 1;

        // Based on the month pick a RANDOM DATE available in that month

        day = generateDayFromMonth(month);

        // PICK A YEAR - 70 to - 18 years from current year.

        year = generateRandomYear();

        birtDate = MessageFormat.format("{0} {1}{2, number, #}", day, month, year);

    }

    private int generateRandomYear() {

        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));

        // Getting the CURRENT YEAR

        int calendarYear = cal.get(Calendar.YEAR);

        // We are interested in an age of MINIMUM 18

        int min = calendarYear - 18;

        // We are interested in an age of MAXIMUM 70

        int max = calendarYear - 70;

        int generateYear = randomWithRange(min, max);


        return generateYear;

    }

    private int generateDayFromMonth(int month) {

        int generatedDay = 0;

        switch (month) {

            case 1:
                // Days in January 1-31
                generatedDay = randomWithRange(1, 31);
            case 2:
                // Days in February 1-28
                generatedDay = randomWithRange(1, 28);
            case 3:
                // Days in March 1-31
                generatedDay = randomWithRange(1, 31);
            case 4:
                // Days in April 1-30
                generatedDay = randomWithRange(1, 30);
            case 5:
                // Days in May 1-31
                generatedDay = randomWithRange(1, 31);
            case 6:
                // Days in June 1-30
                generatedDay = randomWithRange(1, 30);
            case 7:
                // Days in July 1-31
                generatedDay = randomWithRange(1, 31);
            case 8:
                // Days in August 1-31
                generatedDay = randomWithRange(1, 31);
            case 9:
                // Days in September 1-30
                generatedDay = randomWithRange(1, 30);
            case 10:
                // Days in October 1-31
                generatedDay = randomWithRange(1, 31);
            case 11:
                // Days in November 1-30
                generatedDay = randomWithRange(1, 30);
            case 12:
                // Days in December 1-31
                generatedDay = randomWithRange(1, 31);

        }

        return generatedDay;

    }

    private Months randomEnum() {

        // RETURNS a random index of the month enum, based on its length

        return Months.values()[new Random().nextInt(Months.values().length)];

    }

    public int randomWithRange(int min, int max) {

        // RETURNS and random value within the range and including the min and max

        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;

    }

}

