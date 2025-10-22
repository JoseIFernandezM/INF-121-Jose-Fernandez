package Laboratorio5;
import java.util.*;

class Libro {
    private final String titulo;
    private final String isbn;
    private final List<Pagina> paginas = new ArrayList<>();
    private Autor autor;

    // clase interna
    public static class Pagina {
        private final int numero;
        private final String contenido;

        public Pagina(int numero, String contenido) {
            this.numero = numero;
            this.contenido = contenido;
        }

        public void mostrarPagina() {
            System.out.println("Página " + numero + ": " + contenido);
        }

        public int getNumero() { return numero; }
    }
    public Libro(String titulo, String isbn, List<String> contenidosDePaginas) {
        this.titulo = titulo;
        this.isbn = isbn;
        int n = 1;
        for (String c : contenidosDePaginas) {
            this.paginas.add(new Pagina(n++, c));
        }
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void leer() {
        System.out.println("Leyendo " + titulo + " (ISBN " + isbn + ")");
        for (Pagina p : paginas) p.mostrarPagina();
        System.out.println("Fin de " + titulo);
    }

    public String getTitulo() { return titulo; }
    public String getIsbn() { return isbn; }
    public Autor getAutor() { return autor; }
}