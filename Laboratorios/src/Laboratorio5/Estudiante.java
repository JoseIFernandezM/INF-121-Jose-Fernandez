package Laboratorio5;

class Estudiante {
    private final String codigo;
    private final String nombre;

    public Estudiante(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public void mostrarInfo() {
        System.out.println("Estudiante: " + nombre + " [" + codigo + "]");
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
}