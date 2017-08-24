package com.example.gangmingu.myphonebook;

import android.content.ContentUris;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.gangmingu.myphonebook.databinding.ActivityMainBinding;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRecyclerView();

            }
        });

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


    }

    private void setRecyclerView() {
        List<PhoneVO> phoneDTO = new ArrayList<PhoneVO>();
        String[] selectionArgs = {""};
        String selectionClause = null;

        if(binding.textSearch.getText().toString().isEmpty()){
            selectionArgs = null;
            selectionClause = null;
        } else {
            selectionArgs[0] = binding.textSearch.getText().toString() + "%";
            selectionClause = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_PRIMARY + " Like ?";

        }

        Cursor cursor = this.getContentResolver().query(

                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null, // PROJECTION  다보여줘
                selectionClause, // 조건
                selectionArgs, // 조건값
                ContactsContract.Data.DISPLAY_NAME); //정렬

        if (cursor.getColumnCount() > 0) {
            //이름
            int nameColumn = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_PRIMARY);
            //전화번호
            int phoneColumn = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.Phone.NUMBER);

            while (cursor.moveToNext()) {
                String name = cursor.getString(nameColumn);
                String phone = cursor.getString(phoneColumn);

                //사용자 전화번호 고유 아이디
                int cIdex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID);
                long cId = cursor.getLong(cIdex); // 사용자 사진있는 인덱스 주소

                //사진이 저장된 실제 위치
                Uri uri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI,cId);

                //사진 읽기
                InputStream inputStream = ContactsContract.Contacts.openContactPhotoInputStream(
                        this.getContentResolver(),uri);

                //읽은 사진 Bitmap으로 변환
                Bitmap cPhoto = null;
                if (inputStream != null) {
                    cPhoto = BitmapFactory.decodeStream(inputStream);
                }
                phoneDTO.add(new PhoneVO(name, phone, cPhoto));
            }

            //어답터 초기화
            RcAdapter rcAdapter = new RcAdapter(this, phoneDTO);
            binding.listView.setLayoutManager(new LinearLayoutManager(this));
            binding.listView.setAdapter(rcAdapter);
        }

    }
}