package tn.esprit.spring.producer;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonSerializer;
import tn.esprit.spring.DTO.EmployeDTO;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    // Producer pour String
    @Bean
    public KafkaTemplate<String, String> kafkaTemplateString() {
        return new KafkaTemplate<>(stringProducerFactory());
    }

    @Bean
    public ProducerFactory<String, String> stringProducerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }

    // Producer pour EmployeDTO
    @Bean
    public KafkaTemplate<String, EmployeDTO> kafkaTemplateObject() {
        return new KafkaTemplate<>(objectProducerFactory());
    }

    @Bean
    public ProducerFactory<String, EmployeDTO> objectProducerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }
}
