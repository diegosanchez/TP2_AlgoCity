package algo3.algocity.model.conexiones;

import java.awt.Point;

import algo3.algocity.model.caracteristicas.Reparable;
import algo3.algocity.model.caracteristicas.Visitable;
import algo3.algocity.model.caracteristicas.Visitante;
import algo3.algocity.model.excepciones.NoSeCumplenLosRequisitosException;
import algo3.algocity.model.mapas.Mapa;
import algo3.algocity.model.terreno.Superficie;

public class LineaTension implements Conector, Reparable, Visitable {
	
	final boolean intacto = true;
	final boolean destruido = false;
	
	boolean estado; 	//true para intacto
						//false para destruido
	int costo;
	int danios;
	Point coordenadas;

	public LineaTension() {

		this.costo = 5;
	}
	
	public LineaTension(Mapa mapa, int x, int y) throws NoSeCumplenLosRequisitosException {

		coordenadas = new Point(x, y);
		
		if (!esConstruibleEn(mapa.getSuperficie(coordenadas))){
			throw new NoSeCumplenLosRequisitosException();
		}else{
			mapa.agregarLineaTension(this, x, y);;
		}
	}

	public boolean estado(){
		return estado;
	}
	
	@Override
	public void aceptar(Visitante unVisitante) {
		unVisitante.visitar(this); 
		
	}

	public void aplicarDanioGodzilla() {
		estado = destruido;
		
	}

	@Override
	public void repararse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aplicarDanio(double unDanio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getSalud() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Point getCoordenadas() {
		return coordenadas;
	}

	@Override
	public boolean esConstruibleEn(Superficie superficie) {
		return superficie.esTierra();
	}
}