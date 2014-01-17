package controleur;

import vue.*;
//import modele.*;

/**
 * Classe Controleur<br>
 * Controleur principal, il gére toutes les vues.
 * @author Groupe 24
 */
public class ControleurPrincipal {
	public static void main(String[] args) {
		/* cr�ation du premier utilisateur
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
		//ControleurDonneesEvenement cde = new ControleurDonneesEvenement();
		ControleurConnexion cc = new ControleurConnexion(cdu);
		//ControleurAdministrateur ca = new ControleurAdministrateur(cdu, cde);
		VueConnexion fenetreCo = new VueConnexion(cc);
		fenetreCo.setVisible(true);
		//VueAdministrateur va = new VueAdministrateur(ca);
		//va.setVisible(true);
	}

}
