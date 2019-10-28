package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonC = (Button) findViewById(R.id.button10);

        Button buttonAdd = (Button) findViewById(R.id.button33);
        Button buttonSub = (Button) findViewById(R.id.button23);
        Button buttonDel = (Button) findViewById(R.id.button13);
        Button buttonMul = (Button) findViewById(R.id.button12);
        Button buttonDec = (Button) findViewById(R.id.button11);

        Button button0 = (Button) findViewById(R.id.button50);
        Button button1 = (Button) findViewById(R.id.button40);
        Button button2 = (Button) findViewById(R.id.button41);
        Button button3 = (Button) findViewById(R.id.button42);
        Button button4 = (Button) findViewById(R.id.button30);
        Button button5 = (Button) findViewById(R.id.button31);
        Button button6 = (Button) findViewById(R.id.button32);
        Button button7 = (Button) findViewById(R.id.button20);
        Button button8 = (Button) findViewById(R.id.button21);
        Button button9 = (Button) findViewById(R.id.button22);

        Button buttonCount = (Button) findViewById(R.id.button43);


        final TextView textView = (TextView) findViewById(R.id.text_view);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText() + "0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText() + "7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText() + "9");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText() + "+");
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText() + "-");
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText((textView.getText() + "*"));
            }
        });

        buttonDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText() + "/");

            }
        });

        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = textView.getText().toString();
                if(!str.equals("")&& str.length() != 0)
                textView.setText(str.substring(0,str.length() - 1));
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(null);
            }
        });

        buttonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(Count(textView.getText().toString()));
            }
        });
    }

    public String Count(String str){
        Stack stack;
        return "Finish";
    }




}
