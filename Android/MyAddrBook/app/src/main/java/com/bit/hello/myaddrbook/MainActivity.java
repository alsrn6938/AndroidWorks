package com.bit.hello.myaddrbook;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.bit.hello.myaddrbook.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);


        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.textName.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this,"이름은 필수 항목입니다.", Toast.LENGTH_LONG).show();
                    binding.textName.requestFocus();
                    return ;
                }
                if(binding.textBirth.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"생일은 필수 항목입니다.", Toast.LENGTH_LONG).show();
                    binding.textBirth.requestFocus();
                    return ;
                } else {
                    Calendar calendar = Calendar.getInstance();
                    try {
                        calendar.setTime((new SimpleDateFormat("yyyy/mm/dd")).parse(
                                binding.textBirth.getText().toString()));
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this,"날짜 형식이 잘못 되었습니다.(eg yyyy/mm/dd)",Toast.LENGTH_LONG).show();
                        return ;
                    }
                }
                if(binding.textTel.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this,"전화번호는 필수 항목입니다.", Toast.LENGTH_LONG).show();
                    binding.textTel.requestFocus();
                    return ;
                }
                //입력된 값을 vo에 저장
                AddrTableVO vo = makeVO();
                DBHelper dbHelper = new DBHelper(MainActivity.this);
                long insertRow = dbHelper.insertDB(vo);
                Toast.makeText(MainActivity.this,insertRow + "개 추가",Toast.LENGTH_LONG).show();

                makeViewList();



            }
        });

        binding.btnClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                binding.textName.setText("");
                binding.textBirth.setText("");
                binding.textTel.setText("");
            }
        });

        makeViewList();
    }



    private AddrTableVO makeVO(){
        AddrTableVO vo = new AddrTableVO();
        vo.setSname(binding.textName.getText().toString());
        vo.setSbirth(binding.textBirth.getText().toString());
        vo.setStel(binding.textTel.getText().toString());

        return vo;
    }


    private void makeViewList(){
        //DBHelper와 RecyclerAdapter를 이용하여 ListView완성
        //데이터를 읽기 위해서 Helper Loadding


        DBHelper dbHelper = new DBHelper(this);
        //DB을 읽어서 addrDTO에 받기

        List<AddrTableVO> addrDTO = dbHelper.readFromDB();


        binding.listView.setLayoutManager(new LinearLayoutManager(this));
        RcAdapter rcAdapter = new RcAdapter(this,addrDTO);
        binding.listView.setAdapter(rcAdapter);

    }
}
