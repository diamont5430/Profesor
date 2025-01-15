package client.scenes;

import commons.Translation;
import commons.appUser;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class GameSceneController {

    @FXML
    private Text polishField;

    private MainCtrl mainCtrl;

    private appUser currentUser;

    private List<Translation> translationList = new ArrayList<>();

    public void initialize() {
        polishField.setText("Polish");
    }

    public void setMainCtrl(MainCtrl mainCtrl) {
        this.mainCtrl = mainCtrl;
    }



    public void setData(appUser user, List<Translation> translationList) {
        currentUser = user;
        this.translationList = translationList;
    }
}
