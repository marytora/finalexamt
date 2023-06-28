module com.example.final_exam {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.final_exam to javafx.fxml;
    exports com.example.final_exam;
}