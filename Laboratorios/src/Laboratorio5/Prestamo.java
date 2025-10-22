package Laboratorio5;
import java.time.LocalDate;
class Prestamo {
    private final LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private final Estudiante estudiante;
    private final Libro libro;

    public Prestamo(Estudiante estudiante, Libro libro) {
        this.estudiante = estudiante;
        this.libro = libro;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = null;
    }

    public void devolverHoy() {
        this.fechaDevolucion = LocalDate.now();
    }

    public void mostrarInfo() {
        System.out.println("Préstamo:");
        System.out.println("  Estudiante: " + estudiante.getNombre() + " [" + estudiante.getCodigo() + "]");
        System.out.println("  Libro: " + libro.getTitulo() + "(ISBN " + libro.getIsbn() + ")");
        System.out.println("  Fecha préstamo: " + fechaPrestamo);
        System.out.println("  Fecha devolución: " + (fechaDevolucion == null ? "(pendiente)" : fechaDevolucion));
    }

    public Libro getLibro() { return libro; }
    public Estudiante getEstudiante() { return estudiante; }
}