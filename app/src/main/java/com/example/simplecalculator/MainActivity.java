package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn_0,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_dot,btn_mul,btn_sub,btn_add,btn_div,btn_equal;
    TextView result;


    int operatorCount = 0;
    double num1,num2;
    String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        /*btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
    }


    public void setButton(View view){
        Button btnCurrent = (Button) view;

        if (btnCurrent.getId() == R.id.btn_0){
            result.append(btn_0.getText().toString());
        }else if (btnCurrent.getId() == R.id.btn_1){
            result.append(btn_1.getText().toString());
        }else if (btnCurrent.getId() == R.id.btn_2){
            result.append(btn_2.getText().toString());
        }else if (btnCurrent.getId() == R.id.btn_3){
            result.append(btn_3.getText().toString());
        }else if (btnCurrent.getId() == R.id.btn_4){
            result.append(btn_4.getText().toString());
        }else if (btnCurrent.getId() == R.id.btn_5){
            result.append(btn_5.getText().toString());
        }else if (btnCurrent.getId() == R.id.btn_6){
            result.append(btn_6.getText().toString());
        }else if (btnCurrent.getId() == R.id.btn_7){
            result.append(btn_7.getText().toString());
        }else if (btnCurrent.getId() == R.id.btn_8){
            result.append(btn_8.getText().toString());
        }else if (btnCurrent.getId() == R.id.btn_9){
            result.append(btn_9.getText().toString());
        }else if ((btnCurrent.getId() == R.id.btn_dot) && !result.getText().toString().contains(".")){
            if(result.length() == 0){
                result.append("0" + btn_dot.getText().toString());
            }else result.append(btn_dot.getText().toString());
        }

        if (operatorCount == 0) {
            if (btnCurrent.getId() == R.id.btn_mul) {
                result.append("x");
                operatorCount++;
            } else if (btnCurrent.getId() == R.id.btn_sub) {
                result.append("-");
                operatorCount++;
            } else if (btnCurrent.getId() == R.id.btn_add) {
                result.append("+");
                operatorCount++;
            } else if (btnCurrent.getId() == R.id.btn_div) {
                result.append("÷");
                operatorCount++;
            }
        }

        if (btnCurrent.getId() == R.id.btn_equal) {
            afterEqualClicked();
        }
    }

    private void afterEqualClicked() {
        String input = result.getText().toString();
        String[] parts = new String[2];
        if(input.contains("+")) {
            parts = input.split("\\+");
            operator = "+";
        }
        else if (input.contains("-")) {
            parts = input.split("-");
            operator = "-";
        }
        else if (input.contains("x")) {
            parts = input.split("x");
            operator = "x";
        }
        else if (input.contains("÷")) {
            parts = input.split("÷");
            operator = "÷";
        }

        num1 = Double.parseDouble(parts[0]);
        num2 = Double.parseDouble(parts[1]);
        doCalculation();
        operatorCount = 0;
    }


    private void doCalculation() {
        switch (operator){
            case "x":
                result.setText(String.valueOf(num1 * num2));
                break;
            case "-":
                result.setText(String.valueOf(num1 - num2));
                break;
            case "+":
                result.setText(String.valueOf(num1 + num2));
                break;
            case "÷":
                if (num2 != 0)
                    result.setText(String.valueOf(num1 / num2));
                else
                    result.setText("Error!!! Can't divide by Zero");
                break;
        }
    }


    private void init() {
        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_dot = findViewById(R.id.btn_dot);
        btn_mul = findViewById(R.id.btn_mul);
        btn_sub = findViewById(R.id.btn_sub);
        btn_add = findViewById(R.id.btn_add);
        btn_div = findViewById(R.id.btn_div);
        btn_equal = findViewById(R.id.btn_equal);
        result = findViewById(R.id.result);
    }
}