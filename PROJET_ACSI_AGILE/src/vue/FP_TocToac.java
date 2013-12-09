package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JSpinner;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Scrollbar;

import javax.swing.SpinnerListModel;
import java.awt.Choice;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTabbedPane;
import java.awt.Dimension;
import javax.swing.JEditorPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class FP_TocToac {

	JSpinner monSpinner ;
    String [] monTableau = {"Janvier","Fevrier","Mars","Avril","Mai","Juin","Juillet","Aout","Septembre"} ;
    String [] monTableau1 = {"Janvier","Fevrier","Mars","Avril","Mai","Juin","Juillet","Aout","Septembre"} ;
    SpinnerListModel monModel  ;
    
	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FP_TocToac window = new FP_TocToac();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FP_TocToac() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
       
       
		frame = new JFrame();
		frame.setBounds(100, 100, 618, 229);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.WEST);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		Scrollbar scrollbar = new Scrollbar();
		scrollPane.setRowHeaderView(scrollbar);
		
		JLabel lblNewLabel = new JLabel("Liste des entrainements de la semaine");
		scrollPane.setColumnHeaderView(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setBounds(122, 9, 3, 14);
		panel_1.add(lblNewLabel_1);
		
		JButton btnSinscrire = new JButton("S'inscrire");
		btnSinscrire.setBounds(17, 85, 137, 30);
		panel_1.add(btnSinscrire);
		
		 monModel = new SpinnerListModel(monTableau) ;
	       
	       JButton btnNewButton = new JButton("Afficher Participants");
	       btnNewButton.setBounds(164, 85, 153, 30);
	       btnNewButton.addActionListener(new ActionListener() {
	       	public void actionPerformed(ActionEvent e) {
	       	}
	       });
	       

	       panel_1.add(btnNewButton);
	       
	       textField = new JTextField();
	       textField.setBounds(10, 34, 29, 20);
	       panel_1.add(textField);
	       textField.setColumns(10);
	       monSpinner = new JSpinner(monModel) ;
	       monSpinner.setBounds(53, 34, 78, 20);
	       monSpinner.setValue("Janvier") ;
	       panel_1.add(monSpinner) ;
	       
	       Choice choice = new Choice();
	       choice.setBounds(137, 34, 78, 20);
	       panel_1.add(choice);
	       
	       JButton btnOk = new JButton("OK");
	       btnOk.setBounds(228, 33, 89, 23);
	       panel_1.add(btnOk);
	       
	       JMenuBar menuBar = new JMenuBar();
	       frame.setJMenuBar(menuBar);
	       
	       JMenu mnOptions = new JMenu("Options");
	       menuBar.add(mnOptions);
	       
	       JMenuItem mntmDconnexion = new JMenuItem("D\u00E9connexion");
	       mnOptions.add(mntmDconnexion);
	       
	       JSeparator separator = new JSeparator();
	       mnOptions.add(separator);
	       
	       JMenuItem mntmNewMenuItem = new JMenuItem("Quitter");
	       mnOptions.add(mntmNewMenuItem);
	       monSpinner.setVisible(true);
	}
}
