package tn.esprit.spring.DTO;


public class ContratWithEmployeDTO {
    private ContratDTO contrat;
    private EmployeDTO employe;

    public ContratWithEmployeDTO() {
    }

    public ContratWithEmployeDTO(ContratDTO contrat, EmployeDTO employe) {
        this.contrat = contrat;
        this.employe = employe;
    }

    public ContratDTO getContrat() {
        return contrat;
    }

    public void setContrat(ContratDTO contrat) {
        this.contrat = contrat;
    }

    public EmployeDTO getEmploye() {
        return employe;
    }

    public void setEmploye(EmployeDTO employe) {
        this.employe = employe;
    }
}
