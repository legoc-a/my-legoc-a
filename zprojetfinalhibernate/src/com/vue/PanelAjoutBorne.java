package com.vue;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.util.*;
import com.metier.*;
import com.persistance.AccesData;
import java.util.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Cr�er le panel pour l'ajout d'une borne � une station.
 */
public class PanelAjoutBorne extends JPanel {
	private JLabel lblStation;
	private JLabel lblTypeDeCharge;
	private JLabel lblDateDeMise;
	private JButton btnAnnuler;
	private JButton btnValider;
	private JComboBox cbxStation;
	private JComboBox cbxTypeCharge;
	private JTextField textDate;
	private List<TypeCharge> listeTypeCharge;
	//private Parc unParc; 
	private List<Station> lesStations;
	public PanelAjoutBorne(List<Station> lesStation) {
		lesStations= lesStation;
		setLayout(null);
		add(getLblStation());
		add(getLblTypeDeCharge());
		add(getLblDateDeMise());
		listeTypeCharge = AccesData.getListeTypeCharge();
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				effacement();
			}
		});
		btnAnnuler.setBounds(253, 274, 89, 23);
		add(btnAnnuler);
		btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// on r�cup�re les donn�es du formulaire
				//int idStation = unParc.getLeParcBorne().get(cbxStation.getSelectedIndex()).getIdStation();
				int idStation = lesStations.get(cbxStation.getSelectedIndex()).getIdStation();
				TypeCharge type = listeTypeCharge.get(cbxTypeCharge.getSelectedIndex());
				String dateMiseEnService = textDate.getText();
				// on v�rifie la saisie de la date
				if (!(dateMiseEnService.equals("")) )
				{ 
					// on v�rifie la validit� de la date
					if (VerifDate.ConvertChaineDate(dateMiseEnService) == false)
					{
						afficheMessage("Attention cette date n'est pas valide");
						textDate.setText("");;
						textDate.requestFocus();
					}
					else
					{ 
						// on instancie l'objet Borne
						Station st = AccesData.getStation(idStation);
						Borne b = new Borne(dateMiseEnService, st, type);
						// on l'ajoute � la base de donn�es
						if (AccesData.addBorne(b)) 	{
							// rafraichissement obligatoire depuis la base � cause du numero automatique
							//unParc.setLeParcBorne(AccesData.getListeStation());
							lesStations = null;
							lesStations = AccesData.getListeStation();
							afficheMessage("ajout effectu�");
							effacement();
						}
						else
							afficheMessage("ajout non effectu�");
					}
				}
				else
				{  
					afficheMessage("Attention la date doit �tre saisie");
					textDate.requestFocus();
				}
			}
		});
		btnValider.setBounds(404, 274, 89, 23);
		add(btnValider);

		cbxStation = new JComboBox();
		for(Station s:lesStations)
		{
			cbxStation.addItem(s.getLibelleEmplacement());
		}
		cbxStation.setBounds(298, 70, 169, 20);
		add(cbxStation);

		cbxTypeCharge = new JComboBox();
		for(TypeCharge t:listeTypeCharge)
		{
			cbxTypeCharge.addItem(t.getLibelleTypeCharge());
		}
		cbxTypeCharge.setBounds(299, 127, 150, 20);
		add(cbxTypeCharge);

		textDate = new JTextField();
		textDate.setBounds(298, 184, 86, 20);
		add(textDate);
		textDate.setColumns(10);

	}

	private JLabel getLblStation() {
		if (lblStation == null) {
			lblStation = new JLabel("Station");
			lblStation.setBounds(52, 73, 101, 14);
		}
		return lblStation;
	}
	private JLabel getLblTypeDeCharge() {
		if (lblTypeDeCharge == null) {
			lblTypeDeCharge = new JLabel("Type de Charge ");
			lblTypeDeCharge.setBounds(52, 130, 110, 14);
		}
		return lblTypeDeCharge;
	}
	private JLabel getLblDateDeMise() {
		if (lblDateDeMise == null) {
			lblDateDeMise = new JLabel("date de mise en service jj/mm/aaaa");
			lblDateDeMise.setBounds(52, 187, 213, 14);
		}
		return lblDateDeMise;
	}
	private void afficheMessage(String message)
	{
		JOptionPane.showMessageDialog(null,message);
	}
	private void effacement()
	{
		cbxStation.setSelectedIndex(0);
		cbxTypeCharge.setSelectedIndex(0);
		textDate.setText("");
	}

}


