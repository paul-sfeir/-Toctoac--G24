package controleur;

import vue.*;
//import modele.*;

public class ControleurPrincipal {
	public static void main(String[] args) {
		/* création du premier utilisateur
		Utilisateur Admin = new Utilisateur(1, "BigBrother","SWAG", 1);
		try {
		FileOutputStream fichier = new FileOutputStream("personne.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fichier);
		oos.writeObject(Admin);
		oos.flush();
		oos.close();
		}
		catch (java.io.IOException e) {
			e.printStackTrace();
		}
		*/
		
		ControleurDonneesUtilisateur cdu = new ControleurDonneesUtilisateur();
		ControleurConnexion cc = new ControleurConnexion(cdu);
		
		/*
		ControleurEvenement cev = new ControleurEvenement();
		Vue_Evenement vevent = new Vue_Evenement(cev);
		vevent.setVisible(true);
		*/
	}

}
