package tn.esprit.spring.mapper;


import org.mapstruct.Mapper;
import tn.esprit.spring.DTO.EmployeDTO;
import tn.esprit.spring.entities.Employe;

@Mapper(componentModel = "spring")
public interface EmployeMapper {
    EmployeDTO toDTO(Employe employe);
    Employe toEntity(EmployeDTO dto);
}


