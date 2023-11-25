/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author jonathanpizzurro
 */
public class NodoUsuario {

    public String nombre;
    public String prioridad;
    public NodoDocumento[] docs;

    public NodoUsuario(String nombre, String prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.docs = new NodoDocumento[15];
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the prioridad
     */
    public String getPrioridad() {
        return prioridad;
    }

    /**
     * @param prioridad the prioridad to set
     */
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public void agregarDocumento(NodoDocumento doc) {
        for (int i = 0; i < docs.length; i++) {
            if (docs[i] == null) {
                docs[i] = doc;
                break;
            }
        }
    }

    public void eliminarDoc(String doc) {
        for (int i = 0; i < docs.length; i++) {
            if (docs[i] != null && docs[i].titulo.equals(doc)) {
                docs[i] = null;
                break;
            }
        }
    }
        
    public NodoDocumento buscarDoc(String titulo){
        for (int i = 0; i < docs.length; i++) {
            if(docs[i]!= null && docs[i].titulo.equals(titulo)){
                return docs[i];
            }
        }
        return null;
    }

}
