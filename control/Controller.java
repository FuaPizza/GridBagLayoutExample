package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import view.Pannello;

public class Controller implements ActionListener{
	
	private Pannello pannello;
	
	public Controller(Pannello pannello) {
		this.pannello = pannello;
		pannello.registraEvento(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().toString().equals("submit")) {
			System.out.println("Ciao");
			registraUtente();
		}
	}

	private void registraUtente() {
		String nome = pannello.getNome();
		String cognome = pannello.getCognome();
		String sesso = pannello.getSesso();
		
		DefaultTableModel tabellaModel = pannello.getTabellaModel();
		JTable tabella = pannello.getTabella();
		
		tabellaModel.addRow(new Object[] {nome, cognome, sesso});
		tabella.setModel(tabellaModel);
	}
}
