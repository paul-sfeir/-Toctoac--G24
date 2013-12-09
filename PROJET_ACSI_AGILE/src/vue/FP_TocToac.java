package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Scrollbar;

public class FP_TocToac {

	private JFrame frame;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Liste des entrainements de la semaine");
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.WEST);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		Scrollbar scrollbar = new Scrollbar();
		scrollPane.setRowHeaderView(scrollbar);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		

		
		JButton btnSeDsinscrire = new JButton("Se d\u00E9sinscrire");
		panel_1.add(btnSeDsinscrire);
		
		JButton btnSinscrire = new JButton("S'inscrire");
		panel_1.add(btnSinscrire);
		
		JButton btnNewButton = new JButton("Afficher Participants");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		

		panel_1.add(btnNewButton);
	}

}
