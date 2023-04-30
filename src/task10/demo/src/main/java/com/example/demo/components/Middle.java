package com.example.demo.components;

import com.example.demo.interfaces.Programmer;

public class Middle implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Middle is writing the code...");
    }
}
