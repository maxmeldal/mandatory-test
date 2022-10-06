package com.example.mandatorytest.services;

import com.example.mandatorytest.domain.NameAndGender;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.json.simple.parser.ParseException;

public class NameAndGenderService {

    public NameAndGender getRandomName(String gender){

        // Convert input to lowercase
        gender = gender.toLowerCase();

        // Check if input is not male or female
        if(gender.equals("m")) gender = "male";
        else if(gender.equals("f")) gender = "female";
        if(!gender.equals("male") && !gender.equals("female")) throw new IllegalArgumentException("Input must be 'male' or 'female', not case-sensitive");

        // Get list of objects
        var persons = getNameAndGenderList();

        // Remove all that is not of the same gender as input
        String finalGender = gender;
        persons.removeIf(person -> !person.gender().equals(finalGender));

        // Get random and return
        Random r = new Random();
        return persons.get(r.nextInt(persons.size()));
    }
    @SuppressWarnings("unchecked")
    private List<NameAndGender> getNameAndGenderList(){
        List<NameAndGender> nameAndGenderList = new ArrayList<>();

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/resources/person-names.json")) {
            //Read JSON file
            JSONObject obj = (JSONObject) jsonParser.parse(reader);
            JSONArray personsArr = (JSONArray) obj.get("persons");

            personsArr.forEach( person -> nameAndGenderList.add(parseNameAndGenderJson( (JSONObject) person ) ));

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return nameAndGenderList;
    }

    private NameAndGender parseNameAndGenderJson(JSONObject nameAndGender)
    {
        //Get employee first name
        String name = (String) nameAndGender.get("name");

        //Get employee last name
        String surname = (String) nameAndGender.get("surname");

        //Get employee website name
        String gender = (String) nameAndGender.get("gender");

        return new NameAndGender(name, surname, gender);
    }
}
