package client.scenes;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class UserSceneController {

    @FXML
    private VBox vbox;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private CheckBox newAccountCheckBox;

    public void initialize() {
        System.out.println("Welcome to UserSceneController");
        loginButton.setOnAction(event -> {handleLoginClick();});
    }

    @FXML
    public void handleLoginClick() {
        System.out.println("Login clicked");
        String username = this.usernameField.getText();
        String password = this.passwordField.getText();
        System.out.println("username: " + username + " password: " + password);
    }
}
