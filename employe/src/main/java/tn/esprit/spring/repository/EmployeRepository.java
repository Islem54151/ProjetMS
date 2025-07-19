package tn.esprit.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.spring.entities.Employe;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends MongoRepository<Employe, String> {

}
