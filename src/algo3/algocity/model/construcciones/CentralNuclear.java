package algo3.algocity.model.construcciones;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import algo3.algocity.model.caracteristicas.Daniable;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Coordenada;
import algo3.algocity.model.mapas.Mapa;

public class CentralNuclear extends UnidadEnergetica {

	public CentralNuclear() {
		this.costo = 10000;
		this.capacidad = 1000;
		this.radioDeInfluencia = 25;
	}

	public CentralNuclear(int x, int y) {
		coordenadas = new Coordenada(x, y);
		this.costo = 10000;
		this.capacidad = 1000;
		this.radioDeInfluencia = 25;
	}

	public CentralNuclear(Mapa mapa, int x, int y)
			throws NoSeCumplenLosRequisitosException {
		this.costo = 10000;
		this.capacidad = 1000;
		this.radioDeInfluencia = 25;
		this.coordenadas = new Coordenada(x, y);
		if (!esConstruibleEn(mapa.superficie(coordenadas))
				|| !hayConexionesEn(mapa)) {
			throw new NoSeCumplenLosRequisitosException();
		}
	}

	@Override
	public void repararse() {
		this.porcentajeDanios -= this.porcentajeReparacion();
		if (this.getDanios() < 0) {
			this.porcentajeDanios = 0;
		}
	}

	protected double porcentajeReparacion() {
		return (this.ESTADOINICIAL * 3) / 100;
	}

	@Override
	public void agregarseA(Mapa mapa) {
		mapa.agregarACiudad(this);
		mapa.agregarUnidadDaniable(this);
		mapa.agregarPuntoRelevanteEnRedElectrica(this);
	}

	/**********************************************************************/
	/**************************** Persistencia ****************************/
	/**********************************************************************/
	@Override
	public Element getElement(Document doc) {
		Element unidad = doc.createElement("CentralNuclear");

		Element costo = doc.createElement("costo");
		unidad.appendChild(costo);
		costo.setTextContent(String.valueOf(this.costo));

		Element consumo = doc.createElement("consumo");
		unidad.appendChild(consumo);
		consumo.setTextContent(String.valueOf(this.consumo));

		Element capacidad = doc.createElement("capacidad");
		unidad.appendChild(capacidad);
		capacidad.setTextContent(String.valueOf(this.capacidad));

		Element coordenadas = doc.createElement("coordenadas");
		unidad.appendChild(coordenadas);
		coordenadas
				.setTextContent((String.valueOf((int) this.coordenadas.getX())
						+ "," + String.valueOf((int) this.coordenadas.getY())));

		Element porcentajeDanios = doc.createElement("porcentajeDanios");
		unidad.appendChild(porcentajeDanios);
		porcentajeDanios.setTextContent(String.valueOf(this.porcentajeDanios));

		Element radioDeInfluencia = doc.createElement("radioDeInfluencia");
		unidad.appendChild(radioDeInfluencia);
		radioDeInfluencia
				.setTextContent(String.valueOf(this.radioDeInfluencia));

		return unidad;
	}

	public static CentralNuclear fromElement(Node hijoDeNodo) {
		CentralNuclear cn = new CentralNuclear();
		NodeList hijosDeUnidad = hijoDeNodo.getChildNodes();

		for (int i = 0; i < hijosDeUnidad.getLength(); i++) {
			Node hijoDeUnidad = hijosDeUnidad.item(i);
			if (hijoDeUnidad.getNodeName().equals("costo")) {
				cn.costo = Integer.valueOf(hijoDeUnidad.getTextContent());
			} else if (hijoDeUnidad.getNodeName().equals("consumo")) {
				cn.consumo = Integer.valueOf(hijoDeUnidad.getTextContent());
			} else if (hijoDeUnidad.getNodeName().equals("capacidad")) {
				cn.capacidad = Integer.valueOf(hijoDeUnidad.getTextContent());
			} else if (hijoDeUnidad.getNodeName().equals("porcentajeDanios")) {
				cn.porcentajeDanios = Double.valueOf(hijoDeUnidad
						.getTextContent());
			} else if (hijoDeUnidad.getNodeName().equals("radioDeInfluencia")) {
				cn.radioDeInfluencia = Integer.valueOf(hijoDeUnidad
						.getTextContent());
			} else if (hijoDeUnidad.getNodeName().equals("coordenadas")) {
				String stringPunto = hijoDeUnidad.getTextContent();
				String[] arrayPunto = stringPunto.split(",");
				Coordenada punto = new Coordenada(
						Integer.valueOf(arrayPunto[0]),
						Integer.valueOf(arrayPunto[1]));
				cn.coordenadas = punto;
			}
		}
		return cn;
	}

	/* No evalua los invariantes de la clase */
	public boolean equals(Daniable cn) {
		if (cn == this) {
			return true;
		} else if (cn.coordenadas().getX() == this.coordenadas().getX()
				&& cn.coordenadas().getY() == this.coordenadas().getY()
				&& ((CentralNuclear)cn).porcentajeDanios == this.porcentajeDanios) {
			return true;
		}
		return false;
	}

}
