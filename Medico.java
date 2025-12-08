package ExamenFInalInf121;

public class Medico {
    private int idMed;
    private String nombreMed;
    private String apellidoMed;
    private int aniosExperiencia;

    public Medico(int idMed, String nombreMed, String apellidoMed, int aniosExperiencia) {
        this.idMed = idMed;
        this.nombreMed = nombreMed;
        this.apellidoMed = apellidoMed;
        this.aniosExperiencia = aniosExperiencia;
    }

    public int getIdMed() { return idMed; }
    public String getNombreMed() { return nombreMed; }
    public String getApellidoMed() { return apellidoMed; }

    public void mostrar() {
        System.out.println("Medico " + idMed + ": " + nombreMed + " " +
                apellidoMed + " " + aniosExperiencia + " años exp.");
    }
}