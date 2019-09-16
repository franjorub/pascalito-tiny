package ast;

public class NodoIdentificadorArray extends NodoIdentificador{
	private NodoBase posicion;
	
	public NodoIdentificadorArray() {
		super();
		this.posicion = null;
	}
	
	public NodoIdentificadorArray(String identificador, NodoBase posicion) {
		super(identificador);
		this.posicion = posicion;
	}
	
	public NodoBase getPosicion() {
		return this.posicion;
	}
}
