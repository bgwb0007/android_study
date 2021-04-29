package com.example.ch07_menu_option;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

//    LinearLayout baseLayout;
//    Button button1;
    EditText edt1;
    ImageView iv1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.ex07_1_jeju);
        setTitle("배경색 바꾸기");

//        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
//        button1 = (Button) findViewById(R.id.button1);

        edt1 = findViewById(R.id.edt1);
        iv1 = findViewById(R.id.iv1);

    }

    //onCreate()메소드 밑에
    //alt + insert 키로 overriding

    //1.메뉴를 바인딩 한다. 정확하게는 메뉴 생성
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);

        return super.onCreateOptionsMenu(menu);
    }

    //2.메뉴의 각 아이템에 이벤트 처리

    float fAngle =0.0f;
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemRotate:

                String strAngle = edt1.getText().toString();
                //fAngle = fAngle + Float.parseFloat(strAngle);
                fAngle += Float.parseFloat(strAngle);
                iv1.setRotation(fAngle);

//                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.item1:
                iv1.setImageResource(R.drawable.jeju2);
                item.setChecked(true);
//                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.item2:
//                baseLayout.setBackgroundColor(Color.BLUE);
                iv1.setImageResource(R.drawable.jeju4);
                item.setChecked(true);
                return true;
            case R.id.item3:
                iv1.setImageResource(R.drawable.jeju6);
                item.setChecked(true);
//                button1.setRotation(45);
                return true;

//            case R.id.subSize:
//                button1.setScaleX(2);
//                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}