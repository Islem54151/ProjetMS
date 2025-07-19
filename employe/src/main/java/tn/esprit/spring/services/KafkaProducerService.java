package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DTO.EmployeDTO;

@Service
public class KafkaProducerService {
    private static final String TOPIC = "employe-notifications";

    @Autowired
    private KafkaTemplate<String, EmployeDTO> kafkaTemplate;

    public void send(EmployeDTO employe) {
        kafkaTemplate.send(TOPIC, employe);
    }
}
