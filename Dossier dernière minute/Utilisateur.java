package modele;

import java.util.*;

/**
 * Classe Utilisateur avec attributs, constructeur, getters et setters
 * author Groupe 24
 */
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
	
	/**
	 * Constructeur<br>
	 * Créer un Utilisateur par défaut.
	 */
	public Utilisateur () {
		this ("", "", Utilisateur.UTILISATEUR_LAMBDA);
	}
	
	/**
	 * Constructeur<br>
	 * Affecte à un utilisateur les paramétres suivant :
	 * @param _nomUtilisateur Nom de l'utilisateur
	 * @param _mdpUtilisateur Mot de passe de l'utilisateur
	 * @param _satutUtilisateur
	 */
	public Utilisateur(String _nomUtilisateur, String _mdpUtilisateur, int _statutUtilisateur) {
		this.nomUtilisateur = _nomUtilisateur;
		this.mdpUtilisateur = _mdpUtilisateur;
		this.statutUtilisateur =_statutUtilisateur;
		this.listeEvenementsInscrit = new Vector<Evenement>();
	}
	
	/**
	 * Ajoute un evenement a la liste des evenements parmis lequels l'utilisateur est inscrit
	 * @param _e Evenement auquel l'utilisateur est inscris
	 */
	public void inscrire(Evenement _e) {
		//TODO
		this.listeEvenementsInscrit.add(_e);
	}
	
	/** 
	 * Ajoute un evenements a la liste des evenemenbts auquels participe l'utilisateur
	 * @param _ve Vector d'événements
	 * @return void
	 */
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
