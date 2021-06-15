package com.example1.basicbankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button ul = (Button) findViewById(R.id.ul);
        Button transactions = (Button) findViewById(R.id.transactions);
       // Log.d("sjnas","wjnsjs");
        ul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userlistintent=new Intent(getApplicationContext(),userlistactivity.class);
                startActivity(userlistintent);
            }
        });
        transactions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent transactionsIntent=new Intent(getApplicationContext(),transactionslist.class);
                startActivity(transactionsIntent);
            }
        });
        Button addu = (Button) findViewById(R.id.addu);
        addu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adduserintent=new Intent(getApplicationContext(),useradditonactivity.class);
                startActivity(adduserintent);
            }
        });
    }
}