/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author jonathanpizzurro
 */
public class NodoDocumento {

    public String titulo;
    public String tamano;
    public String tipo;
    public int etiquetaDeTiempo;

    public NodoDocumento(String titulo, String tamano, String tipo, int tiempo) {
        this.titulo = titulo;
        this.tamano = tamano;
        this.tipo = tipo;
        this.etiquetaDeTiempo = tiempo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEtiquetaDeTiempo() {
        return etiquetaDeTiempo;
    }

    public void setEtiquetaDeTiempo(int etiquetaDeTiempo) {
        this.etiquetaDeTiempo = etiquetaDeTiempo;
    }

}
