package org.vermeg.bookstore.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="panier")
public class Panier {
@Id
@Column(name="panier_id")
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;

	@OneToMany(mappedBy = "livre", cascade = CascadeType.ALL)
	private List<LignePanier> ligne;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "numU")
	private Utilisateur  user;

	public Panier(int id, List<LignePanier> ligne, Utilisateur user) {
		this.id = id;
		this.ligne = ligne;
		this.user = user;
	}

	public Panier() {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<LignePanier> getLigne() {
		return ligne;
	}

	public void setLigne(List<LignePanier> ligne) {
		this.ligne = ligne;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Panier [id=" + id + ", ligne=" + ligne + ", user=" + user + "]";
	}
	
	
}
