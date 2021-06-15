package com.example1.basicbankapp;

public class transactionmodel {
    private int tId;
    private String senderName;
    private String receiverName;
    private String senderAccNum;
    private String receiverAccNum;
    private int tAmt;

    public transactionmodel(int tId, String senderName, String receiverName, String senderAccNum, String receiverAccNum, int tAmt) {
        this.tId = tId;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.senderAccNum = senderAccNum;
        this.receiverAccNum = receiverAccNum;
        this.tAmt = tAmt;
    }

    public int getTId() {
        return tId;
    }

    public void setTId(int transacId) {
        this.tId = transacId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getSenderAccNum() {
        return senderAccNum;
    }

    public void setSenderAccNum(String senderAccNum) {
        this.senderAccNum = senderAccNum;
    }

    public String getReceiverAccNum() {
        return receiverAccNum;
    }

    public void setReceiverAccNum(String receiverAccNum) {
        this.receiverAccNum = receiverAccNum;
    }

    public int getTAmt() {
        return tAmt;
    }

    public void setTAmt(int tAmt) {
        this.tAmt = tAmt;
    }
}

