package com.example.ch11_listview_insert_delete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edt1 = findViewById(R.id.edt1);
        Button btn1 = findViewById(R.id.btn1);
        ListView listView1 = findViewById(R.id.listView1);//어댑터 "뷰" 임!

//        String []data2 = new String[3];
//        data2[0] = "안녕하세요!";
//        data2[1] = "안녕하세요22222";

        ArrayList<String> data1 = new ArrayList<String>();
//        data.add("안녕하세요~!");
//        data.add("안녕하세요22222");
//        data.remove(1);

        //어댑터(단순 버전)
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                                                android.R.layout.simple_list_item_1,
                                                data1);
        //어댑터를 어댑터뷰에
        listView1.setAdapter(adapter1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //data1 배열에 값을 추가한다.
                data1.add(edt1.getText().toString());
                //리스트뷰 새로고침 (바뀐데이터 전체로 다시 덮어씀)
                adapter1.notifyDataSetChanged();
            }
        });

        listView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                //data1 의 값을 삭제, 그리고 삭제된후 전체 data 덮어서 갱신
                data1.remove(position);
                adapter1.notifyDataSetChanged();//어댑터를 바뀐 data1로 새로만들어라

                return false;
            }
        });



    }
}