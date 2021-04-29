package com.example.ch06_tabhost;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;


@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.tabHost: xml의 TabHost를 java 클래스인 TabActivity의 메소드인 getTabHost()를 이용해 연결한다.
        TabHost tabHost = super.getTabHost();

        //2.탭메뉴:
//        TabSpec tab1 = tabHost.newTabSpec("SONG").setIndicator("음악별");
//        //3.탭과 콘텐츠를 연결한다.
//        tab1.setContent(R.id.tabSong);
//        tabHost.addTab(tab1);

        TabSpec tabCat = tabHost.newTabSpec("CAT").setIndicator("고양이");
        tabCat.setContent(R.id.ivCat);
        tabHost.addTab(tabCat);

        TabSpec tabDog = tabHost.newTabSpec("DOG").setIndicator("강아지");
        tabDog.setContent(R.id.ivDog);
        tabHost.addTab(tabDog);

        TabSpec tabRabbit = tabHost.newTabSpec("RABBIT").setIndicator("토끼");
        tabRabbit.setContent(R.id.ivRabbit);
        tabHost.addTab(tabRabbit);

        TabSpec tabHorse = tabHost.newTabSpec("HORSE").setIndicator("말");
        tabHorse.setContent(R.id.ivHorse);
        tabHost.addTab(tabHorse);


//        TabSpec tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("음악별");
//        tabSpecSong.setContent(R.id.tabSong);
//        tabHost.addTab(tabSpecSong);

//        TabSpec tabSpecArtist = tabHost.newTabSpec("ARTIST")
//                .setIndicator("가수별");
//        tabSpecArtist.setContent(R.id.tabArtist);
//        tabHost.addTab(tabSpecArtist);
//
//        TabSpec tabSpecAlbum = tabHost.newTabSpec("ALBUM").setIndicator("앨범별");
//        tabSpecAlbum.setContent(R.id.tabAlbum);
//        tabHost.addTab(tabSpecAlbum);

        tabHost.setCurrentTab(0);
    }
}
