package com.example.ch10_activity1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.btn1);
        RadioGroup rg1 = findViewById(R.id.rg1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1;
                switch (rg1.getCheckedRadioButtonId())
                {
                    case R.id.rdo2:
                        intent1 = new Intent(MainActivity.this, SecondActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.rdo3:
                        intent1 = new Intent(MainActivity.this, ThirdActivity.class);
                        startActivity(intent1);
                        break;
                    default :
                        Toast.makeText(getApplicationContext(),"라디오를 선택해주세요",Toast.LENGTH_SHORT).show();
                        break;
                }

//                Intent intent1;
//                if(rg1.getCheckedRadioButtonId() == R.id.rdo2)
//                {
//                    //인텐트를 만든다!
//                    intent1 = new Intent(MainActivity.this,
//                                                    SecondActivity.class);
//                    startActivity(intent1);
//                }
//                else if(rg1.getCheckedRadioButtonId() == R.id.rdo3)
//                {
//                    intent1 = new Intent(MainActivity.this,
//                                                    ThirdActivity.class);
//                    startActivity(intent1);
//                }
//                else {
//                    Toast.makeText(getApplicationContext(),
//                            "라디오를 선택해주세요",
//                            Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }
}