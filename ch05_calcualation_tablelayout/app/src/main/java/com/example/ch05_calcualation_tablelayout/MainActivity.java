package com.example.ch05_calcualation_tablelayout;


import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;
    String num1, num2;
    Integer result;

//    Button btn0;
//    Button btn1;
//    Button btn2;
//    Button btn3;
//    Button btn4;
//    Button btn5;
//    Button btn6;
//    Button btn7;
//    Button btn8;
//    Button btn9;

    Button btnArr[] = new Button[10];

    // 10개 숫자 버튼 배열
//    Button[] numButtons = new Button[10];
    // 10개 숫자 버튼의 id 값 배열
//    Integer[] numBtnIDs = { R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2,
//            R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6,
//            R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9 };
    int i; // 증가값 용도

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.grid_layout);

        setTitle("테이블레이아웃 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);



//        btn0 = findViewById(R.id.BtnNum0);
//        btn1 = findViewById(R.id.BtnNum1);
//        btn2 = findViewById(R.id.BtnNum2);
//        btn3 = findViewById(R.id.BtnNum3);
//        btn4 = findViewById(R.id.BtnNum4);
//        btn5 = findViewById(R.id.BtnNum5);
//        btn6 = findViewById(R.id.BtnNum6);
//        btn7 = findViewById(R.id.BtnNum7);
//        btn8 = findViewById(R.id.BtnNum8);
//        btn9 = findViewById(R.id.BtnNum9);

//        btnArr[0] = findViewById(R.id.BtnNum0);
//        btnArr[1] = findViewById(R.id.BtnNum1);
//        btnArr[2] = findViewById(R.id.BtnNum2);

        int NumArr[] = {R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3, R.id.BtnNum4,
                        R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7,R.id.BtnNum8, R.id.BtnNum9};

        for(int i=0; i<=9;++i) {
            btnArr[i] =findViewById(NumArr[i]);
        }

        textResult = (TextView) findViewById(R.id.TextResult);

        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

//        btnAdd = (Button) findViewById(R.id.BtnDiv);

        btnSub.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        btnMul.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        for(int i=0; i<=9; ++i)
        {
            final int finalI = i;
            btnArr[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //포커스 위치를 알아내서
                    if(edit1.isFocused())//1.edit1 포커스 있으면, edit1에다가 0을 넣는다
                    {
                        String str = edit1.getText().toString() + finalI;
                        edit1.setText(str);
                    }
                    else if(edit2.isFocused())//2.edit2 포커스 있으면, edit2에다가 0을 넣는다
                    {
                        String str = edit2.getText().toString() + finalI;
                        edit2.setText(str);
                    }
                }
            });
        }



//        btn0.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //포커스 위치를 알아내서
//                if(edit1.isFocused())//1.edit1 포커스 있으면, edit1에다가 0을 넣는다
//                {
//                    String str = edit1.getText().toString() + "0";
//                    edit1.setText(str);
//                }
//                else if(edit2.isFocused())//2.edit2 포커스 있으면, edit2에다가 0을 넣는다
//                {
//                    String str = edit2.getText().toString() + "0";
//                    edit2.setText(str);
//                }
//            }
//        });

//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //포커스 위치를 알아내서
//                if(edit1.isFocused())//1.edit1 포커스 있으면, edit1에다가 0을 넣는다
//                {
//                    String str = edit1.getText().toString() + "1";
//                    edit1.setText(str);
//                }
//                else if(edit2.isFocused())//2.edit2 포커스 있으면, edit2에다가 0을 넣는다
//                {
//                    String str = edit2.getText().toString() + "1";
//                    edit2.setText(str);
//                }
//            }
//        });
//
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //포커스 위치를 알아내서
//                if(edit1.isFocused())//1.edit1 포커스 있으면, edit1에다가 0을 넣는다
//                {
//                    String str = edit1.getText().toString() + "2";
//                    edit1.setText(str);
//                }
//                else if(edit2.isFocused())//2.edit2 포커스 있으면, edit2에다가 0을 넣는다
//                {
//                    String str = edit2.getText().toString() + "2";
//                    edit2.setText(str);
//                }
//            }
//        });

//        // 숫자 버튼 10개를 대입
//        for (i = 0; i < numBtnIDs.length; i++) {
//            numButtons[i] = (Button) findViewById(numBtnIDs[i]);
//        }
        // 숫자 버튼 10개에 대해서 클릭이벤트 처리
//        for (i = 0; i < numBtnIDs.length; i++) {
//
//            final int index; // 주의! 꼭 필요함..
//            index = i;
//
//            numButtons[index].setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    // 포커스가 되어 있는 에디트텍스트에 숫자 추가
//                    if (edit1.isFocused() == true) {
//                        num1 = edit1.getText().toString()
//                                + numButtons[index].getText().toString();
//                        edit1.setText(num1);
//                    } else if (edit2.isFocused() == true) {
//                        num2 = edit2.getText().toString()
//                                + numButtons[index].getText().toString();
//                        edit2.setText(num2);
//                    } else {
//                        Toast.makeText(getApplicationContext(),
//                                "먼저 에디트텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
//
//                    }
//
//                }
//            });
//
//        }

    }
}
