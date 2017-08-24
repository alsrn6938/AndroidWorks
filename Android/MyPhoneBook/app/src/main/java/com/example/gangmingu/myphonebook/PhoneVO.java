package com.example.gangmingu.myphonebook;

import android.graphics.Bitmap;

/**
 * Created by gangmingu on 2017. 4. 20..
 */

public class PhoneVO {

    private String pName;
    private String pNumber;
    private Bitmap image;

    public PhoneVO(String pName, String pNumber, Bitmap image){
        this.pName = pName;
        this.pNumber = pNumber;
        this.image = image;
    }

    public String getpName() {
        return pName;
    }

    public String getpNumber() {
        return pNumber;
    }

    public Bitmap getImage() {
        return image;
    }
}
