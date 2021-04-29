package com.example.notification;

import androidx.appcompat.app.AppCompatActivity; import androidx.core.app.NotificationCompat; import android.app.Notification; import android.app.NotificationChannel; import android.app.NotificationManager; import android.app.PendingIntent; import android.content.Intent; import android.os.Build; import android.os.Bundle; import android.view.View; import android.widget.Button; import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btnOn, btnCheck;
    NotificationManager manager;
    NotificationCompat.Builder builder;
    ImageView iv;
    private static String CHANNEL_ID = "channel1";
    private static String CHANEL_NAME = "Channel1";
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.qrView);

        btnOn = findViewById(R.id.btnOn);
        btnOn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                showNoti("퇴실");
            }
        });
        btnCheck = findViewById(R.id.btnCheck);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNoti("출석체크");
            }
        });
    Intent intent = getIntent();
    String name = intent.getStringExtra("name");
    }

    public void showNoti(String name){
        builder = null;
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //버전 오레오 이상일 경우
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            manager.createNotificationChannel(
                    new NotificationChannel(CHANNEL_ID, CHANEL_NAME, NotificationManager.IMPORTANCE_DEFAULT) );
            builder = new NotificationCompat.Builder(this,CHANNEL_ID);
            //하위 버전일 경우
            }else{
            builder = new NotificationCompat.Builder(this);
        }
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("name",name);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 101, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        //알림창 제목
        builder.setContentTitle("부산 IT 인재교육원");
        //알림창 메시지
        builder.setContentText(name+"시간입니다. QR 코드를 찍어주세요!");
        //알림창 아이콘
        builder.setSmallIcon(R.drawable.aa);
        //알림창 터치시 상단 알림상태창에서 알림이 자동으로 삭제되게 합니다.
        builder.setAutoCancel(true);
        //pendingIntent를 builder에 설정 해줍니다. //알림창 터치시 인텐트가 전달할 수 있도록 해줍니다.
        builder.setContentIntent(pendingIntent);
        Notification notification = builder.build();
        //알림창 실행
        manager.notify(1,notification);
    }
}
