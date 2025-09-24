package Laboratorio4.Actividad2.Polimorfismo;

public class Pez extends Animal{
    @Override
    public String sonido() {
        return "glu glu";
    }
    @Override
    public String comoSeDesplaza() {
        return "nada";
    }
}
