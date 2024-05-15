package estructuras.lineales.doble;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * Clase que representa una Lista Doblemente enlazada
 * @author caflorezvi
 *
 * @param <T>
 */
public class ListaDoble<T> implements Iterable<T>{

	private Nodo<T> primero, ultimo;
	private int tamano;
	
	/**
	 * Verifica si la lista est� vac�a
	 * @return true si est� vac�a
	 */
	public boolean estaVacia() {
		return primero==null && ultimo==null;
	}
	
	/**
	 * Agrega un dato al final de la lista enlazada
	 * @param dato
	 */
	public void agregar(T dato) {
		
		Nodo<T> nodo = new Nodo<>(dato);
		
		if(estaVacia()) {
			primero = ultimo = nodo;
		}else {
			ultimo.setSiguiente(nodo);
			nodo.setAnterior(ultimo);
			ultimo = nodo;
		}
		tamano++;
	}
	
	/**
	 * Agrega un dato al inicio de la lista enlazada
	 * @param dato
	 */
	public void agregarInicio(T dato) {
		Nodo<T> nodo = new Nodo<>(dato);
		
		if(estaVacia()) {
			primero = ultimo = nodo;
		}else {
			nodo.setSiguiente(primero);
			primero.setAnterior(nodo);
			primero = nodo;
		}
		tamano++;		
	}
	
	/**
	 * Agrega un valor en la lista en una posici�n espec�fica
	 * @param dato El valor a guardar
	 * @param indice �ndice donde se va a guardar el dato
	 */
	public void agregar(T dato, int indice) {
		
		if(esValido(indice)) {
			
			if(indice==0) {
				agregarInicio(dato);
			}else {
				Nodo<T> nuevo = new Nodo<>(dato);			
				Nodo<T> actual = obtenerNodo(indice);
				
				nuevo.setSiguiente(actual);
				nuevo.setAnterior(actual.getAnterior());
				actual.getAnterior().setSiguiente(nuevo);
				actual.setAnterior(nuevo);
				
				tamano++;
			}
			
		}
		
	}
	
	/**
	 * Borra completamente la Lista
	 */
	public void borrarLista() {
		primero = ultimo = null;
		tamano = 0;
	}
	
	/**
	 * Elimina un elemento de la lista
	 * @param dato dato a eliminar
	 * @return El dato que se elimina
	 */
	public T eliminar(T dato) {
		
		Nodo<T> nodo = buscar(dato);
		
		if(nodo!=null) {

			Nodo<T> previo = nodo.getAnterior();
			Nodo<T> siguiente = nodo.getSiguiente();
			
			if(previo==null) {
				primero = siguiente;
			}else {
				previo.setSiguiente(siguiente);
			}
			
			if(siguiente==null) {
				ultimo = previo;
			}else {
				siguiente.setAnterior(previo);
			}
			
			nodo=null;
			tamano--;
			
			return dato;
		}
		
		throw new RuntimeException("El valor no existe");		
	}
	
	/**
	 * Elimina el primer elemento de la lista
	 * @return El dato borrado
	 */
	public T eliminarPrimero() {
		
		if( !estaVacia() ) {
			Nodo<T> n = primero;
		    T valor = n.getDato();
			primero = n.getSiguiente();
			
			if(primero==null) {
				ultimo = null;
			}else {
				primero.setAnterior(null);
			}
			
			tamano--;
			return valor;
		}
		
		throw new RuntimeException("Lista vac�a");		
	}
	
	/**
	 * Elimina el �ltimo elemento de la lista
	 * @return El dato borrado
	 */
	public T eliminarUltimo() {
		
		if( !estaVacia() ) {			
			T valor = ultimo.getDato();
			Nodo<T> prev = obtenerNodo(tamano-2);
			ultimo = prev;
			
			if(ultimo==null) {
				primero=null;
			}else {					
				prev.setSiguiente(null);
			}				
			
			tamano--;
			return valor;
		}
		
		throw new RuntimeException("Lista vac�a");
	}	
	
	/**
	 * Devuelve el Nodo de una lista dada su posici�n
	 * @param indice �ndice para obtener el Nodo
	 * @return Nodo objeto
	 */
	private Nodo<T> obtenerNodo(int indice){
		
		if(indice>=0 && indice<tamano) {
			
			Nodo<T> aux = primero;
			
			for (int i = 0; i < indice; i++) {
				aux = aux.getSiguiente();
			}
			
			return aux;			
		}
		
		return null;
	}
	
	/**
	 * Devuelve un nodo que contenga un dato espec�fico
	 * @param dato Dato a buscar
	 * @return Nodo 
	 */
	private Nodo<T> buscar(T dato){
		
		Nodo<T> aux = primero;
		
		while(aux!=null) {
			if(aux.getDato().equals(dato)) {
				return aux;
			}
			aux = aux.getSiguiente();
		}
		
		return null;		
	}
	
