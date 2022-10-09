package com.example.mandatorytest.services;

import java.text.MessageFormat;

public class PersonRegister {

    private String CPR;
    private String birtDate;

    public String GetCPR(String sex) {

        CPR = MessageFormat.format("{0}", sex);

        return CPR;

    }

}
