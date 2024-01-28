package view;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Finestra extends JFrame implements WindowListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Pannello pannello;
	
	public Finestra() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pannello = new Pannello();
		add(pannello);
		
		pack();
		setLocationRelativeTo(null);
		setTitle("Esempio GridBagLayout");
		
		addWindowListener(this);
		setVisible(true);
	}
	
	public Pannello getPannello() {
		return pannello;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		int risultato=JOptionPane.showConfirmDialog(this, "Sei sicuro di uscire dal programma?", "Avviso", JOptionPane.OK_CANCEL_OPTION);
		if(risultato==JOptionPane.OK_OPTION) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		else {
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
