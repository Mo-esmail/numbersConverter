module com.example.numbersConverter {
    requires javafx.controls;
    requires javafx.fxml;



    exports com.numbersConverter;
    opens com.numbersConverter to javafx.fxml;
}