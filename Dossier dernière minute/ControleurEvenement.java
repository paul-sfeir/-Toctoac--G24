package Controleur;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import Modele.Evenement;
import vue.Vue_Evenement;

/**
 * Contoleur pour la gestion des evenements
 * @author Groupe 24
 */
public class ControleurEvenement {
	private Vue_Evenement lambda;
	private Vector<Evenement> listeEvent;
	
	/**
	 * Constructeur <br>
	 * Créer une liste et y ajoute les evenements  
	 */
	public ControleurEvenement() {
		
		listeEvent = new Vector<Evenement>();
		
		//this.enregistrerEvenementsFichier(); Rmet le fichier � 0;
		this.chargerEvenementFichier();
		
		/*
		// Pour tester 
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(2014, 0, 16); //0 pour janvier, 11 d�cembre
		Date dt = cal.getTime();
		this.listeEvent.add( new Evenement(1, "Evenement 1", dt, "Toulouse"));
		
		cal.set(2014, 0, 16); //0 pour janvier, 11 d�cembre
		dt = cal.getTime();
		this.listeEvent.add( new Evenement(2, "Evenement 2", dt, "Paris"));
		
		cal.set(2014, 0, 16); //0 pour janvier, 11 d�cembre
		dt = cal.getTime();
		this.listeEvent.add( new Evenement(3, "Evenement 3", dt, "Bordeaux"));
		
		// Ne sert que pour tester le fichier
		enregistrerEvenementsFichier();
		*/
	}
	
	/**
	 * Démarre la vue responsable des evenements<br>
	 * @return void
	 */
	public void demarrerControleurEvenement() {
		if (this.lambda == null)
		{
			this.lambda = new Vue_Evenement(this);
			this.lambda.majVue_TocToac_Lambda();
			this.lambda.setResizable(false); //pas de repositionnement
			this.lambda.setLocationRelativeTo(null); //fenetre centr�e
			this.lambda.setVisible (true);
		}
	}
	
	/**
	 * Permet de connaitre le nombre d'evenments dans le calendrier (passé, actuel ou futur.<br>
	 * @return int Nombre d'évenement
	 */
	public int getNbEvenement() {
		return this.listeEvent.size();
	}
	
	/**
	 * Permet de récupérer un evenement en fonction de son rang.
	 * @param _i 	Rang de l'evenement (stocké dans un vector)
	 * @return Evenement
	 */
	public Evenement getEvenementAt(int _i){
		return this.listeEvent.elementAt(_i);
	}
	
	/**
	 *Enregistre les Evenements dans un fichier event.ser.<BR>
	 *@return void
	 */
	public void enregistrerEvenementsFichier(){
		
		File fic = new File("event.ser");
		fic.delete();
		try {
			fic.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
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
	
	/**
	 *Charger des Evenements en provenance d'un fichier event.ser.<BR>
	 *@return void
	 */
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
	
	
}
