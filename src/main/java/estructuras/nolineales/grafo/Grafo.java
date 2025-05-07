package estructuras.nolineales.grafo;

import java.util.*;

/**
 * Clase que representa una estructura de datos tipo Grafo
 * @author caflorezvi
 *
 */
public class Grafo {

    private final Map<Integer, List<Integer>> adyacencias;

    public Grafo() {
        this.adyacencias = new HashMap<>();
    }

    /**
     * Agrega un nuevo vertice al grafo
     */
    public void agregarVertice(int v) {
        if (!adyacencias.containsKey(v)) {
            adyacencias.put(v, new ArrayList<>());
        }
    }

    /**
     * Agrega una arista entre dos vertices u y v
     */
    public void agregarArista(int u, int v) {
        agregarVertice(u); // asegura que existen
        agregarVertice(v);
        adyacencias.get(u).add(v);
    }

    /**
     * Elimina un vertice y todas sus aristas
     */
    public void eliminarVertice(int v) {
        adyacencias.remove(v);
        for (List<Integer> vecinos : adyacencias.values()) {
            vecinos.remove(Integer.valueOf(v));
        }
    }

    /**
     * Elimina una arista entre dos vertices u y v
     */
    public void eliminarArista(int u, int v) {
        List<Integer> vecinos = adyacencias.get(u);
        if (vecinos != null) {
            vecinos.remove(Integer.valueOf(v));
        }
    }

    /**
     * Imprime el grafo en consola
     */
    public void mostrarGrafo() {
        for (int v : adyacencias.keySet()) {
            System.out.print(v + " -> " + adyacencias.get(v) + "\n");
        }
    }

    /**
     * Realiza una busqueda en profundidad (DFS) desde un vertice de inicio
     * @param inicio
     * @param visitado
     */
    public void dfs(int inicio, Set<Integer> visitado) {
        if (visitado.contains(inicio)) return;
        visitado.add(inicio);
        System.out.println("Visitando: " + inicio);

        for (int vecino : adyacencias.get(inicio)) {
            dfs(vecino, visitado);
        }
    }


}
