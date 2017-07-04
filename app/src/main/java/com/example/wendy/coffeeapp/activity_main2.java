package com.example.wendy.coffeeapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static android.R.attr.max;
import static com.example.wendy.coffeeapp.R.id.txttotal;
//import static com.example.wendy.coffeeapp.R.id.txttotal;

public class activity_main2 extends AppCompatActivity implements View.OnClickListener {

    MainActivity main = new MainActivity();
    TextView message;
    String msg1,msg2,msg3,msg4;
    String topping,topping2,topping3,topping4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        message = (TextView) findViewById(R.id.message);

//
        Intent intent = getIntent();
        String toppingAme=intent.getStringExtra(MainActivity.AMERICANOTOP);
        String toppingCupp=intent.getStringExtra(MainActivity.CAPPUTINNOTOP);
        String toppingExp=intent.getStringExtra(MainActivity.EXPRESOTOP);
        String toppingMAc=intent.getStringExtra(MainActivity.MACCHIATOTOP);
        String tot =intent.getStringExtra(MainActivity.TOT);

        //Setting the selected Coffee

        if(main.cappuccinoChk.isChecked())
        {
            msg1=main.quantiy1.getText().toString() + " " + main.cappuccinoChk.getText().toString() +" @ a Price of R" + main.total1.getText().toString() + " + " + toppingCupp +" Topping" ;

        }else
        {
            msg1="";
        }

        if(main.espressoChk.isChecked())
        {
            msg2=main.quantiy2.getText().toString() + " " + main.espressoChk.getText().toString() + " @ a Price of R" + main.total2.getText().toString() + " + " + toppingExp+" Topping";

        }else
        {
            msg2="";
        }

        if(main.macchiatoChk.isChecked())
        {

            msg3=main.quantiy3.getText().toString() + " " + main.macchiatoChk.getText().toString() + " @ a price R" + main.total3.getText().toString() + " + " + toppingMAc+" Topping";
        }else
        {
            msg3="";
        }
        if( main.americanoChk.isChecked())
        {

            msg4=main.quantiy4.getText().toString() + " " + main.americanoChk.getText().toString() + " @ a price R" + main.total4.getText().toString() + " + " + toppingAme+" Topping";

        }else
        {
            msg4="";
        }


        message.setTextColor(Color.BLACK);
        message.setText("You have Ordered "+"\n "+"`"+ msg1 +" \n"+ msg2 +" \n"+msg3 +"\n"+ msg4 +"\n"+"\n"+"price R"+tot);




    }

    @Override
    public void onClick(View v) {

    }
}