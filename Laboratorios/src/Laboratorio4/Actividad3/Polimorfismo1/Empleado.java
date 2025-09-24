package Laboratorio4.Actividad3.Polimorfismo1;

public abstract class Empleado {
    String nombre;
    Empleado(String nombre) {
        this.nombre = nombre;
    }
    public abstract void CalcularSalarioMensual();
    public String toString(){
        return "nombre: " + nombre;
    }
    public Empleado(){
        super();
    }
}