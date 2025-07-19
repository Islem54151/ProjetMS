package tn.esprit.spring.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import tn.esprit.spring.DTO.EmployeDTO;
import tn.esprit.spring.entities.Employe;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-19T07:23:06+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class EmployeMapperImpl implements EmployeMapper {

    @Override
    public EmployeDTO toDTO(Employe employe) {
        if ( employe == null ) {
            return null;
        }

        EmployeDTO employeDTO = new EmployeDTO();

        employeDTO.setId( employe.getId() );
        employeDTO.setNom( employe.getNom() );
        employeDTO.setPrenom( employe.getPrenom() );
        employeDTO.setPoste( employe.getPoste() );

        return employeDTO;
    }

    @Override
    public Employe toEntity(EmployeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Employe employe = new Employe();

        employe.setId( dto.getId() );
        employe.setNom( dto.getNom() );
        employe.setPrenom( dto.getPrenom() );
        employe.setPoste( dto.getPoste() );

        return employe;
    }
}
