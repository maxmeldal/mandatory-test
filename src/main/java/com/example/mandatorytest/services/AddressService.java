package com.example.mandatorytest.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AddressService {

    public String getStreet(){
        // define scope
        String AlphaNumericString = "abcdefghijklmnopqrstuvxyz";
        // define number of letters
        int n = 6;
        // create a new string builder with a capacity of n.
        StringBuilder sb = new StringBuilder(n);
        // create loop that iterate n times and for every iteration will pick a random number from 0 to AlphaNumericString.length and add that letter to our string
        for (int i = 0; i < n; i++) {
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        // return the new string
        return sb.toString();
    }

    public int getNumber() {
        // initialize the random class
        Random r = new Random();
        // set the range
        int low = 1;
        int high = 999;
        // return a random number between 0-999
        return r.nextInt(high-low) + low;
    }

    public String getfloor() {
        // initialize the random class
        Random r = new Random();
        // set the range
        int low = 0;
        int high = 99;
        // set floor to a random number between 0-99
        String floor = String.valueOf(r.nextInt(high-low) + low);

        // if number is 0 return "st"
        if (floor.equals("0")){
            return "st";
        }else {
        // return floor
            return floor;
        }
    }

    public String getDoor(){
        // initialize the random class
        Random r = new Random();
        // create array of floor directions
        String[] floorDirection = {"th", "mf", "tv"};
        // set randomIndex to a random object of the floor direction array
        int randomIndex = r.nextInt(floorDirection.length);
        // set the range
        int low = 1;
        int high = 50;
        // set floorNumber to a string of a random number between 0-50
        String floorNumber = String.valueOf(r.nextInt(high-low) + low);
        // return floorDirection + floorNumber
        return floorDirection[randomIndex] + " " + floorNumber;
    }

    public String getAdress() {
        List<String> postalCodes=new ArrayList<>();
        List<String> townNames=new ArrayList<>();

        try {


        // connect to database
        String url = "jdbc:mysql://localhost:3306/addresses";
        String uname = "root";
        String pass = "rootroot";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        Statement st = con.createStatement();
        // MySQL statement to select the columns from the table
        String query = "select cPostalCode, cTownName from postal_code";
        ResultSet rs = st.executeQuery(query);
        // create an arrayList for postalcode and townname

        //while loop that as long as resultSet has next will add the postalcode to the postalcode arrayList and the townname to the townname arrayList
        while (rs.next()){
            postalCodes.add(rs.getString("cPostalCode"));
            townNames.add(rs.getString("cTownName"));
        }
        // close connection
        st.close();
        con.close();
        }catch (Exception e){
            System.out.println("Could not connect to database");
        }
        // initialize the random class
        Random r = new Random();
        // set the range
        int low = 1;
        int high = 589;
        // set randomNumber to a string of a random number between 0-50
        int randomNumber = r.nextInt(high - low) + low;
        // return postalcode and townname of random object from the database
        return postalCodes.get(randomNumber) + " / " + townNames.get(randomNumber);
    }


    public String getAllInformation() throws Exception {
        // return all the information together
        return "Address\n" +
               "Street" + "    " + "Number"+ "    " + "Floor" + "    " + "Door" + "    " + "Postal Code / Town\n" +
                getStreet() + "    " + getNumber() + "       " + getfloor() + "       " + getDoor() + "   " + getAdress();
    }
}
