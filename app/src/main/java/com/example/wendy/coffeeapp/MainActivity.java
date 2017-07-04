package com.example.wendy.coffeeapp;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.x;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.example.wendy.coffeeapp.R.array.cappucino_topping;
import static com.example.wendy.coffeeapp.R.id.chkamericano;
import static com.example.wendy.coffeeapp.R.id.spinner4;
import static com.example.wendy.coffeeapp.R.id.spinner5;
import static com.example.wendy.coffeeapp.R.id.spinner6;
import static com.example.wendy.coffeeapp.R.id.txttotal;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    //declaring array adapter
    ArrayAdapter<String> ListAdapter;


    //defining global variable
    static CheckBox cappuccinoChk;
    static CheckBox espressoChk;
    static CheckBox macchiatoChk;
    static CheckBox americanoChk;

    static TextView totalw;
    static TextView cappuccinoprioce;
    static TextView expressoprice;
    static TextView macchiatoprice;
    static TextView americanoprice;

    static EditText quantiy1;
    static EditText quantiy2;
    static EditText quantiy3;
    static EditText quantiy4;

    static TextView total1;
    static TextView total2;
    static TextView total3;
    static TextView total4;


    //defining button
    private Button amountdue1;
    private Button total;

    //defining the topping container
    public static final String CAPPUTINNOTOP = "top1";
    public static final String EXPRESOTOP = "top2";
    public static final String MACCHIATOTOP = "top3";
    public static final String AMERICANOTOP = "top4";


    //defining topping variables
    String americanoToppin;
    String cappuccinoToppin;
    String expressoToppin;
    String macchiatoToppin;

    //--------------------------->
    int cupprice = 46;
    int espPrice = 60;
    int macPrice = 53;
    int amrPrice = 63;
    int quan = 0;
    int totAMT = 0;

    private Spinner spinner3;
    private Spinner spinner4;
    private Spinner spinner5;
    private Spinner spinner6;
    public static final String TOT = "tot";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String cappucino_topping[] = {"CHOCOLATE", "CINNAMON", "MINT"};
        String macchiato_topping[] = {"CHOCOLATE", "CINNAMON", "MINT"};
        String expresso_topping[] = {"CHOCOLATE", "CINNAMON", "MINT"};
        String americano_topping[] = {"CHOCOLATE", "CINNAMON", "MINT"};

        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner6 = (Spinner) findViewById(R.id.spinner6);


        ListAdapter = new ArrayAdapter<String>(this, R.layout.text, cappucino_topping);
        spinner3.setAdapter(ListAdapter);

        spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinner4.getSelectedItem().toString();
        ListAdapter = new ArrayAdapter<String>(this, R.layout.text, expresso_topping);
        spinner4.setAdapter(ListAdapter);

        spinner5 = (Spinner) findViewById(R.id.spinner5);
        spinner5.getSelectedItem().toString();
        ListAdapter = new ArrayAdapter<String>(this, R.layout.text, macchiato_topping);
        spinner5.setAdapter(ListAdapter);

        spinner6 = (Spinner) findViewById(R.id.spinner6);
        spinner6.getSelectedItem().toString();
        ListAdapter = new ArrayAdapter<String>(this, R.layout.text, americano_topping);
        spinner6.setAdapter(ListAdapter);


        //castin checkboxe
        cappuccinoChk = (CheckBox) findViewById(R.id.chkcappuccino);
        espressoChk = (CheckBox) findViewById(R.id.chkespresso);
        macchiatoChk = (CheckBox) findViewById(R.id.chkmacchiato);
        americanoChk = (CheckBox) findViewById(R.id.chkamericano);

        cappuccinoChk.setOnClickListener(this);
        espressoChk.setOnClickListener(this);
        macchiatoChk.setOnClickListener(this);
        americanoChk.setOnClickListener(this);

        //casting Textview
        totalw = (TextView) findViewById(R.id.txttotal);
        cappuccinoprioce = (TextView) findViewById(R.id.txtcappuccinoprice);
        expressoprice = (TextView) findViewById(R.id.txtespressoprice);
        macchiatoprice = (TextView) findViewById(R.id.txtmacchiatiprice);
        americanoprice = (TextView) findViewById(R.id.txtamericanoprice);

        //casting Edit texts
        quantiy1 = (EditText) findViewById(R.id.capquantity);
        quantiy2 = (EditText) findViewById(R.id.espressoquantity);
        quantiy3 = (EditText) findViewById(R.id.macchiatoquantity);
        quantiy4 = (EditText) findViewById(R.id.americanoquantity);

        //casting each total coffee price  textview
        total1 = (TextView) findViewById(R.id.totalcappuccino);
        total2 = (TextView) findViewById(R.id.totalespresso);
        total3 = (TextView) findViewById(R.id.totalmacchiato);
        total4 = (TextView) findViewById(R.id.totalamericano);


        //casting Total and amountDue button
        total = (Button) findViewById(R.id.BTNTOTAL);
        total.setOnClickListener(this);

        amountdue1 = (Button) findViewById(R.id.btncalculate);
        amountdue1.setOnClickListener(this);
    }





    public void TotalDue() {
        if (cappuccinoChk.isChecked()) {

            quantiy1.setVisibility(View.VISIBLE);


            if (quantiy1.getText().toString().equals("")) {
                Toast.makeText(MainActivity.this, "Enter Quantity for Cappuccino", Toast.LENGTH_LONG).show();
            } else {
                int price = 46;
                int x = Integer.valueOf(quantiy1.getText().toString());
                int total = (price) * x;

                total1.setText(Integer.toString(total));

            }


        }

        if (espressoChk.isChecked()) {
            quantiy2.setVisibility(View.VISIBLE);
            if (quantiy2.getText().toString().equals("")) {
                Toast.makeText(MainActivity.this, "Enter Quantity for Expresso", Toast.LENGTH_LONG).show();
            } else {
                int price = 60;
                int x = Integer.valueOf(quantiy2.getText().toString());
                int total = (price) * x;

                total2.setText(Integer.toString(total));
            }


        }

        if (macchiatoChk.isChecked()) {
            quantiy3.setVisibility(View.VISIBLE);
            if (quantiy3.getText().toString().equals("")) {
                Toast.makeText(MainActivity.this, "Enter Quantity for Macchiato", Toast.LENGTH_LONG).show();
            } else {
                int price = 53;
                int x = Integer.valueOf((quantiy3.getText().toString()));
                int total = (price) * x;

                total3.setText(Integer.toString(total));
            }


        }
        if (americanoChk.isChecked()) {
            quantiy4.setVisibility(View.VISIBLE);
            if (quantiy4.getText().equals("")) {
                Toast.makeText(MainActivity.this, "Enter Quantity for Americano", Toast.LENGTH_LONG).show();
            } else {
                int price = 62;
                int x = Integer.valueOf((quantiy4.getText().toString()));
                int total = (price) * x;

                total4.setText(Integer.toString(total));

            }


        }


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.BTNTOTAL:
                TotalDue();
                break;
            case R.id.btncalculate:
                Double cappuccino = Double.valueOf(total1.getText().toString());
                Double espresso = Double.valueOf(total2.getText().toString());
                Double macchiato = Double.valueOf(total3.getText().toString());
                Double americano = Double.valueOf(total4.getText().toString());

                //get text from spinner

                americanoToppin = spinner6.getSelectedItem().toString();
                double amtDue = cappuccino + espresso + macchiato + americano;
                totalw.setText(Double.toString(amtDue));

                cappuccinoToppin = spinner3.getSelectedItem().toString();
                double amtDue1 = cappuccino + espresso + macchiato + americano;
                totalw.setText(Double.toString(amtDue1));

                macchiatoToppin = spinner5.getSelectedItem().toString();
                double amtDue2 = cappuccino + espresso + macchiato + americano;
                totalw.setText(Double.toString(amtDue2));

                expressoToppin = spinner4.getSelectedItem().toString();
                double amtDue3 = cappuccino + espresso + macchiato + americano;
                totalw.setText(Double.toString(amtDue3));


                String tot = String.valueOf(amtDue);


                Intent i = new Intent(MainActivity.this, activity_main2.class);
                i.putExtra(CAPPUTINNOTOP, cappuccinoToppin);//put a string variable in a container
                i.putExtra(EXPRESOTOP, expressoToppin);
                i.putExtra(MACCHIATOTOP, macchiatoToppin);
                i.putExtra(TOT, tot);
                i.putExtra(AMERICANOTOP, americanoToppin);//put a string variable in a container


                startActivity(i);
                break;
            case R.id.chkcappuccino:

                if (!cappuccinoChk.isChecked()) {

                    quantiy1.setVisibility(View.INVISIBLE);
                } else {
                    quantiy1.setText("0");
                    quantiy1.setVisibility(View.VISIBLE);

                }
                break;
            case R.id.chkespresso:
                if (!espressoChk.isChecked()) {
                    quantiy2.setVisibility(View.INVISIBLE);
                } else {
                    quantiy2.setText("0");
                    quantiy2.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.chkmacchiato:
                if (!macchiatoChk.isChecked()) {
                    quantiy3.setVisibility(View.INVISIBLE);
                } else {
                    quantiy3.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.chkamericano:
                if (!americanoChk.isChecked()) {
                    quantiy4.setVisibility(View.INVISIBLE);
                } else {
                    quantiy4.setVisibility(View.VISIBLE);
                }
                break;
        }




        }
    }

