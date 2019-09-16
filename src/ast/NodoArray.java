package ast;

public class NodoArray extends NodoBase{
	private NodoIdentificador identificador;
	private NodoBase tam;
	
	public NodoArray() {
		identificador = null;
		tam = null;
	}
	
	public NodoArray(NodoIdentificador identificador, NodoBase exp) {
		this.identificador = identificador;
		this.tam = exp;
	}
	
	public NodoBase getTam() {
		return this.tam;
	}
	
	public NodoIdentificador getIdentificador () {
		return this.identificador;
	}
}