	/**
	 * Verifica que un �ndice est� en un rango permitido
	 * @param indice �ndice a validar
	 * @return boolean true si es v�lido
	 */
	private boolean esValido(int indice) {
		if(indice>=0 && indice<tamano) {
			return true;
		}
		
		throw new RuntimeException("�ndice no v�lido");
	}
	
	/**
	 * Verifica si un dato existe dentro de la lista
	 * @param dato Dato s buscar
	 * @return boolean true si existe
	 */
	public boolean existe(T dato) {
		return buscar(dato)!=null;
	}
	
	/**
	 * Devuelve un elemento de la lista dado su �ndice
	 * @param indice �ndice de la lista
	 * @return dato guardado en el �ndice especificado
	 */
	public T obtener(int indice) {
		
		if( esValido(indice) ) {
			Nodo<T> n = obtenerNodo(indice);
			
			if(n!=null) {
				return n.getDato();
			}
		}

		return null;		
	}
	
	/**
	 * Cambia el valor de un nodo dada su posici�n en la lista
	 * @param indice posici�n donde se va a cambiar el dato
	 * @param nuevo nuevo valor por el que se actualizar� el nodo
	 */
	public void modificar(int indice, T nuevo) {
		
		if( esValido(indice) ) {			
			Nodo<T> nodo = obtenerNodo(indice);
			nodo.setDato(nuevo);			
		}
		
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
	 * Imprime en consola la lista enlazada
	 */
	public void imprimirAdelante() {
		
		for(Nodo<T> aux = primero; aux!=null; aux = aux.getSiguiente()) {
			System.out.print( aux.getDato()+"\t" );
		}
		System.out.println();
		
	}
	
	/**
	 * Imprime en consola la lista enlazada de atr�s hacia adelante
	 */
	public void imprimirAtras() {
		
		for(Nodo<T> aux = ultimo; aux!=null; aux = aux.getAnterior()) {
			System.out.print( aux.getDato()+"\t" );
		}
		System.out.println();
		
	}
	
	/**
	 * Retorna la primera posici�n donde est� guardado el dato
	 * @param dato valor a buscar dentro de la lista
	 * @return primera posici�n del dato
	 */
	public int obtenerPosicion(T dato) {

		int i = 0;
		
		for( Nodo<T> aux = primero ; aux!=null ; aux = aux.getSiguiente() ) {
			if( aux.getDato().equals(dato) ) {
				return i;
			}
			i++;
		}
		
		return -1;
	}
	
	/**
	 * Retorna la �ltima posici�n donde est� guardado el dato
	 * @param dato valor a buscar dentro de la lista
	 * @return �ltima posici�n del dato
	 */
	public int obtenerUltimaPosicion(T dato) {
		
		int i = tamano-1;
		
		for( Nodo<T> aux = ultimo ; aux!=null ; aux = aux.getAnterior() ) {
			if( aux.getDato().equals(dato) ) {
				return i;
			}
			i--;
		}
		
		return -1;
	}		

	public void retainAll(ListaDoble<T> lista2) {
		
		for (Nodo<T> aux = primero; aux!=null; aux = aux.getSiguiente()) {
		
			if( !lista2.existe(aux.getDato()) ) {
				eliminar(aux.getDato());
			}
			
		}
		
	}
	
	@Override
	public Iterator<T> iterator() {
		return new IteradorListaDoble(0);
	}
	
	/**
	 * Retorna un ListIterator que permite iterar los elementos de la lista
	 * @param index �ndice desde donde se va a recorrer
	 * @return IteradorListaDoble
	 */
    public ListIterator<T> listIterator(int index) {
        return new IteradorListaDoble(index);
    }	
	
	/**
	 * Clase que representa el LisIterator de la Lista Doblemente enlazada
	 * @author caflorezvi
	 *
	 */
	protected class IteradorListaDoble implements ListIterator<T>{

		private int posicion;
		private Nodo<T> nodo;
		
		/**
		 * Constructor de la clase Iterador de la lista dobles
		 * @param posicion
		 */
		public IteradorListaDoble(int posicion) {
			this.posicion = posicion;
			this.nodo = obtenerNodo(posicion);
		}
		
		@Override
		public boolean hasNext() {
			return nodo!=null;
		}

		@Override
		public T next() {
			T aux = nodo.getDato();
			nodo = nodo.getSiguiente();
			posicion++;
			return aux;
		}

		@Override
		public boolean hasPrevious() {
			return nodo!=null;
		}

		@Override
		public T previous() {
			T aux = nodo.getDato();
			nodo = nodo.getAnterior();
			posicion--;
			return aux;
		}

		@Override
		public int nextIndex() {
			return posicion;
		}

		@Override
		public int previousIndex() {
			return posicion-1;
		}

		@Override
		public void remove() {
			if(nodo!=null) {
				eliminar(nodo.getDato());
			}
		}

		@Override
		public void set(T e) {
			if(nodo!=null) {
				nodo.setDato(e);				
			}
		}

		@Override
		public void add(T e) {
			agregar(e);
		}
		
		
	}

		
}
