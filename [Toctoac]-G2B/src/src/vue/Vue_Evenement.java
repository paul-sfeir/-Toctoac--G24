package vue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import com.toedter.calendar.JCalendar;

import controleur.ControleurEvenement;

import javax.swing.JLayeredPane;

import java.util.Calendar;
import java.util.Vector;

import javax.swing.border.TitledBorder;

import modele.Evenement;
import modele.Utilisateur;

public class Vue_Evenement extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3218801234799617340L;
	private JCalendar c;
	//private JFrame frame;
	private ControleurEvenement lambda;
	private Vector<Evenement> evenement;
	private Utilisateur user;
	
	public Vector<Evenement> getEvenement() {
		return evenement;
	}

	public void setEvenement(Vector<Evenement> evenement) {
		this.evenement = evenement;
	}

	public ControleurEvenement getLambda() {
		return lambda;
	}

	private JList<String> list;
	public JList<String> getList() {
		return list;
	}
	
	private JButton btnOk;
	private JButton btnSinscrire;
	private JButton btnNewButton;
	private JButton btnDtailDesvnements;
	private JButton btnDesinscrire;
	
	private JButton bAjouter;
	private JButton bSupprimer;
	
	public JButton getbAjouter() {
		return bAjouter;
	}

	public JButton getbSupprimer() {
		return bSupprimer;
	}

	public JCalendar getC() {
		return c;
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public JButton getBtnSinscrire() {
		return btnSinscrire;
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public JButton getBtnDtailDesvnements() {
		return btnDtailDesvnements;
	}

	
	/**
	 * Create the application.
	 */
	public Vue_Evenement(ControleurEvenement _lambda){
		initialize(_lambda);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ControleurEvenement _lambda) {
       lambda = _lambda;
 
		this.setBounds(100, 100, 635, 376);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_1 = new JPanel();
		this.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setBounds(122, 9, 3, 14);
		panel_1.add(lblNewLabel_1);
	       
	       JLayeredPane layeredPane = new JLayeredPane();
	       layeredPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	       layeredPane.setBounds(10, 9, 598, 297);
	       panel_1.add(layeredPane);
	       
	       btnOk = new JButton("OK");
	       btnOk.setBounds(415, 215, 108, 23);
	       layeredPane.add(btnOk);
	       
	       /** Faire les tests utilisateurs pour voir si c'est un entraineur
	        * 
	       **/
	       
	       bAjouter = new JButton("Ajouter Evenement");
	       bAjouter.setBounds(15, 250, 145, 27);
	       layeredPane.add(bAjouter);
	       
	       bSupprimer = new JButton("Supprimer Evenement");
	       bSupprimer.setBounds(165, 250, 160, 27);
	       layeredPane.add(bSupprimer);	       
	       
	       /**
	        * 
	        * Fin des boutons spéciaux
	        */
	       
	       c = new JCalendar ();
	       c.setBounds(365, 31, 200, 200);
	       layeredPane.add(c);
	       
	       list = new JList<String>();
	       list.setBounds(10, 51, 323, 155);
	       layeredPane.add(list);
	       
	       JLabel lblNewLabel = new JLabel("Liste des événements de la semaine");
	       lblNewLabel.setBounds(10, 31, 256, 14);
	       layeredPane.add(lblNewLabel);
	       
	       btnSinscrire = new JButton("S'inscrire");
	       btnSinscrire.setBounds(350, 248, 100, 27);
	       layeredPane.add(btnSinscrire);
	       
	       btnDesinscrire = new JButton("Se désinscrire");
	       btnDesinscrire.setBounds(460, 248, 125, 27);
	       layeredPane.add(btnDesinscrire);
	       
	       btnDtailDesvnements = new JButton("D\u00E9tail des \u00E9v\u00E9nements");
	       btnDtailDesvnements.setBounds(164, 215, 169, 27);
	       layeredPane.add(btnDtailDesvnements);
	       
	
	       
	       btnNewButton = new JButton("Afficher Participants");
	       btnNewButton.setBounds(10, 215, 153, 27);
	       layeredPane.add(btnNewButton);
	       btnNewButton.addActionListener(new ActionListener() {
	       	public void actionPerformed(ActionEvent e) {
	       	}
	       });
	       c.setVisible(true);
	       
	       JMenuBar menuBar = new JMenuBar();
	       this.setJMenuBar(menuBar);
	       
	       JMenu mnOptions = new JMenu("Options");
	       menuBar.add(mnOptions);
	       
	       JMenuItem mntmDconnexion = new JMenuItem("D\u00E9connexion");
	       mnOptions.add(mntmDconnexion);
	       
	       JSeparator separator = new JSeparator();
	       mnOptions.add(separator);
	       
	       JMenuItem mntmNewMenuItem = new JMenuItem("Quitter");
	       mnOptions.add(mntmNewMenuItem);
	       
	       btnDtailDesvnements.addActionListener(new ListenerEvenement(this));
	       btnNewButton.addActionListener(new ListenerEvenement(this));
	       btnOk.addActionListener(new ListenerEvenement(this));
	       btnSinscrire.addActionListener(new ListenerEvenement(this));
	       bAjouter.addActionListener(new ListenerEvenement(this));
	       bSupprimer.addActionListener(new ListenerEvenement(this));
	       btnDesinscrire.addActionListener(new ListenerEvenement(this));
	       /*
	       if(user.getStatutUtilisateur() == 1){
	    	   btnSinscrire.setVisible(false);
	    	   btnDesinscrire.setVisible(false);
	       }
	       if(user.getStatutUtilisateur() == 2){
	    	   btnSinscrire.setVisible(false);
	    	   btnDesinscrire.setVisible(false);
	       }
	       if(user.getStatutUtilisateur() == 3){
	    	   btnDtailDesvnements.setVisible(false);
	       }*/
	       
	}
	
	public void majVue_Evenement (){
		Vector<String> evnmt;
		evnmt = new Vector<String>();
		Evenement ev;
		JCalendar cal;
		
		cal = new JCalendar();
		
		evenement = new Vector<Evenement>();
		
		this.list.removeAll();
		
		for (int i =0; i<this.lambda.getNbEvenement(); i++)
		{
			ev = this.lambda.getEvenementAt(i);
			cal.setDate(ev.getDateEvenement());
			
			if(ev.isEstRegulier() == true){
				evnmt.add((ev.getNomEvenement() + "  "+ ev.getLieuEvenement() +"  "+ev.getDateEvenement()).substring(0, (ev.getNomEvenement() + "  "+ ev.getLieuEvenement() +"  "+ev.getDateEvenement()).length()-25));
				evenement.add(ev);
			}
			else{
				if(cal.getCalendar().get(Calendar.WEEK_OF_YEAR) == this.c.getCalendar().get(Calendar.WEEK_OF_YEAR) && cal.getCalendar().get(Calendar.YEAR) == this.c.getCalendar().get(Calendar.YEAR)){ //Si la date est ok.
					evnmt.add((ev.getNomEvenement() + "  "+ ev.getLieuEvenement() +"  "+ev.getDateEvenement()).substring(0, (ev.getNomEvenement() + "  "+ ev.getLieuEvenement() +"  "+ev.getDateEvenement()).length()-25));
					evenement.add(ev);
				}
			}
		}
		
		this.list.setListData(evnmt);
		this.list.setSelectedIndex(-1);
	}
}
