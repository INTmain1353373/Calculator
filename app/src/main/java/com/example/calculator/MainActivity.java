package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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

        Button buttonPoint = (Button) findViewById(R.id.button52);

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

        Button btA = (Button) findViewById(R.id.buttonA);
        Button btB = (Button) findViewById(R.id.buttonB);
        Button btC = (Button) findViewById(R.id.buttonC);
        Button btD = (Button) findViewById(R.id.buttonD);

        Button buttonCount = (Button) findViewById(R.id.button43);


        final TextView textView = (TextView) findViewById(R.id.text_view);

        buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textView.getText().length() > 0 && textView.getText().toString().charAt(textView.getText().toString().length() - 1) != '.')
                textView.setText(textView.getText() + ".");
            }
        });

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
               textView.setText(Count(textView));
            }
        });
    }

    public boolean isOperate(char c){//判断字符串是否是运算符
        char a[] = { '+','-','*', '/','(',')', '#'};
        for (int i = 0; i < 7; i++) {
            if (c == a[i]) {
                return true;
            }
        }
        return false;
    }

    int getOperateIndex(String s) {//返回运算符的序号

        char[] a = { '+','-','*', '/','(',')', '#' };
        char c = s.charAt(0);
        for (int i = 0; i < 7; i++) {
            if (c == a[i])
                return i;
        }
        return 100;
    }

    char precede(String str,char s) {//构建运算符优先级数组,并判别两个运算符的优先级
        char[][] list = new char[7][7];
        int[] arr = { 1,1,2,2,3,0,-1 };
        for(int i = 0; i < 7; i++)
        {
            for(int j = 0;j<7;j++)
            {
                if((i == 4 && j == 5) || (i == 6 && j == 6))
                    list[i][j] = '=';
                else
                {
                    if (arr[i] >= arr[j])
                        list[i][j] = '>';
                    else if (arr[i] <= arr[j])
                        list[i][j] = '<';
                }
            }
        }
        for (int i = 0; i < 5; i++)
            list[4][i] = '<';
        for (int i = 0; i < 5; i++)
            list[5][i] = '>';

        //for (int i = 0; i < 7; i++) {
        //	for (int j = 0; j < 7; j++)
        //		cout << list[i][j] << " ";
        //	cout << endl;
        //}//验证运算符优先级的构造是否正确
        String st = String.valueOf(s);
        System.out.println(str);
        System.out.println(st);
        char a = list[getOperateIndex(str)][getOperateIndex(st)];
        System.out.println(a);
        return a;
    }

    double operate(double a, String str, double b) {//计算数字栈顶的两个数;
        char c = str.charAt(0);
        switch (c)
        {
            case'+':
                return a + b;

            case'-':
                return a - b;
            case'*':
                return a * b;
            case'/':
                return a / b;
            default:
                break;
        }
        return 0;
    }

    public String Count(TextView textView){
        textView.append("#");
        System.out.println(textView.length());
        String str = textView.getText().toString();
        Stack<String> stack1 = new Stack<String>(); //运算符栈
        Stack<Double> stack2 = new Stack<Double>();// 操作数栈
        Double m = new Double(0);
        stack2.push(m);
        stack1.push("#");
        int i = 0;

        while( str.charAt(i) != '#' || !stack1.peek().equals("#")){
            System.out.println(i);
            if(!isOperate(str.charAt(i))){
                double value1 = 0.0;
                double value2 = 0.0;
                int flag = 1;
                while(str.charAt(i) == '.' || !isOperate(str.charAt(i))) {
                    if (str.charAt(i) == '.') {
                        flag = -1;
                        i++;
                        continue;
                    }
                    else if (flag == 1) {
                        value1 = value1 * 10 + str.charAt(i) - '0';
                        System.out.println(value1);
                    } else {
                        value2 = value2 + Math.pow(10, flag) * (str.charAt(i) - '0');
                        System.out.println(value2);
                        flag--;
                    }
                    i++;
                }
                stack2.push(value1 + value2);
            }
            else{
                System.out.println(i);
                switch (precede(stack1.peek(), str.charAt(i))) {
                    case '<':
                        stack1.push(String.valueOf(str.charAt(i)));
                        i++;
                        break;
                    case '=':
                        stack1.pop();
                        i++;
                        break;
                    case '>':
                        String theta = stack1.pop();
                        double a = stack2.pop();
                        double b = stack2.pop();
                        stack2.push(operate(b, theta, a));
                        System.out.println(operate(b, theta, a));
                        break;
                    default:
                        break;
                }
            }

        }

        double result = stack2.pop();
        return result + "";
    }




}
