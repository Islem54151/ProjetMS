package tn.esprit.spring.control;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DTO.ContratDTO;
import tn.esprit.spring.DTO.ContratWithEmployeDTO;
import tn.esprit.spring.DTO.EmployeDTO;
import tn.esprit.spring.exception.ResourceNotFoundException;
import tn.esprit.spring.services.ContratService;

import java.util.List;



@RestController
@RequestMapping("/api/contrats")
public class ContratController {

    private final ContratService contratService;

    public ContratController(ContratService contratService) {
        this.contratService = contratService;
    }
    @GetMapping("/hello")   // l’URL sera http://localhost:8082/cantrat/hello
    public String hello() {
        return "Contrat service est démarré !";
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ContratDTO create(@RequestBody ContratDTO dto) {
        return contratService.saveContrat(dto);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ContratDTO> getAll() {
        return contratService.getAllContrats();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ContratDTO getById(@PathVariable Long id) {
        return contratService.getContratById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        contratService.deleteContrat(id);
    }

    @GetMapping(value = "/employe/{employeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeDTO> getEmployeInfo(@PathVariable String employeId) {
        EmployeDTO dto = contratService.findEmployeById(employeId);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/full/{contratId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContratWithEmployeDTO> getContratWithEmploye(@PathVariable Long contratId) {
        try {
            ContratWithEmployeDTO dto = contratService.getContratWithEmploye(contratId);
            return ResponseEntity.ok(dto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping(value = "/employe/{employeId}/contrats", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ContratDTO>> getContratsByEmployeId(@PathVariable String employeId) {
        List<ContratDTO> contrats = contratService.findContratsByEmployeId(employeId);
        if (contrats.isEmpty()) {
            return ResponseEntity.noContent().build(); // ou notFound selon ta logique
        }
        return ResponseEntity.ok(contrats);
    }

}

