package Laboratorio5;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Autor a1 = new Autor("Jose Fernandez", "Bolivia");
        Autor a2 = new Autor("Ignacio Maldonado", "Colombia");

        List<String> p1 = Arrays.asList(
                "Cap.1: Comienzo...",
                "Cap.2: Desarrollo...",
                "Cap.3: Final..."
        );
        Libro l1 = new Libro("La historia de pepe", "ISBN-001", p1);
        l1.setAutor(a1);

        List<String> p2 = Arrays.asList(
                "Cap.1: inicio...",
                "Cap.2: Capitulo 1...",
                "Cap.3: El fin..."
        );
        Libro l2 = new Libro("Cien Años de estudio", "ISBN-002", p2);
        l2.setAutor(a2);

        Estudiante e1 = new Estudiante("20250001", "Juanito alcachofa");

        Biblioteca biblio = new Biblioteca(
                "Biblioteca UMSA",
                "Lunes a Viernes",
                "08:30",
                "18:30"
        );

        biblio.agregarAutor(a1);
        biblio.agregarAutor(a2);
        biblio.agregarLibro(l1);
        biblio.agregarLibro(l2);

        biblio.mostrarEstado();

        // prestar libro
        Prestamo pr1 = biblio.prestarLibro(e1, l2);

        biblio.mostrarEstado();

        // leer libro
        l2.leer();

        //prestar el mismo libro
        Estudiante e2 = new Estudiante("20250002", "Luis Soto");
        biblio.prestarLibro(e2, l2);

        biblio.cerrarBiblioteca();

        biblio.mostrarEstado();
    }
}