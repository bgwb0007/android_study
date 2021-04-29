package com.example.ch07_login_dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 정보 입력");

//        TextView tvName = (TextView) findViewById(R.id.tvName);
//        TextView tvEmail = (TextView) findViewById(R.id.tvEmail);

        EditText edtName = findViewById(R.id.edtName);
        EditText edtEmail = findViewById(R.id.edtEmail);

        Button button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str1 = edtName.getText().toString();
                String str2 = edtEmail.getText().toString();

                //0.콘텐트 뷰를 제작한다(dialog에서 사용할)
                View dlgView = View.inflate(MainActivity.this,
                                            R.layout.dialog1,
                                            null);

                EditText dlgEdt1 = dlgView.findViewById(R.id.dlgEdt1);
                EditText dlgEdt2 = dlgView.findViewById(R.id.dlgEdt2);

                dlgEdt1.setText(str1);
                dlgEdt2.setText(str2);

                //1.다이얼로그 객체를 만든다~!
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                //2.다이얼로그 꾸미기, 옵션, 속성 설정!
                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.drawable.ic_menu_allfriends);
                //3.다이얼로그에 이미 만들어진 콘텐트뷰를 꽂는다. 내용(content), items, 1개일 message, 이부분이 조금 복잡
                //그래서 사용자 xml로 만든 뷰를 활용한다.
                //고로 dialog에서 사용할 콘텐트 뷰를 미리 사전 제작을 해놓아한다.(inflate 방식으로)
                dlg.setView(dlgView);

                //4.positive 버튼 설정
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //5.dialog의 확인 버튼을 눌렀을 때
                        //위쪽 dialog의 값을, 아래쪽 activity_main 으로 보낸다.

                        EditText dlgEdt1 = dlgView.findViewById(R.id.dlgEdt1);
                        EditText dlgEdt2 = dlgView.findViewById(R.id.dlgEdt2);

                        String strName = dlgEdt1.getText().toString();
                        String strEmail = dlgEdt2.getText().toString();

//                        tvName.setText(strName);
//                        tvEmail.setText(strEmail);

                        edtName.setText(strName);
                        edtEmail.setText(strEmail);

                    }
                });

                //6.negative 버튼 설정
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //0.xml로 만든 toast를 View 미리 준비
                        View toastView = View.inflate(getApplicationContext(),
                                                     R.layout.toast1,
                                                    null);

                        //1.Toast객체를 만든다.
                        Toast toast1 = new Toast(getApplicationContext());

                        //추가로 위치설정을 넣는다
                        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE))
                                .getDefaultDisplay();
                        int xOffset = (int) (Math.random() * display.getWidth());
                        int yOffset = (int) (Math.random() * display.getHeight());

                        toast1.setGravity(Gravity.TOP | Gravity.LEFT,
                                xOffset, yOffset);


                        //4.toastView에서 tv1을 가져온다.
                        TextView tv1 = toastView.findViewById(R.id.toastText1);
                        tv1.setText("취소했습니다.");

                        //2.Toast의 꾸미기, 옵션, 속성을 설정한다.
                        toast1.setView(toastView);

                        //3.toast를 show()
                        toast1.show();

                    }
                });

                //7. dlg를 show() 마지막 작업
                dlg.show();

            }
        });





    }
}
