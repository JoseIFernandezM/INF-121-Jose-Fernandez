package Laboratorio4.Actividad2.Polimorfismo;

public class Delfin extends Animal{
    @Override
    public String sonido() {
        return "hihihihih";
    }

    @Override
    public String comoSeDesplaza() {
        return "nada y salta";
    }
}
