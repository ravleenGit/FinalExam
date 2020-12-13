package com.models;


    import java.sql.SQLException;
    import java.util.Locale;

public interface StudentInterface
{

    public void add(Locale.Category cat) throws ClassNotFoundException, SQLException;

    void add(StudentData sd) throws ClassNotFoundException, SQLException;


    public void delete(String snumber) throws SQLException;
    public void display() throws ClassNotFoundException, SQLException;


}

