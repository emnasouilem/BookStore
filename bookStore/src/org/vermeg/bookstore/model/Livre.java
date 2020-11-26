package org.vermeg.bookstore.model;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="book")
public class Livre {
	@Id
	@Column(name="livre_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
    @Column(name="reference",length = 12,unique=true)
	private double reference;
    @Column(name = "title")
	private String titre;
    @Column(name = "author")
	private String auteur;
    @Column(name = "releaseDate")
	private String dateRealisation;
    @Column(name = "designation")
	private String designation;
    @Column(name = "unitprice")
	private double prixUnitaire;
    
    @OneToMany(mappedBy = "panier", cascade = CascadeType.ALL)
	private List<LignePanier> ligne;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getReference() {
		return reference;
	}
	public void setReference(double reference) {
		this.reference = reference;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getReleaseDate() {
		return dateRealisation;
	}
	public void setReleaseDate(String releaseDate) {
		this.dateRealisation = releaseDate;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	
	public Livre(int id, double reference, String titre, String auteur, String releaseDate, String designation,
			double prixUnitaire) {
		this.id = id;
		this.reference = reference;
		this.titre = titre;
		this.auteur = auteur;
		this.dateRealisation = releaseDate;
		this.designation = designation;
		this.prixUnitaire = prixUnitaire;
	}
	public Livre() {
	
	}
	@Override
	public String toString() {
		return "Livre [id=" + id + ", reference=" + reference + ", titre=" + titre + ", auteur=" + auteur
				+ ", dateRealisation=" + dateRealisation + ", designation=" + designation + ", prixUnitaire="
				+ prixUnitaire + ", ligne=" + ligne + "]";
	}
	
	
	
	
    
    

}
