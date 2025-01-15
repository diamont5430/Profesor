package client.scenes;

import commons.Collection;
import commons.appUser;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import javax.swing.text.html.ListView;

public class MainMenuSceneController {

    @FXML
    private Text username;

    @FXML
    private Button randomtenButton;

    private MainCtrl mainCtrl;

    private appUser currentUser;

    public void setMainCtrl(MainCtrl mainCtrl) {
        this.mainCtrl = mainCtrl;
    }

    @FXML
    public void initialize() {
    }

    public void setData(appUser user){
        currentUser = user;
        username.setText(currentUser.getUsername());
    }

    public void handleRandomTen(){
        System.out.println("Random 10 clicked");
    }


}
