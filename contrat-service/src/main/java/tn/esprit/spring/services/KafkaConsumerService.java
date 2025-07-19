package tn.esprit.spring.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DTO.EmployeDTO;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "employeTopic", groupId = "contrat-group")
    public void consumeEmploye(EmployeDTO employe) {
        System.out.println("📥 Employé reçu dans contrat-service : "
                + ", Nom: " + employe.getNom() + " "
               +", Prenom: "  + employe.getPrenom()
                + ", poste: " + employe.getPoste());
    }

}
