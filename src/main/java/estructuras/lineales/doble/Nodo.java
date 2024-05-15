package estructuras.lineales.doble;

/**
 * Clase que representa un Nodo de una Lista Doblemente Enlazada
 * @author caflorezvi
 *
 * @param <T>
 */
public class Nodo<T> {

	private Nodo<T> anterior, siguiente;
	private T dato;
	
	/**
	 * Constructor de la clase Nodo
	 * @param dato Elemento que se guarda en el Nodo
	 * @param anterior Enlace al Nodo anterior
	 * @param siguiente Enlace al siguiente Nodo
	 */
	public Nodo(Nodo<T> anterior, Nodo<T> siguiente, T dato) {
		super();
		this.anterior = anterior;
		this.siguiente = siguiente;
		this.dato = dato;
	}
	
	/**
	 * Constructor de la clase Nodo
	 * @param dato Elemento que se guarda en el Nodo
	 */
	public Nodo(T dato) {
		this.dato = dato;
	}
	
	/**
	 * @return the anterior
	 */
	public Nodo<T> getAnterior() {
		return anterior;
	}
	/**
	 * @param anterior the anterior to set
	 */
	public void setAnterior(Nodo<T> anterior) {
		this.anterior = anterior;
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
