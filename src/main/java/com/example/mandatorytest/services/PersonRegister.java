package com.example.mandatorytest.services;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

public class PersonRegister {

    private String CPR;
    private String birtDate;
    private int day;
    private int month;
    private int year;
    private String yearWithoutHundred;
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

    public String GetCPR(String sex) {


        int serialNumber;


        if (sex == "F") {

        }


        CPR = MessageFormat.format("{0}", sex);

        return CPR;

    }

    public void birthDayGenerator() {

        // PICK A RANDOM MONTH based on the enum Months
        // As enums start at index 0. I add + 1.

        month = randomEnum().ordinal() + 1;
        day = generateDayFromMonth(month);
        year = generateRandomYear();


        System.out.println(MessageFormat.format("{0} {1}", day, month));
        System.out.println(year);

        // BASED ON THE MONTH PICK A RANDOM DATA AVAILABLE IN THAT MONTH
        // PICK A YEAR - 70 to - 18  Years from current year.


    }

    /*private String generateRandomYearWithoutHundred() {

    }*/

    private int generateRandomYear() {

        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
        int calendarYear = cal.get(Calendar.YEAR);
        int min = calendarYear - 18;
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

        return Months.values()[new Random().nextInt(Months.values().length)];

    }

    public int randomWithRange(int min, int max) {

        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;

    }

}

