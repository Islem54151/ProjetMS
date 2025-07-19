package tn.esprit.spring.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.spring.DTO.EmployeDTO;
import tn.esprit.spring.security.FeignClientOAuth2Config;

@FeignClient(name = "employe-service", fallback = EmployeFeignFallback.class, configuration = FeignClientOAuth2Config.class)
public interface EmployeFeignClient {

    @GetMapping("/api/employes/{id}")
    EmployeDTO getEmployeById(@PathVariable("id") String id);
}
