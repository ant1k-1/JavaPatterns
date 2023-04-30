package com.example.demo.components;

import com.example.demo.interfaces.Programmer;

public class Senior implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Senior is writing the code...");
    }
}
