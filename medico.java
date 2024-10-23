package usuarios.medicos;


import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDate;

public class Medico extends Usuario {

    private  String rfc;

    public Medico(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String rfc,String contrasenia) {
        super(id, nombre, apellidos, fechaNacimiento, telefono, contrasenia, Rol.MEDICO);
        this.rfc = rfc;
    }


    public String getRfc() {
        return rfc;
    }
@Override
    public String mostrarInformacion(){
        return super.mostrarInformacion() + String.format("\nRFC: %s", this.rfc);
    }
}