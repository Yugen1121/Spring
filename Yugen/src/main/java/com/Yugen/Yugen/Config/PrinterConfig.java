package com.Yugen.Yugen.Config;

import com.Yugen.Yugen.Services.BluePrinter;
import com.Yugen.Yugen.Services.GreenPrinter;
import com.Yugen.Yugen.Services.RedPrinter;
import com.Yugen.Yugen.Services.impl.EnglishBluePrinter;
import com.Yugen.Yugen.Services.impl.EnglishGreenPrinter;
import com.Yugen.Yugen.Services.impl.EnglishRedPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrinterConfig {

    @Bean
    public BluePrinter bluePrinter(){
        return new EnglishBluePrinter();
    }

    @Bean
    public GreenPrinter greenPrinter(){
        return new EnglishGreenPrinter();
    }

    @Bean
    public RedPrinter redPrinter(){
        return new EnglishRedPrinter();
    }

}
