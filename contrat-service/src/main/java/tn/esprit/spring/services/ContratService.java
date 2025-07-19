package tn.esprit.spring.services;

import tn.esprit.spring.DTO.ContratDTO;
import tn.esprit.spring.DTO.ContratWithEmployeDTO;
import tn.esprit.spring.DTO.EmployeDTO;

import java.util.List;

public interface ContratService {
    ContratDTO saveContrat(ContratDTO dto);
    List<ContratDTO> getAllContrats();
    ContratDTO getContratById(Long id);
    void deleteContrat(Long id);
    ContratWithEmployeDTO getContratWithEmploye(Long id);
    EmployeDTO findEmployeById(String id);

    List<ContratDTO> findContratsByEmployeId(String employeId);
}
