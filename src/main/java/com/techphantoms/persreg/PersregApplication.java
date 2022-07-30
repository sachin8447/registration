package com.techphantoms.persreg;

import com.techphantoms.persreg.modal.HelloWorldMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersregApplication implements CommandLineRunner {

    @Autowired
   private RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PersregApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        rabbitTemplate.convertAndSend(new HelloWorldMessage("as","asdas"));
    }
}
