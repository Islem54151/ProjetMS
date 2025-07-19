package tn.esprit.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DTO.EmployeDTO;
import tn.esprit.spring.producer.ObjectProducer;
import tn.esprit.spring.producer.StringProducer;
import tn.esprit.spring.services.EmployeService;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
public class EmployeController {

    private final EmployeService service;

    public EmployeController(EmployeService service) {
        this.service = service;
    }

    @Autowired
    private StringProducer stringProducer;

    @Autowired
    private ObjectProducer objectProducer;


    @PostMapping("/send-string")
    public void sendString(@RequestParam String message) {
        stringProducer.sendMessage("stringTopic", message);
    }

    @PostMapping("/send-object")
    public void sendObject(@RequestBody EmployeDTO employe) {
        objectProducer.send("employeTopic", employe);
    }

    @PostMapping("/add")
    public EmployeDTO save(@RequestBody EmployeDTO dto) {
        return service.save(dto);
    }


    @GetMapping("/list")
    public List<EmployeDTO> getAll() {
        return service.findAll();
    }


    @GetMapping("/{id}")
    public EmployeDTO getById(@PathVariable String id) {
        return service.findById(id);
    }
}
