package com.service;



import com.models.StudentData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class DAOImplementsTest
{
    @InjectMocks
    private DAOImplementation daoImplements;

    @Mock
    private Connection connection;

    @Mock
    private ResultSet resultSet;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private DatabaseConnection connection1;

    StudentData user;

    @BeforeEach
    public void Setup() throws SQLException, ClassNotFoundException
    {
        MockitoAnnotations.initMocks(this);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(connection1()).thenReturn(connection);
        user=new User("101","food");
    }

    @Test
    void addUser() throws SQLException, ClassNotFoundException
    {
        when(connection.prepareStatement("Insert Into User (username, `password`) Values ( ?, ?)")).thenReturn(preparedStatement);
        daoImplements.(user);
        verify(preparedStatement).executeUpdate();

    }

}
