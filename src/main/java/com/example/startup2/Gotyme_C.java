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

public class Gotyme_C {
    @FXML
    private TextField GOtymeResult;

    @FXML
    private TextField GotymeAMT;

    @FXML
    private Button GotymeEnter;

    @FXML
    private TextField GotymeMonths;

    @FXML
    private Button backbttn;

    @FXML
    private Button ExitBttn;
    String type ="Digital";
    String name = "Gotyme";

    @FXML
    void toGotyme_output(ActionEvent event) {
        try {
            //Interest Calculator
            double GoTymeamt = Double.parseDouble(GotymeAMT.getText());
            int GotymeM = Integer.parseInt(GotymeMonths.getText());

            if (GoTymeamt < 0 || GotymeM < 0 || GotymeM >= 1000) {
                GOtymeResult.setText("ERROR");

            } else
            {
                Interest_Calc Interest_calc = new Interest_Calc(Double.parseDouble(GotymeAMT.getText()), 0.05, Integer.parseInt(GotymeMonths.getText()));
                GOtymeResult.setText("₱" + Interest_calc.calculateProfit(Integer.parseInt(GotymeMonths.getText())));
                DatabaseHandler.insertData(type, name, GoTymeamt, GotymeM);


            }

        }catch (Exception e)
        {
            GOtymeResult.setText("WRONG INPUT");
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
}
