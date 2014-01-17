package controleur;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;

import modele.Evenement;
import vue.Vue_Detail_Evenement;
import vue.Vue_Evenement;

public class ControleurEvenement {
	private Vue_Evenement vEvent;
	private Vue_Detail_Evenement det;
	private Vector<Evenement> listeEvent;
	private static int identifiant = 0;
	private ControleurDonneesUtilisateur cdu;
	
	public static int getIdentifiant() {
		return identifiant;
	}

	public static void setIdentifiant(int identifiant) {
		ControleurEvenement.identifiant = identifiant;
	}

	public ControleurEvenement() {
		
		listeEvent = new Vector<Evenement>();
		
		//this.enregistrerEvenementsFichier(); Remet le fichier à 0;
		this.chargerEvenementFichier();
		identifiant = listeEvent.get(listeEvent.size()-1).getIdEvenement() + 1; //on récupère l'id du dernier evenement et on lui ajoute 1 comme ça on est sur de ne jamais avoir deux id identiques.
		
		/*
		// Pour tester 
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(cal.getTime());
		
		Date dt = cal.getTime();
		this.listeEvent.add( new Evenement(1, "Evenement 1", dt, "Toulouse", false));
		
		dt = cal.getTime();
		this.listeEvent.add( new Evenement(2, "Evenement 2", dt, "Paris", false));
		
		dt = cal.getTime();
		this.listeEvent.add( new Evenement(3, "Evenement 3", dt, "Bordeaux", true));
		
		// Ne sert que pour tester le fichier
		enregistrerEvenementsFichier();
		*/
	}
	
	public void demarrerControleurEvenement() {
		if (this.vEvent == null)
		{
			this.vEvent = new Vue_Evenement(this);
			this.vEvent.majVue_Evenement();
			this.vEvent.setResizable(false); //pas de repositionnement
			this.vEvent.setLocationRelativeTo(null); //fenetre centrée
			this.vEvent.setVisible (true);
			
		}
	}
	
	public void ajouterEvenement(Evenement _e){
		listeEvent.add(_e);
		identifiant ++; // on augmente l'identifiant d'un.
		vEvent.majVue_Evenement();
		fermerDetailEvenement();
		enregistrerEvenementsFichier();
	}
	
	public void modifierEvenement(Evenement _e){
		int i = 0;
		boolean trouve = false;
		
		while(trouve == false){
			if(listeEvent.get(i).getIdEvenement() == _e.getIdEvenement()){
				listeEvent.set(i, _e);
				trouve = true;
			}
			i++;
		}
		vEvent.majVue_Evenement();
		fermerDetailEvenement();
	}
	
	public int getNbEvenement() {
		return this.listeEvent.size();
	}
	
	public Evenement getEvenementAt(int _i){
		return this.listeEvent.elementAt(_i);
	}
	
	public void enregistrerEvenementsFichier(){
		
		File fic = new File("event.ser");
		fic.delete();
		try {
			
			fic.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
			
		}
			try {
			FileOutputStream stream = new FileOutputStream(fic);
			ObjectOutputStream oos = new ObjectOutputStream(stream);
			
			for(int i = 0; i< listeEvent.size(); i++){
			oos.writeObject(listeEvent.get(i));
			oos.flush();
			}
			oos.close();
			}
			catch (java.io.IOException e) {
				e.printStackTrace();
			}	
	}
	
	public void chargerEvenementFichier(){
		File fic = new File("event.ser");
		Evenement read;
		
		try {
			FileInputStream fichier = new FileInputStream(fic);
			ObjectInputStream ois = new ObjectInputStream(fichier);
			
			try {
				read = (Evenement) (ois.readObject());
				while( read != null){
					listeEvent.add(read);
					read = null;
					try{
					read = (Evenement) (ois.readObject());
					}
					catch (EOFException e1){
					}
				}
			} catch (ClassNotFoundException e2) {
			}
			
			ois.close();
			}
			catch (java.io.IOException e) {
			}
	}
	
	public void supprimerEvenement(Evenement _ev){
		int i = 0;
		boolean trouve = false;
		
		int rep = JOptionPane.showConfirmDialog(vEvent, "Etes-vous sur de vouloir supprimer l'évènement?","Supprimer",JOptionPane.YES_NO_OPTION);
		if(rep == JOptionPane.YES_OPTION){
			while(trouve == false){
				if(listeEvent.get(i).getIdEvenement() == _ev.getIdEvenement()){
					listeEvent.remove(i);
					trouve = true;
					vEvent.majVue_Evenement();
				}
				i++;
			}
			enregistrerEvenementsFichier();
		}
	}
	
	public void ajouterEvenement (){
		this.det = new Vue_Detail_Evenement(this, new Evenement(-1, "", new Date(), "", true));
		this.det.setResizable(false); //pas de repositionnement
		this.det.setLocationRelativeTo(vEvent); //fenetre centrée
		this.det.setModal(true);
		this.det.setVisible (true);
	}
	
	public void detailEvenement (Evenement _e){
		this.det = new Vue_Detail_Evenement(this, _e);
		this.det.setResizable(false); //pas de repositionnement
		this.det.setLocationRelativeTo(vEvent); //fenetre centrée
		this.det.setModal(true);
		this.det.setVisible (true);
	}
	
	public void fermerDetailEvenement () {
			det.setVisible(false);
			det = null;
	}
}
