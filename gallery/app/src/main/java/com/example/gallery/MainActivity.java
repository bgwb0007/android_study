package com.example.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("갤러리 포스터");

        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
        MyGalleryAdapter myGalleryAdapter = new MyGalleryAdapter(this);
        gallery.setAdapter(myGalleryAdapter);
    }

    public class MyGalleryAdapter extends BaseAdapter {
        Context context;
        Integer[] posterId = {R.drawable.aa, R.drawable.aa, R.drawable.aa, R.drawable.aa, R.drawable.aa, R.drawable.aa, R.drawable.aa
            , R.drawable.aa, R.drawable.aa, R.drawable.aa, R.drawable.aa, R.drawable.aa, R.drawable.aa};

        public MyGalleryAdapter(Context c) {
            context = c;
        }
        @Override
        public int getCount() {
            return posterId.length;
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
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(100,150));
            imageView.setImageResource(posterId[position]);

            return imageView;
        }
    }
}