package com.metier;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="borne")
public class Borne {
		
	@Id
	@Column(name="idBorne")
	@GeneratedValue
	private int idBorne;
	
	@Column(name="dateMiseEnService")
	private String dateMiseEnService;
	
	@Column(name="etat")
	private String etat;
	
	@ManyToOne
	@JoinColumn(name="idStation")
	private Station laStation;
	
	@ManyToOne
	@JoinColumn(name="codeTypeCharge")
	private TypeCharge typeCharge;
	
	
	/*public Borne(int idBorne, String dateMiseEnService,Station laStation, String etat,  TypeCharge typeCharge) {
		super();
		this.idBorne = idBorne;
		this.dateMiseEnService = dateMiseEnService;
		this.etat = etat;
		this.laStation = laStation;
		this.typeCharge = typeCharge;
	}*/
	// constructeur pour nouvelle borne
	public Borne(String dateMiseEnService,Station laStation, TypeCharge typeCharge) {
		super();
		this.etat = "ES";
		this.dateMiseEnService = dateMiseEnService;
		this.laStation = laStation;
		this.typeCharge = typeCharge;
	}
	
	public Borne() {
		super();
	}
	
	@Override
	public String toString() {
		return "Borne [idBorne =" + idBorne + ", dateMiseEnService="
				+ dateMiseEnService + ", etat=" + etat + ", laStation=" + laStation
				+ ", typeCharge=" + typeCharge.toString() + "]";
	}
	
	public Station getLaStation() {
		return laStation;
	}
	public void setLaStation(Station laStation) {
		this.laStation = laStation;
	}
	public String getDateMiseEnService() {
		return dateMiseEnService;
	}
	public void setDateMiseEnService(String dateMiseEnService) {
		this.dateMiseEnService = dateMiseEnService;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public TypeCharge getTypeCharge() {
		return typeCharge;
	}
	public void setTypeCharge(TypeCharge typeCharge) {
		this.typeCharge = typeCharge;
	}
	public int getIdBorne() {
		return idBorne;
	}
	public void setIdBorne(int idBorne) {
		this.idBorne = idBorne;
	}

}
