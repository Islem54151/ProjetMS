package tn.esprit.spring.services;

import org.springframework.stereotype.Component;
import tn.esprit.spring.DTO.EmployeDTO;
@Component
public class EmployeFeignFallback implements EmployeFeignClient {
    @Override
    public EmployeDTO getEmployeById(String id) {
        EmployeDTO fallback = new EmployeDTO();
        fallback.setId(id);
        fallback.setNom("Employé non disponible");
        fallback.setPrenom("Fallback");
        return fallback;
    }
}

