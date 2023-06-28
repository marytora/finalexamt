package com.example.final_exam;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarService extends DataSQL {
    private String car;
    private String model;
    private int year;
    private String serviceType;
    private int priceOfService;
    private Button button;


    public CarService() throws SQLException {
        super();

    }

    public CarService(String car, String model, int year, String serviceType,int priceOfService) throws SQLException {
        super();
        this.car = car;
        this.model = model;
        this.year = year;
        this.serviceType = serviceType;
        this.priceOfService = priceOfService;
        this.button = new Button("Button");
        button.setOnAction(e -> {
            try {
                statement.executeUpdate(
                        "INSERT INTO cars2(Car,Model,Year,ServiceType,priceOfService) VALUES('"+getCar()+"','"+getModel()+"','"+getYear()+"','"+getServiceType()+"','"+getPriceOfService()+"')");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
    }




//    public void click() throws SQLException {
//        button.setOnAction(e -> {
//            try {
//                statement.executeUpdate(
//                        "INSERT INTO cars(Car,Model,Year,ServiceType) VALUES('"+getCar()+"','"+getModel()+"','"+getYear()+"','"+getServiceType()+"')");
//            } catch (SQLException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getServiceType() {
        return serviceType;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public int getPriceOfService() {
        return priceOfService;
    }

    public void setPriceOfService(int priceOfService) {
        this.priceOfService = priceOfService;
    }
}
