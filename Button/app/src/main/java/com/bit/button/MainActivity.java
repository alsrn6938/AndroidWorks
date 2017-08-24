package com.bit.button;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edittext1);
        btnOk = (Button) findViewById(R.id.btnok);

        btnOk.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, editText.getText(), Toast.LENGTH_LONG).show();
                Snackbar sb = Snackbar.make(v,editText.getText(), Snackbar.LENGTH_LONG);

                sb.setAction("YES", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_LONG).show();
                    }
                });
                sb.show();
            }
        });
    }
}
