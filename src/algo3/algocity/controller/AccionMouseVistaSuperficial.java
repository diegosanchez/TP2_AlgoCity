package algo3.algocity.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class AccionMouseVistaSuperficial implements ActionListener {
	
	JPanel panel;
	
	public AccionMouseVistaSuperficial(JPanel panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		((CardLayout) panel.getLayout()).show(panel, "superficie");
		
	}


}
