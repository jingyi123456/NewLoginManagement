package com.yunsu.domain;

import java.io.Serializable;

public class Register implements Serializable{
    private String uname;
    private String upassword;
    private String address;
    private String qq;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Override
    public String toString() {
        return "Register{" +
                "uname='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
                ", address='" + address + '\'' +
                ", qq='" + qq + '\'' +
                '}';
    }
}
