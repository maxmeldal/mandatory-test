package com.example.mandatorytest;

import com.example.mandatorytest.domain.NameAndGender;
import com.example.mandatorytest.services.AddressService;
import com.example.mandatorytest.services.NameAndGenderService;
import com.example.mandatorytest.services.PersonRegister;
import com.example.mandatorytest.services.PhoneNumberService;

import java.util.ArrayList;
import java.util.List;

public class FakePerson {
    private AddressService addressService;
    private NameAndGenderService nameAndGenderService;
    private PersonRegister personRegister;
    private PhoneNumberService phoneNumberService;
    private String gender;

    public FakePerson(String gender) {
        this.addressService = new AddressService();
        this.nameAndGenderService = new NameAndGenderService();
        this.personRegister = new PersonRegister(gender);
        this.phoneNumberService = new PhoneNumberService();
        this.gender = gender;
    }

    public String getFakeCPR(){
        return this.personRegister.GetCPR();
    }

    public String getFakeNameAndGender(){
        NameAndGender nag = this.nameAndGenderService.getRandomName(gender);
        return nag.name() + " " + nag.surname() + ", " + nag.gender();
    }

    public String getFakeNameAndGenderAndDateOfBirth(){
        return getFakeNameAndGender() + ", " + this.personRegister.GetBirthDate();
    }

    public String getCPRAndNameAndGender(){
        return this.personRegister.GetCPR() + ", " + this.nameAndGenderService.getRandomName(gender);
    }

    public String getCPRAndNameAndGenderAndDateOfBirth(){
        return this.personRegister.GetCPR() + ", " + getFakeNameAndGenderAndDateOfBirth();
    }

    public String getFakeAddress(){
        return this.addressService.getAllInformation();
    }

    public String getFakeNumber(){
        return String.valueOf(this.phoneNumberService.generatePhoneNumber());
    }

    public String getFullFakePerson(){
        return getCPRAndNameAndGenderAndDateOfBirth() + ", " + getFakeNumber() + ", " + getFakeAddress();
    }

    public List<String> getFakePersons(int amount){
        List<String> persons = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            persons.add(getFullFakePerson());
        }
        return persons;
    }
}
