package com.example1.basicbankapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;


public class databasehelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Bank.db";
    public static final String TABLE_NAME = "Customers";
    public static final String COL_ACCNO = "C_ACCNO";
    public static final String COL_NAME = "C_NAME";
    public static final String COL_EMAIL = "C_EMAIL";
    public static final String COL_BALANCE = "C_BALANCE";

    public databasehelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table " + TABLE_NAME + " (C_ACCNO INTEGER PRIMARY KEY AUTOINCREMENT ,C_NAME TEXT ,C_EMAIL TEXT,C_BALANCE INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);


    }

    public boolean insertdata(Customer c) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_ACCNO, c.getAccId());
        cv.put(COL_NAME, c.getName());
        cv.put(COL_EMAIL, c.getEmail());
        cv.put(COL_BALANCE, c.getAccBal());
        long insert = db.insert(TABLE_NAME, null, cv);
        db.close();
        if (insert == -1) {
            return false;
        } else
            return true;
    }

    public List<Customer> getCustomers() {
        List<Customer> returnList = new ArrayList<>(); //getting data from database
        String query = "Select * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                String accNo = cursor.getString(0);
                String cName = cursor.getString(1);
                String cEmail = cursor.getString(2);
                int cBal = cursor.getInt(3);
                Customer newCust = new Customer(accNo, cName, cEmail, cBal);
                returnList.add(newCust);
            } while (cursor.moveToNext());
        }
        else{}
        cursor.close();
        db.close();
        return returnList;
    }
    public boolean postTransactionTableUpdation(Customer sender,Customer receiver,int transAmt) {
        SQLiteDatabase db= this.getWritableDatabase();
        String tableupdatestatement="Update " + TABLE_NAME +" set "+ COL_BALANCE +"="+ (sender.getAccBal()-transAmt)+" where " + COL_ACCNO +"="+sender.getAccId();
        db.execSQL(tableupdatestatement);
        tableupdatestatement="Update " + TABLE_NAME +" set "+ COL_BALANCE +"="+ (receiver.getAccBal()+transAmt)+" where " + COL_ACCNO +"="+receiver.getAccId();
        db.execSQL(tableupdatestatement);
        return true;
    }
}

