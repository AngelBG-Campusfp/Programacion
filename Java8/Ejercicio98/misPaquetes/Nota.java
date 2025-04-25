package misPaquetes;

import java.io.*;

// Clase Nota
class Nota {
    private String titulo;
    private String contenido;

    public Nota(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void guardarEnArchivo() throws IOException {
        FileWriter escritor = new FileWriter(titulo + ".txt");
        escritor.write(contenido);
        escritor.close();
    }
}


