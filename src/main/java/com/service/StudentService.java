package com.service;

import com.models.StudentData;
import com.models.StudentInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class StudentService implements StudentInterface
{
    Connection conn;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public StudentService(Connection conn) {
        this.conn = conn;
    }

    public StudentData getUser(String snumber, String sname, double gpa)
    {
        StudentData loggedInUser = null;
        try
        {
            // the mysql insert statement
            String query = " select * from student where sname = ? and snumber = ? LIMIT 1";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, snumber);
            preparedStmt.setString(2, sname);
            preparedStmt.setDouble(3,gpa);


            // execute the preparedstatement
            ResultSet rs = preparedStmt.executeQuery();

            if (rs.next())
            {
                loggedInUser = new StudentData
                        (
                        rs.getString("snumber"),
                        rs.getString("sname"),
                        rs.getDouble("gpa")
                                );
                loggedInUser.setSnumber(rs.getString("isnumber"));



            }

            rs.close();

            conn.close();

        }
        catch (Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }

        return loggedInUser;
    }

    @Override
    public void add(Locale.Category cat) throws ClassNotFoundException, SQLException {

    }

    @Override

    public void add(StudentData sd) throws ClassNotFoundException, SQLException {



        String quer1 = "INSERT INTO Category VALUES ( ?, ? )";
        PreparedStatement query = conn.prepareStatement(quer1);


        query.setString(1, sd.getSname());
        query.setString(2, sd.getSnumber());

        query.executeUpdate();


        System.out.println("One record added");




    }





    @Override
    public void delete(String catcode) throws SQLException {

        String quer1 = "Delete from Category where catcode = ?";
        PreparedStatement query = conn.prepareStatement(quer1);
        query.setString(1, catcode);
        query.executeUpdate();

        System.out.println("One record Deleted");
    }

    @Override
    public void display() throws ClassNotFoundException, SQLException {

    }
}
