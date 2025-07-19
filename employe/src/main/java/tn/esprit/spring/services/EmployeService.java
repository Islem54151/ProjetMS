package tn.esprit.spring.services;



import tn.esprit.spring.DTO.EmployeDTO;

import java.util.List;

public interface EmployeService {
    EmployeDTO save(EmployeDTO dto);
    List<EmployeDTO> findAll();
    EmployeDTO findById(String id);
}

