package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    boolean flag2 = false;
    boolean flag8 = false;
    boolean flag10 = false;
    boolean flag16 = false;
    boolean flagcm = false;
    boolean flagm = false;
    boolean flagml = false;
    boolean flagl= false;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.help_item:
                Intent intent = new Intent(MainActivity.this, Help.class);
                startActivity(intent);
                break;
            default:
        }
        return true;
    }

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
        Button btE = (Button) findViewById(R.id.buttonE);
        Button btF = (Button) findViewById(R.id.buttonF);

        Button btLn = (Button) findViewById(R.id.buttonln);
        Button btCos = (Button) findViewById(R.id.buttoncos);
        Button btSin = (Button) findViewById(R.id.buttonsin);

        Button btLeft = (Button) findViewById(R.id.buttonLeft);
        Button btRight = (Button) findViewById(R.id.buttonRight);

        Button btCm = (Button) findViewById(R.id.buttoncm);
        Button btM = (Button) findViewById(R.id.buttonm);
        Button btMl = (Button) findViewById(R.id.buttonml);
        Button btL = (Button) findViewById(R.id.buttonL);

        Button btS = (Button) findViewById(R.id.buttonsqu);

        Button bt2 = (Button) findViewById(R.id.button2);
        Button bt8 = (Button) findViewById(R.id.button8);
        Button bt10 = (Button) findViewById(R.id.button10o);
        Button bt16 = (Button) findViewById(R.id.button16);

        Button buttonCount = (Button) findViewById(R.id.button43);


        final TextView textView = (TextView) findViewById(R.id.text_view);

        Configuration mConfiguration = this.getResources().getConfiguration();
        int ori = mConfiguration.orientation;

        if(ori == mConfiguration.ORIENTATION_LANDSCAPE) {

            btLeft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textView.setText(textView.getText() + "(");
                }
            });

            btS.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    double result = translate(textView.getText().toString());
                    result = Math.sqrt(result);
                    String str = String.valueOf(result);
                    textView.setText(str);
                }
            });

            btLn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    double result = translate(textView.getText().toString());
                    result = Math.log(result);
                    String str = String.valueOf(result);
                    textView.setText(str);
                }
            });

            btSin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    double result = translate(textView.getText().toString());
                    result = Math.toRadians(result);
                    result = Math.sin(result);

                    textView.setText(String.format("%.2f",result));
                }
            });

            btCos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Double result = translate(textView.getText().toString());
                    result = Math.toRadians(result);
                    result = Math.cos(result);
                    textView.setText(String.format("%.2f",result));
                }
            });


            btRight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textView.setText(textView.getText() + ")");
                }
            });

            btA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textView.setText(textView.getText() + "A");
                }
            });

            btB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textView.setText(textView.getText() + "B");
                }
            });

            btC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textView.setText(textView.getText() + "C");
                }
            });

            btD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textView.setText(textView.getText() + "D");
                }
            });

            btE.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textView.setText(textView.getText() + "E");
                }
            });

            btF.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textView.setText(textView.getText() + "F");
                }
            });

           bt2.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if(flag10){
                       System.out.println(flag10);
                       double result = translate(textView.getText().toString());
                       String str = Integer.toBinaryString((int)result);
                       textView.setText(str);
                       flag10 = false;
                   }
                   else if(flag8){
                       String str = Integer.toBinaryString(Integer.parseInt(textView.getText().toString(), 8));
                       textView.setText(str);
                       flag8 = false;
                   }
                   else if(flag16){
                       String str = Integer.toBinaryString(Integer.parseInt(textView.getText().toString(), 16));
                       textView.setText(str);
                       flag16 = false;
                   }
                   else
                       flag2 = true;

               }
           });

            bt8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag10){
                        double result = translate(textView.getText().toString());
                        String str = Integer.toOctalString((int)result);
                        textView.setText(str);
                        flag10 = false;
                    }
                    else if(flag2){
                        String str = Integer.toOctalString(Integer.parseInt(textView.getText().toString(), 2));
                        textView.setText(str);
                        flag2 = false;
                    }
                    else if(flag16){
                        String str = Integer.toOctalString(Integer.parseInt(textView.getText().toString(), 16));
                        textView.setText(str);
                        flag16 = false;
                    }
                    else
                        flag8 = true;

                }
            });

            bt10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag2){
                        String str = String.valueOf(Integer.parseInt(textView.getText().toString(), 2));
                        textView.setText(str);
                        flag2 = false;

                    }
                    else if(flag16){
                        System.out.println(textView.getText().toString());
                        String str = String.valueOf(Integer.parseInt(textView.getText().toString(), 16));
                        textView.setText(str);
                        flag16 = false;
                    }
                    else if(flag8){
                        String str = String.valueOf(Integer.parseInt(textView.getText().toString(), 8));
                        textView.setText(str);
                        flag8 = false;
                    }
                    else
                        flag10 = true;

                }
            });

            bt16.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag10){
                        double result = translate(textView.getText().toString());
                        String str = Integer.toHexString((int)result);
                        textView.setText(str);
                        flag10 = false;
                    }
                    else if(flag2){
                        String str = Integer.toHexString(Integer.parseInt(textView.getText().toString(), 2));
                        textView.setText(str);
                        flag10 = false;
                    }
                    else if(flag8){
                        String str = Integer.toHexString(Integer.parseInt(textView.getText().toString(), 8));
                        textView.setText(str);
                        flag8 = false;
                    }
                    else
                        flag16 = true;

                }
            });

            btCm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flagm){
                        double result = translate(textView.getText().toString()) * 100;
                        textView.setText(String.valueOf(result) + "cm");
                        flagm = false;
                    }
                    else
                        flagcm = true;
                }
            });

            btM.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flagcm){
                        double result = translate(textView.getText().toString()) / 100;
                        textView.setText(String.valueOf(result) + "m");
                        flagcm = false;
                    }
                    else
                        flagm = true;
                }
            });

            btMl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flagl){
                        double result = translate(textView.getText().toString()) * 1000;
                        textView.setText(String.valueOf(result) + "mL");
                        flagl = false;
                    }
                    else
                        flagml = true;
                }
            });


            btL.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flagml){
                        double result = translate(textView.getText().toString()) / 1000;
                        textView.setText(String.valueOf(result) + "L");
                        flagml = false;
                    }
                    else
                        flagl = true;
                }
            });
        }

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

    public double translate(String str){//将字符数据转化为数值
        double value = 0.0;
        int flag = 1;
        for(int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '.') {
                flag = -1;
                continue;
            }
            else if (flag == 1) {
                value = value * 10 + str.charAt(i) - '0';
                System.out.println(value);
            } else {
                value = value + Math.pow(10, flag) * (str.charAt(i) - '0');
                System.out.println(value);
                flag--;
            }
        }

        return value;
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
        return String.format("%.2f", result);
    }




}
