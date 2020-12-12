package com.service;

import com.models.User;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginService
{
    public User getUser(String email, String password)
    {
        User loggedInUser = null;
        try
        {
            Connection conn = DatabaseConnection.getDatabaseConnection();

            // the mysql insert statement
            String query = " select * from users where email = ? and password = ? LIMIT 1";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, email);
            preparedStmt.setString(2, password);


            // execute the preparedstatement
            ResultSet rs = preparedStmt.executeQuery();

            if (rs.next())
            {
                loggedInUser = new User(
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("email"),
                        "",
                        rs.getString("userType"),
                        rs.getString("phoneNumber"),
                        rs.getInt("age"));
                loggedInUser.setUserId(rs.getInt("userId"));

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
}
