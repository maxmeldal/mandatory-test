package com.example.mandatorytest.services;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyJDBC {

    public static void main(String[] args) throws Exception{

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
            System.out.println(postalCodes.size());
            System.out.println(postalCodes.get(0));
            System.out.println(townNames.get(0));
            st.close();
            con.close();


    }


}
