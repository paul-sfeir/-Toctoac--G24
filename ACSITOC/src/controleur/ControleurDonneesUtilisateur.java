package controleur;

import modele.*;
//import modele.Utilisateur.*;

import java.util.*;

public class ControleurDonneesUtilisateur {
	private Vector<Utilisateur> listeUtilisateurs;
	
	public ControleurDonneesUtilisateur() {
		this.listeUtilisateurs = new Vector<Utilisateur>();
		
		this.listeUtilisateurs.add(new Utilisateur("admin", "a", Utilisateur.ADMINISTRATEUR));
		this.listeUtilisateurs.add(new Utilisateur("entraineur", "a", Utilisateur.ENTRAINEUR));
		this.listeUtilisateurs.add(new Utilisateur("user", "a", Utilisateur.UTILISATEUR_LAMBDA));
	}

	public Vector<Utilisateur> getListeUtilisateurs() {
		return listeUtilisateurs;
	}
	
	public Utilisateur getUtilisateur (String _nu) {
		int i = 0;
		Utilisateur user = null;
		
		while (i < this.listeUtilisateurs.size() && user == null) {
			if (this.listeUtilisateurs.get(i).getNomUtilisateur().equals(_nu))
				user = this.listeUtilisateurs.get(i);
			i++;
		}
		
		return user;
	}

	public void setListeUtilisateurs(Vector<Utilisateur> listeUtilisateurs) {
		this.listeUtilisateurs = listeUtilisateurs;
	}
}
