

package tn.esprit.spring.entities ;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "employes")
@Data


public class Employe {
    @Id
    private String id;
    private String nom;
    private String prenom;
    private String poste;
    public Employe() {
        // constructeur vide obligatoire pour MapStruct
    }
    public Employe(String id, String nom, String prenom, String poste) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
    }

    // getters/setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getPoste() { return poste; }
    public void setPoste(String poste) { this.poste = poste; }
}
