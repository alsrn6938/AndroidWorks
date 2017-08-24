package com.bit.mycalc;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.bit.mycalc.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ActivityMainBinding mainBinding;
    String operator = "";
    double dsum = 0;
    double lastNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        mainBinding.btn0.setOnClickListener(this);
        mainBinding.btn1.setOnClickListener(this);
        mainBinding.btn2.setOnClickListener(this);
        mainBinding.btn3.setOnClickListener(this);
        mainBinding.btn4.setOnClickListener(this);
        mainBinding.btn5.setOnClickListener(this);
        mainBinding.btn6.setOnClickListener(this);
        mainBinding.btn7.setOnClickListener(this);
        mainBinding.btn8.setOnClickListener(this);
        mainBinding.btn9.setOnClickListener(this);

        mainBinding.btnClear.setOnClickListener(this);
        mainBinding.btnDel.setOnClickListener(this);

        mainBinding.btnPlus.setOnClickListener(this);
        mainBinding.btnMinus.setOnClickListener(this);
        mainBinding.btnTimes.setOnClickListener(this);
        mainBinding.btnDiv.setOnClickListener(this);
        mainBinding.btnEq.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int btnId = view.getId();

        switch (btnId){
            case R.id.btn_clear :
                mainBinding.tvResult.setText("");
                break;

            case R.id.btn_plus :
                operator = "+";
//                lastNum = Double.parseDouble(mainBinding.tvResult.getText().toString());
                lastNum = Double.valueOf(mainBinding.tvResult.getText().toString());
                mainBinding.tvResult.setText("");
                break;

            case R.id.btn_minus :
                operator = "-";
//                lastNum = Double.parseDouble(mainBinding.tvResult.getText().toString());
                lastNum = Double.valueOf(mainBinding.tvResult.getText().toString());
                mainBinding.tvResult.setText("");
                break;

            case R.id.btn_times :
                operator = "*";
//                lastNum = Double.parseDouble(mainBinding.tvResult.getText().toString());
                lastNum = Double.valueOf(mainBinding.tvResult.getText().toString());
                mainBinding.tvResult.setText("");
                break;

            case R.id.btn_div :
                operator = "/";
//                lastNum = Double.parseDouble(mainBinding.tvResult.getText().toString());
                lastNum = Double.valueOf(mainBinding.tvResult.getText().toString());
                mainBinding.tvResult.setText("");
                break;

            case R.id.btn_eq:

                Double tmp = Double.valueOf(mainBinding.tvResult.getText().toString());
                switch (operator) {
                    case "+":
                        lastNum += tmp;
                        break;
                    case "-":
                        lastNum -= tmp;
                        break;
                    case "*":
                        lastNum *= tmp;
                        break;
                    case "/":
                        lastNum /= tmp;
                        break;
                }
                mainBinding.tvResult.setText(String.valueOf(lastNum));
                operator = "=";
                break;

            default:
                String strResult = mainBinding.tvResult.getText().toString();
                strResult += ((Button)view).getText().toString();
                int intResult = Integer.valueOf(strResult);
                strResult = String.valueOf(intResult);
                
                mainBinding.tvResult.setText(strResult);
        }
    }
}
