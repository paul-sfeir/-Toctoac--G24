package vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
/** 
 * Vue pout ajouter un utilisateur
 * @author Groupe G24
 */
public class VueAjouterUtilisateur extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;


	public static void main(String[] args) {
		try {
			VueAjouterUtilisateur dialog = new VueAjouterUtilisateur();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Constructeur
	 * Création de la vue Utilisateur
	 */
	public VueAjouterUtilisateur() {
		setBounds(100, 100, 450, 185);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 0));
		{
			JLabel lblNewLabel = new JLabel("Nom de L'utilisateur");
			contentPanel.add(lblNewLabel);
		}
		{
			textField = new JTextField();
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Mot de passe");
			contentPanel.add(lblNewLabel_1);
		}
		{
			passwordField = new JPasswordField();
			contentPanel.add(passwordField);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Confirmation du mot de passe");
			contentPanel.add(lblNewLabel_2);
		}
		{
			passwordField_1 = new JPasswordField();
			contentPanel.add(passwordField_1);
		}
		{
			JLabel lblS = new JLabel("Statut");
			contentPanel.add(lblS);
		}
		{
			JComboBox comboBox = new JComboBox();
			contentPanel.add(comboBox);
		}
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
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
