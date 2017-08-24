package com.example.gangmingu.myphonebooktest;

/**
 * Created by gangmingu on 2017. 4. 21..
 */

public class PhoneVO {

    private String pName;
    private String pNumber;

    public PhoneVO(String pName, String pNumber){
        this.pName = pName;
        this.pNumber = pNumber;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpNumber() {
        return pNumber;
    }

    public void setpNumber(String pNumber) {
        this.pNumber = pNumber;
    }
}
