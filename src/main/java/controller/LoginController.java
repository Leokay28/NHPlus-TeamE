package controller;

import datastorage.DAOFactory;
import datastorage.UserDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.User;
import utils.ErrorMessages;
import utils.PasswordEncryptor;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

public class LoginController {

    private Main main;

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Label txtError;
    @FXML
    private Button btnSubmit;

    private UserDAO dao;

    public void initialize() {
        this.dao = DAOFactory.getDAOFactory().createUserDAO();
    }

    @FXML
    private void handleSubmit() throws SQLException, InvalidKeyException, InterruptedException, IOException {
        String usernameInput = txtUsername.getText();
        String passwordInput = PasswordEncryptor.ecrypt(txtPassword.getText());
        if(usernameInput.equals("")) {
            handleError(2);
            return;
        }
        if(passwordInput.equals("")) {
            handleError(1);
            return;
        }

        User user = getUser(usernameInput);
        if(user == null) {
            handleError(5);
        } else {
            if(!user.getPassword().equals(passwordInput)) {
                handleError(6);
            } else {
                login(user);
            }
        }
    }

    private User getUser(String username) throws SQLException {
       return dao.getUserByUsername(username);
    }

    private void handleError(int errorCode) throws InvalidKeyException, InterruptedException {
        String error = ErrorMessages.getErrorMessage(errorCode);
        txtError.setText(error);
    }

    private void login(User user) throws IOException {
        Main.createUserSession(user.getUid(), user.getUsername(), user.getRole());
        openMainWindow();
    }

    private void openMainWindow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/MainWindowView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Main.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
