package com.example.mandatorytest.services;

import java.util.Random;

public class PhoneNumberService {

    public static final int[] START_NUMBERS = {2, 30, 31, 40, 41, 42, 50, 51, 52, 53, 60, 61, 71, 81, 91, 92, 93, 342, 344, 345, 346, 347, 348, 349, 356, 357, 359, 362, 365, 366, 389, 398, 431, 441, 462, 466,  468,  472,  474,  476,  478,  485, 486,  488, 489,  493, 494, 496, 496,  498, 499,  542, 543,  545,  551, 552, 556, 571, 572, 573, 574, 577, 579, 584, 586, 587, 589, 597, 598, 627, 629, 641, 649, 658, 662, 663, 664, 665, 667, 692, 693, 694, 697, 771, 772, 782, 783, 785, 786, 788, 789, 826, 827, 829};

    public int generatePhoneNumber(){
        Random r = new Random();

        // instantiates a string and adds the start of the phone number
        String phoneNumber = String.valueOf(START_NUMBERS[r.nextInt(START_NUMBERS.length)]);

        // gets number of remaining digits to be added
        int index = 8 - phoneNumber.length();

        // concats a random int until string has 8 digits
        for (int i = 0; i < index; i++) {
            phoneNumber += String.valueOf(r.nextInt(10));
        }
        // returns phone number as an int
        return Integer.parseInt(phoneNumber);
    }
}
