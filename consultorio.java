package consultorios;

import java.util.Random;

public class Consultorio {
    public String id;
    public int piso;
    public int numeroConsultorio;

    public Consultorio(String id, int piso, int numeroConsultorio) {
        this.id = id;
        this.piso = piso;
        this.numeroConsultorio = numeroConsultorio;
    }

    public String getId() {
        return id;
    }

    public int getPiso() {
        return piso;
    }

    public int getNumeroConsultorio() {
        return numeroConsultorio;
    }

    public String mostrarDatos(){
        String datos = String.format("Id del consultorio: %s, Piso: %s, No. de consultorio: %s", this.id, this.piso, this.numeroConsultorio);
        return datos;
    }
}