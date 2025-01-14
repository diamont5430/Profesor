package client.scenes;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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

    @FXML
    private ColorPicker colorPicker;

    public void initialize() {
        System.out.println("Welcome to UserSceneController");
        loginButton.setOnAction(event -> {handleLoginClick();});
    }

    @FXML
    public void handleLoginClick() {
        boolean check = newAccountCheckBox.isSelected();
        String username = this.usernameField.getText();
        String password = this.passwordField.getText();

        if(check) {

        }else{

        }

        System.out.println("username: " + username + " password: " + password);
    }

    @FXML
    public void handleCheckBoxClick(){
        boolean check = newAccountCheckBox.isSelected();
        if(check){
            this.loginButton.setText("Register");
            colorPicker.setVisible(true);
        }else{
            this.loginButton.setText("Login");
            colorPicker.setVisible(false);
        }
    }
}
