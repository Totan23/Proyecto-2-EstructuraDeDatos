/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */package Main;

import EDD.HashTable;
import EDD.MonticuloBinario;
import EDD.NodoUsuario;
import Interfaces.VentanaPrincipal;
import static Interfaces.VentanaPrincipal.montBinario;
import static Interfaces.VentanaPrincipal.table;

/**
 *
 * @author jonathanpizzurro
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashTable hash = new HashTable();
        MonticuloBinario montBinario = new MonticuloBinario(300);
        VentanaPrincipal mainFrame = new VentanaPrincipal(hash,montBinario);
        mainFrame.setVisible(true);
            
//        HashTable t = new HashTable();
//        t.imprimir();
        
        
        
        
        
        
        
//        MonticuloBinario binaryHeap = new MonticuloBinario(10);
//
//        // Agregar elementos al montículo
//        binaryHeap.add(15);
//        binaryHeap.add(10);
//        binaryHeap.add(20);
//        binaryHeap.add(5);
//
//        // Mostrar el elemento más pequeño
//        System.out.println("Elemento más pequeño: " + binaryHeap.peek());
//
//        // Eliminar y mostrar el elemento más pequeño
//        System.out.println("Elemento eliminado: " + binaryHeap.poll());
//        System.out.println("Nuevo elemento más pequeño: " + binaryHeap.peek());
//
//        // Agregar más elementos y probar nuevamente
//        binaryHeap.add(2);
//        System.out.println("Elemento más pequeño después de agregar más elementos: " + binaryHeap.peek());
    }
}
