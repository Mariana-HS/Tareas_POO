package consultas;

import consultas.utils.Status;
import usuarios.medicos.Medico;
import usuarios.pacientes.Paciente;
import consultorios.Consultorio;

import java.time.LocalDateTime;


public class Consulta {

    public int id;
    public LocalDateTime fechaHora;
    public Paciente paciente;
    public Medico medico;
    public Consultorio consultorio;
    public Status Status;

   /* public Consulta(int id, LocalDateTime fechaHora, Paciente paciente, Medico medico, Consultorio consultorio) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.paciente = paciente;
        this.medico = medico;
        this.consultorio = consultorio;
    }*/

    public Consulta(String idConsulta, LocalDateTime fechaHora, Paciente paciente, Medico medico, Consultorio consultorio) {
        this.fechaHora = fechaHora;
        this.paciente = paciente;
        this.medico = medico;
        this.consultorio = consultorio;
        this.Status= consultas.utils.Status.PENDIENTE;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getFechaHora() {
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

    public consultas.utils.Status getStatus() {
        return Status;
    }

    public String mostrarDatos(){

        String datos = String.format("ID: %s, Fecha/Hora: %s, ID Paciente: %s, Nombre Paciente: %s ID Médico: %s, Nombre Médico: %s Piso Consultorio: %d, Número Consultorio %d", id, fechaHora, paciente.getId(),paciente.getNombre(), medico.getId(),medico.getNombre(), consultorio.getPiso(),consultorio.getNumeroConsultorio());
        return datos;
    }
}