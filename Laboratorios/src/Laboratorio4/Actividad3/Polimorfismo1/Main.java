package Laboratorio4.Actividad3.Polimorfismo1;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empleado[] empleados = new Empleado[5];
        for (int i = 0; i < empleados.length; i++){
            if (i<3){
                System.out.println("Empleados tiempo completo");
                String nombre = scanner.nextLine();
                double salarioAnual = scanner.nextDouble();
                scanner.nextLine();
                empleados[i] = new EmpleadoTiempoCompleto(nombre, salarioAnual);
            }
            else {
                System.out.println("Empleados tiempo horario");
                String nombre = scanner.nextLine();
                double horas = scanner.nextDouble();
                double tarifa = scanner.nextDouble();
                scanner.nextLine();
                empleados[i] = new EmpleadoTiempoHorario(nombre, horas, tarifa);
            }

        }
        System.out.println("empleados");
        for (Empleado e : empleados){
            System.out.println(e.toString());
        }
    }
}
