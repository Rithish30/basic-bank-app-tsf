package com.example1.basicbankapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class transactionslist extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transactionlist);
        transactiondatabase db=new transactiondatabase(this);
        ListView tranasctionlistview =(ListView)findViewById(R.id.transactionListListView);
        Button goback=(Button)findViewById(R.id.back);
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gobackintent= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(gobackintent);
            }
        });
        List<transactionmodel> tList = db.getAllTransactions();
        transactionlistadapter tAdapter = new transactionlistadapter(this,tList);
        tranasctionlistview.setAdapter(tAdapter);
    }
}
