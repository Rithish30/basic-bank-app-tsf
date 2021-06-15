package com.example1.basicbankapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class transactiondatabase extends SQLiteOpenHelper {
    public static final String TRANSACTION_TABLE = "TRANSACTION_TABLE";
    public static final String TRANSACTION_ID = "TRANSACTION_ID";
    public static final String SENDER_ACCNO = "SENDER_ACCNO";
    public static final String SENDER_NAME = "SENDER_NAME";
    public static final String  RECEIVER_ACCNO= "RECEIVER_ACCNO";
    public static final String RECEIVER_NAME = "RECEIVER_NAME";
    public static final String AMOUNT = "AMOUNT";
    private databasehelper cdb;
    public transactiondatabase(@Nullable Context context)
    {
        super(context, "transaction.db", null, 1);
        cdb=new databasehelper(context);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery =" create table " + TRANSACTION_TABLE + " ("+TRANSACTION_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "  + SENDER_ACCNO + " TEXT," + SENDER_NAME + " TEXT ,"  + RECEIVER_ACCNO + " TEXT,"+ RECEIVER_NAME + " TEXT," + AMOUNT + " INT)";
        db.execSQL(createTableQuery);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TRANSACTION_TABLE);
        onCreate(db);

    }
    public boolean insertdata(Customer sender,Customer receiver,int tAmt) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SENDER_NAME, sender.getName());
        cv.put(SENDER_ACCNO, sender.getAccId());
        cv.put(RECEIVER_NAME, receiver.getName());
        cv.put(RECEIVER_ACCNO, receiver.getAccId());
        cv.put(AMOUNT,tAmt);
        if(!cdb.postTransactionTableUpdation(sender,receiver,tAmt)) {
            return false;
        }
        long insert = db.insert(TRANSACTION_TABLE, null, cv);
        db.close();
        if (insert == -1) {
            return false;
        } else
            return true;
    }
    public List<transactionmodel> getAllTransactions() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<transactionmodel> listTM = new ArrayList<>();
        String query = "select * from " + TRANSACTION_TABLE;
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst())
        {
            do{
                int transacId = cursor.getInt(0);
                String senderAccId = cursor.getString(1);
                String senderName = cursor.getString(2);
                String receiverAccId = cursor.getString(3);
                String receiverName = cursor.getString(4);
                int tAmt = cursor.getInt(5);
                transactionmodel tm = new transactionmodel(transacId,senderName,receiverName,senderAccId,receiverAccId,tAmt);
                listTM.add(tm);

            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return listTM;
    }


}
