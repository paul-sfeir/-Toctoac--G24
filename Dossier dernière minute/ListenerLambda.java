package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ecouteur de la vue evenment
 * @author Groupe G24
 */
public class ListenerLambda implements ActionListener {
	
	private Vue_Evenement vue;
	
	public ListenerLambda(Vue_Evenement _vue){
		vue = _vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(vue.getBtnDtailDesvnements())){
			
		}
		else{
			if (e.getSource().equals(vue.getBtnNewButton())){
				
			}
			else{
				if (e.getSource().equals(vue.getBtnOk())){
					vue.majVue_TocToac_Lambda();
				}
				else{
					if (e.getSource().equals(vue.getBtnSinscrire())){
						
					}
				}
			}
		}
		
	}

}
