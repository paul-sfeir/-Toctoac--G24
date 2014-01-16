package controleur;

import java.util.Date;
import java.util.Vector;

import modele.Evenement;

/**
 * Controleur des données Evenement
 * author Groupe 24
 */
public class ControleurDonneesEvenement {
	private Vector<Evenement> listeEvenements;
	
	/**
	 * Controleur<br>
	 * initialise un événement 
	 */
	public ControleurDonneesEvenement() {
		this.listeEvenements = new Vector<Evenement>();
		
		this.listeEvenements.add(new Evenement(0, "Event0", new Date(), "lieu0", true));
		this.listeEvenements.add(new Evenement(1, "Event1", new Date(), "lieu1", false));
	}
	
	/**
	 * Permet de récupérer un la liste des evenements
	 * @return Evenement
	 */
	public Vector<Evenement> getListeEvenements() {
		return listeEvenements;
	}
	
	/**
	 * Permet de récupérer un événéments
	 * @param _ne
	 * @return Evenement
	 */
	public Evenement getEvenement(String _ne) {
		int i = 0;
		Evenement event = null;
		
		while (i < this.listeEvenements.size() && event == null) {
			if (this.listeEvenements.get(i).getNomEvenement().equals(_ne))
				event = this.listeEvenements.get(i);
			i++;
		}
		
		return event;
	}
	
	/**
	 * Permet de d'initialiser la liste des evenements
	 * @param _listeEvenement
	 * @return void
	 */
	public void setListeEvenements(Vector<Evenement> _listeEvenement) {
		this.listeEvenements = _listeEvenement;
	}
}
