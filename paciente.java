package usuarios.pacientes;

import expediente.Expediente;
import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;

public class Paciente extends Usuario {
    public String tipoSangre;
    public char sexo;
    public ArrayList<Expediente> expedientes;


    public Paciente( String id, String nombre, String apellidos, LocalDate fechaNacimiento, String tipoSangre, char sexo, String telefono, String contrenia) {
        super(id, nombre, apellidos, fechaNacimiento, telefono, contrenia, Rol.PACIENTE);
        this.tipoSangre = tipoSangre;
        this.sexo = sexo;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public char getSexo() {
        return sexo;
    }

    public String mostrarDatos(){
        String datos = String.format("ID: %s, NOMBRE: %s, APELLIDOS: %s, FECHA NACIMIENTO: %s, TIPO DE SANGRE: %s, SEXO: %s, TELEFONO: %s", this.id, this.nombre, this.apellidos, this.fechaNacimiento, this.tipoSangre, this.sexo, this.telefono, this.tipoSangre, this.sexo, this.telefono);
        return datos;
    }

    public void registrarExpediente(Expediente expediente){
        this.expedientes.add(expediente);
    }
}