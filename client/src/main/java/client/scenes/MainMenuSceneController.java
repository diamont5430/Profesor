package client.scenes;

import commons.Collection;
import commons.Translation;
import commons.appUser;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.ListView;
import java.util.*;

public class MainMenuSceneController {

    @FXML
    private Text username;

    @FXML
    private Button randomtenButton;

    @FXML
    private TableView<Collection> collectionTable;

    @FXML
    private Button createCollectionButton;

    @FXML
    private Button deleteCollectionButton;

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

        translations = getXRandomTranslations(translations, 10);

        mainCtrl.switchToGameScene("/client/scenes/GameScene.fxml", currentUser, translations);
    }



    public List<Translation> getAllTranslations(){
        RestTemplate restTemplate = new RestTemplate();
        Translation[] translations1 =  restTemplate.getForObject("http://localhost:8080/api/translation", Translation[].class);
        assert translations1 != null;
        return Arrays.stream(translations1).toList();
    }

    public List<Translation> getXRandomTranslations(List<Translation> translations, int x){
        Random rand = new Random();
        List<Translation> translations1 = new ArrayList<>();
        for(int i=0; i<x; i++){
            int randomIndex = rand.nextInt(translations.size());
            Translation translation = translations.get(randomIndex);
            translations1.add(translation);
        }
        return translations1;
    }

    public void handleCreateCollection(){

    }

    public void handleDeleteCollection(){

    }


}
