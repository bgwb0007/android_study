package com.example.ch07_dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button1 = (Button) findViewById(R.id.button1);

        boolean[] checkArray = new boolean[] { false, false, false };
        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                final String[] versionArray = new String[] { "누가", "오레오", "파이" };
                //final boolean[] checkArray = new boolean[] { true, false, false };
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("좋아하는 버전은?");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setMultiChoiceItems(versionArray, checkArray,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which, boolean isChecked) {

                                //생략이 가능했다. 안드로이드가 알아서 해줬기 때문에...
//                                if(isChecked == true)
//                                    checkArray[which] = true;
//                                else if(isChecked == false)
//                                    checkArray[which] = false;

                                String str1 = "";
                                int cnt = 0;

                                //배열을 돌면서... true or false 체크 한다!
                                for(int i=0; i<checkArray.length;++i)
                                {
//                                    if(checkArray[i] == true)
                                    if(checkArray[i])//배열안에 true 체크가 되어있으면
                                    {
                                        cnt++;//첫번째 체크임
                                        if(cnt == 1)
                                            str1 = versionArray[i];
                                        else
                                            str1 = str1 + "," + versionArray[i];
                                    }
                                }

                                if(cnt ==0)
                                    str1 = "선택없음";

                                button1.setText(str1);

                                //button1.setText(versionArray[which]);

                            }
                        });
                dlg.setPositiveButton("닫기", null);
                dlg.show();

            }
        });
    }
}
