package com.example.ch11_listview_simple;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("리스트뷰 테스트");

        final String[] mid = { "히어로즈", "24시", "로스트", "로스트룸", "스몰빌", "탐정몽크",
                "빅뱅이론", "프렌즈", "덱스터", "글리", "가쉽걸", "테이큰", "슈퍼내추럴", "브이" };

        //1.어댑터뷰 객체 생성, 그리고 바인딩
        ListView adapterView = findViewById(R.id.listView1);

        //2.어댑터를 만든다(어댑터뷰에 꽂을) -> 1)심플방식(2번디자인기준)
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                                    android.R.layout.simple_list_item_1,
                                    mid);

        //3.어댑터를 어댑터뷰(listview)에 꽂는다
        adapterView.setAdapter(adapter);

        //4.어댑터가 꽂힌 어댑터뷰의 아이템을 이벤트 처리
        adapterView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                                mid[position],
                            Toast.LENGTH_SHORT).show();
            }
        });


    }
}
