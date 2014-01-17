package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;


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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueAfficherUtilisateurs frame = new VueAfficherUtilisateurs();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructeur<br>
	 * Création de la fenêtre
	 */
	public VueAfficherUtilisateurs() {
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

	@Override
	public void actionPerformed(ActionEvent _e) {
		if (_e.getSource().equals(this.boutonAjouter)) {
			VueAjouterUtilisateur vau = new VueAjouterUtilisateur();
			vau.setVisible(true);
		}
		
		else if (_e.getSource().equals(this.boutonFermer)) {
			this.setVisible(false);
		}
		
	}
}
