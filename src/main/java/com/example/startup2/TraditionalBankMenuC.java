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

public class TraditionalBankMenuC {
    @FXML
    private Button BDObttns;

    @FXML
    private Button BPIbttn;

    @FXML
    private Button LandBankBttn;

    @FXML
    private Button PSBankBttn;

    @FXML
    private AnchorPane TraditionalBankMenu;
    @FXML
    private Button backbttn;

    @FXML
    void toBDO_calc(ActionEvent event) {
        openFXML("BDO_calc.fxml", event);
    }

    @FXML
    void toBPI_calc(ActionEvent event) {
        openFXML("BPI_calc.fxml", event);
    }

    @FXML
    void toLandBank_calc(ActionEvent event) {
        openFXML("LandBank_calc.fxml", event);
    }

    @FXML
    void toPSBank_calc(ActionEvent event) {
        openFXML("PSBank_calc.fxml", event);
    }

    @FXML
    void toBankScene(ActionEvent event) {
        openFXML("BankScene.fxml", event);
    }

    private void openFXML(String fxmlFileName, ActionEvent event) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
            Parent root = loader.load();

            // Create a new stage
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            // Close the current window
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
