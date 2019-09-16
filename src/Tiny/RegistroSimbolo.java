package Tiny;

public class RegistroSimbolo {
	private String identificador;
	private int NumLinea;
	private int DireccionMemoria;
	private int cantidadReservada;
	
	public RegistroSimbolo(String identificador, int numLinea,
			int direccionMemoria) {
		super();
		this.identificador = identificador;
		NumLinea = numLinea;
		DireccionMemoria = direccionMemoria;
		cantidadReservada = 1;
	}
	
	public RegistroSimbolo(String identificador, int numLinea, int direccionMemoria, int cantidadReservada) {
		super();
		this.identificador = identificador;
		NumLinea = numLinea;
		DireccionMemoria = direccionMemoria;
		this.cantidadReservada = cantidadReservada;
	}
	
	public String getIdentificador() {
		return identificador;
	}

	public int getNumLinea() {
		return NumLinea;
	}

	public int getDireccionMemoria() {
		return DireccionMemoria;
	}

	public void setDireccionMemoria(int direccionMemoria) {
		DireccionMemoria = direccionMemoria;
	}
	
	public int getCantidadReservada() {
		return this.cantidadReservada;
	}
}
