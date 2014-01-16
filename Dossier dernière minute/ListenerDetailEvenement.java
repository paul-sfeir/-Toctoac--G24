package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modele.Evenement;

public class ListenerDetailEvenement implements ActionListener{
	
	private Vue_Detail_Evenement vue;
	private boolean trouve = false;
	
	public ListenerDetailEvenement(Vue_Detail_Evenement _vue){
		vue = _vue;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if (arg0.getSource().equals(vue.getOkButton())){
			if(vue.isAjouter() == true){
				if(vue.getTextField().getText().equals("")){
					JOptionPane.showMessageDialog(vue, "Il faut un nom à l'évènement");
				}
				else{
					if(vue.getTextField_1().getText().equals("")){
						JOptionPane.showMessageDialog(vue, "Il faut donner un lieu");
					}
					else{
				//		vue.getCe().ajouterEvenement(new Evenement(vue.getCe().getIdentifiant(), vue.getTextField().getText(), vue.getCalendar().getDate() , vue.getTextField_1().getText()));
					}
				}
				
			}
			else{
				if(vue.getTextField().getText().equals("")){
					JOptionPane.showMessageDialog(vue, "Il faut un nom à l'évènement");
				}
				else{
					if(vue.getTextField_1().getText().equals("")){
						JOptionPane.showMessageDialog(vue, "Il faut donner un lieu");
					}
					else{
				//		vue.getCe().modifierEvenement(new Evenement(vue.getE().getIdEvenement(), vue.getTextField().getText(), vue.getCalendar().getDate() , vue.getTextField_1().getText()));
					}
				}
			}
		}
		else{
			int rep = JOptionPane.showConfirmDialog(vue, "Etes-vous sur de vouloir quitter?","Quitter",JOptionPane.YES_NO_OPTION);
			if(rep == JOptionPane.YES_OPTION){
				vue.getCe().fermerDetailEvenement();
			}
		}
	}

}
