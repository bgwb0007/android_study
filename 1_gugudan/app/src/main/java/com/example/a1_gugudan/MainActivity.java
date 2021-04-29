package com.example.a1_gugudan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("구구단 맞추기");

        EditText Edit1, Edit2, Edit3;
        Button btnRandom, btnResult;
        TextView textResult;

        Edit1 = (EditText) findViewById(R.id.Edit1);
        Edit2 = (EditText) findViewById(R.id.Edit2);
        Edit3 = (EditText) findViewById(R.id.Edit3);
        btnRandom = (Button) findViewById(R.id.BtnRandom);
        btnResult = (Button) findViewById(R.id.BtnResult);
        ListView listView = findViewById(R.id.listView);

        ArrayList<String> data = new ArrayList<String>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                data);
        listView.setAdapter(adapter);

        final Integer[] random = {0,0};

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rand1 = new Random().nextInt(8)+2;
                int rand2 = new Random().nextInt(8)+2;
                Edit1.setText(rand1+"");
                Edit2.setText(rand2+"");
                random[0] = rand1;
                random[1] = rand2;
            }
        });
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int answer = Integer.parseInt(Edit3.getText().toString());
                int result = random[0] * random[1];
                if (answer == result){
                    data.clear();
                    adapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this,"정답입니다!",Toast.LENGTH_SHORT).show();
                }else{
                    data.clear();
                    for (int i=1; i<10;i++){
                        String temp = " "+ random[0]+" X "+i+" = "+random[0]*i;
                        data.add(temp);
                        adapter.notifyDataSetChanged();
                    }
                    Toast.makeText(MainActivity.this,"틀렸습니다!",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}