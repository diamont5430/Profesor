package client.scenes;

import commons.Collection;
import commons.Translation;
import commons.appUser;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
        List<Translation> translations = getAllTranslations();

        mainCtrl.switchToGameScene("/client/scenes/GameScene.fxml", currentUser, translations);
    }



    public List<Translation> getAllTranslations(){
        RestTemplate restTemplate = new RestTemplate();
        Translation[] translations1 =  restTemplate.getForObject("http://localhost:8080/api/translation", Translation[].class);
        assert translations1 != null;
        return Arrays.stream(translations1).toList();
    }


}
