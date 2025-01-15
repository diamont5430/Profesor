/*
 * Copyright 2021 Delft University of Technology
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package client.scenes;

import commons.Translation;
import commons.appUser;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class MainCtrl {

    private Stage primaryStage;

    private appUser user;

    public void initialize(Stage primaryStage, Parent overview) {
        this.primaryStage = primaryStage;
        if(overview != null) {
            this.primaryStage.setScene(new Scene(overview));
            this.primaryStage.show();
        }

    }


    public void switchScene(String path, appUser user2) {
        try{
            this.user = user2;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(path));

            Parent root = loader.load();

            MainMenuSceneController controller = loader.getController();
            controller.setData(this.user);
            controller.setMainCtrl(this);

            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.show();

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void switchToGameScene(String path, appUser user2, List<Translation> lista) {
        try{
            this.user = user2;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(path));

            Parent root = loader.load();
            GameSceneController controller = loader.getController();
            controller.setData(this.user, lista);
            controller.setMainCtrl(this);

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public appUser getUser() {
        return user;
    }
}