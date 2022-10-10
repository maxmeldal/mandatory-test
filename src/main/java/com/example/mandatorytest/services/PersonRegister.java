package com.example.mandatorytest.services;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;

public class PersonRegister {

    private int serialNumber;
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

        // PICK A RANDOM MONTH based on the enum Months
        // As enums start at index 0. I add + 1.

        this.month = randomEnum().ordinal() + 1;

        // Based on the month pick a RANDOM DATE available in that month

        this.day = generateDayFromMonth(month);

        // PICK A YEAR - 70 to - 18 years from current year.

        this.year = generateRandomYear();
        this.birtDate = birthDayGenerator();
        this.serialNumber = generateSerialNumber(sex);
        this.CPR = generateCPR();

    }

    public String GetBirthDate() {

        // Return the birthdate in format DD:MM:YY

        return birtDate;

    }

    public int GetBirthDay () {

        return day;
    }

    public int GetBirthMonth() {

        return month;

    }

    public int GetBirthYear() {

        return year;

    }

    public int GetSerialNumber() {

        return serialNumber;

    }

    public String GetCPR() {

        return CPR;

    }

    private String generateCPR() {

        String formattedDay = String.format("%02d", day);

        String formattedMonth = String.format("%02d", month);

        String formattedSerialNumber = String.format("%04d", serialNumber);

        String yearString = String.valueOf(year);

        String yearWithoutHundred = yearString.substring(2, 4);

        String formattedCPR = MessageFormat.format("{0}{1}{2}-{3}", formattedDay, formattedMonth, yearWithoutHundred, formattedSerialNumber);

        return formattedCPR;

    }


    private int generateSerialNumber(String sex) {

        int newSerialNumber = 0;

        if (sex == "f" || sex == "female")  {

            newSerialNumber = randomWithRange(2, 9998);

            if (newSerialNumber % 2 != 0) {

                newSerialNumber--;

            }

        }

        if (sex == "m" || sex == "male") {

            newSerialNumber = randomWithRange(2, 9998);

            if (newSerialNumber % 2 == 0) {

                newSerialNumber++;

            }

        }

        return newSerialNumber;

    }


    private String birthDayGenerator() {

        String formattedDay = String.format("%02d", day);

        String formattedMonth = String.format("%02d", month);

        return MessageFormat.format("{0} {1}{2, number, #}", formattedDay, formattedMonth, year);

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

