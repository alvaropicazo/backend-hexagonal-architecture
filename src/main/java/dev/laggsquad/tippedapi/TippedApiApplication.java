package dev.laggsquad.tippedapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class TippedApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(TippedApiApplication.class, args);
  }
}
