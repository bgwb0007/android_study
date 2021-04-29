package com.example.a2_cal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("2_계산기");

        EditText Edit1, Edit2, Edit3;
        TextView op;
        RadioGroup radio;
        Button btnResult;

        Edit1 = (EditText) findViewById(R.id.Edit1);
        Edit2 = (EditText) findViewById(R.id.Edit2);
        Edit3 = (EditText) findViewById(R.id.Edit3);
        op = (TextView) findViewById(R.id.op);
        radio = (RadioGroup) findViewById(R.id.rGroup);
        btnResult = (Button)findViewById(R.id.btnResult);
        final String[] op_temp = {""};

        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton)findViewById(checkedId);
                op_temp[0] = rb.getText().toString();
                op.setText(op_temp[0]);
            }
        });
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double num1 = Double.parseDouble(Edit1.getText().toString());
                Double num2 = Double.parseDouble(Edit2.getText().toString());
                Double cal;
                if (op_temp[0].equals("+")){
                    cal = num1 + num2;
                    Edit3.setText(cal+"");
                }else if (op_temp[0].equals("-")){
                    cal = num1 - num2;
                    Edit3.setText(cal+"");
                }else if (op_temp[0].equals("*")){
                    cal = num1 * num2;
                    Edit3.setText(cal+"");
                }else if (op_temp[0].equals("/")){
                    if (num2 == 0){
                        cal = 0.0;
                    }else{
                        cal = num1 / num2;
                    }
                    Edit3.setText(cal+"");
                }

            }
        });

    }
}