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

public class CIMB_C
{
    @FXML
    private Button CimbEnter;

    @FXML
    private TextField CIMBamt;

    @FXML
    private TextField CIMBmonths;

    @FXML
    private TextField CIMBresult;

    @FXML
    private Button backBttn;
    @FXML
    void toCimb_output(ActionEvent event) {
        try {
            //Interest Calculator
            double CIMBAMT = Double.parseDouble(CIMBamt.getText());
            int CIMBm = Integer.parseInt(CIMBmonths.getText());

            if (CIMBAMT < 0 || CIMBm < 0 || CIMBm > 1000) {
                CIMBresult.setText("ERROR");

            } else
            {
                Interest_Calc Interest_calc = new Interest_Calc(Double.parseDouble(CIMBamt.getText()), 0.000625, Integer.parseInt(CIMBmonths.getText()));

                CIMBresult.setText("₱" + Interest_calc.calculateProfit(Integer.parseInt(CIMBmonths.getText())));

            }

        }catch (Exception e)
        {
            CIMBresult.setText("WRONG INPUT");
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
