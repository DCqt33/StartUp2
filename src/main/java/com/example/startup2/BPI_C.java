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

public class BPI_C {
    @FXML
    private Button BPIenter;
    @FXML
    private TextField BPIamt;

    @FXML
    private TextField BPImonths;

    @FXML
    private TextField BPIresult;

    @FXML
    private Button BackBttn;

    @FXML
    void toBPI_output(ActionEvent event) {
        try {
            //Interest Calculator
            double BPIAMT = Double.parseDouble(BPIamt.getText());
            int BPIm = Integer.parseInt(BPImonths.getText());

            if (BPIAMT < 5000 || BPIm < 0 || BPIm > 1000) {
                BPIresult.setText("ERROR");

            } else
            {
                Interest_Calc Interest_calc = new Interest_Calc(Double.parseDouble(BPIamt.getText()), 0.000625, Integer.parseInt(BPImonths.getText()));

                BPIresult.setText("₱" + Interest_calc.calculateProfit(Integer.parseInt(BPImonths.getText())));

            }

        }catch (Exception e)
        {
            BPIresult.setText("WRONG INPUT");
        }

    }


    @FXML
    void toTraditionalMenu(ActionEvent event) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TraditionalBankMenu.fxml"));
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
