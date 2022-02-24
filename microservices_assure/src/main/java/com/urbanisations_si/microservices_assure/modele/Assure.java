package com.urbanisations_si.microservices_assure.modele;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

@Entity
public class Assure {
	
	@Id    
    @GeneratedValue(strategy=GenerationType.AUTO)     
    private Integer id;

	@Length(min=3, max=30, message = "Le nombre de caractères du nom de la personne doit être compris entre 3 et 30 au sens large.")
    private String nom;

    private String prenom;

    private Long numeroPersonne;
    
    private String dateNaissance;
    
    private String dossierMedical;
    
    private Long numeroAssure;

	public Assure() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Long getNumeroPersonne() {
		return numeroPersonne;
	}

	public void setNumeroPersonne(Long numeroPersonne) {
		this.numeroPersonne = numeroPersonne;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getDossierMedical() {
		return dossierMedical;
	}

	public void setDossierMedical(String dossierMedical) {
		this.dossierMedical = dossierMedical;
	}

	public Long getNumeroAssure() {
		return numeroAssure;
	}

	public void setNumeroAssure(Long numeroAssure) {
		this.numeroAssure = numeroAssure;
	}

	@Override
	public String toString() {
		return "Assure [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", numeroPersonne=" + numeroPersonne
				+ ", dateNaissance=" + dateNaissance + ", dossierMedical=" + dossierMedical + ", numeroAssure="
				+ numeroAssure + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateNaissance, dossierMedical, id, nom, numeroAssure, numeroPersonne, prenom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Assure other = (Assure) obj;
		return Objects.equals(dateNaissance, other.dateNaissance)
				&& Objects.equals(dossierMedical, other.dossierMedical) && Objects.equals(id, other.id)
				&& Objects.equals(nom, other.nom) && Objects.equals(numeroAssure, other.numeroAssure)
				&& Objects.equals(numeroPersonne, other.numeroPersonne) && Objects.equals(prenom, other.prenom);
	}

}
