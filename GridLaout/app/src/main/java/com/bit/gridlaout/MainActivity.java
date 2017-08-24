package com.bit.gridlaout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<String> arrayList = new ArrayList();
    ArrayList<String> arrayArth = new ArrayList();

    long lsum = 0;
    double dsum = 0;

    TextView tv_result;

    Button btn_clear;
    Button btn_del;
    Button btn_plus;
    Button btn_minus;
    Button btn_times;
    Button btn_div;
    Button btn_eq;
    Button btn_dot;

    Button btn_0;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_result = (TextView) findViewById(R.id.tv_result);

        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_del = (Button) findViewById(R.id.btn_del);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_times = (Button) findViewById(R.id.btn_times);
        btn_div = (Button) findViewById(R.id.btn_div);
        btn_eq = (Button) findViewById(R.id.btn_eq);
        btn_dot = (Button) findViewById(R.id.btn_dot);


        btn_clear.setOnClickListener(this);
        btn_dot.setOnClickListener(this);

        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_times.setOnClickListener(this);
        btn_eq.setOnClickListener(this);

        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_clear:

                tv_result.setText("");
                break;

            case R.id.btn_del:

                if (tv_result.getText().toString() != "") {
                    tv_result.setText("");
                }
                break;

            case R.id.btn_plus:
                arrayList.add(tv_result.getText().toString());
                arrayArth.add("+");
                tv_result.setText("");
                break;

            case R.id.btn_minus:
                arrayList.add(tv_result.getText().toString());
                arrayArth.add("-");
                tv_result.setText("");
                break;

            case R.id.btn_times:
                arrayList.add(tv_result.getText().toString());
                arrayArth.add("*");
                tv_result.setText("");
                break;
            case R.id.btn_div:
                arrayList.add(tv_result.getText().toString());
                arrayArth.add("/");
                tv_result.setText("");
                break;

            case R.id.btn_eq:
                if (arrayList.isEmpty()) {
                    tv_result.setText("");
                } else {

                    boolean isDouble = false;
                    int count = 0;
                        String strValue = arrayList.get(count);
                    dsum = Integer.parseInt(strValue);

                        if (strValue.contains(".")) {
                            isDouble = true;
                        }
                        String strValue1 = arrayList.get(++count);

                            switch (arrayArth.get(count)) {
                                case "+":
                                    dsum += Integer.parseInt(strValue1);
                                    break;
                                case "-":
                                    dsum -= Integer.parseInt(strValue1);
                                    break;
                                case "*":
                                    dsum *= Integer.parseInt(strValue1);
                                    break;
                                case "/":
                                    dsum /= Integer.parseInt(strValue1);
                                    break;
                            }
                }
                tv_result.setText(Long.toString(lsum));
                lsum = 0;
                break;


            default:

                String strResult = tv_result.getText().toString();
//                if(Integer.parseInt(strResult) == 0){
//                    strResult = "";
//                }
                strResult += ((Button) v).getText();

                tv_result.setText(strResult);
        }

    }

}
