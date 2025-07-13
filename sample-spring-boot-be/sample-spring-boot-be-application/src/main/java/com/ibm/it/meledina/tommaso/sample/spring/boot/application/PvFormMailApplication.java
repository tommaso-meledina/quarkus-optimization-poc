package com.ibm.it.meledina.tommaso.sample.spring.boot.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.ibm.it.meledina.tommaso.sample.spring.boot.model"})
public class PvFormMailApplication {

  public static void main(String[] args) {
    SpringApplication.run(PvFormMailApplication.class, args);
  }
}
