package com.example.ch11_gridview_base_adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gv1 = findViewById(R.id.gv1);

        //어댑터를 만든다(복잡 버전 -> BaseAdapter 을 이용해서)
        //어댑터 만들기 3요소 -> (1.this, 2.디자인, 3.데이터)
        // -> 심플은 ArrayAdapter 클래스로 만들었었음
        MyGridAdapter adapter1 = new MyGridAdapter(this);

        //어댑터뷰 gv1에, 어댑터 adapter1을 장착한다.
        gv1.setAdapter(adapter1);

        //어댑터뷰의 아이템 이벤트 처리는 getView() 메소드 안에 구현한다.!



    }

    //내부(inner) 클래스 위치에 만든다.
    class MyGridAdapter extends BaseAdapter
    {
//        Activity act;
        Context con1;

        //1.this는 생성자로 받아와서, 멤버 변수에 담는다. 뭐를? 액티비티를


        public MyGridAdapter(Context con1) {
            this.con1 = con1;
        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //2.디자인과 3.데이터를 처리
            //3.데이터를 가지고 2번 디자인에 끼워넣는다.
            return null;
        }
    }


}