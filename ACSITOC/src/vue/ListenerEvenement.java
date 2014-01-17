package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ListenerEvenement implements ActionListener {
	
	private Vue_Evenement vue;
	
	public ListenerEvenement(Vue_Evenement _vue){
		vue = _vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(vue.getBtnDtailDesvnements())){
			if(vue.getList().getSelectedIndex() == -1){
				JOptionPane.showMessageDialog(vue, "Sélectionnez un évènement");
			}else{
				vue.getLambda().detailEvenement(vue.getEvenement().elementAt(vue.getList().getSelectedIndex()));
			}
		}
		else{
			if (e.getSource().equals(vue.getBtnNewButton())){
				
			}
			else{
				if (e.getSource().equals(vue.getBtnOk())){
					vue.majVue_Evenement();
				}
				else{
					if (e.getSource().equals(vue.getBtnSinscrire())){
						
					}
					else{
						if (e.getSource().equals(vue.getbSupprimer())){
							if(vue.getList().getSelectedIndex() == -1){
								JOptionPane.showMessageDialog(vue, "Sélectionnez un évènement");
							}else{
								vue.getLambda().supprimerEvenement(vue.getEvenement().elementAt(vue.getList().getSelectedIndex()));
							}
						}
						else{
							if (e.getSource().equals(vue.getbAjouter())){
								vue.getLambda().ajouterEvenement();
							}
							else{
								
							}
						}
					}
				}
			}
		}
		
	}
}
