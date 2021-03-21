package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField fieldNum1;

    @FXML
    private TextField fieldNum2;

    @FXML
    private Button buttonSum;

    @FXML
    private Button buttonMult;

    @FXML
    private Label labelAnswerSum;

    @FXML
    private Label labelAnswerMult;

    @FXML
    void initialize (){
        buttonSum.setOnAction(event->{                                  // СОбытие при нажатии на кнопку сложения
            labelAnswerMult.setText(" ");
            if(testFields()) return;                                    // Если мы непрошли тесты заканчиваем программу

            int a = Integer.parseInt(fieldNum1.getText());              // Переводим введеные числа
            int b = Integer.parseInt(fieldNum2.getText());

            Calculator calc = new Calculator();
            labelAnswerSum.setText(convertIntToString(calc.getSum(a, b)));  // Считаем сумму
        });

        buttonMult.setOnAction(event->{                                 // Событие при нажатии на кнопку Умножения
            labelAnswerSum.setText(" ");
            if(testFields()) return;

            int a = Integer.parseInt(fieldNum1.getText());              // Переводим введеные числа
            int b = Integer.parseInt(fieldNum2.getText());

            Calculator calc = new Calculator();
            labelAnswerMult.setText(convertIntToString(calc.getMult(a, b)));  // Считаем Произведение
        });
    }

    boolean testFields()
    {
        boolean tests = false;
        if (!checkStringToInteger(fieldNum1.getText())){            // Проверка введенного числа
            fieldNum1.clear();
            labelAnswerMult.setText(" ");
            labelAnswerSum.setText(" ");
            tests = true;
        }
        if (!checkStringToInteger(fieldNum2.getText())){            // Проверка введенного числа
            fieldNum2.clear();
            labelAnswerMult.setText(" ");
            labelAnswerSum.setText(" ");
            tests = true;
        }
        return tests;
    }

    boolean checkStringToInteger (String str){                          // Проверяем ввод
        try{
            Integer.parseInt(str);
        }
        catch (Exception exp){
            return false;
        }
        return true;
    }

    String convertIntToString(int number){
        String answer;
        if(number >= 99999999 || number <= -99999999){                      // Учитываем размер поля вывода
            number /= 10000000;
            answer = String.valueOf(number);
            answer += "* 10^7";
        }
        else {
           answer = String.valueOf(number);
        }
        return answer;
    }
}