package com.example.dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] versionArray = new String[] {"ver.1", "ver.2","ver.3"};
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("제목입니다");
                //dlg.setMessage("이곳이 내용입니다");
                dlg.setIcon(R.mipmap.ic_launcher);

                dlg.setSingleChoiceItems(versionArray, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        button1.setText(versionArray[which]);
                    }
                });
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "확인을 눌렀네요",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });
    }
}