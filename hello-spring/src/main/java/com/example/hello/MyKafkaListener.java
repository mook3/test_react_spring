package com.example.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import org.springframework.kafka.annotation.KafkaListener;


@Component
public class MyKafkaListener {
//
//    private final KafkaTemplate<String, String> template;
//
//    @Autowired
//    public MyKafkaListener(KafkaTemplate<String, String> template) {
//        this.template = template;
//    }
//
//    @KafkaListener(id = "topic1_2", topics = "topic1")
//    public void listen(String in) {
//        System.out.println("MyKafkaListener: " + in);
//    }
}
