package com.example.baitap.Lab1.Lab1b;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.baitap.R;

public class Lab1b extends AppCompatActivity {

    private TextView resultTextView;
    private String currentDisplay = "";
    private double firstOperand = 0;
    private String operator = "";
    private boolean isNewOperator = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab1b);

        // Áp dụng padding cho chế độ Edge-to-Edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        resultTextView = findViewById(R.id.resultTextView);

        // Thiết lập sự kiện cho các nút số
        setNumberButtonListeners();

        // Thiết lập sự kiện cho các nút phép toán
        setOperatorButtonListeners();
    }

    private void setNumberButtonListeners() {
        int[] numberButtonIds = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btncham};
        View.OnClickListener listener = this::onNumberClick;
        for (int id : numberButtonIds) {
            findViewById(id).setOnClickListener(listener);
        }
    }

    private void setOperatorButtonListeners() {
        int[] operatorButtonIds = {R.id.btncong, R.id.btntru, R.id.btnnhan, R.id.btnchia, R.id.btnbang, R.id.btnClear};
        View.OnClickListener listener = this::onOperatorClick;
        for (int id : operatorButtonIds) {
            findViewById(id).setOnClickListener(listener);
        }
    }

    public void onNumberClick(View view) {
        if (isNewOperator) {
            currentDisplay = "";
            isNewOperator = false;
        }
        Button button = (Button) view;
        currentDisplay += button.getText().toString();
        resultTextView.setText(currentDisplay);
    }

    public void onOperatorClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        if ("=".equals(buttonText)) {
            onEqualClick();
        } else if ("AC".equals(buttonText)) {
            onClearClick();
        } else {
            operator = buttonText;
            firstOperand = Double.parseDouble(currentDisplay);
            isNewOperator = true;
        }
    }

    private void onEqualClick() {
        double secondOperand = Double.parseDouble(currentDisplay);
        double result = 0;
        switch (operator) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
                break;
            case "/":
                result = firstOperand / secondOperand;
                break;
        }
        resultTextView.setText(String.valueOf(result));
        currentDisplay = String.valueOf(result);
        isNewOperator = true;
    }

    public void onClearClick() {
        currentDisplay = "";
        firstOperand = 0;
        operator = "";
        resultTextView.setText("0");
        isNewOperator = false;
    }
}