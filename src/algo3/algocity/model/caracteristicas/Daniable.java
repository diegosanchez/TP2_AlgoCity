package algo3.algocity.model.caracteristicas;


import org.w3c.dom.Document;
import org.w3c.dom.Element;

import algo3.algocity.model.mapas.Coordenada;

public interface Daniable {

	public void repararse();

	public void aplicarDanio(double unDanio);

	public double getSalud();

	public Coordenada coordenadas();
	
	public void aceptar(Visitante v);
	
	/*Persistencia*/
	public Element getElement(Document doc);
	
	public boolean equals(Daniable d);
}
