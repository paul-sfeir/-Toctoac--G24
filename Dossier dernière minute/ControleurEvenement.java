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

public class ControleurEvenement {
	private Vue_Evenement lambda;
	private Vector<Evenement> listeEvent;
	
	public ControleurEvenement() {
		
		listeEvent = new Vector<Evenement>();
		
		//this.enregistrerEvenementsFichier(); Rmet le fichier à 0;
		this.chargerEvenementFichier();
		
		/*
		// Pour tester 
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(2014, 0, 16); //0 pour janvier, 11 décembre
		Date dt = cal.getTime();
		this.listeEvent.add( new Evenement(1, "Evenement 1", dt, "Toulouse"));
		
		cal.set(2014, 0, 16); //0 pour janvier, 11 décembre
		dt = cal.getTime();
		this.listeEvent.add( new Evenement(2, "Evenement 2", dt, "Paris"));
		
		cal.set(2014, 0, 16); //0 pour janvier, 11 décembre
		dt = cal.getTime();
		this.listeEvent.add( new Evenement(3, "Evenement 3", dt, "Bordeaux"));
		
		// Ne sert que pour tester le fichier
		enregistrerEvenementsFichier();
		*/
	}
	
	public void demarrerControleurEvenement() {
		if (this.lambda == null)
		{
			this.lambda = new Vue_Evenement(this);
			this.lambda.majVue_TocToac_Lambda();
			this.lambda.setResizable(false); //pas de repositionnement
			this.lambda.setLocationRelativeTo(null); //fenetre centrée
			this.lambda.setVisible (true);
		}
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
