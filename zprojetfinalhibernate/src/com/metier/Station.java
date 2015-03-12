package com.metier;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author lequay-l
 * classe métier qui gère une station  avec sa liste de bornes
 * 
 */
@Entity
@Table(name="station")
public class Station {
	
	@Id
	@Column(name="idStation")
	@GeneratedValue
	private int idStation;
	
	@Column(name="libelleEmplacement")
	private String libelleEmplacement;
	
	@OneToMany
	@JoinColumn(name="idStation")
	private List<Borne> lesBornes;
	/**
	 * constructeur utilisé par la classe StationDAO
	 * @param idStation
	 * @param libelleEmplacement
	 * 
	 */
	public Station(int idStation, String libelleEmplacement) {
		super();
		this.idStation = idStation;
		this.libelleEmplacement = libelleEmplacement;
		this.lesBornes = new ArrayList<Borne>();
	}
	/**
	 * constructeur pour nouvelle station, pas idStation car numéro auto
	 * @param libelleEmplacement
	 */

	public Station(String libelleEmplacement) {
		super();
		this.libelleEmplacement = libelleEmplacement;
		this.lesBornes = new ArrayList<Borne>();
	}
	
	public Station() {
		super();
	}
	
	/**
	 * accesseur sur le libelle emplacement de la station
	 * @return libelleEmplacement
	 * 
	 */
	public String getLibelleEmplacement() {
		return libelleEmplacement;
	}
	/**
	 * modificateur sur le libelle emplacement de la station
	 * @param libelleEmplacement
	 */
	public void setLibelleEmplacement(String libelleEmplacement) {
		this.libelleEmplacement = libelleEmplacement;
	}
	
	/**
	 * redéfinition de la méthode toString()
	 * affiche l'idStation et le libellé emplacement
	 */
	@Override
	public String toString() {
		return "Station [idStation=" + idStation + ", libelleEmplacement="
				+ libelleEmplacement + "]";
	}


	public List<Borne> getLesBornes() {
		return lesBornes;
	}
	public void setLesBornes(List<Borne> lesBornes) {
		this.lesBornes = lesBornes;
	}
	public int getIdStation() {
		return idStation;
	}
	public void addBorne(Borne b) {
		lesBornes.add(b);
	}
	public void setIdStation(int idStation) {
		this.idStation = idStation;
	}

}

