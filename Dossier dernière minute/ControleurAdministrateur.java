package controleur;

import vue.VueAfficherUtilisateurs;

public class ControleurAdministrateur {
	private ControleurDonneesUtilisateur controleurDonneesU;
	private ControleurDonneesEvenement controleurDonneesE;
	
	public ControleurAdministrateur(ControleurDonneesUtilisateur _cdu, ControleurDonneesEvenement _cde) {
		this.controleurDonneesU = _cdu;
		this.controleurDonneesE = _cde;
	}
	
	public void afficherListeUtilisateurs () {
		VueAfficherUtilisateurs vau = new VueAfficherUtilisateurs();
		vau.setVisible(true);
	}
	
	public void afficherListeEvenements () {
		
	}

	public ControleurDonneesUtilisateur getControleurDonneesU() {
		return controleurDonneesU;
	}

	public void setControleurDonneesU(
			ControleurDonneesUtilisateur controleurDonneesU) {
		this.controleurDonneesU = controleurDonneesU;
	}

	public ControleurDonneesEvenement getControleurDonneesE() {
		return controleurDonneesE;
	}

	public void setControleurDonneesE(ControleurDonneesEvenement controleurDonneesE) {
		this.controleurDonneesE = controleurDonneesE;
	}
}
