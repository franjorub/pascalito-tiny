package ast;

public class NodoIdentificador extends NodoBase {
  private String nombre;
  private String tipo;

  public NodoIdentificador(String nombre) {
    super();
    this.nombre = nombre;
    this.tipo = "no_asignado";
  }
  
  public NodoIdentificador (String nombre, String tipo) {
    super();
    this.nombre = nombre;
    this.tipo = tipo;
  }

  public NodoIdentificador() {
    super();
  }

  public String getNombre() {
    return nombre;
  }
  
  public String getTipo () {
    return this.tipo;
  }
  
  public void setTipo (String tipo) {
    this.tipo = tipo;
  }
}