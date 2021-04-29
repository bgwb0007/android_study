package com.example.implicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("암시적 인텐트");

        Button btnDial = (Button) findViewById(R.id.btnDial);
        Button btnWeb = (Button) findViewById(R.id.btnWeb);
        Button btnGoogle = (Button) findViewById(R.id.btnGoogle);
        Button btnSearch = (Button) findViewById(R.id.btnSearch);
        Button btnSms = (Button) findViewById(R.id.btnSms);
        Button btnPhoto = (Button) findViewById(R.id.btnPhoto);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:01088360007");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.naver.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        

    }
}