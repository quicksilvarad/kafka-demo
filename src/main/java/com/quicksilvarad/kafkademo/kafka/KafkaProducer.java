package com.quicksilvarad.kafkademo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Value("${spring.kafka.topic.name}")
    private String topic;
    private KafkaTemplate<String,String> kafkaTemplate;
    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaProducer.class);
    public KafkaProducer(KafkaTemplate<String,String> kafkaTemplate)
    {
         this.kafkaTemplate=kafkaTemplate;
    }

    public void sendMessage(String message)
    {
        LOGGER.info(String.format("Message sent %s", message));
        kafkaTemplate.send(topic,message);
    }
}
