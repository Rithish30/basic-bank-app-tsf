package com.example1.basicbankapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class useradditonactivity extends AppCompatActivity {

    String useraccId;
    String name;
    String email;
    int userbalamt;
    databasehelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.useraddition_activity);
        db = new databasehelper(this);
        databasehelper db = new databasehelper(this);

        Button back2 = (Button) findViewById(R.id.back2);

       back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backtomainintent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(backtomainintent);
            }
        });
    }

    public void handler(View v) {
        EditText accId = (EditText) findViewById(R.id.Editcacc);
        EditText username = (EditText) findViewById(R.id.Editcname);
        EditText useremail = (EditText) findViewById(R.id.Editcemail);
        EditText userbal = (EditText) findViewById(R.id.Editbal);
        userbalamt = Integer.parseInt(userbal.getText().toString());
        useraccId = accId.getText().toString();
        name = username.getText().toString();
        email = useremail.getText().toString();
       // Log.d("ew", "pass43");
        Customer customer1 = new Customer(useraccId, name, email, userbalamt);
        //Log.d("ew", "pass");
        boolean success = db.insertdata(customer1);
        //Log.d("ew2", "pass");
        if (success) {
            Toast.makeText(useradditonactivity.this, "user added", Toast.LENGTH_SHORT).show();
        }
    }
}