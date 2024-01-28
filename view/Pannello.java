package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import control.Controller;

public class Pannello extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labelNome;
	private JLabel labelCognome;
	
	private JRadioButton radioButtonMaschio;
	private JRadioButton radioButtonFemmina;
	private ButtonGroup buttonGroupSesso;
	private Box boxSesso;
	
	private JTextField textFieldNome;
	private JTextField textFieldCognome;
	
	private JButton buttonSubmit;
	
	private JScrollPane scrollPaneTabella;
	private DefaultTableModel tabellaModel;
	private JTable tabella;
	
	public Pannello() {
		GridBagLayout gbl = new GridBagLayout(); // Crea un layout GridBagLayout
		GridBagConstraints gbc = new GridBagConstraints(); // Crea la classe GridBagConstraints specificante varie regole dei componenti disposti nel GridBagLayout
		setLayout(gbl); // Imposta come layout del pannello il GridBagLayout
		
		labelNome = new JLabel("Nome: ");
		labelCognome = new JLabel("Cognome: ");
		
		radioButtonMaschio = new JRadioButton("Maschio");
		radioButtonMaschio.setActionCommand("Maschio");
		radioButtonFemmina = new JRadioButton("Femmina");
		radioButtonFemmina.setActionCommand("Femmina");
		buttonGroupSesso = new ButtonGroup();// Crea un gruppo di bottoni
		boxSesso = new Box(0); // Crea un box orientato orizzontalmente
		
		buttonGroupSesso.add(radioButtonMaschio);
		buttonGroupSesso.add(radioButtonFemmina);
		boxSesso.add(radioButtonMaschio);
		boxSesso.add(radioButtonFemmina);
		boxSesso.setBorder(BorderFactory.createTitledBorder("Sesso")); // Aggiunge un bordo al box
		
		buttonSubmit = new JButton("Invia");
		buttonSubmit.setActionCommand("submit");
		
		textFieldNome = new JTextField();
		textFieldCognome = new JTextField();
		
		tabellaModel = new DefaultTableModel(); // Crea un modello DefaultTableModel per la tabella 
		tabellaModel.addColumn("Nome"); // Aggiunge una colonna "Nome" al modello DefaultTableModel
		tabellaModel.addColumn("Cognome");
		tabellaModel.addColumn("Sesso");
		
		tabella = new JTable(tabellaModel); // Crea una JTable con modello DefaultTableModel
		tabella.setPreferredScrollableViewportSize(new Dimension(300, 200)); // Imposta la dimensione preferita per questa tabella. 
		tabella.setFillsViewportHeight(true); // Imposta se la tabella deve tutta l'altezza della finestra. 
		scrollPaneTabella = new JScrollPane(tabella); // Crea un JScrollPane con all'interno il componente JTable
		
		gbc.insets = new Insets(5, 5, 5, 5); // Imposta i margini in px del componente
		gbc.gridwidth = 1; gbc.gridheight = 1; // Imposta l'altezza e la larghezza in celle del componente
		gbc.anchor = GridBagConstraints.LINE_START; // Posiziona il componente all'inizio della cella

		gbc.gridx = 0; gbc.gridy = 0; add(labelNome, gbc); // Imposta rispettivamente la posizione x e y delle celle e infine la aggiunge al Pannello secondo le regole definite dal GridBagConstraints
		gbc.gridx = 0; gbc.gridy = 1; add(labelCognome, gbc);
		
		gbc.fill = GridBagConstraints.BOTH; // Regola come il componente deve riempire le celle, in questo caso le occupa sia in altezza che in larghezza
		
		gbc.gridx = 1; gbc.gridy = 0; add(textFieldNome, gbc);	
		gbc.gridx = 1; gbc.gridy = 1; add(textFieldCognome, gbc);	
		gbc.gridwidth = 2;
		
		gbc.gridx = 0; gbc.gridy = 2; add(boxSesso, gbc);				
		gbc.gridx = 0; gbc.gridy = 3; add(buttonSubmit, gbc);
		
		gbc.gridwidth = 1; gbc.gridheight = 5;
		gbc.weightx = 1; gbc.weighty = 1; // Specificano come distribuire lo spazio extra, in questo caso lo riempiono
		
		gbc.gridx = 2; gbc.gridy = 0; add(scrollPaneTabella, gbc);
	}
	
	public void registraEvento(Controller controller) {
		buttonSubmit.addActionListener(controller);		
	}
	
	public String getNome() {
		return textFieldNome.getText();
	}
	
	public String getCognome() {
		return textFieldCognome.getText();
	}
	
	public String getSesso() {
		return buttonGroupSesso.getSelection().getActionCommand().toString();
	}
	
	public DefaultTableModel getTabellaModel() {
		return tabellaModel;
	}
	
	public JTable getTabella() {
		return tabella;
	}
	
}
