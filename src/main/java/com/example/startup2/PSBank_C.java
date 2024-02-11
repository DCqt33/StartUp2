package com.example.startup2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class PSBank_C {

    @FXML
    private TextField PSBankMonth;
    @FXML
    private TextField PsbankAmt;
    @FXML
    private Button PSBank_enter;
    @FXML
    private TextField PSBankResult;
    @FXML
    private Button BackBttn;

    @FXML
    void toPSBank_output(ActionEvent event) {

        try {
            //Interest Calculator
            double PSBankAMT = Double.parseDouble(PsbankAmt.getText());
            int PSBm = Integer.parseInt(PSBankMonth.getText());

            if (PSBankAMT < 3000 || PSBm < 0 || PSBm > 1000) {
                PSBankResult.setText("ERROR");

            } else
            {
                Interest_Calc Interest_calc = new Interest_Calc(Double.parseDouble(PsbankAmt.getText()), 0.001, Integer.parseInt(PSBankMonth.getText()));

                PSBankResult.setText("₱" + Interest_calc.calculateProfit(Integer.parseInt(PSBankMonth.getText())));

            }

        }catch (Exception e)
        {
            PSBankResult.setText("WRONG INPUT");
        }
    }
    @FXML
    void toTraditionalBank(ActionEvent event) {
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
