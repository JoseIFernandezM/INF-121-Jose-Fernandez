package Laboratorio4.Actividad3.Polimorfismo2;

public abstract class Figura {
    private String color;

    public Figura(){}

    public Figura(String color){
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "color: " + color;
    }
    public abstract double area();
    public abstract double perimetro();
}
