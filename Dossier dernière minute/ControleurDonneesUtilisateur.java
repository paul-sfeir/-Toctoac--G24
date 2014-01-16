package controleur;

import modele.*;
//import modele.Utilisateur.*;

import java.util.*;

/**
 * Gestion des données utilisateur
 * @author Groupe G24
 */
public class ControleurDonneesUtilisateur {
	private Vector<Utilisateur> listeUtilisateurs;
	
	
	/**
	 * Constructeur, initialise les données utilisateur
	 */
	public ControleurDonneesUtilisateur() {
		this.listeUtilisateurs = new Vector<Utilisateur>();
		
		this.listeUtilisateurs.add(new Utilisateur("user1", "a", Utilisateur.ADMINISTRATEUR));
		this.listeUtilisateurs.add(new Utilisateur("user2", "a", Utilisateur.ENTRAINEUR));
		this.listeUtilisateurs.add(new Utilisateur("user3", "a", Utilisateur.UTILISATEUR_LAMBDA));
	}
	
	/**
	 * Retourne la liste des utilisateurs
	 * @return Vector<Utilisateur>
	 */
	public Vector<Utilisateur> getListeUtilisateurs() {
		return listeUtilisateurs;
	}
	
	/**
	 * Retourne un utilisateur en fonction de son nom.
	 * @param _nu Le nom de l'utilisateur recherché
	 * @return Utilisateur
	 */
	public Utilisateur getUtilisateur(String _nu) {
		int i = 0;
		Utilisateur user = null;
		
		while (i < this.listeUtilisateurs.size() && user == null) {
			if (this.listeUtilisateurs.get(i).getNomUtilisateur().equals(_nu))
				user = this.listeUtilisateurs.get(i);
			i++;
		}
		
		return user;
	}
	
	/**
	 * Initialise la liste d'utilisateur
	 * @param listeUtilisateurs
	 * @return void
	 */
	public void setListeUtilisateurs(Vector<Utilisateur> listeUtilisateurs) {
		this.listeUtilisateurs = listeUtilisateurs;
	}
}
