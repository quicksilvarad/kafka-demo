package com.quicksilvarad.kafkademo.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name}")
    private String topic;
    @Value("${spring.kafka.topic.name}")
    private String topic_json;
    @Bean
    public NewTopic demoTopic()
    {
        return TopicBuilder.name(topic).build();
    }

    @Bean
    public NewTopic demoJsonTopic()
    {
        return TopicBuilder.name(topic_json).build();
    }
}
