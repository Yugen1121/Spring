package com.Yugen.Yugen.Services.impl;

import com.Yugen.Yugen.Services.BluePrinter;
import org.springframework.stereotype.Component;

@Component
public class EnglishBluePrinter implements BluePrinter {

    public void print(){
        System.out.println("English Blue");
    }

}
