package com.backup.reports.resources;

import com.backup.reports.database.dbConnection;
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


    public void showDbStatus(){

        if (new dbConnection().isDatabaseConnected()){
            Text txt =  new Text(10,10,"DataBase connected");
            txt.setStroke(Color.RED);
            txt.setFont(Font.font(12));
            dbStatus.getChildren().add(txt);
            //System.out.println("database connected");

        }

    }
}
