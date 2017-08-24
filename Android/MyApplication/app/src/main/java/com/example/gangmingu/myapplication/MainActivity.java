package com.example.gangmingu.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.gangmingu.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding.btnSave.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                AddrTableVO vo = makeVO();
                DBHelper dbHelper = new DBHelper(MainActivity.this);

                dbHelper.insertDB(vo);



            }
        });
    }

    public AddrTableVO makeVO(){
        AddrTableVO vo = new AddrTableVO();
        vo.setAno(binding.setNo.getText().toString());
        vo.setAname(binding.setName.getText().toString());
        vo.setAtel(binding.setTel.getText().toString());

        return vo;
    }
}
