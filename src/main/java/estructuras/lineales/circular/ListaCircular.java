package estructuras.lineales.circular;

import java.util.Iterator;

/**
 * Clase que representa una Lista Circular
 * @author caflorezvi
 *
 * @param <T>
 */
public class ListaCircular<T> implements Iterable<T>{

	private Nodo<T> primero, ultimo;
	private int tamano;
	
	/**
	 * Verifica si la lista est� vac�a
	 * @return true si est� vac�a
	 */
	public boolean estaVacia() {
		return primero==null;
	}
	
	/**
	 * Agrega un dato en la lista circular enlazada
	 * @param dato
	 */
	public void agregar(T dato) {
		Nodo<T> nuevo = new Nodo<T>(dato);
		
		if( estaVacia() ){
			primero = ultimo = nuevo;
		}else {
			Nodo<T> aux = ultimo.getSiguiente();
			ultimo.setSiguiente(nuevo);
			nuevo.setSiguiente(aux);
			ultimo = nuevo;
		}
		
		tamano++;
	}
	
	/**
	 * Elimina un elemento de la lista
	 * @param dato Nodo a eliminar
	 * @throws Exception 
	 */
	public T eliminar(T dato){

		Nodo<T> previo = ultimo;
		boolean encontrado = false;
		
		//buscar el nodo previo
		do{
			
			if( previo.getSiguiente().getDato().equals(dato)){
				encontrado = true;
				break;
			}					
			previo = previo.getSiguiente();
			
		} while(previo!=ultimo);	
		
		if(encontrado){
			
			Nodo<T> actual = previo.getSiguiente();
			
			if(primero == primero.getSiguiente()){
				primero = ultimo = null;
			}else{								
				previo.setSiguiente(actual.getSiguiente());
				
				if(actual==primero) {
					primero = previo.getSiguiente();	
				}				
				
				if(actual == ultimo) {
					ultimo = previo;
				}
				
			}
			
			tamano--;
			actual = null;	
			
			return dato;			
		}
			
		throw new RuntimeException("El valor no existe");		
	}
	
	/**
	 * Recorre la lista circular
	 * @throws Exception 
	 */
	public void imprimir(){
				
		if(!estaVacia()) {
		
			Nodo<T> aux = primero;
			
			do{
				System.out.print( aux.getDato()+"\t" );
				aux = aux.getSiguiente();
			}while(aux!=primero);			
			
			System.out.println();
		
		}		
	}
	
	/**
	 * Verifica si un elemento existe dentro de la lista
	 * @param elemento Criterio de b�squeda
	 * @return true si encuentra el elemento, de lo contrario false
	 */
	public boolean existe(T elemento){
		return buscar(elemento)!=null;
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
	 * Busca un elemento en la lista
	 * @param dato de b�squeda
	 * @return Primer Nodo que cumple con la condici�n
	 */
	private Nodo<T> buscar(T dato){
		
		if ( !estaVacia() ){
			Nodo<T> p = primero;
			
			do{
				if(p.getDato().equals(dato)){
					return p;
				}
				p = p.getSiguiente();
				
			}while(p!=primero);
			
		}	
		
		return null;
	}	
	
	/**
	 * Elimina la lista circular
	 */
	public void eliminarLista(){
		primero = null;
		tamano = 0;
	}	
	
	/**
	 * @return the primero
	 */
	public Nodo<T> getPrimero() {
		return primero;
	}
	
	/**
	 * @return the primero
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
	
	@Override
	public Iterator<T> iterator() {
		return new IteradorListaCircular(primero);
	}
	
	/**
	 * Clase que representa el iterador de la Lista enlazada circular
	 * @author caflorezvi
	 *
	 */
	protected class IteradorListaCircular implements Iterator<T>{

		private Nodo<T> referencia;
		private Nodo<T> actual;		
		private int posicion = 0;
		
		/**
		 * Constructor de la clase IteradorListaCircular
		 * @param referencia
		 */
		public IteradorListaCircular(Nodo<T> referencia) {
			this.referencia = referencia;
			this.actual = referencia;
			this.posicion = 0;
		}

		@Override
		public boolean hasNext() {		
			return actual!=null;
		}

		@Override
		public T next() {
			T aux = actual.getDato();		
			
			if(actual.getSiguiente() == referencia){
				actual = null;
			}else{
				actual = actual.getSiguiente();
			}
			posicion++;	
			
			return aux;
		}
		
		/**
		 * Posici�n actual de la lista
		 * @return
		 */
		public int getPosicion() {
			return posicion;
		}
		
	}
	
	public boolean buscar1(T dato) {
		
		int aux = 0;
		boolean encontrado = false;
		
		do {
			
			if(dato.equals( obtener(aux) )) {
				encontrado = true;
			}
			aux++;
		}while(aux<tamano);
		
		return encontrado;
		
	}
	
}
