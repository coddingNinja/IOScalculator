package com.example.ioscalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private double data_1 = 0, data_2 = 0, Result = 0;
    private char operator;
    boolean flag = true;
    private stack s;
    private Button but_7, but_8, but_9, but_6, but_5, but_4, but_3, but_2, but_1, but_pluss, but_minus, but_equal, but_multi, but_devide, but_dot, but_AC, but_perce, but_sign, but_zero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        build();
        but_1.setOnClickListener(this);
        but_2.setOnClickListener(this);
        but_3.setOnClickListener(this);
        but_4.setOnClickListener(this);
        but_5.setOnClickListener(this);
        but_6.setOnClickListener(this);
        but_7.setOnClickListener(this);
        but_8.setOnClickListener(this);
        but_9.setOnClickListener(this);
        but_perce.setOnClickListener(this);
        but_pluss.setOnClickListener(this);
        but_minus.setOnClickListener(this);
        but_devide.setOnClickListener(this);
        but_multi.setOnClickListener(this);
        but_dot.setOnClickListener(this);
        but_equal.setOnClickListener(this);
        but_zero.setOnClickListener(this);
        but_AC.setOnClickListener(this);
        but_sign.setOnClickListener(this);

    }

    public void build() {
        editText = findViewById(R.id.edittext);
        editText.setFocusable(false);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(uiOptions);
        s = new stack(2);
        but_7 = findViewById(R.id.seven);
        but_8 = findViewById(R.id.eight);
        but_9 = findViewById(R.id.nine);
        but_6 = findViewById(R.id.six);
        but_5 = findViewById(R.id.five);
        but_4 = findViewById(R.id.four);
        but_3 = findViewById(R.id.three);
        but_2 = findViewById(R.id.two);
        but_1 = findViewById(R.id.one);
        but_zero = findViewById(R.id.zero);
        but_equal = findViewById(R.id.equal);
        but_pluss = findViewById(R.id.but_plus);
        but_minus = findViewById(R.id.minus);
        but_devide = findViewById(R.id.devide);
        but_multi = findViewById(R.id.multiply);
        but_dot = findViewById(R.id.dot);
        but_perce = findViewById(R.id.percent);
        but_sign = findViewById(R.id.sign);
        but_AC = findViewById(R.id.AC);

    }

    //    @SuppressLint("SetTextI18n")
    @SuppressLint("SetTextI18n")
    public void calculate() {

        data_2 = s.pop();
        data_1 = s.pop();


        switch (operator) {
            case '+':
                Result = data_1 + data_2;
                break;
            case '-':
                Result = data_1 - data_2;
                break;
            case '*':
                Result = data_1 * data_2;
                break;
            case '/':
                Result = data_1 / data_2;
                break;
            case '%':
                Result = data_2 / 100;
                break;
        }


        editText.setText("" + Result);
        s.push(Result);
    }

    public void upgrade(Button b) {

        String s = String.format("%s%s", editText.getText().toString(), b.getText().toString());
        editText.setText(s);
        flag = true;
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.seven) {
            if (!flag) {
                editText.setText(" ");
            }

            upgrade(but_7);
        } else if (v.getId() == R.id.eight) {
            if (!flag) {
                editText.setText(" ");
            }

            upgrade(but_8);
        } else if (v.getId() == R.id.nine) {
            if (!flag) {
                editText.setText(" ");
            }
            upgrade(but_9);

        } else if (v.getId() == R.id.six) {
            if (!flag) {
                editText.setText(" ");
            }
            upgrade(but_6);

        } else if (v.getId() == R.id.five) {
            if (!flag) {
                editText.setText(" ");
            }
            upgrade(but_5);

        } else if (v.getId() == R.id.four) {
            if (!flag) {
                editText.setText(" ");
            }
            upgrade(but_4);

        } else if (v.getId() == R.id.three) {
            if (!flag) {
                editText.setText(" ");
            }
            upgrade(but_3);

        } else if (v.getId() == R.id.two) {
            if (!flag) {
                editText.setText(" ");
            }
            upgrade(but_2);

        } else if (v.getId() == R.id.one) {
            if (!flag) {
                editText.setText(" ");
            }
            upgrade(but_1);

        } else if (v.getId() == R.id.zero) {
            if (!flag) {
                editText.setText(" ");
            }
            upgrade(but_zero);

        } else if (v.getId() == R.id.dot) {
            int index = editText.getText().toString().indexOf('.');
            if (index == -1) {
                upgrade(but_dot);
            }
        } else if (v.getId() == R.id.equal) {
//
            s.push(Double.parseDouble(editText.getText().toString()));

            calculate();
            operator = '\0';
            flag = false;


        } else if (v.getId() == R.id.AC) {
            editText.setText("");
            operator = '\0';
            while (!s.isEmpty()) {
                s.pop();
            }
        } else if (v.getId() == R.id.but_plus) {

            if (operator != '\0') {
                flag = false;
            }
            if (!s.isFull()) {
                if (editText.getText().toString().trim().isEmpty()) {
                    s.push(0);


                } else if (flag && !editText.getText().toString().trim().isEmpty()) {
                    s.push(Double.parseDouble(editText.getText().toString()));


                } else if (!flag && !editText.getText().toString().trim().isEmpty() && operator != '\0') {
                    s.push(Double.parseDouble(editText.getText().toString()));
                    calculate();
                }

            }
            operator = '+';
            flag = false;
        } else if (v.getId() == R.id.minus) {
            if (operator != '\0') {
                flag = false;
            }
            if (!s.isFull()) {
                if (editText.getText().toString().trim().isEmpty()) {
                    s.push(0);
                } else if (flag && !editText.getText().toString().trim().isEmpty()) {
                    s.push(Double.parseDouble(editText.getText().toString()));
                } else if (!flag && !editText.getText().toString().trim().isEmpty() && operator != '\0') {
                    s.push(Double.parseDouble(editText.getText().toString()));
                    calculate();
                }

            }
            operator = '-';
            flag = false;
        } else if (v.getId() == R.id.multiply) {
            if (operator != '\0') {
                flag = false;
            }
            if (!s.isFull()) {
                if (editText.getText().toString().trim().isEmpty()) {
                    s.push(0);


                } else if (flag && !editText.getText().toString().trim().isEmpty()) {
                    s.push(Double.parseDouble(editText.getText().toString()));


                } else if (!flag && !editText.getText().toString().trim().isEmpty() && operator != '\0') {
                    s.push(Double.parseDouble(editText.getText().toString()));
                    calculate();
                }

            }
            operator = '*';
            flag = false;

        } else if (v.getId() == R.id.devide) {
            if (operator != '\0') {
                flag = false;
            }
            if (!s.isFull()) {
                if (editText.getText().toString().trim().isEmpty()) {
                    s.push(0);


                } else if (flag && !editText.getText().toString().trim().isEmpty()) {
                    s.push(Double.parseDouble(editText.getText().toString()));


                } else if (!flag && !editText.getText().toString().trim().isEmpty() && operator != '\0') {
                    s.push(Double.parseDouble(editText.getText().toString()));
                    calculate();
                }

            }
            operator = '/';
            flag = false;
        } else if (v.getId() == R.id.sign) {
            if (!editText.getText().toString().startsWith("-") && !editText.getText().toString().equals("0")) {
                editText.setText(editText.getText().insert(0, "-"));
            } else if (editText.getText().toString().startsWith("-")) {
                editText.setText(editText.getText().toString().substring(1));
            }
        }


    }
}
