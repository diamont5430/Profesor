package client.scenes;

import commons.Translation;
import commons.appUser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class GameSceneController {

    @FXML
    private Text polishField;

    @FXML
    private Button guessButton;

    @FXML
    private TextField dutchInput;

    int i;
    int points;

    private MainCtrl mainCtrl;

    private appUser currentUser;

    private List<Translation> translationList = new ArrayList<>();

    public void initialize() {
        polishField.setText("Polish");
        i = 0;
        points = 0;
    }

    public void setMainCtrl(MainCtrl mainCtrl) {
        this.mainCtrl = mainCtrl;
    }



    public void setData(appUser user, List<Translation> translationList) {
        currentUser = user;
        this.translationList = translationList;
        polishField.setText(translationList.getFirst().getTextInFirstLanguage());
    }

    public void handleGuess(){
        String userInput = dutchInput.getText();
        String desiredInput = translationList.get(i).getTextInSecondLanguage();

        if(userInput.equals(desiredInput)){
            points++;
            System.out.println(points);
            System.out.println("You got it right!!");
        }else{
            System.out.println("You got it wrong!!");
        }
        if(i<9){
            polishField.setText(translationList.get(i+1).getTextInFirstLanguage());
        }
        i++;
    }


}
