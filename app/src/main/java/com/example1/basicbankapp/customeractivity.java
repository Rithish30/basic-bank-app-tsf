package com.example1.basicbankapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class customeractivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_activity);
        final Customer customer = (Customer) getIntent().getExtras().getSerializable(".com.example1.basicbankapp.selectedcustomer");
        TextView cname =(TextView)findViewById(R.id.cname);
        TextView caccno =(TextView)findViewById(R.id.c_accno);
        TextView cemail =(TextView)findViewById(R.id.c_email);
        TextView cbal =(TextView)findViewById(R.id.c_balance);
        Button send =(Button)findViewById(R.id.send);
        Button home=(Button)findViewById(R.id.homebutton);
        cname.setText(customer.getName());
        caccno.setText(customer.getAccId());
        cemail.setText(customer.getEmail());
        cbal.setText(customer.getAccBal()+"");
        Log.d("jd",customer.getAccBal()+"");
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendintent=new Intent(getApplicationContext(),receiverlist.class);
                sendintent.putExtra(".com.example1.basicbankapp.sender",customer);
                startActivity(sendintent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeintent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(homeintent);
            }
        });

    }
}

