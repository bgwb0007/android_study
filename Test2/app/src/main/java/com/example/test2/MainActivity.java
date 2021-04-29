package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //0.XML파일을 연결한다.(파일)
        setContentView(R.layout.activity_main);
        setContentView(R.layout.ch04_02);

//        EditText edt1;//1.Java 객체를 만든다(위젯View객체)
//        edt1 = findViewById(R.id.edt1);//2.XML객체를 Java객체에 연결(바인딩)
//
//        Button btn1 = findViewById(R.id.btn1);
//        TextView tv1 = findViewById(R.id.tv1);

        //이벤트 처리
//        버튼객체.set리스너(리스너)

//        btn1.setOnClickListener(리스너);

//        A a1 = new A();
//        A a2 = new A();
//        A a3 = new A();

//        View.OnClickListener a1 = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tv1.setText(edt1.getText().toString());
//            }
//        };

//        btn1.setOnClickListener(a1);


//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tv1.setText(edt1.getText().toString());
//            }
//        });
    }
}