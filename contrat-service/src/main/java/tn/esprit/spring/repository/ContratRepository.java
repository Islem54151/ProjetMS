package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.DTO.ContratDTO;
import tn.esprit.spring.entities.Contrat;

import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat, Long> {
    List<Contrat> findByEmployeId(String employeId);



}
