package com.example.startup2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MayaBank_C {
    @FXML
    private Button BackBttn;

    @FXML
    private TextField MAYAmonths;

    @FXML
    private TextField MayaAMT;

    @FXML
    private Button MayaEnterBttn;

    @FXML
    private TextField MayaResult;

    @FXML
    void toMayaBank_output(ActionEvent event) {

        try {
            //Interest Calculator
            double MAYAAMT = Double.parseDouble(MayaAMT.getText());
            int MAYAm = Integer.parseInt(MAYAmonths.getText());

            if (MAYAAMT < 0 || MAYAm < 0 || MAYAm >= 1000) {
                MayaResult.setText("ERROR");

            } else
            {
                Interest_Calc Interest_calc = new Interest_Calc(Double.parseDouble(MayaAMT.getText()), 0.035, Integer.parseInt(MAYAmonths.getText()));

                MayaResult.setText("₱" + Interest_calc.calculateProfit(Integer.parseInt(MAYAmonths.getText())));

            }

        }catch (Exception e)
        {
            MayaResult.setText("WRONG INPUT");
        }

    }
    @FXML
    void toDigitalMenu(ActionEvent event) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DigitalBankMenu.fxml"));
            Parent root = loader.load();

            // Create a new stage
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            // Close the current window (optional)
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
