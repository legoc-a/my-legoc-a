package com.vue;

import java.util.ArrayList;
import java.util.List;

import com.metier.*;
import com.modele.ModeleBorneTypeCharge;
import com.persistance.AccesData;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/**
 * Créer le panel pour choisir le type de charge souhaité
 * fait appel au ModeleBorneTypeCharge pour rechercher et afficher les bornes correspondantes
 */
public class PanelBorneTypeCharge extends JPanel {

	
	private List<TypeCharge> listeTypeCharge=null;
	private ModeleBorneTypeCharge modele=null;
	private JTable table;
	private JComboBox cbxTypeCharge;
	private JScrollPane scrollPane;
	private JLabel lblTypeDeCharge; 
	//private Parc unParc;
	private List<Station> lesStations;
	public PanelBorneTypeCharge(List<Station> ls) {
		// récupération des types de charge dans la base de données
		listeTypeCharge = AccesData.getListeTypeCharge();
		// absence de gestionnaire de placement dans le panel
		setLayout(null);
		lesStations=ls;
		//unParc = p;
		// instanciation et ajout du label 
		lblTypeDeCharge = new JLabel("Type de charge ");
		lblTypeDeCharge.setBounds(72, 78, 143, 14);
		add(lblTypeDeCharge);
		// instanciation JscollPane et Jtable et ajout
		scrollPane = new JScrollPane();
		table = new JTable();
		table.setBounds(0, 0, 1, 1);
		scrollPane.setBounds(20, 115, 403, 159);
		scrollPane.setViewportView(table);
		add(scrollPane);
		// instanciation et ajout liste déroulante
		cbxTypeCharge = new JComboBox();
		cbxTypeCharge.setBounds(251, 75, 125, 20);
		add(cbxTypeCharge);
		// évènement sur liste
		cbxTypeCharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// instanciation d'un objet Modele
				modele = new ModeleBorneTypeCharge(lesStations);
				// transmission au modèle du type de charge sélectionné pour recherche des bornes concernées
				modele.ChargeListeBorne(listeTypeCharge.get(cbxTypeCharge.getSelectedIndex()).getCodeTypeCharge());
				// affectation du modèle à la Jtable
				table.setModel(modele);
				// rafraichissement
				table.revalidate();
			}
		});
		// chargement de la liste
		for(TypeCharge t: listeTypeCharge) 	{
			cbxTypeCharge.addItem(t.getLibelleTypeCharge());
		}
		// positionnement sur le premier élément de liste au départ
		//cbxTypeCharge.setSelectedItem(0);
	}
}
