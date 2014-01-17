package vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;

import modele.Utilisateur;
import controleur.ControleurDonneesUtilisateur;

public class VueAjouterUtilisateur extends JDialog implements ActionListener {
	private static final long serialVersionUID = 15L;
	private final JPanel contentPanel, buttonPane;
	private JTextField textField;
	private JPasswordField champMotDePasse;
	private JPasswordField champMotDePasseBis;
	private JLabel labelNomUtilisateur, labelMotDePasse, labelConfirmationMotDePasse, labelStatut;
	private JComboBox<String> boiteCombinee;
	private JButton boutonOk, boutonAnnuler;
	
	private ControleurDonneesUtilisateur cdu;


	/**
	 * Create the dialog.
	 */
	public VueAjouterUtilisateur(ControleurDonneesUtilisateur _cdc) {
		
		cdu = _cdc;
		
		this.setBounds(100, 100, 450, 185);
		this.getContentPane().setLayout(new BorderLayout());
		
		this.contentPanel = new JPanel();
		this.buttonPane = new JPanel();
		this.labelNomUtilisateur = new JLabel("Nom de l'utilisateur");
		this.textField = new JTextField();
		this.labelMotDePasse = new JLabel("Mot de passe");
		this.labelConfirmationMotDePasse = new JLabel("Confirmation du mot de passe");
		this.labelStatut = new JLabel("Statut");
		this.champMotDePasse = new JPasswordField();
		this.champMotDePasseBis = new JPasswordField();
		this.boiteCombinee = new JComboBox<String>();
		this.boutonOk = new JButton("OK");
		this.boutonAnnuler = new JButton("Annuler");
		
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPanel.setLayout(new GridLayout(0, 2, 0, 0));
		this.textField.setColumns(10);
		this.getRootPane().setDefaultButton(this.boutonOk);
		
		
		this.contentPanel.add(this.labelNomUtilisateur);

		this.boiteCombinee.addItem("Administrateur");
		this.boiteCombinee.addItem("Entraineur");
		this.boiteCombinee.addItem("Utilisateur");
		this.boiteCombinee.setSelectedIndex(0);

		this.contentPanel.add(textField);
		this.contentPanel.add(this.labelMotDePasse);
		this.contentPanel.add(this.champMotDePasse);
		this.contentPanel.add(this.labelConfirmationMotDePasse);
		this.contentPanel.add(this.champMotDePasseBis);
		this.contentPanel.add(this.labelStatut);
		this.contentPanel.add(this.boiteCombinee);
		
		this.buttonPane.add(this.boutonOk);
		this.buttonPane.add(this.boutonAnnuler);
		
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);
		this.buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.getContentPane().add(this.buttonPane, BorderLayout.SOUTH);
		
		this.boutonOk.addActionListener(this);
		this.boutonAnnuler.addActionListener(this);
	}

	public void actionPerformed(ActionEvent _e) {
		if (_e.getSource().equals(this.boutonOk)) {
			if(textField.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Veuillez rentrez un nom d'évènement");
			}
			else{
					if(new String (champMotDePasse.getPassword()).equals("")){
					JOptionPane.showMessageDialog(null, "Veuillez rentrez un mot de passe");
					}
					else{
						if(new String (champMotDePasseBis.getPassword()).equals(new String (champMotDePasse.getPassword())) == false){
						JOptionPane.showMessageDialog(null, "Mot de passe différent");
						}
						else{
							if(boiteCombinee.getSelectedItem().equals("Administrateur")){
								cdu.ajouterUtilisateur(new Utilisateur(textField.getText(), new String (champMotDePasse.getPassword()) , 1));
								this.setVisible(false);
							}
							if(boiteCombinee.getSelectedItem().equals("Entraineur")){
								cdu.ajouterUtilisateur(new Utilisateur(textField.getText(), new String (champMotDePasse.getPassword()) , 2));
								this.setVisible(false);
							}
							if(boiteCombinee.getSelectedItem().equals("Utilisateur")){
								cdu.ajouterUtilisateur(new Utilisateur(textField.getText(), new String (champMotDePasse.getPassword()), 3));
								this.setVisible(false);
							}
						}
					}
			}
		}
		
		else{
			if (_e.getSource().equals(this.boutonAnnuler)) {
			cdu.fermerVueAjouterUtilissateur(this);
			}
		}
		
	}

}
