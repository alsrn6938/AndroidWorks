package com.bit.myorient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "onCreate() 호출됨" , Toast.LENGTH_LONG).show();

        Button button = (Button) findViewById(R.id.button);
        if(button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    editText = (EditText) findViewById(R.id.editText);
                    name = editText.getText().toString();
                    Toast.makeText(getApplicationContext(), "입력값 name 변수에 할당함", Toast.LENGTH_LONG).show();
                }
            });
        }

        if(savedInstanceState != null){
            String name = savedInstanceState.getString("name");
            if(editText != null){
                editText.setText("복원된 이름 : " + name);
                Toast.makeText(getApplicationContext(), "이름이 복원됨 " + name, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("name", name);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(this, "onStart() 호출됨" , Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this, "onStop() 호출됨" , Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(this, "onPause() 호출됨" , Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "onResume() 호출됨" , Toast.LENGTH_LONG).show();
    }
}
