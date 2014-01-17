package controleur;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vue.*;
import modele.*;

public class ControleurConnexion {
	private ControleurDonneesUtilisateur controleurDonneesU;
	
	public ControleurConnexion(ControleurDonneesUtilisateur _cdu) {
		this.controleurDonneesU = _cdu;
	}
	
	public String getChampIdUtilisateur(VueConnexion _vc){
		String champId;
		champId = _vc.getChampIdUtilisateur().getText();
		
		if(this.controleurDonneesU.getListeUtilisateurs().contains(champId) == true){
			return(champId);
		}
		else{
			return null;
		}
	}
		
		public String getChampMdp(VueConnexion _vc){
			char[] mdp = _vc.getChampMotDePasseUtilisateur().getPassword();
		    String Mdp = new String(mdp);
		    
			return(Mdp);
		}
	
	public int controleurValiderIdentifiant(VueConnexion _vc) {
		Utilisateur user;
		int statut = -1;
		
		if (_vc.getChampIdUtilisateur() != null) {
			user = this.controleurDonneesU.getUtilisateur(_vc.getChampIdUtilisateur().getText());
			
			if (!(user == null)) {
				if (user.getMdpUtilisateur().equals(this.getChampMdp(_vc))) {
					JOptionPane.showMessageDialog(new JFrame(), "Identification correcte",
							"Conexion...", JOptionPane.INFORMATION_MESSAGE);
					statut = user.getStatutUtilisateur();
				}
				
				else {
				JOptionPane.showMessageDialog(new JFrame(), "Mot de passe incorrect !",
						"Avertissement", JOptionPane.ERROR_MESSAGE);
				_vc.getChampMotDePasseUtilisateur().setText("");
				_vc.getChampMotDePasseUtilisateur().requestFocusInWindow();
				}
			}
			
			else {
				JOptionPane.showMessageDialog(new JFrame(), "Identifiant incorrect !",
						"Avertissement", JOptionPane.ERROR_MESSAGE);
				_vc.getChampIdUtilisateur().setText("");
			}
		}
		
		return statut;
	}

	public ControleurDonneesUtilisateur getControleurDonneesU() {
		return controleurDonneesU;
	}

	public void setControleurDonneesU(
			ControleurDonneesUtilisateur controleurDonneesU) {
		this.controleurDonneesU = controleurDonneesU;
	}
}
