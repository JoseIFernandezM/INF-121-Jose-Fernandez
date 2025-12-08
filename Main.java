package ExamenFInalInf121;

public class Main {
    public static void main(String[] args) {
        Consultorio cons = new Consultorio("consultas.json", "medicos.json");

        cons.altaInicial();
        cons.mostrarTodo();

        cons.bajaMedico("Juan", "Perez");
        cons.mostrarTodo();

        cons.cambiarNavidadAnioNuevo();
        cons.mostrarTodo();
        
        cons.mostrarPacientesCumple(19, "JULIO");
    }
}