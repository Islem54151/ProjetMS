package tn.esprit.spring.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class ContratDTO {
    private Long reference;
    private Date dateDebut;
    private String typeContrat;
    private float salaire;
    private String employeId; // juste l'ID, car Employé est dans un autre microservice

    public Long getReference() {
        return reference;
    }

    public void setReference(Long reference) {
        this.reference = reference;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    public String getEmployeId() {
        return employeId;
    }

    public void setEmployeId(String employeId) {
        this.employeId = employeId;
    }
}
