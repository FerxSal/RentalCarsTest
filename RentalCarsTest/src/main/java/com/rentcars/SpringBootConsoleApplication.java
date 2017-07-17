package com.rentcars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.rentcars.service.HelloMessageService;
import com.rentcars.service.MessageService;

import static java.lang.System.exit;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

    @Autowired
    private MessageService helloService;

    public static void main(String[] args) throws Exception {

        //disabled banner, don't want to see the spring logo
        SpringApplication app = new SpringApplication(SpringBootConsoleApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

    }

	// Put your logic here.
    @Override
    public void run(String... args) throws Exception {

        if (args.length > 0) {
            helloService.getMessage(args[0].toString());
        } else {
            helloService.getMessage();
        }

        exit(0);
    }
}