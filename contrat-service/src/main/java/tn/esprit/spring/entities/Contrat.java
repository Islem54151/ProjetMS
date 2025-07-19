package tn.esprit.spring.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Contrat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reference;

	@Temporal(TemporalType.DATE)
	private Date dateDebut;

	private String typeContrat;

	private float salaire;

	private String employeId;

	// Getters & setters

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
