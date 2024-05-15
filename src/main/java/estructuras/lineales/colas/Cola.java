package estructuras.lineales.colas;

import estructuras.lineales.simple.Nodo;

/**
 * Clase que representa una estructura de datos tipo Cola - FIFO (primero en entrar, primero en salir)
 * @author caflorezvi
 *
 * @param <T>
 */
public class Cola<T> {

	private Nodo<T> primero, ultimo;
	private int tamano;
	
	/**
	 * Verifica si la Cola est� vac�a
	 * @return true si est� vac�a
	 */
	public boolean estaVacia() {
		return primero == null;
	}
	
	/**
	 * Agrega un elemento en la Cola
	 * @param dato elemento a guardar en la Cola
	 */
	public void encolar(T dato) {
		
		Nodo<T> nodo = new Nodo<>(dato);
		
		if(estaVacia()) {
			primero = ultimo = nodo;
		}else {
			ultimo.setSiguiente(nodo);
			ultimo = nodo;
		}
		
		tamano++;
	}
	
	/**
	 * Retorna y elimina el elemento que est� al incio de la Cola
	 * @return Primer elemento de la Cola
	 */
	public T desencolar() {
		
		if(estaVacia()) {
			throw new RuntimeException("La Cola est� vac�a");
		}
		
		T dato = primero.getDato();
		primero = primero.getSiguiente();
		
		if(primero==null) {
			ultimo = null;
		}
		
		tamano--;
		return dato;
	}
	
	/**
	 * Borra completamente la Cola
	 */
	public void borrarCola() {
		primero = ultimo = null;
		tamano = 0;
	}

	/**
	 * @return the primero
	 */
	public Nodo<T> getPrimero() {
		return primero;
	}

	/**
	 * @return the ultimo
	 */
	public Nodo<T> getUltimo() {
		return ultimo;
	}

	/**
	 * @return the tamano
	 */
	public int getTamano() {
		return tamano;
	}
	
	/**
	 * Verifica si la Cola es id�ntica a la actual
	 * @param cola Cola a comparar
	 * @return True si son iguales
	 */
	public boolean sonIdenticas(Cola<T> cola) {
		
		Cola<T> clon1 = clone();
		Cola<T> clon2 = cola.clone();
		
		if(clon1.getTamano() == clon2.getTamano()) {
			
			while( !clon1.estaVacia() ) {				
				if( !clon1.desencolar().equals( clon2.desencolar() ) ) {
					return false;
				}				
			}
			
		}else {
			return false;
		}
		
		return  true;
	}
	
	/**
	 * Imprime una cola en consola
	 */
	public void imprimir() {
		Nodo<T> aux = primero;
		while(aux!=null) {
			System.out.print(aux.getDato()+"\t");
			aux = aux.getSiguiente();
		}
		System.out.println();
	}
	
	@Override
	protected Cola<T> clone() {
		
		Cola<T> nueva = new Cola<>();
		Nodo<T> aux = primero;
		
		while(aux!=null) {
			nueva.encolar( aux.getDato() );
			aux = aux.getSiguiente();
		}
		
		return nueva;		
	}
	
	
}