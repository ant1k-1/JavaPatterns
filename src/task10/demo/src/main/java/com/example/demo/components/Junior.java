package com.example.demo.components;

import com.example.demo.interfaces.Programmer;

public class Junior implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Junior is writing the code...");
    }
}
