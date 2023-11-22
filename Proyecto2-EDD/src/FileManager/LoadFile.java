/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileManager;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author jonathanpizzurro
 */
public class LoadFile {

    public static File leerCSV() {
        JFrame frame = new JFrame();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            readFile(selectedFile);
            return selectedFile;
        }
        return null;
    }

    private static void readFile(File file) {
        try ( BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Dividir la línea en partes basadas en la coma
                String[] parts = line.split(",");

                // Si la línea contiene 2 partes, es una línea de datos válida
                if (parts.length == 2) {
                    String usuario = parts[0];
                    String tipo = parts[1];
                    System.out.println("Usuario: " + usuario + ", Tipo: " + tipo);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
