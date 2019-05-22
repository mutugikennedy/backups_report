package com.backup.reports.resources;

import com.backup.reports.database.dbConnection;
import com.backup.reports.util.ReadConfigFile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class settingController implements Initializable {


    @FXML
    private TextField hostNameTxtId;
    @FXML
    private TextField dbNameTxtId;
    @FXML
    private PasswordField passwordTxtId;
    @FXML
    private Button dbConfigSaveId;
    @FXML
    private Button dbTxtClearId;
    @FXML
    private TextField pathTxtId;
    @FXML
    private Button pathBtnId;
    @FXML
    private Button pathSaveBtnId;
    @FXML
    private  Button pathTxtClearId;
    @FXML
    private Pane dbStatus;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //dblog Text area not editable;

        showDbStatus();

    }

    @FXML
    public  void dbConfigSaveId(ActionEvent event){
        dbConfigs();
    }



    private  void dbConfigs(){

       String host = hostNameTxtId.getText();
       String dbName =dbNameTxtId.getText();
       String password = passwordTxtId.getText();

       boolean response = new ReadConfigFile().updateDbConfigFile(host,dbName,password);
       if (response){
           Text txt =  new Text(10,10,"Database configuration set");
           txt.setStroke(Color.RED);
           txt.setFont(Font.font(10));
           dbStatus.getChildren().clear();
           dbStatus.getChildren().add(txt);
           showDbStatus();
       }else{
           Text txt =  new Text(10,10,"Database configuration not set");
           txt.setStroke(Color.RED);
           txt.setFont(Font.font(10));
           dbStatus.getChildren().clear();
           dbStatus.getChildren().add(txt);
       }


    }


    public void showDbStatus(){

        if (new dbConnection().isDatabaseConnected()){
            Text txt =  new Text(10,10,"DataBase connected");
            txt.setStroke(Color.RED);
            txt.setFont(Font.font(12));
            dbStatus.getChildren().clear();
            dbStatus.getChildren().add(txt);
            //System.out.println("database connected");

        }else{
            Text txt =  new Text(10,10,"DataBase Not connected");
            txt.setStroke(Color.RED);
            txt.setFont(Font.font(12));
            dbStatus.getChildren().add(txt);
        }

    }
}
