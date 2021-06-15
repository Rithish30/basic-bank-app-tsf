package com.example1.basicbankapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class transactionlistadapter extends BaseAdapter {
    LayoutInflater mInflator;
    List<transactionmodel> transacList;

    public transactionlistadapter(Context c,List<transactionmodel> transacList) {
        this.transacList = transacList;
        mInflator = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return transacList.size();
    }

    @Override
    public Object getItem(int position) {
        return transacList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflator.inflate(R.layout.transactions_activity,null);
        TextView senderNameTextView = (TextView) v.findViewById(R.id.sender_name);
        TextView senderIdTextView = (TextView) v.findViewById(R.id.sender_id);
        TextView receiverIdTextView = (TextView) v.findViewById(R.id.receiver_id);
        TextView receiverNameTextView = (TextView) v.findViewById(R.id.receiver_name);
        TextView transacAmtTextView = (TextView) v.findViewById(R.id.amtTxt);

        senderIdTextView.setText("Sender: "+transacList.get(position).getSenderAccNum());
        receiverIdTextView.setText("Receiver: "+transacList.get(position).getReceiverAccNum());
        senderNameTextView.setText(transacList.get(position).getSenderName());
        receiverNameTextView.setText(transacList.get(position).getReceiverName());
        transacAmtTextView.setText("Amount Transferred = " + transacList.get(position).getTAmt());

        return v;
    }
}

