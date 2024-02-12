package com.example.startup2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DigitalBankMenuC {

    @FXML
    private Button CIMBbttn;

    @FXML
    private AnchorPane DigitalBanMenu;

    @FXML
    private Button GoTYmebttn;

    @FXML
    private Button MayaBttn;

    @FXML
    private Button NetBankBttn;

    @FXML
    void toCIMB_calc(ActionEvent event) {
        openFXML("CIMB_calc.fxml", event);
    }

    @FXML
    void toGotyme_calc(ActionEvent event) {
        openFXML("Gotyme_calc.fxml", event);
    }

    @FXML
    void toMaya_calc(ActionEvent event) {
        openFXML("Maya_calc.fxml", event);
    }

    @FXML
    void toNetbank_calc(ActionEvent event) {
        openFXML("Netbank_calc.fxml", event);
    }

    @FXML
    void toBankscene(ActionEvent event) {
        openFXML("BankScene.fxml", event); // Replace "" with the correct FXML filename
    }

    private void openFXML(String fxmlFileName, ActionEvent event) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
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
}
