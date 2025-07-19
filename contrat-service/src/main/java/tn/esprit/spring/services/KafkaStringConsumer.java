package tn.esprit.spring.services;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaStringConsumer {

    @KafkaListener(topics = "stringTopic", groupId = "contrat-string-group")
    public void consumeString(String message) {
        System.out.println("Message texte reçu dans contrat-service : " + message);
    }
}
