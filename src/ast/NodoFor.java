package ast;

public class NodoFor extends NodoBase{
	
	private NodoBase cuerpo;
	private NodoBase prueba;
	private NodoBase asignaP;
	private NodoBase asignaT;
	public NodoFor(NodoBase asignaP,NodoBase prueba,NodoBase asignaT, NodoBase cuerpo) {
		super();
		this.cuerpo = cuerpo;
		this.prueba = prueba;
		this.asignaP = asignaP;
		this.asignaT = asignaT;
	}
	
	public NodoFor() {
		super();
		this.cuerpo = null;
		this.prueba = null;
		this.asignaP = null;
		this.asignaT = null;
	}
	
	public NodoBase getCuerpo() {
		return cuerpo;
	}

	public NodoBase getAsignaP() {
		return asignaP;
	}

	public void setAsignaP(NodoBase asignaP) {
		this.asignaP = asignaP;
	}

	public NodoBase getAsignaT() {
		return asignaT;
	}

	public void setAsignaT(NodoBase asignaT) {
		this.asignaT = asignaT;
	}

	public void setCuerpo(NodoBase cuerpo) {
		this.cuerpo = cuerpo;
	}

	public NodoBase getPrueba() {
		return prueba;
	}

	public void setPrueba(NodoBase prueba) {
		this.prueba = prueba;
	}
	
}
