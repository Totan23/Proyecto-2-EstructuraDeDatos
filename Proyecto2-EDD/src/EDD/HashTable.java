/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author jonathanpizzurro
 */
public class HashTable {

    public NodoUsuario[] usuarios;
    public int capacidad;

    public HashTable() {
        this.usuarios = new NodoUsuario[150];
        this.capacidad = 0;
    }

    public int calcularHash(String usuario) {
        int hash = 0;
        for (int i = 0; i < usuario.length(); i++) {
            hash += (int) usuario.charAt(i) * i;

        }

        hash = hash % 150;

        return hash;
    }

    public void Insertar(String usuario, String prioridad) {
        int hash = calcularHash(usuario);
        if (usuarios[hash] == null) {
            usuarios[hash] = new NodoUsuario(usuario, prioridad);
        } else {
            while (true) {
                if (usuarios[hash] == null) {
                    usuarios[hash] = new NodoUsuario(usuario, prioridad);
                    break;
                }
                if (capacidad == 150) {
                    break;
                }
                if (hash == 149) {
                    hash = 0;
                } else {
                    hash++;
                }
            }
        }
    }

    public int buscar(String usuario) {
        int contador = 1;
        int hash = calcularHash(usuario);

        if (usuarios[hash] == null) {
            return -1;

        } else {
            if (usuarios[hash].nombre.equals(usuario)) {
                return hash;
            } else {
                while (true) {

                    if (usuarios[hash].nombre.equals(usuario)) {
                        return hash;
                    } else {
                        if (hash == 149) {
                            hash = 0;
                        } else {
                            hash++;
                        }
                        if (contador == 150) {
                            break;
                        } else {
                            contador++;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public void eliminar(String usuario) {
        int pos = buscar(usuario);
        if (pos != -1) {
            this.usuarios[pos] = null;
        }
    }

    public void imprimir() {
        System.out.println("Tabla de Dispersión:");
        System.out.println("----------------------------");
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                System.out.println("Posición " + i + ":");
                System.out.println("Nombre de Usuario: " + usuarios[i].getNombre());
                System.out.println("Prioridad: " + usuarios[i].getPrioridad());
                System.out.println("----------------------------");
            }
        }
    }
}
