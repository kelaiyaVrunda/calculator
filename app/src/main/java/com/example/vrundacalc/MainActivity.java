package com.example.vrundacalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity  {

    TextView resultbar, solutionbar;
    MaterialButton buttonC, buttonopen, buttonclose;
    MaterialButton buttondiv, buttonmul, buttonadd, buttonsub, buttonequal;
    MaterialButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button0;
    MaterialButton buttonAC, buttondot;
    private final char ADDITION='+';
    private final char SUBTRACTION='-';
    private final char MULTIPLICATION='*';
    private final char DIVISION='/';
    private final char EQUA='=';

    private char ACTION;
    private double val1=Double.NaN;
    private double val2=Double.NaN;
    private double temp = 0;

    private String tempStr = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        resultbar  = findViewById(R.id.result);
        solutionbar = findViewById(R.id.solution);
        buttonC =findViewById(R.id.btn_c);
        buttonopen=findViewById(R.id.btn_open_brac);
        buttonclose=findViewById(R.id.btn_close_brac);
        buttondiv =findViewById(R.id.btn_div);
        buttonmul =findViewById(R.id.btn_mul);
        buttonadd=findViewById(R.id.btn_add);
        buttonsub=findViewById(R.id.btn_sub);
        buttonequal=findViewById(R.id.btn_eql);
        button1=findViewById(R.id.btn_1);
        button2=findViewById(R.id.btn_2);
        button3=findViewById(R.id.btn_3);
        button4=findViewById(R.id.btn_4);
        button5=findViewById(R.id.btn_5);
        button6=findViewById(R.id.btn_6);
        button7=findViewById(R.id.btn_7);
        button8=findViewById(R.id.btn_8);
        button9=findViewById(R.id.btn_9);
        button0=findViewById(R.id.btn_0);
        buttonAC=findViewById(R.id.btn_ac);
        buttondot=findViewById(R.id.btn_dot);






       button1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               ifErrorOnOutput();
               exceedlength();
               solutionbar.setText(solutionbar.getText().toString() + "1");
           }
       });

       button2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               ifErrorOnOutput();
               exceedlength();
               solutionbar.setText(solutionbar.getText().toString() + "2");

           }
       });
       button3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               ifErrorOnOutput();
               exceedlength();
               solutionbar.setText(solutionbar.getText().toString() + "3");
           }
       });
       button4.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               ifErrorOnOutput();
               exceedlength();
               solutionbar.setText(solutionbar.getText().toString() + "4");
           }
       });
       button5.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               ifErrorOnOutput();
               exceedlength();
               solutionbar.setText(solutionbar.getText().toString() + "5");
           }
       });
       button6.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               ifErrorOnOutput();
               exceedlength();
               solutionbar.setText(solutionbar.getText().toString() + "6");
           }
       });
       button7.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               ifErrorOnOutput();
               exceedlength();
               solutionbar.setText(solutionbar.getText().toString() + "7");
           }
       });
       button8.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               ifErrorOnOutput();
               exceedlength();
               solutionbar.setText(solutionbar.getText().toString() + "8");
           }
       });
       button9.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               ifErrorOnOutput();
               exceedlength();
               solutionbar.setText(solutionbar.getText().toString() + "9");
           }
       });
       button0.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               ifErrorOnOutput();
               exceedlength();
               solutionbar.setText(solutionbar.getText().toString() + "0");
           }
       });
       buttondot.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               exceedlength();
               solutionbar.setText(solutionbar.getText().toString() + ".");
           }
       });

       buttonadd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(solutionbar.getText().length()>0){
                   ACTION=ADDITION;
                   operation();
                   if(!ifReallyDecimal()){
                       resultbar.setText(val1 + "+");
                   }else {
                       resultbar.setText((int)val1 + "+");
                       Log.d("val 1", "onClick:add " + val1 );
                   }
                   solutionbar.setText("");
               }else {
                   resultbar.setText("Error");
               }

           }
       });
       buttonsub.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(solutionbar.getText().length()>0){
                   ACTION=SUBTRACTION;
                   operation();
                   if(!ifReallyDecimal()){
                       resultbar.setText(val1+"-");
                   }else {
                       resultbar.setText((int) val1 + "-");
                   }
                   solutionbar.setText("");
               }else {
                   resultbar.setText("Error");
               }

           }
       });
       buttonmul.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(solutionbar.getText().length()>0){
                   ACTION=MULTIPLICATION;
                   operation();
                   if(!ifReallyDecimal()){
                       resultbar.setText(val1+"*");
                   }else {
                       resultbar.setText((int) val1 + "*");
                   }
                   solutionbar.setText("");
               }else {
                   resultbar.setText("Error");
               }

           }
       });
       buttondiv.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(solutionbar.getText().length()>0){
                   ACTION=DIVISION;
                   operation();
                   if(!ifReallyDecimal()){
                       resultbar.setText(val1+"/");
                   }else {
                       resultbar.setText((int) val1 + "/");
                   }
                   solutionbar.setText("");
               }else {
                   resultbar.setText("Error");
               }

           }
       });
       buttonequal.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(solutionbar.getText().length()>0){

                   ACTION=EQUA;
                   operation();
//                   if(!ifReallyDecimal()){
////                       resultbar.setText(String.valueOf((val1)));
//                   }else {
////                       String.valueOf((int) val1 + "%");
////                       resultbar.setText(String.valueOf(val1));
//                   }
//                   solutionbar.setText(null);
               }else {
                   resultbar.setText("Error");
               }

           }
       });
       buttonC.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(solutionbar.getText().length()>0){
                   CharSequence name = solutionbar.getText().toString();
                   solutionbar.setText(name.subSequence(0,name.length()-1));
               }else {
                   val1 = Double.NaN;
                   val2 = Double.NaN;
                   solutionbar.setText("");
                   resultbar.setText("");
               }

           }
       });
       buttonAC.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               val1 =Double.NaN;
               val2 =Double.NaN;
               solutionbar.setText("");
               resultbar.setText("");
           }
       });
    }

    private void operation(){
        if (!Double.isNaN(val1)){

            if(Double.isNaN(val2) || val2 == 0){
                val2=Double.parseDouble(solutionbar.getText().toString());
            }
            else{
                val2 = 0;
            }


           switch (ACTION){
               case ADDITION:
                   val1 = val1 + val2;
                   break;
               case SUBTRACTION:
                   val1=val1-val2;
                   break;
               case MULTIPLICATION:
                   val1=val1*val2;
                   break;
               case DIVISION:
                   val1=val1/val2;
                   break;

               case  EQUA:
                   temp = Double.parseDouble(solutionbar.getText().toString());
                   tempStr = resultbar.getText().toString();
                   tempStr = tempStr.substring(tempStr.length()-1);

                   switch (tempStr){
                       case "+":
                           val1 += temp;
                            break;

                       case "-":
                           val1-=temp;
                           break;

                       case "*":
                           val1 *= temp;
                           break;

                       case "/":
                           val1/=temp;
                           break;
                   }




                   solutionbar.setText("" + val1);
                   resultbar.setText(null);
                   break;
           }val2 = Double.NaN;
        }else {
            val1=Double.parseDouble(solutionbar.getText().toString());
        }
    }

    private void ifErrorOnOutput(){
        if(resultbar.getText().toString().equals("Error")){
            resultbar.setText("");
        }
    }

    private boolean ifReallyDecimal(){
        return val1 ==(int) val1;
    }

    private void noOperation(){
        String inputExpression =resultbar.getText().toString();
        if(!inputExpression.isEmpty() && !inputExpression.equals("Error")){
            if(inputExpression.contains("-")){
                inputExpression = inputExpression.replace("-","");
                resultbar.setText("");
                val1 = Double.parseDouble(inputExpression);
            }
            if(inputExpression.contains("+")){
                inputExpression = inputExpression.replace("+","");
                resultbar.setText("");
                val1 = Double.parseDouble(inputExpression);

            }
            if(inputExpression.contains("/")){
                inputExpression = inputExpression.replace("/","");
                resultbar.setText("");
                val1 = Double.parseDouble(inputExpression);
            }
            if (inputExpression.contains("*")){
                inputExpression = inputExpression.replace("*","");
                resultbar.setText("");
                val1 = Double.parseDouble(inputExpression);
            }
        }
    }

    private void exceedlength(){
        if(solutionbar.getText().toString().length()>10){
            solutionbar.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        }
    }


}