package com.lld.bms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.lld.bms.controller.UserController;
import com.lld.bms.repository.UserRepository;

@SpringBootApplication
public class BmsApplication implements CommandLineRunner{

  @Autowired
  UserRepository userRepository;
  
  @Autowired
  UserController userController;
  
	public static void main(String[] args){
		SpringApplication.run(BmsApplication.class, args);
	}

  @Override
  public void run(String... args) throws Exception {
    // TODO Auto-generated method stub
    System.out.println("Inside book My Show");
    
    //we can add user details for sign up
  }

}
