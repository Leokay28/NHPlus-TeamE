package controller;

import datastorage.UserDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtError;
    @FXML
    private Button btnSubmit;

    private UserDAO dao;
    private Stage stage;

    public void initialize(Stage stage) {
        this.stage = stage;
    }

    public void handleSubmit() {

    }

    public void handleError() {

    }

    public void login() {

    }
}
