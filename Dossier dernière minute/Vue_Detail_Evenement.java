package vue;

import java.awt.BorderLayout;

import Controleur.ControleurEvenement;

import com.toedter.calendar.JCalendar;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.GridLayout;

import javax.swing.JLayeredPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import modele.Evenement;

import java.awt.Color;
import java.util.Vector;

public class Vue_Detail_Evenement extends JDialog {
	private JTextField textField;
	public JTextField getTextField() {
		return textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public ControleurEvenement getCe() {
		return ce;
	}

	private JTextField textField_1;
	private JLabel nbPart;
	private ControleurEvenement ce;
	private boolean Ajouter;
	private JCalendar calendar;
	public JCalendar getCalendar() {
		return calendar;
	}

	private JButton cancelButton;
	private JButton	okButton;
	private Evenement e;

	public void setE(Evenement e) {
		this.e = e;
	}

	public Evenement getE() {
		return e;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JButton getOkButton() {
		return okButton;
	}

	/**
	 * Launch the application.
	 */
	
	public boolean isAjouter() {
		return Ajouter;
	}

	/**
	 * Create the dialog.
	 */
	public Vue_Detail_Evenement(ControleurEvenement _ce, Evenement _e) {
		
		ce = _ce;
		e = _e;
		Ajouter= true; // On l'initialise à true car on part du principe que c'est un ajout et on change le booléen si ce n'est pas le cas.
		
		setBounds(100, 100, 450, 321);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Annuler");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				cancelButton.setActionCommand("Annuler");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panel_1 = new JPanel();
			getContentPane().add(panel_1, BorderLayout.NORTH);
			panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
			panel_1.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JLabel label = new JLabel("Nom Ev\u00E9nement");
				panel_1.add(label);
			}
			{
				textField = new JTextField();
				textField.setColumns(10);
				panel_1.add(textField);
			}
			{
				JLabel label = new JLabel("Lieux Ev\u00E9nement");
				panel_1.add(label);
			}
			{
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				panel_1.add(textField_1);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel label = new JLabel("Date Ev\u00E9nement");
				label.setBounds(10, 11, 102, 14);
				panel.add(label);
			}
			{
				calendar = new JCalendar();
				calendar.setBounds(163, 11, 205, 153);
				panel.add(calendar);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(0, 175, 424, 20);
				panel.add(panel_1);
				panel_1.setLayout(new GridLayout(0, 2, 0, 0));
				
				JLabel lblNombreDeParticipants = new JLabel("  Nombre de participants");
				panel_1.add(lblNombreDeParticipants);
				
				nbPart = new JLabel();
				nbPart.setText("0");
				panel_1.add(nbPart);
				
				okButton.addActionListener(new ListenerDetailEvenement(this));
				cancelButton.addActionListener(new ListenerDetailEvenement(this));
				
				if(_e.getIdEvenement() != -1){ //Si on modifie un évènement
					Ajouter = false; // on est en modification d'evenement
					textField.setText(e.getNomEvenement());
					textField_1.setText(e.getLieuEvenement());
					calendar.setDate(e.getDateEvenement());
				}
				
			}
		}
	}	
	
	public void majVue_Detail_Evenement(){
		
	}
	
}
