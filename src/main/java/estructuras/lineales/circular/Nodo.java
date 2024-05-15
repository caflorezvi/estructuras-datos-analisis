package estructuras.lineales.circular;

/**
 * Clase que representa un Nodo de una Lista Enlazada Circular
 * @author caflorezvi
 *
 */
public class Nodo<T> {

	private Nodo<T> siguiente;
	private T dato;
	
	/**
	 * Constructor de la clase Nodo
	 * @param dato Elemento que se guarda en el Nodo
	 */
	public Nodo(T dato) {
		this.dato = dato;
		this.siguiente = this;
	}
	
	/**
	 * @return the siguiente
	 */
	public Nodo<T> getSiguiente() {
		return siguiente;
	}
	/**
	 * @param siguiente the siguiente to set
	 */
	public void setSiguiente(Nodo<T> siguiente) {
		this.siguiente = siguiente;
	}
	/**
	 * @return the dato
	 */
	public T getDato() {
		return dato;
	}
	/**
	 * @param dato the dato to set
	 */
	public void setDato(T dato) {
		this.dato = dato;
	}
	
	@Override
	public String toString() {
		return dato.toString();
	}
	
}
