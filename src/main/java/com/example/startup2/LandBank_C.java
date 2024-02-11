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

public class LandBank_C {


    @FXML
    private Button BackBttn;

    @FXML
    private TextField LandBankAMT;

    @FXML
    private TextField LandBankMonths;

    @FXML
    private TextField LandBankResult;

    @FXML
    private Button LandBank_Enter;
    @FXML
    void toLandBank_output(ActionEvent event) {
        try {
            //Interest Calculator
            double LANDBANKamt = Double.parseDouble(LandBankAMT.getText());
            int LandBankm = Integer.parseInt(LandBankMonths.getText());

            if (LANDBANKamt< 500 || LandBankm < 0 || LandBankm > 1000) {
                LandBankResult.setText("ERROR");

            } else
            {
                Interest_Calc Interest_calc = new Interest_Calc(Double.parseDouble(LandBankAMT.getText()), 0.0005, Integer.parseInt(LandBankMonths.getText()));

                LandBankResult.setText("₱" + Interest_calc.calculateProfit(Integer.parseInt(LandBankMonths.getText())));

            }

        }catch (Exception e)
        {
            LandBankResult.setText("WRONG INPUT");
        }


    }
    @FXML
    void toTradionalMenu(ActionEvent event) {
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
