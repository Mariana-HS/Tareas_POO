package usuarios.pacientes;

import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDate;

public class Paciente extends Usuario {

    public String tipoSangre;
    public char sexo;



    public Paciente( String id, String nombre, String apellidos, LocalDate fechaNacimiento, String tipoSangre, char sexo, String telefono, String contrasenia) {
       super(id, nombre, apellidos, fechaNacimiento, telefono, contrasenia, Rol.PACIENTE);
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
        String datos = String.format("ID: %s, Nombre: %s, Apellidos: %s, Fecha de Nacimiento: %s, Tipo de Sangre: %s, Sexo: %s, Teléfono: %s", this.id, this.nombre, this.apellidos, this.fechaNacimiento, this.tipoSangre, this.sexo, this.telefono, this.tipoSangre, this.sexo, this.telefono);
        return datos;
    }
}