package client.scenes;

import commons.appUser;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

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

    public appUser appUser;

    private MainCtrl mainCtrl;

    public void setMainCtrl(MainCtrl mainCtrl) {
        this.mainCtrl = mainCtrl;
    }

    public void initialize() {
        System.out.println("Welcome to UserSceneController");
        loginButton.setOnAction(event -> {handleLoginClick();});
    }

    @FXML
    public void handleLoginClick() {
        boolean check = newAccountCheckBox.isSelected();
        String username = this.usernameField.getText();
        String password = this.passwordField.getText();

        String color = this.colorPicker.getValue().toString();
        color = "#"+ color.substring(2,color.length()-2);

        //vbox.setStyle("-fx-background-color: "+color);

        if(check) {
            appUser user = new appUser(username,password,color);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForObject("http://localhost:8080/api/appUser", user, appUser.class);
            appUser = user;
        }else{
            RestTemplate restTemplate = new RestTemplate();
            appUser user =  restTemplate.getForObject("http://localhost:8080/api/appUser/" + username, appUser.class);
            if(user != null) {
                appUser = user;
                System.out.println(appUser.getUsername() + "   " + appUser.getPassword());
                mainCtrl.switchScene("/client/scenes/MainMenuScene.fxml", appUser);
            }else{
                System.out.println("User not found");
            }
        }
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
