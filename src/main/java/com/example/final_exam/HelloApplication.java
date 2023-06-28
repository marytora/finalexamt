package com.example.final_exam;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {



        CarService car1 = new CarService("Porche","911",2003,"EngineChange",100);
        CarService car2 = new CarService("Opel","Corsa",2008,"Wash",10);
        CarService car3 = new CarService("Mersedes-Benz","CLS",2015,"Paint",50);
        CarService car4 = new CarService("Nissan-Skyline","R34",1999,"SVAP",30);
        DataSQL dataSQL = new DataSQL();

        TableView<CarService> tableView = new TableView<>();

        TableColumn<CarService, String > nameColumn = new TableColumn<>("Car");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("car"));

        TableColumn<CarService, String> priceColumn = new TableColumn<>("Model");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("model"));

        TableColumn<CarService, Integer > quantityColumn = new TableColumn<>("Year");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("year"));

        TableColumn<CarService, Integer> idColumn = new TableColumn<>("ServiceType");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("serviceType"));

        TableColumn<CarService, Integer> price = new TableColumn<>("Price");
        price.setCellValueFactory(new PropertyValueFactory<>("priceOfService"));


        TableColumn<CarService, Button> button = new TableColumn<>("Button");
        button.setCellValueFactory(new PropertyValueFactory<>("button"));





        tableView.getColumns().addAll(nameColumn, priceColumn, quantityColumn, idColumn,price,button);



     ObservableList<CarService> cars2 = FXCollections.observableArrayList();
        cars2.add(car1);
        cars2.add(car2);
        cars2.add(car3);
        cars2.add(car4);





        tableView.setItems(cars2);

        Group root = new Group();
        PieChart pieChart = new PieChart();
        pieChart.setData(getPieChartData());
        root.getChildren().add(pieChart);



        Scene scene = new Scene(tableView, 320, 240);
        Scene scene1 = new Scene(root, 320, 240);

        stage.setTitle("Hello!");
        stage.setScene(scene);
//        stage.setScene(scene1);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private ObservableList<PieChart.Data> getPieChartData() throws SQLException {
        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
        DataSQL dataSQL = new DataSQL();
        List<CarService> list2 = dataSQL.ParseDate().stream()
                .filter(f -> f.getPriceOfService() > 40)
                .collect(Collectors.toList());

        for (int i = 0; i < list2.size();i++){
            list.add(new PieChart.Data(list2.get(i).getCar(),list2.get(i).getPriceOfService()));
            System.out.println(list2.get(i).getCar() + "---"+ list2.get(i).getPriceOfService());

        }



        return list;
    }
}


