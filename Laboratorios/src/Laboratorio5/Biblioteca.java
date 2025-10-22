package Laboratorio5;
import java.util.*;

class Biblioteca {
    private final String nombre;
    // biblioteca referencia libros y autores
    private final List<Libro> librosDisponibles = new ArrayList<>();
    private final List<Autor> autoresRegistrados = new ArrayList<>();
    private final List<Prestamo> prestamosActivos = new ArrayList<>();
    // clase interna
    public static class Horario {
        private final String diasApertura;
        private final String horaApertura;
        private final String horaCierre;

        public Horario(String diasApertura, String horaApertura, String horaCierre) {
            this.diasApertura = diasApertura;
            this.horaApertura = horaApertura;
            this.horaCierre = horaCierre;
        }

        public void mostrarHorario() {
            System.out.println("Horario: " + diasApertura + " — " + horaApertura + " a " + horaCierre);
        }
    }

    private final Horario horario;

    public Biblioteca(String nombre, String dias, String horaApertura, String horaCierre) {
        this.nombre = nombre;
        this.horario = new Horario(dias, horaApertura, horaCierre);
    }

    public void agregarLibro(Libro libro) {
        if (!librosDisponibles.contains(libro)) {
            librosDisponibles.add(libro);
        }
    }

    public void agregarAutor(Autor autor) {
        if (!autoresRegistrados.contains(autor)) {
            autoresRegistrados.add(autor);
        }
    }

    public Prestamo prestarLibro(Estudiante estudiante, Libro libro) {
        if (!librosDisponibles.contains(libro)) {
            System.out.println("No se puede prestar: el libro no pertenece a esta biblioteca.");
            return null;
        }
        for (Prestamo p : prestamosActivos) {
            if (p.getLibro() == libro) {
                System.out.println("No se puede prestar: el libro ya está prestado.");
                return null;
            }
        }
        Prestamo prestamo = new Prestamo(estudiante, libro);
        prestamosActivos.add(prestamo);
        System.out.println("Préstamo realizado: " + libro.getTitulo() +  "para " + estudiante.getNombre());
        return prestamo;
    }

    public void mostrarEstado() {
        System.out.println("Estado de la Biblioteca: " + nombre);
        horario.mostrarHorario();

        System.out.println("Libros disponibles (" + librosDisponibles.size() + "):");
        for (Libro l : librosDisponibles) {
            String autorStr = (l.getAutor() != null) ? (" — Autor: " + l.getAutor().getNombre()) : "";
            System.out.println(" - " + l.getTitulo() + " (ISBN " + l.getIsbn() + ")" + autorStr);
        }

        System.out.println("Autores registrados (" + autoresRegistrados.size() + "):");
        for (Autor a : autoresRegistrados) a.mostrarInfo();

        System.out.println("Préstamos activos (" + prestamosActivos.size() + "):");
        if (prestamosActivos.isEmpty()) {
            System.out.println(" (ninguno)");
        } else {
            for (Prestamo p : prestamosActivos) p.mostrarInfo();
        }
    }

    public void cerrarBiblioteca() {
        System.out.println("La biblioteca " + nombre + " ha cerrado. Todos los préstamos se anulan.");
        prestamosActivos.clear();
    }
}
