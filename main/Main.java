package main;

import control.Controller;
import view.Finestra;

public class Main {
	public static void main(String[] args) {
		Finestra finestra = new Finestra();
		new Controller(finestra.getPannello());
	}
}
