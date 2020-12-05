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
@Table(name="LignePanier")
public class LignePanier {
	@Id
	@Column(name="code")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "livre_id")
	private Livre livre;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "panier_id")
	private Panier panier;
	
	@Column(name="total")
	private double total=0;
	
	
	public LignePanier(Livre livre, Panier panier, double total, int code) {
		this.livre = livre;
		this.panier = panier;
		this.total = total;
		this.code = code;
	}

	public LignePanier() {
	
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "LignePanier [livre=" + livre + ", panier=" + panier + ", total=" + total + ", code=" + code + "]";
	}


}
