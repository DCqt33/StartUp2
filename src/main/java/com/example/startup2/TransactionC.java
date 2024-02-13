package com.example.startup2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;

public class TransactionC {
    @FXML
    private TableColumn<?, ?> AMT;

    @FXML
    private TableColumn<?, ?> BankN;

    @FXML
    private TableView<?> DBtable;

    @FXML
    private Button ExitBttn;

    @FXML
    private TableColumn<?, ?> Months;

    @FXML
    private TableColumn<?, ?> TBank;

    @FXML
    private AnchorPane TransactionPage;

    @FXML
    private Button ViewBttn;

    @FXML
    private Button backbttn;



    @FXML
    void toStartupM(ActionEvent event) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StartUp_MainP.fxml"));
            Parent root = loader.load();

            // Create a new stage
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("StartUp");
            stage.show();


            // Close the current window (optional)
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ToExitPrg(ActionEvent event) {
        Main.exitApplication();
    }
    @FXML
    void ToViewBD(ActionEvent event) {

    }
}

