package Laboratorio4.Actividad3.Polimorfismo2;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Figura[] figuras = new Figura[5];
        Random random = new Random();

        for (int i = 0; i < figuras.length; i++){
            int tipo = random.nextInt(2) + 1;
            String color = colorAleatorio(random);

            if(tipo == 1){
                double lado = 1 + random.nextInt(20);
                figuras[i] = new Cuadrado(lado, color);
            }
            else {
                double radio = 1 + random.nextInt(20);
                figuras[i] = new Cuadrado(radio, color);
            }
        }
        System.out.println("figuras");

        for (Figura f: figuras){
            System.out.println(f.toString());
            System.out.println("area: " + f.area());
            System.out.println("perimetro: " + f.perimetro());
            if (f instanceof Coloreado){
                Coloreado c = (Coloreado) f;
                System.out.println("Como colorear: " + c.comoColorear());
            }
        }
    }
    private static String colorAleatorio(Random rnd) {
        String[] colores = {"Rojo", "Verde", "Azul", "Amarillo", "Negro"};
        return colores[rnd.nextInt(colores.length)];
    }
}
