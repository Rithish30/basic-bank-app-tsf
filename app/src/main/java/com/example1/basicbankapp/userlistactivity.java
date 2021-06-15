package com.example1.basicbankapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class userlistactivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userlist_activity);
        databasehelper db=new databasehelper(this);
        List<Customer>allCustomers=db.getCustomers();
        ListView userlistview= (ListView)findViewById(R.id.ulview);
        Customeradapter ca=new Customeradapter(this,allCustomers);
        userlistview.setAdapter(ca);

        userlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Customeradapter adapter=(Customeradapter)parent.getAdapter();
                Customer C = (Customer) adapter.getItem(position);
                Intent useractivityintent =new Intent(getApplicationContext(),customeractivity.class);
                useractivityintent.putExtra(".com.example1.basicbankapp.selectedcustomer",C);
                startActivity(useractivityintent);
            }
        });
    }
}