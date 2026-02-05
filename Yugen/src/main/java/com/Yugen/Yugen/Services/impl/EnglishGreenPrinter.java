package com.Yugen.Yugen.Services.impl;

import com.Yugen.Yugen.Services.GreenPrinter;
import org.springframework.stereotype.Component;

@Component
public class EnglishGreenPrinter implements GreenPrinter {

    public void print(){
        System.out.println("English Green");
    }
}
