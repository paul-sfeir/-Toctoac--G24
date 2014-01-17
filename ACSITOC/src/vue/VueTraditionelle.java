package vue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class VueTraditionelle extends JFrame {
	private static final long serialVersionUID = 10L;
	private JMenuBar menuBar;
	private JMenu mnOptions;
	private JMenuItem mntmDconnexion;
	private JSeparator separator;
	private JMenuItem mntmNewMenuItem;

	public VueTraditionelle () {
		this.menuBar = new JMenuBar();
	    this.setJMenuBar(menuBar);
	    
	    this.mnOptions = new JMenu("Options");
	    this.menuBar.add(mnOptions);
	    
	    this.mntmDconnexion = new JMenuItem("D\u00E9connexion");
	    this.mnOptions.add(mntmDconnexion);
	    
	    this.separator = new JSeparator();
	    this.mnOptions.add(separator);
	    
	    this.mntmNewMenuItem = new JMenuItem("Quitter");
	    this.mnOptions.add(mntmNewMenuItem);
	}
}
