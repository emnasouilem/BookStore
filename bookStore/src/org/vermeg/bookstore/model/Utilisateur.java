package org.vermeg.bookstore.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class Utilisateur {
	@Id
	@Column(name="numU")
	private int numU;
	@Column(name="pseudo")
	private String pseudo ;
	@Column(name="motpasse")
	private String motpasse;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Panier> listPanier;

	public Utilisateur(int numU, String pseudo, String motpasse, List<Panier> listPanier) {
		super();
		this.numU = numU;
		this.pseudo = pseudo;
		this.motpasse = motpasse;
		this.listPanier = listPanier;
	}

	public Utilisateur() {
	
	}

	public int getNumU() {
		return numU;
	}

	public void setNumU(int numU) {
		this.numU = numU;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMotpasse() {
		return motpasse;
	}

	public void setMotpasse(String motpasse) {
		this.motpasse = motpasse;
	}

	public List<Panier> getListPanier() {
		return listPanier;
	}

	public void setListPanier(List<Panier> listPanier) {
		this.listPanier = listPanier;
	}

	@Override
	public String toString() {
		return "Utilisateur [numU=" + numU + ", pseudo=" + pseudo + ", motpasse=" + motpasse + ", listPanier="
				+ listPanier + "]";
	}
	
}
