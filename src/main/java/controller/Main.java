package controller;

import datastorage.ConnectionBuilder;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.UserSession;

import java.io.IOException;

public class Main extends Application {

    private static Stage primaryStage;
    private static UserSession userSession;

    @Override
    public void start(Stage pS) {
        primaryStage = pS;
        mainWindow();
    }

    public void mainWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/Login.fxml"));
            AnchorPane pane = loader.load();

            Scene scene = new Scene(pane);
            primaryStage.setTitle("NHPlus");
            setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();

            primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent e) {
                    ConnectionBuilder.closeConnection();
                    Platform.exit();
                    System.exit(0);
                }
            });
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void setScene(Scene scene) {
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    public static void createUserSession(float uid, String username, String role) throws IOException {
        if(userSession == null) {
            userSession = new UserSession(uid, username, role);
        }
    }

    public static void clearUserSession() {
        if(userSession != null) {
            userSession = null;
        }
    }

    public static UserSession getUserSession() {
        if(userSession != null) {
            return userSession;
        }
        return null;
    }

    public static void logout() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/Login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            clearUserSession();
            setScene(scene);
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}