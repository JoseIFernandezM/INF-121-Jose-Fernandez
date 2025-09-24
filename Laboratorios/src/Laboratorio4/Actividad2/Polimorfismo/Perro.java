package Laboratorio4.Actividad2.Polimorfismo;

public class Perro extends Animal{
    @Override
    public String sonido() {
        return "¡Guau!";
    }

    @Override
    public String comoSeDesplaza() {
        return "Camina, corre o salta";
    }
}
