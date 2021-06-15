package com.example1.basicbankapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class transactionactivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transaction_activity);
        Customer sender = (Customer) getIntent().getExtras().getSerializable(".com.example1.basicbankapp.finalsender");
        Customer receiver = (Customer) getIntent().getExtras().getSerializable(".com.example1.basicbankapp.finalreceiver");
        ListView transactionlistview =(ListView)findViewById(R.id.TransactionDetailsListView);
        List<Customer> temp = new ArrayList<>();
        temp.add(sender);
        temp.add(receiver);
        TransactionAdapter transactionAdapter=new TransactionAdapter(this,temp);
        transactionlistview.setAdapter(transactionAdapter);

        Button complete =(Button)findViewById(R.id.complete);
        Button cancel =(Button)findViewById(R.id.cancel);
        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText amtEditText = (EditText) transactionactivity.this.findViewById(R.id.amount);
                int transacAmt = 0;
                try {
                    transacAmt = Integer.parseInt(amtEditText.getText().toString());
                }
                catch (Exception e)
                {
                    Toast.makeText(transactionactivity.this,"Enter a Valid Amount",Toast.LENGTH_LONG).show();
                    return;
                }
                Customer sender = (Customer) transactionactivity.this.getIntent().getExtras().getSerializable(".com.example1.basicbankapp.finalsender");
                Customer receiver = (Customer) transactionactivity.this.getIntent().getExtras().getSerializable(".com.example1.basicbankapp.finalreceiver");
                if(transacAmt > sender.getAccBal()){
                    Toast.makeText(transactionactivity.this,"Entered Amount is more than the Balance",Toast.LENGTH_LONG).show();
                    return;
                }
                else if(transacAmt<0)
                {
                    Toast.makeText(transactionactivity.this,"Enter a Valid Amount",Toast.LENGTH_LONG).show();
                    return;
                }
                transactiondatabase tdb = new transactiondatabase(transactionactivity.this);
                boolean x =tdb.insertdata(sender,receiver,transacAmt);
                if (x) {
                    Toast.makeText(transactionactivity.this, "Transaction Success", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(transactionactivity.this, "Transaction Failed", Toast.LENGTH_LONG).show();
                }
                Intent mainActivityIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainActivityIntent);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivityintent =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainActivityintent);
            }
        });
    }
}
