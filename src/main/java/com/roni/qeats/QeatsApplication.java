package com.roni.qeats;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class QeatsApplication {

  @Autowired
  private PasswordEncoder passwordEncoder;


  @Bean
  public ModelMapper modelMapper()
  {
    return new ModelMapper();
  }

  public static void main(String[] args) {
    SpringApplication.run(QeatsApplication.class, args);
  }

}
