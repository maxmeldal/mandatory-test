package com.example.mandatorytest.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AddressService {

    public static String getStreet()
    {
        // chose a Character random from this String
        String AlphaNumericString = "abcdefghijklmnopqrstuvxyz";
        int n = 6;

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    static int getNumber() {
        Random r = new Random();
        int low = 1;
        int high = 999;
        return r.nextInt(high-low) + low;
    }

    static String getfloor() {
        Random r = new Random();
        int low = 0;
        int high = 99;
        String floor = String.valueOf(r.nextInt(high-low) + low);

        if (floor.equals("0")){
            return "st";
        }else {
            return floor;
        }
    }

    static String getDoor(){
        Random r = new Random();
        String[] floorDirection = {"th", "mf", "tv"};
        int randomIndex = r.nextInt(floorDirection.length);
        int low = 1;
        int high = 50;
        String floorNumber = String.valueOf(r.nextInt(high-low) + low);
        return floorDirection[randomIndex] + " "+ floorNumber;
    }

    static String getAdress() throws Exception{
        String url = "jdbc:mysql://localhost:3306/addresses";
        String uname = "root";
        String pass = "rootroot";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        Statement st = con.createStatement();
        String query = "select cPostalCode, cTownName from postal_code";
        ResultSet rs = st.executeQuery(query);
        List<String> postalCodes=new ArrayList<>();
        List<String> townNames=new ArrayList<>();
        while (rs.next()){
            postalCodes.add(rs.getString("cPostalCode"));
            townNames.add(rs.getString("cTownName"));


        }
        st.close();
        con.close();
        Random r = new Random();
        int low = 1;
        int high = 589;
        int randomNumber = r.nextInt(high - low) + low;
        return postalCodes.get(randomNumber) + " / " + townNames.get(randomNumber);

    }

    static String getAllInformation() throws Exception {
        return "Address\n" +
               "Street" + "    " + "Number"+ "    " + "Floor" + "    " + "Door" + "    " + "Postal Code / Town\n" +
                getStreet() + "    " + getNumber() + "       " + getfloor() + "       " + getDoor() + "   " + getAdress();
    }


    public static void main(String[] args) throws Exception {
        System.out.println(getAllInformation());
    }
}
