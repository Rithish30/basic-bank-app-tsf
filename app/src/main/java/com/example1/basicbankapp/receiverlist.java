package com.example1.basicbankapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class receiverlist extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receiverlist);
        Customer sender=(Customer)getIntent().getExtras().getSerializable(".com.example1.basicbankapp.sender");
        databasehelper db=new databasehelper(this);
        List<Customer> allcustomers=db.getCustomers();
        List<Customer> Recievers = new ArrayList<>();
        for(Customer c: allcustomers)
        {
            if(sender.getAccId().compareTo(c.getAccId())!=0)
            {
                Recievers.add(c);
            }
            else{
                Log.d("Message", c.toString() + "\n" + sender.toString());
            }
        }
        ListView receiverslist=(ListView)findViewById(R.id.receiverlistview);
        Customeradapter ca=new Customeradapter(this,Recievers);
        receiverslist.setAdapter(ca);
        receiverslist.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Customeradapter ra=(Customeradapter)parent.getAdapter();
                Customer receiver=(Customer)ra.getItem(position);
                Customer sender= (Customer) receiverlist.this.getIntent().getExtras().getSerializable(".com.example1.basicbankapp.sender");
                Intent receiverlistintent= new Intent(receiverlist.this,transactionactivity.class);
                receiverlistintent.putExtra(".com.example1.basicbankapp.finalsender",sender);
                receiverlistintent.putExtra(".com.example1.basicbankapp.finalreceiver",receiver);
                startActivity(receiverlistintent);
            }
        });
    }
}
