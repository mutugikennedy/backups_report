package com.backup.reports.resources;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class mainController implements Initializable {

    @FXML
    private Button settingBtnId;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }



    public void Dbsettings(ActionEvent event){

        openDbsettings();
    }

    /**
     * opening the setting box
     */

    public  void openDbsettings(){
        try {
            Stage dbSetting = new Stage();
            FXMLLoader dbSettingLoader =  new FXMLLoader();
            Pane dbSettingsRoot = dbSettingLoader.load(getClass().getResource("./settingsFXML.fxml").openStream());

            Scene scene =  new Scene(dbSettingsRoot);
            dbSetting.setScene(scene);
            dbSetting.setResizable(false);
            dbSetting.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
