package tn.esprit.spring.services;

import org.springframework.stereotype.Service;
import tn.esprit.spring.DTO.ContratDTO;
import tn.esprit.spring.DTO.ContratWithEmployeDTO;
import tn.esprit.spring.DTO.EmployeDTO;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.exception.ResourceNotFoundException;
import tn.esprit.spring.mapper.ContratMapper;
import tn.esprit.spring.repository.ContratRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContratServiceImpl implements ContratService {

    private final ContratRepository repository;
    private final ContratMapper mapper;
    private final EmployeFeignClient employeFeignClient;

    public ContratServiceImpl(
            ContratRepository repository,
            ContratMapper mapper,
            EmployeFeignClient employeFeignClient
    ) {
        this.repository = repository;
        this.mapper = mapper;
        this.employeFeignClient = employeFeignClient;
    }

    @Override
    public ContratDTO saveContrat(ContratDTO dto) {
        Contrat contrat = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(contrat));
    }

    @Override
    public List<ContratDTO> getAllContrats() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public ContratDTO getContratById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElse(null);
    }

    @Override
    public void deleteContrat(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ContratWithEmployeDTO getContratWithEmploye(Long contratId) {
        Contrat contrat = repository.findById(contratId)
                .orElseThrow(() -> new ResourceNotFoundException("Contrat non trouvé avec l'id " + contratId));

        EmployeDTO employe = employeFeignClient.getEmployeById(contrat.getEmployeId());

        return new ContratWithEmployeDTO(mapper.toDTO(contrat), employe);
    }


    @Override
    public EmployeDTO findEmployeById(String id) {
        try {
            return employeFeignClient.getEmployeById(id);
        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération de l'employé : " + e.getMessage());
            return null;
        }
    }


    public List<ContratDTO> findContratsByEmployeId(String employeId) {
        // Utiliser l'instance contratRepository (avec la première lettre en minuscule)
        List<Contrat> contrats = repository.findByEmployeId(employeId);

        // Utiliser l'instance contratMapper (avec la première lettre en minuscule)
        return contrats.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

}
