package vue;

import java.awt.*;
import java.awt.event.*;
//import java.awt.event.*;
//import java.io.*;
import javax.swing.*;
//import javax.swing.border.*;
//import com.toedter.calendar.JCalendar;
import controleur.*;
/**  
 * Vue pour la connexion
 * @author Groupe 24
 */
public class VueConnexion extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private ControleurConnexion controleurC;
	private JPanel panelIdUtilisateur, panelMotDePasseUtilisateur;
	private JButton boutonValider;
	private JTextField champIdUtilisateur;
	private JPasswordField champMotDePasseUtilisateur;
	private JLabel labelIdUtilisateur, labelMotDePasseUtilisateur, labelSaisie;
	
	/**
	 * Constructeur<br>
	 * Création de la vue connexion.
	 */
	public VueConnexion(ControleurConnexion _cc) {
		this.setBounds(700, 500, 500, 125);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.controleurC = _cc;
		
		this.panelIdUtilisateur = new JPanel();
		this.panelMotDePasseUtilisateur = new JPanel();
		this.labelSaisie = new JLabel("Veuillez entrer votre identifiant et votre mot de passe :");
		this.labelIdUtilisateur = new JLabel("Identifiant");
		this.labelMotDePasseUtilisateur = new JLabel("Mot de passe : ");
		this.champIdUtilisateur = new JTextField();
		this.champMotDePasseUtilisateur = new JPasswordField();
		this.boutonValider = new JButton("Valider");
		
		this.labelSaisie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		this.champIdUtilisateur.setColumns(10);
		this.champMotDePasseUtilisateur.setColumns(10);
		
		this.panelIdUtilisateur.add(this.labelIdUtilisateur);
		this.panelIdUtilisateur.add(this.champIdUtilisateur);
		this.panelMotDePasseUtilisateur.add(this.labelMotDePasseUtilisateur);
		this.panelMotDePasseUtilisateur.add(champMotDePasseUtilisateur);
		
		this.add(this.labelSaisie, BorderLayout.NORTH);
		this.add(panelIdUtilisateur, BorderLayout.WEST);
		this.add(this.panelMotDePasseUtilisateur, BorderLayout.EAST);
		this.add(this.boutonValider, BorderLayout.SOUTH);
		
		this.boutonValider.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent _e) {
		if (_e.getSource().equals(this.boutonValider)) {
			this.controleurC.controleurValiderIdentifiant(this);
		}		
	}

	public ControleurConnexion getControleurC() {
		return controleurC;
	}

	public void setControleurC(ControleurConnexion controleurC) {
		this.controleurC = controleurC;
	}

	public JPanel getPanelIdUtilisateur() {
		return panelIdUtilisateur;
	}

	public void setPanelIdUtilisateur(JPanel panelIdUtilisateur) {
		this.panelIdUtilisateur = panelIdUtilisateur;
	}

	public JPanel getPanelMotDePasseUtilisateur() {
		return panelMotDePasseUtilisateur;
	}

	public void setPanelMotDePasseUtilisateur(JPanel panelMotDePasseUtilisateur) {
		this.panelMotDePasseUtilisateur = panelMotDePasseUtilisateur;
	}

	public JButton getBoutonValider() {
		return boutonValider;
	}

	public void setBoutonValider(JButton boutonValider) {
		this.boutonValider = boutonValider;
	}

	public JTextField getChampIdUtilisateur() {
		return champIdUtilisateur;
	}

	public void setChampIdUtilisateur(JTextField champIdUtilisateur) {
		this.champIdUtilisateur = champIdUtilisateur;
	}

	public JPasswordField getChampMotDePasseUtilisateur() {
		return champMotDePasseUtilisateur;
	}

	public void setChampMotDePasseUtilisateur(
			JPasswordField champMotDePasseUtilisateur) {
		this.champMotDePasseUtilisateur = champMotDePasseUtilisateur;
	}

	public JLabel getLabelIdUtilisateur() {
		return labelIdUtilisateur;
	}

	public void setLabelIdUtilisateur(JLabel labelIdUtilisateur) {
		this.labelIdUtilisateur = labelIdUtilisateur;
	}

	public JLabel getLabelMotDePasseUtilisateur() {
		return labelMotDePasseUtilisateur;
	}

	public void setLabelMotDePasseUtilisateur(JLabel labelMotDePasseUtilisateur) {
		this.labelMotDePasseUtilisateur = labelMotDePasseUtilisateur;
	}

	public JLabel getLabelSaisie() {
		return labelSaisie;
	}

	public void setLabelSaisie(JLabel labelSaisie) {
		this.labelSaisie = labelSaisie;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
