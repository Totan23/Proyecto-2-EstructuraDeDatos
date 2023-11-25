/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import java.util.Arrays;

/**
 *
 * @author jonathanpizzurro
 */
public class MonticuloBinario {

    public NodoDocumento[] monticulo;
    public int tamaño;
    public int capacidad;

    public MonticuloBinario(int capacidad) {
        this.capacidad = capacidad;
        this.tamaño = 0;
        this.monticulo = new NodoDocumento[capacidad];
    }

    private int obtenerIndicePadre(int indiceHijo) {
        return (indiceHijo - 1) / 2;
    }

    private int obtenerIndiceHijoIzquierdo(int indicePadre) {
        return 2 * indicePadre + 1;
    }

    private int obtenerIndiceHijoDerecho(int indicePadre) {
        return 2 * indicePadre + 2;
    }

    private boolean tieneHijoIzquierdo(int indice) {
        return obtenerIndiceHijoIzquierdo(indice) < tamaño;
    }

    private boolean tieneHijoDerecho(int indice) {
        return obtenerIndiceHijoDerecho(indice) < tamaño;
    }

    private boolean tienePadre(int indice) {
        return obtenerIndicePadre(indice) >= 0;
    }

    private NodoDocumento hijoIzquierdo(int indice) {
        return monticulo[obtenerIndiceHijoIzquierdo(indice)];
    }

    private NodoDocumento hijoDerecho(int indice) {
        return monticulo[obtenerIndiceHijoDerecho(indice)];
    }

    private NodoDocumento padre(int indice) {
        return monticulo[obtenerIndicePadre(indice)];
    }

    private void intercambiar(int indiceUno, int indiceDos) {
        NodoDocumento temp = monticulo[indiceUno];
        monticulo[indiceUno] = monticulo[indiceDos];
        monticulo[indiceDos] = temp;
    }

    private void asegurarCapacidadExtra() {
        if (tamaño == capacidad) {
            monticulo = Arrays.copyOf(monticulo, capacidad * 2);
            capacidad *= 2;
        }
    }

    public NodoDocumento verCima() {
        if (tamaño == 0) {
            throw new IllegalStateException();
        }
        return monticulo[0];
    }

    public NodoDocumento extraerMinimo() {
        if (tamaño != 0) {
            
        NodoDocumento elemento = monticulo[0];
        monticulo[0] = monticulo[tamaño - 1];
        tamaño--;
        reorganizarHaciaAbajo();
        return elemento;}
        else{
            System.out.println("null");
            return null;
        }
    }

    public void insertar(NodoDocumento elemento) {
        asegurarCapacidadExtra();
        monticulo[tamaño] = elemento;
        tamaño++;
        reorganizarHaciaArriba();
    }

    public void reorganizarHaciaArriba() {
        int indice = tamaño - 1;
        while (tienePadre(indice) && padre(indice).etiquetaDeTiempo > monticulo[indice].etiquetaDeTiempo) {
            intercambiar(obtenerIndicePadre(indice), indice);
            indice = obtenerIndicePadre(indice);
        }
    }

    public void reorganizarHaciaAbajo() {
        int indice = 0;
        while (tieneHijoIzquierdo(indice)) {
            int indiceHijoMenor = obtenerIndiceHijoIzquierdo(indice);
            if (tieneHijoDerecho(indice) && hijoDerecho(indice).etiquetaDeTiempo < hijoIzquierdo(indice).etiquetaDeTiempo) {
                indiceHijoMenor = obtenerIndiceHijoDerecho(indice);
            }

            if (monticulo[indice].etiquetaDeTiempo < monticulo[indiceHijoMenor].etiquetaDeTiempo) {
                break;
            } else {
                intercambiar(indice, indiceHijoMenor);
            }
            indice = indiceHijoMenor;
        }
    }
    
    public String imprimirMonticulo(String doc){
        NodoDocumento minimo = this.extraerMinimo();
        if (minimo != null) {
            doc += minimo.getTitulo() + ", " + minimo.getEtiquetaDeTiempo() + "\n";
            doc = imprimirMonticulo(doc);
            this.insertar(minimo);
        }
        return doc;
    }
    
    
}
