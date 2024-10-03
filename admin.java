package usuarios.admin;

import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDate;

public class Admin extends Usuario {

    private int sueldo;
    private String rfc;
    public int añosTrabajados;

    public Admin(String id, String nombre, String apellidos, LocalDate fechaNacimiento,String contrasenia, String telefono, int sueldo, String rfc, int añosTrabajados) {
        super(id, nombre, apellidos, fechaNacimiento, telefono, contrasenia, Rol.ADMIN);
        this.sueldo = sueldo;
        this.rfc = rfc;
        this.añosTrabajados = añosTrabajados;
    }

    public int getAñosTrabajados() {
        return añosTrabajados;
    }

    public String getRfc() {
        return rfc;
    }

    public int getSueldo() {
        return sueldo;
    }
}
