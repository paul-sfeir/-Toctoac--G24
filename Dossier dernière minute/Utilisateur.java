package modele;

import java.util.*;

public class Utilisateur {
	private String nomUtilisateur;
	private String mdpUtilisateur;
	private int statutUtilisateur;
	private Vector<Evenement> listeEvenementsInscrit;
	public static final int ADMINISTRATEUR = 1;
	public static final int ENTRAINEUR = 2;
	public static final int UTILISATEUR_LAMBDA = 3;
	/* TODO: enum
	public enum statut {
			ADMINISTRATEUR,
			ENTRAINEUR,
			UTILISATEUR_LAMBDA
	}
	*/
	
	public Utilisateur () {
		this ("", "", Utilisateur.UTILISATEUR_LAMBDA);
	}
	
	public Utilisateur(String _nomUtilisateur, String _mdpUtilisateur, int _statutUtilisateur) {
		this.nomUtilisateur = _nomUtilisateur;
		this.mdpUtilisateur = _mdpUtilisateur;
		this.statutUtilisateur =_statutUtilisateur;
		this.listeEvenementsInscrit = new Vector<Evenement>();
	}
	
	public void inscrire(Evenement _e) {
		//TODO
		this.listeEvenementsInscrit.add(_e);
	}
	
	public void remplirListeEvenements (Vector<Evenement> _ve) {
		for (int i = 0; i < _ve.size(); i++) {
			if (_ve.get(i).getListeParticipantsEvenement().contains(this)) {
				this.listeEvenementsInscrit.add(_ve.get(i));
			}
		}
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getMdpUtilisateur() {
		return mdpUtilisateur;
	}

	public void setMdpUtilisateur(String mdpUtilisateur) {
		this.mdpUtilisateur = mdpUtilisateur;
	}

	public int getStatutUtilisateur() {
		return statutUtilisateur;
	}

	public void setStatutUtilisateur(int statutUtilisateur) {
		this.statutUtilisateur = statutUtilisateur;
	}

	public Vector<Evenement> getListeEvenementsInscrit() {
		return listeEvenementsInscrit;
	}

	public void setListeEvenementsInscrit(Vector<Evenement> listeEvenementsInscrit) {
		this.listeEvenementsInscrit = listeEvenementsInscrit;
	}
}
