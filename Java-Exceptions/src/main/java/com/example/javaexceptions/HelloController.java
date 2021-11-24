package com.example.javaexceptions;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label Result;
    @FXML
    private TextField first_num;
    @FXML
    private TextField second_num;

    @FXML
    protected void onDividedButtonClick() {
        String firstNumber = first_num.getText();
        String secondNumber = second_num.getText();

        if (firstNumber != "" && secondNumber !="")
        {
            double firstnumber, secondnumber;
            try {
                firstnumber=Double.parseDouble(firstNumber);
                try {
                    secondnumber=Double.parseDouble(secondNumber);
                    try {
                        if (secondnumber == 13)
                            throw new UnluckyException();
                        else
                            Result.setText("Result:" + String.valueOf(firstnumber) + "/" + String.valueOf(secondnumber) + "=" + String.valueOf(firstnumber/secondnumber));
                    } catch (UnluckyException e) {
                        Result.setText("Result : Unlucky number!" );
                    }
                }
                catch (NumberFormatException e){
                    Result.setText("Result : Wrong Number Format");
                }
            }
            catch (NumberFormatException e){
                Result.setText("Result : Wrong Number Format");
            }
        }
        else {
            Result.setText("Result: All inputs should be completed");
        }
    }
}