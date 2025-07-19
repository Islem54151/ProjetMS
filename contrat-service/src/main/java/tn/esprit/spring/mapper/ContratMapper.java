package tn.esprit.spring.mapper;

import org.mapstruct.Mapper;
import tn.esprit.spring.DTO.ContratDTO;
import tn.esprit.spring.entities.Contrat;

@Mapper(componentModel = "spring")
public interface ContratMapper {
    ContratDTO toDTO(Contrat contrat);
    Contrat toEntity(ContratDTO dto);
}
