package com.example.hello;

import com.example.hello.repository.PostRepository;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class HelloApplication {

    @Autowired
    private PostRepository postRepository;

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
        System.out.println("HelloApplication main!");
    }

//    @Bean
//    public NewTopic topic() {
//        return TopicBuilder.name("topic1")
//                //.partitions(10)
//                .replicas(1)
//                .build();
//    }
//
//    @KafkaListener(id = "topic1_1", topics = "topic1")
//    public void listen(String in) {
//        System.out.println("HelloApp: " + in);
//    }
//
//    @Bean
//    public ApplicationRunner runner(KafkaTemplate<String, String> template) {
//        return args -> {
//            template.send("topic1", "test");
//        };
//    }
}

