package controleur;

import vue.VueAfficherUtilisateurs;
import vue.Vue_Evenement;

public class ControleurAdministrateur {
	private ControleurDonneesUtilisateur controleurDonneesU;
	private ControleurEvenement ce;
	private ControleurConnexion cc;
	
	public ControleurConnexion getCc() {
		return cc;
	}

	public ControleurAdministrateur(ControleurDonneesUtilisateur _cdu, ControleurEvenement _cde, ControleurConnexion _cc) {
		this.controleurDonneesU = _cdu;
		this.ce = _cde;
	}
	
	public void afficherListeUtilisateurs () {
		VueAfficherUtilisateurs vau = new VueAfficherUtilisateurs(controleurDonneesU);
		vau.majVueAfficher();
		vau.setLocationRelativeTo(null); //fenetre centrée
		vau.setVisible(true);
	}
	
	public void afficherListeEvenements () {
		ce = new ControleurEvenement();
		ce.demarrerControleurEvenement();
	}

	public ControleurDonneesUtilisateur getControleurDonneesU() {
		return controleurDonneesU;
	}

	public void setControleurDonneesU(
			ControleurDonneesUtilisateur controleurDonneesU) {
		this.controleurDonneesU = controleurDonneesU;
	}

	public ControleurEvenement getControleurDonneesE() {
		return ce;
	}

	public void setControleurDonneesE(ControleurEvenement controleurDonneesE) {
		this.ce = controleurDonneesE;
	}
}
