package com.example.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    /**
     * Se crea un topic de kafka llamado: "amigoscode"
     */
    @Bean
     public NewTopic amigoscodeTopic(){
         return TopicBuilder.name("amigoscode")
                 .build();
     }
}
