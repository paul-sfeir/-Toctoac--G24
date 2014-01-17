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

import controleur.ControleurEvenement;
import modele.Evenement;

import com.toedter.calendar.JCalendar;

import javax.swing.JLayeredPane;

import java.util.Calendar;
import java.util.Vector;

import javax.swing.border.TitledBorder;
/** 
 * Vue pour les evenements
 * @author Groupe 24
 */
public class Vue_Evenement extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 50L;
	private JCalendar c;
	//private JFrame frame;
	private ControleurEvenement lambda;
	private JList<String> list;
	private JButton btnOk;
	private JButton btnSinscrire;
	private JButton btnNewButton;
	private JButton btnDtailDesvnements;
	
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
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vue_TocToac_Lambda window = new Vue_TocToac_Lambda();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Constructeur<br>
	 * Initialise et lance l'application
	 * @param _lambda
	 */
	public Vue_Evenement(ControleurEvenement _lambda){
		initialize(_lambda);
	}

	/**
	 * Initialise le contenue de la fenêtre.
	 * @param _lambda
	 * @return void
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
	       btnOk.setBounds(415, 237, 108, 23);
	       layeredPane.add(btnOk);
	       
	       c = new JCalendar ();
	       c.setBounds(365, 31, 200, 200);
	       layeredPane.add(c);
	       
	       list = new JList<String>();
	       list.setBounds(10, 51, 323, 155);
	       layeredPane.add(list);
	       
	       JLabel lblNewLabel = new JLabel("Liste des �v�nements de la semaine");
	       lblNewLabel.setBounds(10, 31, 256, 14);
	       layeredPane.add(lblNewLabel);
	       
	       btnSinscrire = new JButton("S'inscrire");
	       btnSinscrire.setBounds(98, 248, 137, 27);
	       layeredPane.add(btnSinscrire);
	       
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
	       
	       btnDtailDesvnements.addActionListener(new ListenerLambda(this));
	       btnNewButton.addActionListener(new ListenerLambda(this));
	       btnOk.addActionListener(new ListenerLambda(this));
	       btnSinscrire.addActionListener(new ListenerLambda(this));
	       
	}
	
	
	/**
	 * Rafraichissement de la fenêtre
	 * @return void
	 */
	public void majVue_TocToac_Lambda (){
		Vector<String> evnmt;
		evnmt = new Vector<String>();
		Evenement ev;
		JCalendar cal;
		
		cal = new JCalendar();
		
		this.list.removeAll();
		
		for (int i =0; i<this.lambda.getNbEvenement(); i++)
		{
			ev = this.lambda.getEvenementAt(i);
			cal.setDate(ev.getDateEvenement());

			if(cal.getCalendar().get(Calendar.WEEK_OF_YEAR) == this.c.getCalendar().get(Calendar.WEEK_OF_YEAR) && cal.getCalendar().get(Calendar.YEAR) == this.c.getCalendar().get(Calendar.YEAR)){ //Si la date est ok.
				evnmt.add(ev.getNomEvenement() + "  "+ ev.getLieuEvenement() +"  "+ev.getDateEvenement());
			}
		}
		
		this.list.setListData(evnmt);
		this.list.setSelectedIndex(-1);
	}
}
