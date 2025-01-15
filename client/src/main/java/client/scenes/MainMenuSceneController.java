package client.scenes;

import commons.appUser;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class MainMenuSceneController {

    @FXML
    private Text username;

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


}
