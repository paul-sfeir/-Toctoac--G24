package vue;

import java.awt.*;
import java.awt.event.*;
//import java.io.*;
import javax.swing.*;
import javax.swing.border.*;
import com.toedter.calendar.JCalendar;
//import controleur.*;


public class VueDetailEvenement extends JDialog {
	private static final long serialVersionUID = 6L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VueDetailEvenement dialog = new VueDetailEvenement();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VueDetailEvenement() {
		setBounds(100, 100, 450, 321);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Annuler");
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
				JCalendar calendar = new JCalendar();
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
				
				textField_2 = new JTextField();
				panel_1.add(textField_2);
				textField_2.setColumns(10);
			}
		}
	}
}
