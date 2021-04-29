package com.example.ch06_actionbar_and_fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {

    //멤버변수
    //1.탭 클래스로 "탭객체"를 만든다.-> 액션바의 버전을 유의 x버전(통일 시키면 된다)
    ActionBar.Tab tab1, tab2, tab3;//아직은 객체아님, 객체변수임 (new가 없다, or 바인딩이 없다)

    //7-1.MyFrament 객체 "배열"을 만든다!
    MyFragment myFragArr[] = new MyFragment[3];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);//XML을 안쓴다!

//        myFragArr[0] = new MyFragment();
//        myFragArr[1] = new MyFragment();
//        myFragArr[2] = new MyFragment();

        //2.액션바 클래스로 "액션바 객체"를 만든다.
        ActionBar actionBar1;//(정확하게는 객체변수, 아직 객체 아님! new가 없다 or 바인딩 안됐다!)
        //3.만들어진 액션바 객체 변수에 바인딩을 시켜서 객체로 만든다.
        actionBar1 = getSupportActionBar();//액션바 찐객체가 된다.
        actionBar1.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);//액션바 옵션: 액션바 모양 설정

        //4.탭객체(객체변수->찐객체)를 생성한다.(newTab()메소드를 이용해서, 바인딩 개념)
        tab1 = actionBar1.newTab();
        tab1.setText("음악별");
        tab1.setTabListener(this);//탭에 리스너를 장착한다.(setListener)
        //5.탭객체(찐객체)를 액션바 객체(찐객체)에 연결한다.
        actionBar1.addTab(tab1);

        tab2 = actionBar1.newTab();
        tab2.setText("가수별");
        //이벤트처리 연결 -> 나중에 꼭해야함! 안하면 동작안함!
        tab2.setTabListener(this);
        actionBar1.addTab(tab2);

        tab3 = actionBar1.newTab();
        tab3.setText("앨범별");
        //이벤트처리
        tab3.setTabListener(this);
        actionBar1.addTab(tab3);
    }

    //내부클래스(이너클래스) 부분에
    //6.프래그먼트 "클래스"를 만든다(상속을 이용해서) -> 프래그먼트 객체를 찍어내기 위해서
    public static class MyFragment extends Fragment
    {

        String tabName;
        //프래그먼트 만들때 2가지를 해줘야 한다.
        //1.onCreate() 메소드와 2.onCreateView()메소드를 만들어 줘야한다.(정확히는 재정의)

        //6-1. onCreate() -> 프래그먼트 객체 생성시 값 설정?
        //alt + insert 키 -> overriding methods
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);//이줄은 제일 위쪽에 있어야한다.

            //OS와 통신하기 위한 객체 만들기(연결, 준비)
            Bundle data = getArguments();
            tabName = data.getString("tabName");
        }

        //6-2. onCreateView() -> 프래그먼트 내부의 view 만들기(정의)
        //alt + insert 키 -> overriding methods
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            //프래그먼트 내부의 View -> 리니어레이아웃으로 한 번 만들어보자!
            //"리니어레이아웃"을 java Code Only 방식으로 만들겠다. 추천방식은 아님!
            //-> 추천방식은 xml을 통해서 inflate 방식으로 만드거임

            LinearLayout.LayoutParams params
                    = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                                                    LinearLayout.LayoutParams.MATCH_PARENT);

//            LinearLayout baseLayout = new LinearLayout(MainActivity.this);
            LinearLayout baseLayout = new LinearLayout(super.getActivity());
            baseLayout.setOrientation(LinearLayout.VERTICAL);
            baseLayout.setLayoutParams(params);

            if(tabName == "음악별")
                baseLayout.setBackgroundColor(Color.RED);
            else if(tabName == "가수별")
                baseLayout.setBackgroundColor(Color.GREEN);
            else if(tabName == "앨범별")
                baseLayout.setBackgroundColor(Color.BLUE);


            return baseLayout;//리턴은 제일 마지막 줄
        }
    }

    //나자신(MainActivity)가 리스너가 되겠다. 그래서 탭에 달리겠다.(반드시 위에서 해줘야 동작함)
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        //이거 하기전에 MyFragment 객체 배열을 먼저 만들어 놓는다.재활용을 위해서,왜 계속 new하면 안되니까
        //위에 7-1을 먼저 확인
        //7-2. Frag객체 "배열" 안에 있는지 체크를 해서,
        // "frag객체(=예:f)"가 배열안에 없으면, frag객체를 new하고 배열에 넣어둔다(나중에 쓸려고)
        //반대로, 배열안에 있으면, 배열안의 frag객체를 꺼내서(new 할필요없이),
        //frag 객체를 tab에 연결한다.

        MyFragment f=null;
        if(myFragArr[tab.getPosition()]==null)
        {
            f = new MyFragment();
            Bundle data = new Bundle();
            data.putString("tabName", tab.getText().toString());
            f.setArguments(data);

            //객체배열안에 넣어준다(null -> f1)
            myFragArr[tab.getPosition()] = f;
        }
        else
        {
            f = myFragArr[tab.getPosition()];
        }

        //프래그먼트 f를 화면에 최종 연결해서 뿌린다.

        ft.replace(android.R.id.content, f);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }


}