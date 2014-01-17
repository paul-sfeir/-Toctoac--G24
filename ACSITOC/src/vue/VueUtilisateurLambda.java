package vue;

import java.awt.*;
//import java.awt.event.*;
//import java.io.*;
import javax.swing.*;
import javax.swing.border.*;
import com.toedter.calendar.JCalendar;
//import controleur.*;

public class VueUtilisateurLambda extends JFrame {
	private static final long serialVersionUID = 2L;
	private JCalendar c;
	private JPanel panel_1;

	public VueUtilisateurLambda() {
		this.setBounds(100, 100, 635, 376);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel_1 = new JPanel();
		this.getContentPane().add(panel_1, BorderLayout.CENTER);
		this.panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setBounds(122, 9, 3, 14);
		this.panel_1.add(lblNewLabel_1);
	       
       JLayeredPane layeredPane = new JLayeredPane();
       layeredPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
       layeredPane.setBounds(10, 9, 598, 297);
       this.panel_1.add(layeredPane);
       
       JButton btnOk = new JButton("OK");
       btnOk.setBounds(415, 237, 108, 23);
       layeredPane.add(btnOk);
       
       c = new JCalendar ();
       c.setBounds(365, 31, 200, 200);
       layeredPane.add(c);
       
       JList<String> list = new JList<String>();
       list.setBounds(10, 51, 323, 155);
       layeredPane.add(list);
       
       JLabel lblNewLabel = new JLabel("Liste des événements de la semaine");
       lblNewLabel.setBounds(10, 31, 256, 14);
       layeredPane.add(lblNewLabel);
       
       JButton btnSinscrire = new JButton("S'inscrire");
       btnSinscrire.setBounds(98, 248, 137, 27);
       layeredPane.add(btnSinscrire);
       
       JButton btnDtailDesvnements = new JButton("D\u00E9tail des \u00E9v\u00E9nements");
       btnDtailDesvnements.setBounds(164, 215, 169, 27);
       layeredPane.add(btnDtailDesvnements);
       

       
       JButton btnNewButton = new JButton("Afficher Participants");
       btnNewButton.setBounds(10, 215, 153, 27);
       layeredPane.add(btnNewButton);
       
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
	}
}
