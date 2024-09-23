package consultas;

import medicos.Medico;
import pacientes.Paciente;
import consultorios.Consultorio;


public class Consulta {
    public int id;
    public String fechaHora;
    public Paciente paciente;
    public Medico medico;
    public Consultorio consultorio;

    public Consulta(int id, String fechaHora, Paciente paciente, Medico medico, Consultorio consultorio) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.paciente = paciente;
        this.medico = medico;
        this.consultorio = consultorio;
    }

    public int getId() {
        return id;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public String mostrarDatos(){
        String datos = String.format("Id: %d, Fecha y hora de la consulta: %s, Paciente: %s, Medico asignado: %s, Consultorio: %d", this.id, this.fechaHora, this.paciente, this.medico, this.consultorio);
        return datos;
    }
}