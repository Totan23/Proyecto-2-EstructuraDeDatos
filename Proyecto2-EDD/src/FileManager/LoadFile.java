/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileManager;
import EDD.HashTable;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author jonathanpizzurro
 */
public class LoadFile {
    public static HashTable tabla;
    public LoadFile(HashTable t){
        this.tabla  = t;
    }

    public static void leerCSV(HashTable td) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar Archivo CSV");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos CSV", "csv"));

        int seleccion = fileChooser.showOpenDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try {
                BufferedReader lector = new BufferedReader(new FileReader(archivo));
                String linea;
                while ((linea = lector.readLine()) != null) {
                    leerLinea(linea, td);
                }
                lector.close();
                JOptionPane.showMessageDialog(null, "Cargado Exitosamente");

            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún archivo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private static void leerLinea(String linea, HashTable hs) {
        // Dividir la línea en partes basadas en la coma
        linea = linea.replace("\"", "");
        String[] partes = linea.split(",");
        

        // Si la línea contiene 2 partes, es una línea de datos válida
        if (partes.length == 2) {
            
            String usuario = partes[0].trim();
            String tipo = partes[1].trim();
            
            hs.insertarUser(usuario, tipo);
            System.out.println("Usuario: " + usuario + ", Tipo: " + tipo);
           
        }
    }
}
