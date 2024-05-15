package estructuras.lineales.simple;

/**
 * Clase que representa un Nodo de una Lista Enlazada
 * @author caflorezvi
 *
 */
public class Nodo<T> {
	
	private T dato;
	private Nodo<T> siguiente;
	
	/**
	 * Constructor de la clase Nodo
	 * @param dato Elemento que se guarda en el Nodo
	 * @param siguiente Enlace al siguiente Nodo
	 */
	public Nodo(T dato, Nodo<T> siguiente) {
		super();
		this.dato = dato;
		this.siguiente = siguiente;
	}
	
	/**
	 * Constructor de la clase Nodo
	 * @param dato Elemento que se guarda en el Nodo
	 */
	public Nodo(T dato) {
		super();
		this.dato = dato;
	}
	
	/**
	 * Constructor de la clase Nodo
	 */
	public Nodo() { }

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
	
	@Override
	public String toString() {
		return dato.toString();
	}
	
}