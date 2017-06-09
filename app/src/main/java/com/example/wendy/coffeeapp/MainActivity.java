package com.example.wendy.coffeeapp;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.wendy.coffeeapp.R.id.txttotal;

public class MainActivity extends AppCompatActivity {

    private CheckBox cappuccino;
    private CheckBox espresso;
    private CheckBox macchiato;
    private CheckBox americano;

    private TextView totalw;
    private TextView cappuccinoprioce;
    private TextView expressoprice;
    private TextView macchiatoprice;
    private TextView americanoprice;

    private EditText quantiy1;
    private EditText quantiy2;
    private EditText quantiy3;
    private EditText quantiy4;

    private TextView total1;
    private TextView total2;
    private TextView total3;
    private TextView total4;


    private Button amountdue1;
    private Button total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cappuccino = (CheckBox) findViewById(R.id.chkcappuccino);
        espresso = (CheckBox) findViewById(R.id.chkespresso);
        macchiato = (CheckBox) findViewById(R.id.chkmacchiato);
        americano = (CheckBox) findViewById(R.id.chkamericano);

        totalw = (TextView) findViewById(txttotal);
        cappuccinoprioce = (TextView) findViewById(R.id.txtcappuccinoprice);
        expressoprice = (TextView) findViewById(R.id.txtespressoprice);
        macchiatoprice = (TextView) findViewById(R.id.txtmacchiatiprice);
        americanoprice = (TextView) findViewById(R.id.txtamericanoprice);

        quantiy1 = (EditText) findViewById(R.id.capquantity);
        quantiy2 = (EditText) findViewById(R.id.espressoquantity);
        quantiy3 = (EditText) findViewById(R.id.macchiatoquantity);
        quantiy4 = (EditText) findViewById(R.id.americanoquantity);

        total1 = (TextView) findViewById(R.id.totalcappuccino);
        total2 = (TextView) findViewById(R.id.totalespresso);
        total3 = (TextView) findViewById(R.id.totalmacchiato);
        total4 = (TextView) findViewById(R.id.totalamericano);

        total = (Button) findViewById(R.id.BTNTOTAL);
        amountdue1 = (Button) findViewById(R.id.btncalculate);


        cappuccino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cappuccino.isChecked()) {
                    quantiy1.setVisibility(View.INVISIBLE);
                } else {
                    quantiy1.setVisibility(View.VISIBLE);
                }
            }
        });
        espresso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!espresso.isChecked()) {
                    quantiy2.setVisibility(View.INVISIBLE);
                } else {
                    quantiy2.setVisibility(View.VISIBLE);
                }
            }
        });
        macchiato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!macchiato.isChecked()) {
                    quantiy3.setVisibility(View.INVISIBLE);
                } else {
                    quantiy3.setVisibility(View.VISIBLE);
                }
            }
        });
        americano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!americano.isChecked()) {
                    quantiy4.setVisibility(View.INVISIBLE);
                } else {
                    quantiy4.setVisibility(View.VISIBLE);
                }
            }
        });


        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TotalDue();
            }
        });

    }

    public void TotalDue() {
        if (cappuccino.isChecked()) {
            int price = 46;
            int x = Integer.valueOf(quantiy1.getText().toString());
            int total = (price) * x;

            total1.setText( Integer.toString(total));

        }

        if (espresso.isChecked()) {
            int price = 60;
            int x = Integer.valueOf(quantiy2.getText().toString());
            int total = (price) * x;

            total2.setText(Integer.toString(total));

        }

        if (macchiato.isChecked()) {
            int price = 53;
            int x = Integer.valueOf((quantiy3.getText().toString()));
            int total = (price) * x;

            total3.setText(Integer.toString(total));


        }
        if (americano.isChecked()) {
            int price = 62;
            int x = Integer.valueOf((quantiy4.getText().toString()));
            int total = (price) * x;

            total4.setText(Integer.toString(total));


        }
        amountdue1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                Double cappuccino = Double.valueOf(total1.getText().toString());
                Double espresso = Double.valueOf(total2.getText().toString());
                Double macchiato = Double.valueOf(total3.getText().toString());
                Double americano = Double.valueOf(total4.getText().toString());

                double amtDue = cappuccino + espresso + macchiato + americano;
                totalw.setText(Double.toString(amtDue));


            }
        });

    }


}