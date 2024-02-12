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

public class NetBank_C {

    @FXML
    private Button BackBttn;

    @FXML
    private TextField NetbankAMT;

    @FXML
    private Button NetbankEnter;

    @FXML
    private TextField NetbankMonths;

    @FXML
    private TextField NetbankResult;


    @FXML
    void toNetbank_output(ActionEvent event) {

        try {
            //Interest Calculator
            double netbankAMT = Double.parseDouble(NetbankAMT.getText());
            int Netbankm = Integer.parseInt(NetbankMonths.getText());

            if (netbankAMT < 0 || Netbankm < 0 || Netbankm >= 1000) {
                NetbankResult.setText("ERROR");

            } else
            {
                Interest_Calc Interest_calc = new Interest_Calc(Double.parseDouble(NetbankAMT.getText()), 0.04, Integer.parseInt(NetbankMonths.getText()));

                NetbankResult.setText("₱" + Interest_calc.calculateProfit(Integer.parseInt(NetbankMonths.getText())));

            }

        }catch (Exception e)
        {
            NetbankResult.setText("WRONG INPUT");
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
