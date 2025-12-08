package ExamenFInalInf121;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

    public class Consultorio {

        private String consultas;
        private String medicos;

        public Consultorio(String consultas, String medicos) {
            this.consultas = consultas;
            this.medicos = medicos;
        }

        // inciso a
        public void altaInicial() {
            try {
                Gson gson = new Gson();
                List<Medico> listaMed = new ArrayList<>();
                listaMed.add(new Medico(1, "Jose ", "Fernandez", 2));
                listaMed.add(new Medico(2, "Ignacio", "Maldonado", 5));
                listaMed.add(new Medico(3, "Pepito", "Nacho", 3));

                String cadMed = gson.toJson(listaMed);
                FileWriter wMed = new FileWriter(this.medicos);
                wMed.write(cadMed);
                wMed.close();
                List<Consulta> listaCon = new ArrayList<>();
                listaCon.add(new Consulta(1, "Lionel",   "Messi", 1, 25, "DICIEMBRE", 2025));
                listaCon.add(new Consulta(2, "Luis",  "SUarez",  1,  1, "ENERO",     2026));
                listaCon.add(new Consulta(3, "Neymar",  "Jr", 1, 10, "MARZO",     2025));
                listaCon.add(new Consulta(4, "Pedro", "Picapiedra", 2, 19, "MARZO",     2025));
                listaCon.add(new Consulta(5, "Celia",  "Cruz", 2,  5, "MAYO",     2025));
                listaCon.add(new Consulta(6, "Mario", "Bros", 2, 25, "DICIEMBRE", 2025));
                listaCon.add(new Consulta(117, "Luis",   "Vega",   3,  1, "ENERO",     2026));
                listaCon.add(new Consulta(118, "Juan",  "Bautista",   3, 30, "NOVIEMBRE",      2025));
                listaCon.add(new Consulta(119, "Edman", "Lari",  3, 19, "OCTUBRE",     2025));

                String cadCon = gson.toJson(listaCon);
                FileWriter wCon = new FileWriter(this.consultas);
                wCon.write(cadCon);
                wCon.close();
                System.out.println("Alta");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private List<Medico> leerMedicos() throws IOException {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(this.medicos));
            Medico[] arr = gson.fromJson(reader, Medico[].class);
            reader.close();

            List<Medico> lista = new ArrayList<>();
            if (arr != null) {
                for (Medico m : arr) lista.add(m);
            }
            return lista;
        }

        private List<Consulta> leerConsultas() throws IOException {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(this.consultas));
            Consulta[] arr = gson.fromJson(reader, Consulta[].class);
            reader.close();

            List<Consulta> lista = new ArrayList<>();
            if (arr != null) {
                for (Consulta c : arr) lista.add(c);
            }
            return lista;
        }

        private void escribirMedicos(List<Medico> lista) throws IOException {
            Gson gson = new Gson();
            FileWriter w = new FileWriter(this.medicos);
            w.write(gson.toJson(lista));
            w.close();
        }

        private void escribirConsultas(List<Consulta> lista) throws IOException {
            Gson gson = new Gson();
            FileWriter w = new FileWriter(this.consultas);
            w.write(gson.toJson(lista));
            w.close();
        }

        // Inciso b
        public void bajaMedico(String nombreX, String apellidoY) {
            try {
                List<Medico> listaMed = leerMedicos();
                Integer idBorrar = null;

                Iterator<Medico> itM = listaMed.iterator();
                while (itM.hasNext()) {
                    Medico m = itM.next();
                    if (m.getNombreMed().equals(nombreX)
                            && m.getApellidoMed().equals(apellidoY)) {
                        idBorrar = m.getIdMed();
                        itM.remove();
                        break;
                    }
                }

                if (idBorrar == null) {
                    System.out.println("Medico no encontrado.");
                    return;
                }

                escribirMedicos(listaMed);

                List<Consulta> listaCon = leerConsultas();
                Iterator<Consulta> itC = listaCon.iterator();
                while (itC.hasNext()) {
                    Consulta c = itC.next();
                    if (c.getIdMed() == idBorrar) {
                        itC.remove();
                    }
                }
                escribirConsultas(listaCon);

                System.out.println("Medico consultas dados de baja.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // inciso c
        public void cambiarNavidadAnioNuevo() {
            try {
                List<Consulta> listaCon = leerConsultas();

                for (Consulta c : listaCon) {
                    boolean esNavidad =
                            c.getDia() == 25 && c.getMes().equals("DICIEMBRE");
                    boolean esAnioNuevo =
                            c.getDia() == 1 && c.getMes().equals("ENERO");

                    if (esNavidad || esAnioNuevo) {
                        c.setDia(c.getDia() + 1);
                    }
                }

                escribirConsultas(listaCon);
                System.out.println("Fechas modificadas para navidad/año nuevo.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // inciso d
        public void mostrarPacientesCumple(int diaCumple, String mesCumple) {
            try {
                List<Consulta> listaCon = leerConsultas();
                System.out.println("Pacientes en tu cumpleaños " +
                        diaCumple + "/" + mesCumple + ":");

                for (Consulta c : listaCon) {
                    if (c.getDia() == diaCumple && c.getMes().equals(mesCumple)) {
                        System.out.println("- " + c.getNombrePaciente() + " " +
                                c.getApellidoPaciente());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void mostrarTodo() {
            try {
                System.out.println(" Medicos ");
                for (Medico m : leerMedicos()) m.mostrar();
                System.out.println(" Consultas ");
                for (Consulta c : leerConsultas()) c.mostrar();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
