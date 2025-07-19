package tn.esprit.spring.services;

import org.springframework.stereotype.Service;
import tn.esprit.spring.DTO.EmployeDTO;
import tn.esprit.spring.mapper.EmployeMapper;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.services.EmployeService;

import java.util.List;

@Service
public class EmployeServiceImpl implements EmployeService {

    private final EmployeRepository repository;
    private final EmployeMapper mapper;

    // Constructeur explicitement défini
    public EmployeServiceImpl(EmployeRepository repository, EmployeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public EmployeDTO save(EmployeDTO dto) {
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public List<EmployeDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }


    @Override
    public EmployeDTO findById(String id) {
        EmployeDTO dto = mapper.toDTO(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employé non trouvé avec ID : " + id)));
        System.out.println("EmployeDTO retourné: " + dto);
        return dto;
    }

}
