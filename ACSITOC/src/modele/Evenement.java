package modele;

import java.util.*;

public class Evenement {

	private int idEvenement;
	private String nomEvenement;
	private String lieuEvenement;
	private Date dateEvenement;
	private boolean estRegulier;
	private Vector<Utilisateur> listeParticipantsEvenement;
	private int nbParticipantsEvenement;
	
	public Evenement () {
		this (-1, "", new Date(), "", false);
	}
	
	public Evenement (int _idEvenement, String _nomEvenement, Date _dateEvenement, String _lieuEvenement, boolean _estRegulier) {
		this.idEvenement = _idEvenement;
		this.nomEvenement = _nomEvenement;
		this.dateEvenement = _dateEvenement;
		this.lieuEvenement = _lieuEvenement;
		this.estRegulier = _estRegulier;
	}

	public int getIdEvenement() {
		return idEvenement;
	}

	public void setIdEvenement(int idEvenement) {
		this.idEvenement = idEvenement;
	}

	public String getNomEvenement() {
		return nomEvenement;
	}

	public void setNomEvenement(String nomEvenement) {
		this.nomEvenement = nomEvenement;
	}

	public String getLieuEvenement() {
		return lieuEvenement;
	}

	public void setLieuEvenement(String lieuEvenement) {
		this.lieuEvenement = lieuEvenement;
	}

	public Date getDateEvenement() {
		return dateEvenement;
	}

	public void setDateEvenement(Date dateEvenement) {
		this.dateEvenement = dateEvenement;
	}

	public boolean isEstRegulier() {
		return estRegulier;
	}

	public void setEstRegulier(boolean estRegulier) {
		this.estRegulier = estRegulier;
	}

	public Vector<Utilisateur> getListeParticipantsEvenement() {
		return listeParticipantsEvenement;
	}

	public void setListeParticipantsEvenement(
			Vector<Utilisateur> listeParticipantsEvenement) {
		this.listeParticipantsEvenement = listeParticipantsEvenement;
	}

	public int getNbParticipantsEvenement() {
		return nbParticipantsEvenement;
	}

	public void setNbParticipantsEvenement(int nbParticipantsEvenement) {
		this.nbParticipantsEvenement = nbParticipantsEvenement;
	}
}