package algo3.algocity.model;

public class FabricaUnidadComercial implements FabricaEdificables {

	private int costo = 5;
	private int consumo = 2;

	public UnidadComercial construir() {

		return new UnidadComercial(this.costo, this.consumo);
	}

}