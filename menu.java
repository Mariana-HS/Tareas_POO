package menu;

import consultas.Consulta;
import consultorios.Consultorio;
import hospital.Hospital;
import usuarios.Usuario;
import usuarios.admin.Admin;
import usuarios.medicos.Medico;
import usuarios.pacientes.Paciente;
import usuarios.utils.Rol;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    private Hospital hospital = new Hospital();



    public void login(){
        int intentosMaximos=5,intentosUsuario=0;

        while(intentosUsuario< intentosMaximos){
            System.out.println("\n     --BIENVENIDO--\n");
            System.out.println("Inicia sesión para continuar");

            System.out.print("Ingresa tu usuario: \n");
            String usuario =scanner.nextLine();

            System.out.print("Ingresa tu contraseña: ");
            String contraseña =scanner.nextLine();

            Usuario usuarioEnSesion= hospital.validarInicioSesion(usuario, contraseña);

            if(usuarioEnSesion instanceof Usuario){
                //Sesion ha sido existosa
                if (usuarioEnSesion.getRol()== Rol.PACIENTE){
                    //Mostrar menu paciente
                    Paciente pacienteEnSesion=(Paciente)usuarioEnSesion;
                    this.mostrarMenuPaciente(pacienteEnSesion);
                    intentosUsuario=0;
                }else if(usuarioEnSesion.getRol()==Rol.MEDICO){
                    //mostrar menu medico
                    Medico medicoEnSesion=(Medico)usuarioEnSesion;
                    this.mostrarMenuMedico(medicoEnSesion);
                    intentosUsuario=0;
                }else{
                    Admin administradorEnSesion=(Admin)usuarioEnSesion;
                    this.mostrarMenu(administradorEnSesion);
                    intentosUsuario=0;
                }
            }else{
                intentosUsuario= mostrarErrorInicioSesion(intentosUsuario);
            }

        }
        System.out.println("Intentos máximos permitidos");
    }

    private int mostrarErrorInicioSesion(int intentosUsaurio){
        System.out.println("Usuario o contraseña incorrectos,intenta de nuevo");
        return intentosUsaurio +1;
    }

    private void  mostrarMenuPaciente(Paciente pacienteEnSesion){
        int opcion=0;
        while (opcion!=4){
            System.out.println("\n*SISTEMA HOSPITAL*");
            System.out.println("1. Ver mis consultas");
            System.out.println("2. Ver mis datos");// tarea
            System.out.println("3. Ver mi expediente");
            System.out.println("4. Salir");
            System.out.println("Selecciona una opción");
            opcion=scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("-- Seleccionaste Ver Consultas --\n");
                    System.out.print("Ingresa tu ID: ");
                    String idPaciente=scanner.nextLine();
                    hospital.mostrarConsultasPaciente(idPaciente);
                    break;
                case 2:
                    System.out.println("-- Seleccionaste Ver mis Datos --\n");
                    System.out.print("Ingresa tu ID: ");
                    String idPaciente2=scanner.nextLine();
                    hospital.mostrarPacientePorId(idPaciente2);
                    break;
                case 3:
                    System.out.println("Hasta luego ");
                    break;
            }

        }
    }

    private  void mostrarMenuMedico(Medico medicoEnSesion){
        int opcion=0;
        while (opcion!=7){
            System.out.println("\n*SISTEMA HOSPITAL*");
            System.out.println("1. Ver mis Consultas Actuales");// TAREA
            System.out.println("2. Ver mis Datos");// TAREA
            System.out.println("3. Ver mis pacientes");
            System.out.println("4. Consultar paciente");
            System.out.println("5. Consultar expediente de paciente");
            System.out.println("6. Completar Consulta");
            System.out.println("7. Salir");


            System.out.println("Selecciona una opción");
            opcion=scanner.nextInt();
            scanner.nextLine();


            switch (opcion){
                case 1:
                    System.out.println("-- Seleccionaste Ver Mis Consultas --\n");
                    System.out.print("Ingresa tu ID: ");
                    String idMedico=scanner.nextLine();
                    hospital.mostrarConsultasMedico(idMedico);
                    break;
                case 2:
                    System.out.println("-- Seleccionaste Ver mis Datos --\n");
                    System.out.print("Ingresa tu ID: ");
                    String idMedico2=scanner.nextLine();
                    hospital.mostrarMedicoPorId(idMedico2);

                    break;
                case 3:
                    System.out.println("-- Seleccionaste Ver Pacientes --\n");
                    System.out.print("Ingresa tu ID:");
                    String idMedico3=scanner.nextLine();
                    hospital.mostrarPacientesMedico(idMedico3);

                    break;
                case 4:
                    System.out.println("Hasta luego");
                    break;
            }



        }
    }

    private void mostrarMenu (Admin administradorEnSesion) {

        int opcion = 0;
        while (opcion != 14) {
            System.out.println("\n*BIENVENIDO*");
            System.out.println("1. Registrar Paciente");
            System.out.println("2. Registrar Médico");
            System.out.println("3. Registrar Consultorio");
            System.out.println("4. Registrar Consultas");
            System.out.println("5. Mostrar Pacientes");
            System.out.println("6. Mostrar Médico");
            System.out.println("7. Mostrar Consultorios");
            System.out.println("8. Mostrar Consultas");
            System.out.println("9. Mostrar Paciente por ID");
            System.out.println("10.Mostrar Médico por ID");
            System.out.println("11.Mostrar Consultorios por ID");
            System.out.println("12.Listar Médico por ID");
            System.out.println("13.Listar Consultorio por ID");
            System.out.println("14.Salir");

            System.out.print("\nSeleccione una opción:\n");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("-- Seleccionaste Registrar Paciente --\n");
                    String id = hospital.generarIdPaciente();
                    scanner.nextLine();
                    System.out.print("Ingrese el Nombre del Paciente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese los apellidos: ");
                    String apellidos = scanner.nextLine();


                    System.out.print("Ingresa el año de nacimiento del paciente: ");
                    int anio = scanner.nextInt();
                    System.out.print("Ingresa el mes de nacimiento del paciente: ");
                    int mes = scanner.nextInt();
                    System.out.print("Ingresa el dia de nacimiento del paciente: ");
                    int dia = scanner.nextInt();
                    scanner.nextLine();

                    LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);


                    System.out.print("Ingrese el tipo de sangre del Paciente: ");
                    String tipoSangre = scanner.nextLine();
                    System.out.println("Ingrese el Sexo del Paciente: H/M");
                    Character sexo = scanner.next().charAt(0);
                    scanner.nextLine();
                    System.out.print("Ingrese la contraseña: ");
                    String contraseñaPaciente = scanner.nextLine();
                    String telefono;
                    while (true) {
                        System.out.print("Ingrese el teléfono del paciente: ");
                        telefono = scanner.nextLine();

                        if (hospital.validarTelefonoUnico(telefono)) {
                            Paciente paciente = new Paciente(id, nombre, apellidos, fechaNacimiento, tipoSangre, sexo, telefono, contraseñaPaciente);
                            hospital.registrarPaciente(paciente);

                            System.out.println("Paciente registrado exitosamente.");
                            break;
                        } else {
                            System.out.println("Ya existe un paciente con el mismo número de teléfono. Intente de nuevo.");
                        }
                    }
                    break;

                case 2:
                    System.out.println("-- Seleccionaste Registrar Médico --\n");

                    scanner.nextLine();
                    System.out.print("Ingrese el Nombre del Médico: ");
                    String nombreMedico = scanner.nextLine();
                    System.out.print("Ingrese los apellidos: ");
                    String apellidosMedico = scanner.nextLine();
                    System.out.print("Ingresa el año de nacimiento del Medico: ");
                    int anioMedico = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingresa el mes de nacimiento del Médico: ");
                    int mesMedico = scanner.nextInt();
                    System.out.print("Ingresa el dia de nacimiento del Médico: ");
                    int diaMedico = scanner.nextInt();
                    LocalDate fechaNacimientoMedico = LocalDate.of(anioMedico, mesMedico, diaMedico);

                    String idMedico = hospital.generarIdMedico(apellidosMedico, fechaNacimientoMedico);
                    scanner.nextLine();

                    String telefonoMedico;
                    while (true) {
                        System.out.print("Ingrese el teléfono del Médico: ");
                        telefonoMedico = scanner.nextLine();

                        if (hospital.validarTelefonoUnicoMedico(telefonoMedico)) {

                            break;
                        } else {
                            System.out.println("Ya existe un Médico con el mismo número de teléfono. Intente de nuevo.");
                        }
                    }
                    System.out.print("Ingrese la contraseña: ");
                    String contraseñaMedico = scanner.nextLine();
                    String rfcMedico;
                    while (true) {
                        System.out.print("Ingrese el RFC del Médico: ");
                        rfcMedico = scanner.nextLine();


                        if (hospital.validarRfcUnicoMedico(rfcMedico)) {

                            break;
                        } else {
                            System.out.println("Ya existe un Médico con el mismo RFC. Intente de nuevo.");
                        }
                    }
                    scanner.nextLine();
                    Medico medico = new Medico(idMedico, nombreMedico, apellidosMedico, fechaNacimientoMedico, telefonoMedico, rfcMedico, contraseñaMedico);
                    hospital.registrarMedico(medico);
                    break;
                case 3:
                    System.out.println("-- Seleccionaste Registrar Consultorio --\n");
                    String idConsultorio = hospital.generarIdConsultorio();
                    scanner.nextLine();
                    System.out.print("Ingrese el piso: ");
                    int piso = scanner.nextInt();
                    System.out.print("Ingrese el Número del Consultorio: ");
                    int numeroConsultorio = scanner.nextInt();

                    Consultorio consultorio = new Consultorio(idConsultorio, piso, numeroConsultorio);
                    hospital.registrarConsultorio(consultorio);
                    break;
                case 4:
                    System.out.println("-- Seleccionaste Registrar Consulta --\n ");
                    String idConsulta = hospital.generarIdConsulta();
                    LocalDateTime fechaConsulta;

                    while (true) {
                        System.out.print("Ingresa el día de la consulta deseada: ");
                        int diaConsulta = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Ingresa el mes de la consulta deseada: ");
                        int mesConsulta = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Ingresa el año de la consulta deseada: ");
                        int anioConsulta = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Ingresa la hora de la consulta: ");
                        int horaConsulta = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Ingresa los minutos de la consulta: ");
                        int minutosConsulta = scanner.nextInt();
                        scanner.nextLine();

                        fechaConsulta = LocalDateTime.of(anioConsulta, mesConsulta, diaConsulta, horaConsulta, minutosConsulta);

                        if (hospital.validarFechaConsulta(fechaConsulta)) {
                            break;
                        } else {
                            System.out.println("La fecha no puede estar en el pasado. Intente de nuevo.");
                        }
                    }


                    Paciente pacienteConsulta = null;

                    while (pacienteConsulta == null) {
                        System.out.print("Ingresa el ID del paciente: ");
                        String pacienteId = scanner.nextLine();

                        pacienteConsulta = hospital.obtenerPacientePorId(pacienteId);
                        if (pacienteConsulta == null) {
                            System.out.println("\nPaciente no encontrado, intente de nuevo.\n");
                        }

                    }

                    Medico medicoConsulta = null;
                    while (medicoConsulta == null) {
                        System.out.print("Ingresa el ID del Médico: ");
                        String MedicoId = scanner.nextLine();
                        medicoConsulta = hospital.obtenerMedicoPorId(MedicoId);
                        if (medicoConsulta == null) {
                            System.out.println("\nMédico no encontrado, intente de nuevo.\n");
                        }
                    }

                    Consultorio consultorioConsulta = null;
                    while (consultorioConsulta == null) {
                        System.out.print("Ingresa el ID del consultorio: ");
                        String ConsultorioId = scanner.nextLine();

                        consultorioConsulta = hospital.obtenerConsultorioPorId(ConsultorioId);
                        if (consultorioConsulta == null) {
                            System.out.println("\nConsultorio no encontrado, intente de nuevo.\n");
                        }
                    }
                    Consulta nuevaConsulta = new Consulta(idConsulta, fechaConsulta, pacienteConsulta, medicoConsulta, consultorioConsulta);

                    hospital.registrarConsulta(nuevaConsulta, pacienteConsulta.getId());

                    System.out.println("Consulta exitosamente registrada");

                    break;
                case 5:
                    System.out.println("-- Seleccionaste mostrar Pacientes -- \n");
                    hospital.mostrarPaciente();
                    break;
                case 6:
                    System.out.println("-- Seleccionaste mostrar Médicos --\n");
                    hospital.mostrarMedico();
                    break;
                case 7:
                    System.out.println("-- Seleccionaste mostrar Consultorios -- \n");
                    hospital.mostrarConsultorio();
                    break;
                case 8:
                    System.out.println("-- Seleccionaste mostrar Consultas --\n");
                    hospital.mostrarConsulta();
                    break;
                case 9:
                    System.out.println("-- Seleccionaste mostrar Paciente por ID -- \n");
                    scanner.nextLine();
                    System.out.println("Ingrese el ID del paciente a buscar");
                    String idPaciente = scanner.nextLine();
                    hospital.mostrarPacientePorId(idPaciente);
                    break;
                case 10:
                    System.out.println("-- Seleccionaste mostrar Médico por ID -- \n");
                    scanner.nextLine();
                    System.out.print("Ingrese el ID del medico a buscar: ");
                    String idM = scanner.nextLine();
                    hospital.mostrarMedicoPorId(idM);
                    break;
                case 11:
                    System.out.println("-- Seleccionaste mostrar Consultorio por ID -- \n");
                    scanner.nextLine();
                    System.out.print("Ingrese el id del consultorio a buscar: ");
                    String id_Consultorio = scanner.nextLine();
                    hospital.mostrarConsultorioPorId(id_Consultorio);
                    break;
                case 12:
                    System.out.println("-- Seleccionaste Listar Médicos por ID --");
                    hospital.listarMedicosPorId();
                    break;

                case 13:
                    System.out.println("-- Seleccionaste Listar Consultorios por ID --");
                    hospital.listarConsultorios();
                    break;
                case 14:
                    System.out.println("Hasta Luego");
                    break;
                default:
                    System.out.println("Opción no Valida\n");
                    break;

            }
        }
    }
}