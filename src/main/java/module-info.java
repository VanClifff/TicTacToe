module com.example.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.safronov.tictactoe to javafx.fxml;
    exports com.safronov.tictactoe;
}