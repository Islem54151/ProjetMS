package tn.esprit.spring.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DTO.EmployeDTO;

@Service
public class ObjectProducer {

    @Autowired
    private KafkaTemplate<String, EmployeDTO> kafkaTemplate;

    public void send(String topic, EmployeDTO employe) {
        kafkaTemplate.send(topic, employe);
        System.out.println(" Objet EmployeDTO envoyé à Kafka : " + employe);
    }
}
