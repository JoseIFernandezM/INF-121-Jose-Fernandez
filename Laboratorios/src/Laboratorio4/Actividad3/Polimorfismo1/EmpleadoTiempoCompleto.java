package Laboratorio4.Actividad3.Polimorfismo1;

public class EmpleadoTiempoCompleto extends Empleado {
    @Override
    public void CalcularSalarioMensual() {
        double salarioMensual = (salarioAnual/12);
    }
    double salarioAnual;
    public EmpleadoTiempoCompleto(String nombre, double salarioAnual) {
        super(nombre);
        this.salarioAnual = salarioAnual;
    }
    public String toString() {
        double salarioAnual = this.salarioAnual;
        return super.toString()+salarioAnual;
    }
}

