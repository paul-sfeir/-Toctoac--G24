package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
/**
 * Classe ecouteur pour les utilisateurs lambda
 * @author Groupe 24
 */
public class ListenerLambda implements ActionListener {
	
	private Vue_Evenement vue;
	
	public ListenerLambda(Vue_Evenement _vue){
		vue = _vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(vue.getBtnDtailDesvnements())){
			if(vue.getList().getSelectedIndex() == -1){
				JOptionPane.showMessageDialog(vue, "S�lectionnez un �v�nement");
			}else{
				vue.getLambda().detailEvenement(vue.getLambda().getEvenementAt(vue.getList().getSelectedIndex()));
			}
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
					else{
						if (e.getSource().equals(vue.getbSupprimer())){
							if(vue.getList().getSelectedIndex() == -1){
								JOptionPane.showMessageDialog(vue, "S�lectionnez un �v�nement");
							}else{
								vue.getLambda().supprimerEvenement(vue.getList().getSelectedIndex());
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
