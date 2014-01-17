package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;

import modele.Evenement;
import modele.Utilisateur;

import com.toedter.calendar.JCalendar;

import controleur.ControleurDonneesUtilisateur;


/** 
 * Vue pour afficher un utilisateur
 * @author Groupe G24
 */

public class VueAfficherUtilisateurs extends JFrame implements ActionListener {
	private static final long serialVersionUID = 20L;
	private JPanel contentPane, panel;
	private JLabel labelListeDesUtilisateurs;
	private JScrollPane scrollPane;
	private JList<String> list;
	private JButton boutonAjouter, boutonSupprimer, boutonFermer;

	private ControleurDonneesUtilisateur cdc;


	/**
	 * Constructeur<br>
	 * Création de la fenêtre
	 */
	public VueAfficherUtilisateurs(ControleurDonneesUtilisateur _cdc) {
		
		cdc =_cdc;
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		
		this.contentPane = new JPanel();
		this.labelListeDesUtilisateurs = new JLabel("Liste des Utilisateurs");
		this.scrollPane = new JScrollPane();
		this.list = new JList<String>();
		this.panel = new JPanel();
		this.boutonAjouter = new JButton("Ajouter");
		this.boutonSupprimer = new JButton("Supprimer");
		this.boutonFermer = new JButton("Fermer");
		
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(this.contentPane);		
		
		this.scrollPane.setViewportView(list);
		
		this.panel.add(this.boutonAjouter);
		this.panel.add(this.boutonSupprimer);
		this.panel.add(this.boutonFermer);
		
		this.contentPane.add(this.labelListeDesUtilisateurs, BorderLayout.NORTH);
		this.contentPane.add(this.panel, BorderLayout.SOUTH);
		this.contentPane.add(this.scrollPane, BorderLayout.CENTER);
		
		this.boutonAjouter.addActionListener(this);
		this.boutonSupprimer.addActionListener(this);
		this.boutonFermer.addActionListener(this);
	}

	public void majVueAfficher(){
		
		Vector<String> user = new Vector<String>();
		Utilisateur u_inter;
		
		this.list.removeAll();
		
		for(int i=0 ; i < cdc.getListeUtilisateurs().size(); i++){
			u_inter = cdc.getListeUtilisateurs().get(i);
			if(u_inter.getStatutUtilisateur() == Utilisateur.ADMINISTRATEUR)
				user.add("ADMINISTRATEUR " + u_inter.getNomUtilisateur());
			if(u_inter.getStatutUtilisateur() == Utilisateur.ENTRAINEUR)
				user.add("ENTRAINEUR " + u_inter.getNomUtilisateur());
			if(u_inter.getStatutUtilisateur() == Utilisateur.UTILISATEUR_LAMBDA)
				user.add("UTILISATEUR " + u_inter.getNomUtilisateur());
		}
		
		list.setListData(user);
		this.list.setSelectedIndex(-1);
	}
	
	
	public JList<String> getList() {
		return list;
	}

	@Override
	public void actionPerformed(ActionEvent _e) {
		if (_e.getSource().equals(this.boutonAjouter)) {
			cdc.ouvrirFenetreAjouterUtilisateur(this);
		}
		
		else if (_e.getSource().equals(this.boutonSupprimer)) {
			cdc.supprimerUtilisateur(this, list.getSelectedIndex());
		}
		
		else if (_e.getSource().equals(this.boutonFermer)) {
			this.setVisible(false);
		}
		
	}
}
