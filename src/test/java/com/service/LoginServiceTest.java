package com.service;

import com.models.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import com.service.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
class LoginServiceTest

{
    @InjectMocks
    private LoginService loginService;

    @Mock
    private Connection connection;

    @Mock
    private ResultSet resultSet;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private DatabaseConnection databaseConnection;

    User user;


    @BeforeEach

    public void Setup() throws SQLException, ClassNotFoundException
    {
        MockitoAnnotations.initMocks(this);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(databaseConnection.getDatabaseConnection()).thenReturn(connection);
        user = new User("Rav","Kaur","rav.com","rav123","user","1234566",45);
    }

    @Test
    void getUser() throws SQLException
    {

        when(connection.prepareStatement(" select * from users where email = ? and password = ? ")).thenReturn(preparedStatement);
        loginService.getUser(user.getEmail(),user.getPassword());
        verify(preparedStatement).executeQuery();


    }
}

