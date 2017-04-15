package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "app")
public class SpringBootApp extends SpringBootServletInitializer {
    public static void main(String[] args) /*throws Exception*/ { 
        SpringApplication.run(SpringBootApp.class, args);
    }

   @Override
   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
       return application.sources(SpringBootApp.class);
   }
   
}