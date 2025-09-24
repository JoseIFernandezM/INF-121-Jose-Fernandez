package Laboratorio4.Actividad2.Polimorfismo;

public class Serpiente extends Animal{
    @Override
    public String sonido() {
        return "¡sssss!";
    }

    @Override
    public String comoSeDesplaza() {
        return "Se arrastra por el suelo";
    }
}
