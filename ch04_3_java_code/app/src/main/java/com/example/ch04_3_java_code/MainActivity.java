package com.example.ch04_3_java_code;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv1;
        TextView tv2;
        TextView tv3;

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);

        tv1.setText("안녕하세요?");
        tv1.setTextColor(Color.RED);
        tv1.setTextSize(40);

        tv2.setTypeface(Typeface.MONOSPACE, Typeface.BOLD_ITALIC);
        
        tv3.setText("가나다라마마사사사사ㅏ사사사사사ㅏ삿사사ㅏ사");
        tv3.setSingleLine();
    }
}