package controleur;

import vue.VueAfficherUtilisateurs;
/**
 * Controleur de la classe administrateur
 * @author Groupe 24
 */
public class ControleurAdministrateur {
	private ControleurDonneesUtilisateur controleurDonneesU;
	private ControleurDonneesEvenement controleurDonneesE;
	
	/**
 	 * Controleur<br>
 	 * Initialise les controleurs des Donnees utilisateur et des Donnees événements
 	 * @param _cdu ControleurDonneesUtilisateur
 	 * @param _cde ControleurDonneesEvenement
 	 */
	public ControleurAdministrateur(ControleurDonneesUtilisateur _cdu, ControleurDonneesEvenement _cde) {
		this.controleurDonneesU = _cdu;
		this.controleurDonneesE = _cde;
	}
	
	/**
 	 * Initialise et lance la vue pour afficher les utilisateurs
 	 * @return void
 	 */
	public void afficherListeUtilisateurs () {
		VueAfficherUtilisateurs vau = new VueAfficherUtilisateurs();
		vau.setVisible(true);
	}
	
	/**
	 * 
	 * @return void
	 */
	public void afficherListeEvenements () {
		
	}
	
	public ControleurDonneesUtilisateur getControleurDonneesU() {
		return controleurDonneesU;
	}
	
	public void setControleurDonneesU(ControleurDonneesUtilisateur controleurDonneesU) {
		this.controleurDonneesU = controleurDonneesU;
	}
	
	public ControleurDonneesEvenement getControleurDonneesE() {
		return controleurDonneesE;
	}

	public void setControleurDonneesE(ControleurDonneesEvenement controleurDonneesE) {
		this.controleurDonneesE = controleurDonneesE;
	}
}
