package controleur;

import modele.*;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

import javax.swing.JOptionPane;

import vue.VueAfficherUtilisateurs;
import vue.VueAjouterUtilisateur;

public class ControleurDonneesUtilisateur {
	private Vector<Utilisateur> listeUtilisateurs;
	private VueAfficherUtilisateurs vau;
	private VueAjouterUtilisateur vajout;
	
	public ControleurDonneesUtilisateur() {
		
		this.listeUtilisateurs = new Vector<Utilisateur>();
		chargerUtilisateur();
		/*
		//Pour remplir la base
		
		
		this.listeUtilisateurs.add(new Utilisateur("admin", "a", Utilisateur.ADMINISTRATEUR));
		this.listeUtilisateurs.add(new Utilisateur("entraineur", "a", Utilisateur.ENTRAINEUR));
		this.listeUtilisateurs.add(new Utilisateur("user", "a", Utilisateur.UTILISATEUR_LAMBDA));
		
		enregistrerUtilisateur();
		*/
		
	}

	public void ajouterUtilisateur(Utilisateur _u){
		listeUtilisateurs.add(_u);
		vau.majVueAfficher();
		
		enregistrerUtilisateur();
		
	}

	public void supprimerUtilisateur(VueAfficherUtilisateurs _vau, int _i){
		
		int rep = JOptionPane.showConfirmDialog(_vau, "Etes-vous sur de vouloir supprimer l'évènement?","Supprimer",JOptionPane.YES_NO_OPTION);
		if(rep == JOptionPane.YES_OPTION){
			listeUtilisateurs.remove(_i);
			enregistrerUtilisateur();
			_vau.majVueAfficher();
			
		}
			
	}
	
	public void ouvrirFenetreAjouterUtilisateur(VueAfficherUtilisateurs _v){
		vau = _v;
		vajout = new VueAjouterUtilisateur(this);
		vajout.setLocationRelativeTo(_v);
		vajout.setVisible(true);
	}
	
	
	public void fermerVueAjouterUtilissateur(VueAjouterUtilisateur _v) {
		_v.setVisible(false);
		_v =null;
	}
	
	public void chargerUtilisateur(){
		File fic = new File("utilisateur.ser");
		Utilisateur read;
		
		try {
			FileInputStream fichier = new FileInputStream(fic);
			ObjectInputStream ois = new ObjectInputStream(fichier);
			
			try {
				read = (Utilisateur) (ois.readObject());
				while( read != null){
					listeUtilisateurs.add(read);
					read = null;
					try{
					read = (Utilisateur) (ois.readObject());
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
	
	public void enregistrerUtilisateur () {
		File fic = new File("utilisateur.ser");
		fic.delete();
		try {
			
			fic.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
			
		}
			try {
			FileOutputStream stream = new FileOutputStream(fic);
			ObjectOutputStream oos = new ObjectOutputStream(stream);
			
			for(int i = 0; i< listeUtilisateurs.size(); i++){
			oos.writeObject(listeUtilisateurs.get(i));
			oos.flush();
			}
			oos.close();
			}
			catch (java.io.IOException e) {
				e.printStackTrace();
			}
	}
	
	public Vector<Utilisateur> getListeUtilisateurs() {
		return listeUtilisateurs;
	}
	
	public Utilisateur getUtilisateur (String _nu) {
		int i = 0;
		Utilisateur user = null;
		
		while (i < this.listeUtilisateurs.size() && user == null) {
			if (this.listeUtilisateurs.get(i).getNomUtilisateur().equals(_nu))
				user = this.listeUtilisateurs.get(i);
			i++;
		}
		
		return user;
	}

	public void setListeUtilisateurs(Vector<Utilisateur> listeUtilisateurs) {
		this.listeUtilisateurs = listeUtilisateurs;
	}
}
