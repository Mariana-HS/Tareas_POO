package usuarios.administrador;

import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDate;

public class Administrador extends Usuario {

    public String rfc;
    public int añosTrabajados;
    public double sueldo;

    public Administrador(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String contraseña, String rfc, int añosTrabajados, double sueldo) {
        super(id, nombre, apellidos, fechaNacimiento, telefono,contraseña, Rol.ADMIN);
        this.rfc = rfc;
        this.añosTrabajados = añosTrabajados;
        this.sueldo = sueldo;
    }

    public String getRfc() {
        return rfc;
    }

    public int getAñosTrabajados() {
        return añosTrabajados;
    }

    public double getSueldo() {
        return sueldo;
    }

    public String mostrarDatos() {
        String datos = String.format(
                "ID: %s, Nombre: %s, Apellidos: %s, Fecha de Nacimiento: %s, Teléfono: %s, RFC: %s, Años trabajados: %d, Sueldo: %.2f",
                id, nombre, apellidos, fechaNacimiento, telefono, rfc, añosTrabajados, sueldo
        );
        return datos;
    }

}
