package vue;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import controleur.ControleurAdministrateur;
import controleur.ControleurConnexion;

public class VueAdministrateur extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton boutonUtilisateurs, boutonEvenements;
	private JMenuBar barreDeMenu;
	private JMenu menuOptions;
	private JMenuItem itemMenuDeconnexion, itemMenuQuitter;
	private JSeparator separateur;
	private ControleurAdministrateur controleurA;
	
	public VueAdministrateur (ControleurAdministrateur _ca) {
		this.setBounds(700, 500, 500, 125);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.controleurA = _ca;
		
		this.boutonUtilisateurs = new JButton("Afficher la liste des utilisateurs");
		this.boutonEvenements = new JButton("Afficher la liste des évènements");
		this.barreDeMenu = new JMenuBar();
		this.menuOptions = new JMenu("Options");
		this.itemMenuDeconnexion = new JMenuItem("Déconnexion");
		this.separateur = new JSeparator();
		this.itemMenuQuitter = new JMenuItem("Quitter");
		
	    this.setJMenuBar(this.barreDeMenu);
	    
	    this.barreDeMenu.add(this.menuOptions);

	    this.menuOptions.add(this.itemMenuDeconnexion);

	    this.menuOptions.add(this.separateur);

	    this.menuOptions.add(this.itemMenuQuitter);

		this.setLayout(new GridLayout (2,1));
		
		this.add(this.boutonUtilisateurs);
		this.add(this.boutonEvenements);
		
		this.boutonUtilisateurs.addActionListener (this);
		this.boutonEvenements.addActionListener (this);
		this.itemMenuDeconnexion.addActionListener (this);
		this.itemMenuQuitter.addActionListener (this);
	}

	public void actionPerformed(ActionEvent _e) {
		if (_e.getSource().equals(this.boutonUtilisateurs)) {
			this.controleurA.afficherListeUtilisateurs();
		}
		
		else if (_e.getSource().equals(this.boutonEvenements)) {
			this.setVisible(false);
			controleurA.afficherListeEvenements();
		}
		
		else if (_e.getSource().equals(this.itemMenuDeconnexion)) {
			this.setVisible(false);
			ControleurConnexion cc = new ControleurConnexion(controleurA.getControleurDonneesU());
		}
		
		else if (_e.getSource().equals(this.itemMenuQuitter)) {
			System.exit (0);
		}
	}
}
