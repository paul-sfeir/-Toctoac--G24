package controleur;

import java.util.Date;
import java.util.Vector;

import modele.Evenement;

public class ControleurDonneesEvenement {
	private Vector<Evenement> listeEvenements;
	
	public ControleurDonneesEvenement() {
		this.listeEvenements = new Vector<Evenement>();
		
		this.listeEvenements.add(new Evenement(0, "Event0", new Date(), "lieu0", true));
		this.listeEvenements.add(new Evenement(1, "Event1", new Date(), "lieu1", false));
	}

	public Vector<Evenement> getListeEvenements() {
		return listeEvenements;
	}
	
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

	public void setListeEvenements(Vector<Evenement> _listeEvenement) {
		this.listeEvenements = _listeEvenement;
	}
}
