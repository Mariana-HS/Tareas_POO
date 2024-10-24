package menu;
import hospital.Hospital;
import usuarios.Usuario;
import usuarios.administrador.Administrador;
import usuarios.medicos.Medico;
import usuarios.pacientes.Paciente;
import usuarios.utils.Rol;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    private Hospital hospital = new Hospital();


    public void login() {
        int intentosMaximos = 5, intentosUsuario = 0;

        while (intentosUsuario < intentosMaximos) {
            System.out.println("\n     --BIENVENIDO--\n");
            System.out.println("Inicia sesión para continuar");

            System.out.print("Ingresa tu usuario: \n");
            String usuario = scanner.nextLine();

            System.out.print("Ingresa tu contraseña: ");
            String contraseña = scanner.nextLine();

            Usuario usuarioEnSesion = hospital.validarInicioSesion(usuario, contraseña);

            if (usuarioEnSesion instanceof Usuario) {
                //Sesion ha sido existosa
                if (usuarioEnSesion.getRol() == Rol.PACIENTE) {
                    //Mostrar menu paciente
                    Paciente pacienteEnSesion = (Paciente) usuarioEnSesion;
                    MenuPaciente menuPaciente= new MenuPaciente();
                    int opcion=0;
                    while(opcion != 4){
                        opcion= menuPaciente.mostrarmenu();
                        menuPaciente.procesarDatosMenu(opcion, hospital, pacienteEnSesion);
                    }
                    intentosUsuario = 0;
                } else if (usuarioEnSesion.getRol() == Rol.MEDICO) {
                    //mostrar menu medico
                    Medico medicoEnSesion = (Medico) usuarioEnSesion;
                    MenuMedico menuMedico= new MenuMedico();
                    int opcion=0;
                    while(opcion != 7){
                        opcion= menuMedico.mostrarmenu();
                        menuMedico.procesarDatosMenu(opcion,medicoEnSesion, hospital);

                    }
                    //this.mostrarMenuMedico(medicoEnSesion);
                    intentosUsuario = 0;
                } else {
                    Administrador administradorEnSesion = (Administrador) usuarioEnSesion;
                    // this.mostrarMenu(administradorEnSesion);
                    MenuAdministrador menuAdministrador= new MenuAdministrador();
                    int opcion=0;
                    while(opcion != 16){
                        opcion= menuAdministrador.mostrarMenu();
                        menuAdministrador.procesarDatosMenu(opcion,administradorEnSesion,hospital);
                    }
                    intentosUsuario = 0;
                }
            } else {
                intentosUsuario = mostrarErrorInicioSesion(intentosUsuario);
            }

        }
        System.out.println("Intentos máximos permitidos");
    }

    private int mostrarErrorInicioSesion(int intentosUsaurio) {
        System.out.println("Usuario o contraseña incorrectos,intenta de nuevo");
        return intentosUsaurio + 1;
    }

    private void mostrarMenuPaciente(Paciente pacienteEnSesion) {

    }

    private void mostrarMenuMedico(Medico medicoEnSesion) {

    }

    private void mostrarMenu(Administrador administradorEnSesion) {


    }
}