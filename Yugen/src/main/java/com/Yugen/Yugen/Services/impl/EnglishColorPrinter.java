package com.Yugen.Yugen.Services.impl;

import com.Yugen.Yugen.Services.BluePrinter;
import com.Yugen.Yugen.Services.ColorPrinter;
import com.Yugen.Yugen.Services.GreenPrinter;
import com.Yugen.Yugen.Services.RedPrinter;
import org.springframework.stereotype.Component;

@Component
public class EnglishColorPrinter implements ColorPrinter {

    private RedPrinter redPrinter;

    private GreenPrinter greenPrinter;

    private BluePrinter bluePrinter;

    public EnglishColorPrinter(RedPrinter redPrinter,  GreenPrinter greenPrinter, BluePrinter bluePrinter){
        this.redPrinter = redPrinter;
        this.greenPrinter = greenPrinter;
        this.bluePrinter = bluePrinter;
    }


    @Override
    public void print() {
        redPrinter.print();
        greenPrinter.print();
        bluePrinter.print();
    }
}
