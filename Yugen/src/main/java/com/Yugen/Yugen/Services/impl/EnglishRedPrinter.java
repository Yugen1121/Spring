package com.Yugen.Yugen.Services.impl;

import com.Yugen.Yugen.Services.RedPrinter;
import org.springframework.stereotype.Component;

@Component
public class EnglishRedPrinter implements RedPrinter {

    public void print(){
        System.out.println("English red");
    }

}
