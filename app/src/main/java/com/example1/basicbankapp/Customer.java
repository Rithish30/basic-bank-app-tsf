package com.example1.basicbankapp;
import java.io.Serializable;

public class Customer implements Serializable {
    private String accId;
    private String name;
    private String email;
    private int accBal;
public Customer(String accId,String name,String email,int accBal){
    this.accId = accId;
    this.name = name;
    this.email = email;
    this.accBal = accBal;
}
public Customer(){}
    @Override
    public String toString(){
    return "Customer{" +
            "accId='" + accId + '\'' +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", accBal=" + accBal +
            '}';
}

    public String getAccId() {
        return accId;
    }
    public void setAccId(){
    this.accId=accId;
    }
    public String getName() {
        return name;
    }
    public void setName(){
        this.name=name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(){
        this.email=email;
    }
    public int getAccBal() {
        return accBal;
    }
    public void setAccBal(){
        this.accBal=accBal;
    }
 }
