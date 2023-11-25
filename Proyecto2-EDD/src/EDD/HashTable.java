/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Asus
 */
public class HashTable {

    public NodoUsuario[] usuarios;
    public int capacidad;

    public HashTable() {
        this.usuarios = new NodoUsuario[150];
        this.capacidad = 0;
    }

    public int calcHash(String usuario) {
        int hash = 0;
        for (int i = 0; i < usuario.length(); i++) {
            hash += (int) usuario.charAt(i) * i;
        }

        hash = hash % 149;
        return hash;
    }

    public void insertarUser(String nombreUsuario, String Prioridad) {
        int hash = calcHash(nombreUsuario);
        if (usuarios[hash] == null) {
            usuarios[hash] = new NodoUsuario(nombreUsuario, Prioridad);
        } else {
            int contador = 1;
            while (true) {
                if (usuarios[hash] == null) {
                    usuarios[hash] = new NodoUsuario(nombreUsuario, Prioridad);
                    break;
                }
                if (capacidad == 150 || contador == 150) {
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

    public int BuscarUser(String usuario) {

        int hash = calcHash(usuario);
        if (usuarios[hash] == null) {
            return -1;
        } else {
            if (usuarios[hash].nombre.equals(usuario)) {
                return hash;
            } else {
                int cont = 1;
                while (true) {

                    if ((usuarios)[hash].nombre.equals(usuario)) {
                        return hash;
                    } else {
                        if (hash == 149) {
                            hash = 0;
                        } else {
                            hash++;
                        }
                        if (cont == 150) {
                            break;
                        } else {
                            cont++;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public void eliminarUsuario(String usuario) {
        int n = BuscarUser(usuario);
        if (n != -1) {
            this.usuarios[n] = null;
        }
    }

    public void imprimir() {

        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                System.out.println("Nombre de Usuario: " + usuarios[i].getNombre());
                System.out.println("Prioridad: " + usuarios[i].getPrioridad());
                System.out.println("Posicion: " + i);

                for (int j = 0; j < 11; j++) {
                    if (usuarios[i].docs[j] != null) {
                        System.out.println("Documento: " + usuarios[i].docs[j].titulo);
                    }
                }
            }
        }
    }

    public void insertarDocumento(String usuario, String titulo, String tamano, String tipo, int tiempo) {
        int index = this.BuscarUser(usuario);
        if (index != -1 && this.usuarios[index] != null) {
            System.out.println(index);
            NodoDocumento d = new NodoDocumento(titulo, tamano, tipo, tiempo);
            this.usuarios[index].agregarDocumento(d);
        }
        else{
            
        }
    }

    public void eliminarDocumento(String usuario, String titulo) {
        int index = this.BuscarUser(usuario);
        this.usuarios[index].eliminarDoc(titulo);
    }
    
    public String imprimirUsuario(String data){
        for (int i = 0; i < this.usuarios.length; i++) {
            if (this.usuarios[i] != null) {
                data += this.usuarios[i].getNombre();
                for (int j = 0; j < this.usuarios[i].docs.length; j++) {
                    if (this.usuarios[i].docs[i] != null) {
                        data += this.usuarios[i].docs[i].getTitulo() + "\n";
                    }
                }
            }
        }
        return data;
    }
}
