package com.coforge.kafkaProducerApp.kafkaController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KfkaUserResourse {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "THIS IS MY FIRST TOPIC";

    @RequestMapping("/resource/{message}")
    public String post(@PathVariable("message") String msg) {
        kafkaTemplate.send(TOPIC, msg);
        return "Message is sended ";
    }
}
