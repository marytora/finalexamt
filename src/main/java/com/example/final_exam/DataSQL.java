package com.example.final_exam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSQL {
    final String URL = "jdbc:mysql://localhost:3306/carservice";
    final String NAME = "root";
    final String PASSWORD = "";
    List<CarService> carServiceList = new ArrayList<>();

    public DataSQL() throws SQLException {

    }

    Connection connection = DriverManager.getConnection(URL,NAME,PASSWORD);
    Statement statement = connection.createStatement();


    public ResultSet resultSet = statement.executeQuery(
            "select * from cars2"
    );

    public List<CarService> ParseDate() throws SQLException {
        while (resultSet.next()) {
            CarService carService = new CarService(resultSet.getString("car"),resultSet.getString("model"),resultSet.getInt("year"),resultSet.getString("serviceType"),resultSet.getInt("priceOfService"));
            carServiceList.add(carService);
        }
        return carServiceList;
    }



}
