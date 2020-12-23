package BMICalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class BmiController {



    @FXML
    private TextField bmiOrginary;

    @FXML
    private TextField bmiEnglish;

    @FXML
    private TextField heightEnterField;

    @FXML
    private TextField weightEnterField;
    @FXML
    private Button calculateButton;

    @FXML
    private Label answer;
    @FXML
    private Label answer1;

    @FXML
    private TextField heightEnterField1;

    @FXML
    private TextField weightEnterField1;

    @FXML
    void calculateBmi(ActionEvent event) {
        BigDecimal height = new BigDecimal(heightEnterField.getText());

        BigDecimal weight = new BigDecimal(weightEnterField.getText());
        BigDecimal mBMI;


        try {

           mBMI = weight.divide(height.multiply(height));


//            int height = Integer.parseInt(heightEnterField.getText());
//            int weight = Integer.parseInt(weightEnterField.getText());
//            int eBMI = (int) (weight/Math.pow(height,2));
//            int mBMI = (int) ((int) 703*(weight/Math.pow(height,2)));


            bmiOrginary.setText(mBMI+" kg/m^2");

            if(mBMI.compareTo(new BigDecimal("18.5"))==-1){
                answer1.setText(" Underweight");
            }else if(mBMI.compareTo(new BigDecimal("18.5"))<=0 && mBMI.compareTo(new BigDecimal("24.9"))==-1 ){
                answer1.setText(" Normal");
            }else if(mBMI.compareTo(new BigDecimal("25.0"))<=0 && mBMI.compareTo(new BigDecimal("29.9"))==-1 ){
                answer1.setText(" Normal");
            }else answer1.setText(" Obese");



        }catch (NumberFormatException ex){
            bmiOrginary.setText("Reenter");
        }

        BigDecimal eheight = new BigDecimal(heightEnterField1.getText());
        BigDecimal eweight = new BigDecimal(weightEnterField1.getText());
        BigDecimal eBMI;

        try{
            eBMI = (eweight.divide(eheight.multiply(eheight)));
            eBMI = eBMI.multiply(BigDecimal.valueOf(703));
            bmiEnglish.setText(eBMI+" lbs/in^2");

            if(eBMI.compareTo(new BigDecimal("18.5"))==-1){
                answer.setText(" Underweight");
            }else if(eBMI.compareTo(new BigDecimal("18.5"))<=0 && eBMI.compareTo(new BigDecimal("24.9"))==-1 ){
                answer.setText(" Normal");
            }else if(eBMI.compareTo(new BigDecimal("25.0"))<=0 && eBMI.compareTo(new BigDecimal("29.9"))==-1 ){
                answer.setText(" Normal");
            }else answer.setText(" Obese");


        }catch (NumberFormatException ex){
            bmiEnglish.setText("Reenter");


        }


    }



}
