package algo3.algocity.view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class VistaPanelInfo extends JPanel {

	private static final long serialVersionUID = -7918349684154728725L;

	JTextArea mensaje;

	public VistaPanelInfo() {
		setPreferredSize(new Dimension(200, 250));
		setBorder(BorderFactory.createTitledBorder("Info"));
		mensaje = new JTextArea();
		mensaje.setLineWrap(true);
		mensaje.setWrapStyleWord(true);
		mensaje.setEditable(false);
		mensaje.setFocusable(false);
		mensaje.setOpaque(false);
		add(mensaje);
	}

	public void agregarTexto(String texto) {
		mensaje.setText(texto);
	}

}
