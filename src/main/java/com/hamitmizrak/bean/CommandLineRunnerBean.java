package com.hamitmizrak.bean;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@Log4j2
public class CommandLineRunnerBean {
    public CommandLineRunner commandLineRunnerMethod() {
        return args -> {
            log.info("Data set oluşturulmuştur.");
            System.out.println("Data set oluşturulmuştur.");
        }; //end retur
    } //end CommandLineRunnerBean method
} // end class
