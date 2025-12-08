package ExamenFInalInf121;

public class Consulta {
        private int ci;
        private String nombrePaciente;
        private String apellidoPaciente;
        private int idMed;
        private int dia;
        private String mes;
        private int anio;

        public Consulta(int ci, String nombrePaciente, String apellidoPaciente,
                        int idMed, int dia, String mes, int anio) {
            this.ci = ci;
            this.nombrePaciente = nombrePaciente;
            this.apellidoPaciente = apellidoPaciente;
            this.idMed = idMed;
            this.dia = dia;
            this.mes = mes;
            this.anio = anio;
        }

        public int getIdMed() { return idMed; }
        public int getDia() { return dia; }
        public String getMes() { return mes; }
        public void setDia(int dia) { this.dia = dia; }

        public String getNombrePaciente() { return nombrePaciente; }
        public String getApellidoPaciente() { return apellidoPaciente; }

        public void mostrar() {
            System.out.println(nombrePaciente + " " + apellidoPaciente +
                    " CI:" + ci + "  Fecha: " + dia + "/" + mes + "/" + anio +
                    "  Med:" + idMed);
        }
    }

