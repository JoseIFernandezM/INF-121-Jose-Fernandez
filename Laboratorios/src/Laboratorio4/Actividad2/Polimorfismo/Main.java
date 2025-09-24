package Laboratorio4.Actividad2.Polimorfismo;

public class Main {
    public static void main(String[] args){
        Animal perro = new Perro();
        Animal serpiente = new Serpiente();
        Animal pez = new Pez();
        Animal delfin = new Delfin();

        Animal[] animales = { perro, serpiente, pez,  delfin};

        for (Animal a : animales) {
            System.out.println(a.getClass().getSimpleName() + " sonido: " + a.sonido());
            System.out.println(a.getClass().getSimpleName() + " desplazamiento: " + a.comoSeDesplaza());
        }
    }
}
