package Laboratorio4.Actividad3.Polimorfismo1;

public class EmpleadoTiempoHorario extends Empleado {
    double horasTrabajadas;
    double tarifaPorHora;
    EmpleadoTiempoHorario(String nombre, double horasTrabajadas, double tarifaPorHora) {
        super(nombre);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
    }
    public void CalcularSalarioMensual(){}
    public String toString(){
        return "Horas trabajadas: " + horasTrabajadas + "Tarifa por hora: " + tarifaPorHora;
    }
}
