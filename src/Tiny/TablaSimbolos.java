package Tiny;

import java.util.*;

import ast.NodoArray;
import ast.NodoAsignacion;
import ast.NodoBase;
import ast.NodoEscribir;
import ast.NodoIdentificador;
import ast.NodoIf;
import ast.NodoOperacion;
import ast.NodoRepeat;
import ast.NodoValor;
import ast.NodoWhile;
import ast.NodoFor;
import ast.NodoOperacionUnaria;

public class TablaSimbolos {
	private HashMap<String, RegistroSimbolo> tabla;
	private int direccion;  //Contador de las localidades de memoria asignadas a la tabla
	
	public TablaSimbolos() {
		super();
		tabla = new HashMap<String, RegistroSimbolo>();
		direccion=0;
	}

	public void cargarTabla(NodoBase raiz){
		while (raiz != null) {
	    if (raiz instanceof NodoIdentificador){
	    	System.out.println("guardare: " + ((NodoIdentificador)raiz).getNombre());

	    	InsertarSimbolo(((NodoIdentificador)raiz).getNombre(),-1);
	    	
	    	//TODO: Anadir el numero de linea y localidad de memoria correcta
	    }

	    /* Hago el recorrido recursivo */
	    if (raiz instanceof  NodoIf){
	    	cargarTabla(((NodoIf)raiz).getPrueba());
	    	cargarTabla(((NodoIf)raiz).getParteThen());
	    	if(((NodoIf)raiz).getParteElse()!=null){
	    		cargarTabla(((NodoIf)raiz).getParteElse());
	    	}
	    }
	    else if (raiz instanceof  NodoRepeat){
	    	cargarTabla(((NodoRepeat)raiz).getCuerpo());
	    	cargarTabla(((NodoRepeat)raiz).getPrueba());
	    }
	    else if (raiz instanceof  NodoWhile){
	    	cargarTabla(((NodoWhile)raiz).getPrueba());
	    	cargarTabla(((NodoWhile)raiz).getCuerpo());
	    }
	    else if (raiz instanceof  NodoFor){
	    	cargarTabla(((NodoFor)raiz).getAsignaP());
	    	cargarTabla(((NodoFor)raiz).getPrueba());
	    	cargarTabla(((NodoFor)raiz).getCuerpo());
	    	cargarTabla(((NodoFor)raiz).getAsignaT());
	    }
	    else if (raiz instanceof  NodoAsignacion)
	    	cargarTabla(((NodoAsignacion)raiz).getExpresion());
	    else if (raiz instanceof  NodoEscribir)
	    	cargarTabla(((NodoEscribir)raiz).getExpresion());
	    else if (raiz instanceof NodoOperacion){
	    	cargarTabla(((NodoOperacion)raiz).getOpIzquierdo());
	    	cargarTabla(((NodoOperacion)raiz).getOpDerecho());
	    }
	    else if (raiz instanceof NodoOperacionUnaria) {
		    cargarTabla(((NodoOperacionUnaria)raiz).getOpDerecho());
		}
	    else if(raiz instanceof NodoArray) {
	    	NodoIdentificador identificador = ((NodoArray)raiz).getIdentificador();
	    	NodoValor tam = (NodoValor)((NodoArray)raiz).getTam();	    	
	    	InsertarSimbolo(identificador.getNombre(), -1, tam.getValor());
	    }
	    raiz = raiz.getHermanoDerecha();
	  }
	}
	
	public boolean InsertarSimbolo(String identificador, int numLinea, int espacioReservado) {
		RegistroSimbolo simbolo;
		if(tabla.containsKey(identificador)){
			return false;
		}else{
			System.out.println("hola");
			simbolo= new RegistroSimbolo(identificador,numLinea,direccion++, espacioReservado);
			direccion += espacioReservado;
			tabla.put(identificador,simbolo);
			return true;			
		}
	}
	//true es nuevo no existe se insertara, false ya existe NO se vuelve a insertar 
	public boolean InsertarSimbolo(String identificador, int numLinea){
		RegistroSimbolo simbolo;
		if(tabla.containsKey(identificador)){
			return false;
		}else{
			System.out.println("hola");
			simbolo= new RegistroSimbolo(identificador,numLinea,direccion++);
			tabla.put(identificador,simbolo);
			return true;			
		}
	}
	
	public RegistroSimbolo BuscarSimbolo(String identificador){
		RegistroSimbolo simbolo=(RegistroSimbolo)tabla.get(identificador);
		return simbolo;
	}
	
	public void ImprimirClaves(){
		System.out.println("*** Tabla de Simbolos ***");
		for( Iterator <String>it = tabla.keySet().iterator(); it.hasNext();) { 
            String s = (String)it.next();
	    System.out.println("Consegui Key: "+s+" con direccion: " + BuscarSimbolo(s).getDireccionMemoria());
		}
	}

	public int getDireccion(String Clave){
		return BuscarSimbolo(Clave).getDireccionMemoria();
	}
	
	/*
	 * TODO:
	 * 1. Crear lista con las lineas de codigo donde la variable es usada.
	 * */
}
