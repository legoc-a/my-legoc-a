package com.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.metier.*;
import com.modele.ModeleListeBorneStation;
import com.persistance.AccesData;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
/**
 * Créer le panel pour afficher les bornes par station
 * fait appel au ModeleListeBorneStation
 */
public class PanelBorneStation extends JPanel {
	private JLabel lblStation;
	private JComboBox cbxStation;
	private JScrollPane scrollPane;
	private JTable table;
	private ModeleListeBorneStation modele;
	private List<Station> lesStations;

	//private Parc unParc;
	public PanelBorneStation(List<Station> ls) {
		
		lesStations = ls;
		//unParc=p;
		this.setBounds(100, 100, 633, 329);
		modele = null;
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		this.add(getLblStation());
		this.add(getScrollPane());
		this.add(getCbxStation());

	}
	public JLabel getLblStation() {
		if (lblStation == null) {
			lblStation = new JLabel("Station");
			lblStation.setBounds(152, 42, 46, 14);
		}
		return lblStation;
	}
	public JComboBox getCbxStation() {
		if (cbxStation == null) {
			cbxStation = new JComboBox();
			/*cbxStation.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					modele=new ModeleListeBorneStation(listeStation.get(cbxStation.getSelectedIndex()).getIdStation());
					table.setModel(modele);
					 // réactualisation de la table
					table.revalidate();
				}
			});*/
			cbxStation.setBounds(389, 38, 168, 22);
			for(Station s:lesStations)
			{
				cbxStation.addItem(s.getLibelleEmplacement());
			}
			
		cbxStation.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (cbxStation.getSelectedIndex()!= -1) 	{				
					//modele = new ModeleListeBorneStation(unParc.getLeParcBorne().get(cbxStation.getSelectedIndex()).getIdStation());
					modele = new ModeleListeBorneStation(lesStations.get(cbxStation.getSelectedIndex()).getIdStation());
					table.setModel(modele);
					 // réactualisation de la table
					table.revalidate();
					}
				}
			});
			cbxStation.setSelectedIndex(0);
			
	}
		return cbxStation;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(52, 105, 505, 125);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	public JTable getTable() {
		if (table == null) {
			table = new JTable();
		}
		return table;
	}
	public void setIndexCombo() {
		this.getCbxStation().setSelectedIndex(0);
	}

	public void setIndex(int i)	{
		cbxStation.setSelectedIndex(i);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
