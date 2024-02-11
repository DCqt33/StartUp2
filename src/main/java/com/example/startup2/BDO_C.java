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

public class BDO_C {
    @FXML
    private TextField BDOamt;

    @FXML
    private Button BDOenter;

    @FXML
    private TextField BDOmonth;

    @FXML
    private Button backbttn;

    @FXML
    private TextField BDOResult;

    @FXML
    void toBDO_output(ActionEvent event) {
        try {
            //Interest Calculator
            double BDOAMT = Double.parseDouble(BDOamt.getText());
            int BDOm = Integer.parseInt(BDOmonth.getText());

            if (BDOAMT < 5000 || BDOm < 0 || BDOm >= 1000) {
                BDOResult.setText("ERROR");

            } else
            {
                Interest_Calc Interest_calc = new Interest_Calc(Double.parseDouble(BDOamt.getText()), 0.000625, Integer.parseInt(BDOmonth.getText()));

                BDOResult.setText("₱" + Interest_calc.calculateProfit(Integer.parseInt(BDOmonth.getText())));

            }

        }catch (Exception e)
        {
            BDOResult.setText("WRONG INPUT");
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
