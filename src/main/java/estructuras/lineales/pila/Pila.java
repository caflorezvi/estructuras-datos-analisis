package estructuras.lineales.pila;

import estructuras.lineales.simple.Nodo;

/**
 * Clase que representa una estructura de datos tipo Pila - LIFO (�ltimo en entrar, primero en salir).
 * @author caflorezvi
 *
 * @param <T>
 */
public class Pila<T> {

	private Nodo<T> cima;
	private int tamano;
	
	/**
	 * Verifica si la Pila est� vac�a
	 * @return true si est� vac�a
	 */
	public boolean estaVacia() {
		return cima==null;
	}
	
	/**
	 * Inserta un elemento en la Pila - push
	 * @param dato elemento a guardar en la pila
	 */
	public void agregar(T dato) {
		
		Nodo<T> nodo = new Nodo<>(dato);
		nodo.setSiguiente(cima);
		cima = nodo;		
		
		tamano++;
	}
	
	/**
	 * Retorna y elimina el elemento que est� en la cima de la Pila - pop
	 * @return Elemento de la cima
	 */
	public T quitar() {
		
		if(estaVacia()) {
			throw new RuntimeException("La Pila est� vac�a");
		}
		
		T dato = cima.getDato();
		cima = cima.getSiguiente();
		tamano--;
		
		return dato;		
	}
	
	/**
	 * Borra completamente la Pila
	 */
	public void borrarPila() {
		cima = null;
		tamano = 0;
	}
	
	/**
	 * @return the cima - peek
	 */
	public T obtenerCima() {
		return cima.getDato();
	}
	
	/**
	 * @return the cima - peek
	 */
	public Nodo<T> getCima() {
		return cima;
	}

	/**
	 * @return the tamano
	 */
	public int getTamano() {
		return tamano;
	}
	
	/**
	 * Agrega una Pila nueva
	 * @param pila nueva Pila
	 */
	public void agregar(Pila<T> pila) {
		
		Pila<T> clon = pila.clone();
		Pila<T> aux = new Pila<>();
		
		while(!clon.estaVacia()) {
			aux.agregar(clon.quitar());
		}
		
		while(!aux.estaVacia()) {
			agregar(aux.quitar());
		}
		
	}
	
	/**
	 * Imprime una pila en consola
	 */
	public void imprimir() {
		Nodo<T> aux = cima;
		while(aux!=null) {
			System.out.print(aux.getDato()+"\t");
			aux = aux.getSiguiente();
		}
		System.out.println();
	}
	
	
	
	@Override
	protected Pila<T> clone(){

		Pila<T> pilaFinal = new Pila<>();		
		Nodo<T> nodoCima = null;
		
		for (Nodo<T> aux = cima; aux!=null; aux = aux.getSiguiente()) {
			
			Nodo<T> nuevo = new Nodo<>( aux.getDato() );
			
			if(pilaFinal.estaVacia()) {
				pilaFinal.cima = nuevo;
				nodoCima = nuevo;
			}else {
				pilaFinal.cima.setSiguiente(nuevo);
				pilaFinal.cima = nuevo;
			}			
			pilaFinal.tamano++;
			
		}
		
		pilaFinal.cima = nodoCima;
		
		return pilaFinal;
	}
	
}