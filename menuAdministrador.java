package menu;

import consultas.Consulta;
import consultorios.Consultorio;
import hospital.Hospital;
import usuarios.Usuario;
import usuarios.administrador.Administrador;
import usuarios.medicos.Medico;
import usuarios.pacientes.Paciente;
import usuarios.utils.Rol;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuAdministrador {
    Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
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
        System.out.println("14.Registrate");
        System.out.println("15.Ver mi informacion");
        System.out.println("16.Salir");

        System.out.print("\nSeleccione una opción:\n");
        return scanner.nextInt();
    }

    public void procesarDatosMenu(int opcion, Administrador administrador, Hospital hospital) {
        switch (opcion) {
            case 1:
                // Registrar Paciente
                System.out.println("--Seleccionaste Registrar Paciente--\n");
                String id = hospital.generarIdPaciente();
                ArrayList<String> datosPaciente = this.obtenerDatosComun(Rol.PACIENTE, hospital);

                String nombrePaciente = datosPaciente.get(0);
                String apellidoPaciente = datosPaciente.get(1);
                LocalDate fechaNacimiento = LocalDate.parse(datosPaciente.get(2));
                String numeroTelefonoPaciente = datosPaciente.get(3);
                String contraseniaPaciente = datosPaciente.get(4);
                String correoPaciente = datosPaciente.get(5);

                System.out.print("Ingrese el tipo de sangre del Paciente: ");
                String tipoSangre = scanner.nextLine();
                System.out.println("Ingrese el Sexo del Paciente: H/M");
                Character sexo = scanner.next().charAt(0);
                scanner.nextLine();

                // Validar ambos: teléfono y correo
                boolean esTelefonoValido = validarTelefonoRepetido(hospital.listaUsuarios, numeroTelefonoPaciente);
                boolean esCorreoValido = hospital.validarCorreoElectronico(hospital.listaUsuarios, correoPaciente);

                // Mostrar mensajes de error según la validación fallida
                if (!esTelefonoValido || !esCorreoValido) {
                    System.out.println("El registro ha fallado.");
                    return; // Si alguno es inválido, salir sin registrar
                }

                // Si ambos son válidos, registrar el paciente
                Paciente paciente = new Paciente(id, nombrePaciente, apellidoPaciente, fechaNacimiento, tipoSangre, sexo, numeroTelefonoPaciente, contraseniaPaciente, correoPaciente);
                hospital.registrarPaciente(paciente);

                System.out.println("Paciente registrado exitosamente.");
                break;

            case 2:
                // Registrar Médico
                System.out.println("-- Seleccionaste Registrar Médico --\n");

                ArrayList<String> datosMedico = this.obtenerDatosComun(Rol.MEDICO, hospital);

                String nombreMedico = datosMedico.get(0);
                String apellidosMedico = datosMedico.get(1);
                LocalDate fechaNacimientoMedico = LocalDate.parse(datosMedico.get(2));
                String numeroTelefonoMedico = datosMedico.get(3);
                String contraseniaMedico = datosMedico.get(4);
                String correoMedico = datosMedico.get(5);

                String idMedico = hospital.generarIdMedico(apellidosMedico, fechaNacimientoMedico);

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

                // Validar ambos: teléfono y correo
                boolean esTelefonoMedicoValido = validarTelefonoRepetido(hospital.listaUsuarios, numeroTelefonoMedico);
                boolean esCorreoMedicoValido = hospital.validarCorreoElectronico(hospital.listaUsuarios, correoMedico);

                // Mostrar mensajes de error según la validación fallida
                if (!esTelefonoMedicoValido || !esCorreoMedicoValido) {
                    System.out.println("El registro ha fallado.");
                    return; // Si alguno es inválido, salir sin registrar
                }

                // Si ambos son válidos, registrar el médico
                Medico medico = new Medico(idMedico, nombreMedico, apellidosMedico, fechaNacimientoMedico, numeroTelefonoMedico, rfcMedico, contraseniaMedico, correoMedico);
                hospital.registrarMedico(medico);
                System.out.println("Médico registrado exitosamente.");
                break;


            case 3:
                System.out.println("-- Seleccionaste Registrar Consultorio --\n");
                String idConsultorio = hospital.generarIdConsultorio();
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
                    System.out.print("Ingresa el mes de la consulta deseada: ");
                    int mesConsulta = scanner.nextInt();
                    System.out.print("Ingresa el año de la consulta deseada: ");
                    int anioConsulta = scanner.nextInt();
                    System.out.print("Ingresa la hora de la consulta: ");
                    int horaConsulta = scanner.nextInt();
                    System.out.print("Ingresa los minutos de la consulta: ");
                    int minutosConsulta = scanner.nextInt();

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
                    String pacienteId = scanner.next();
                    pacienteConsulta = hospital.obtenerPacientePorId(pacienteId);
                    if (pacienteConsulta == null) {
                        System.out.println("\nPaciente no encontrado, intente de nuevo.\n");
                    }
                }

                Medico medicoConsulta = null;
                while (medicoConsulta == null) {
                    System.out.print("Ingresa el ID del Médico: ");
                    String MedicoId = scanner.next();
                    medicoConsulta = hospital.obtenerMedicoPorId(MedicoId);
                    if (medicoConsulta == null) {
                        System.out.println("\nMédico no encontrado, intente de nuevo.\n");
                    }
                }

                Consultorio consultorioConsulta = null;
                while (consultorioConsulta == null) {
                    System.out.print("Ingresa el ID del consultorio: ");
                    String ConsultorioId = scanner.next();
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
              /* System.out.println("-- Seleccionaste Registrarte --");
                    scanner.nextLine();
                    System.out.print("Ingrese su Nombre: ");
                    String nombreAdmin = scanner.nextLine();
                    System.out.print("Ingrese los apellidos: ");
                    String apellidosAdmin = scanner.nextLine();
                    System.out.print("Ingrese su año de nacimiento: ");
                    int anioAdmin = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese su mes de nacimiento: ");
                    int mesAdmin = scanner.nextInt();
                    System.out.print("Ingrese su dia de nacimiento: ");
                    int diaAdmin = scanner.nextInt();
                    LocalDate fechaNacimientoAdmin = LocalDate.of(anioAdmin, mesAdmin, diaAdmin);

                    String idAmin = hospital.generarIdMedico(apellidosAdmin, fechaNacimientoAdmin);
                    scanner.nextLine();

                    System.out.print("Ingrese sus años trabajados: ");
                    String aniosAdmin= scanner.nextLine();
                    System.out.print("Ingrese su sueldo: ");
                    Double sueldoAdmin= scanner.nextDouble();

                    String telefonoAdmin;
                    while (true) {
                        System.out.print("Ingrese su teléfono: ");
                        telefonoAdmin = scanner.nextLine();
                        scanner.nextLine();

                        if (hospital.validarTelefonoUnicoMedico(telefonoAdmin)) {

                            break;
                        } else {
                            System.out.println("Ya existe un Administrador con el mismo número de teléfono. Intente de nuevo.");
                        }
                    }
                    System.out.print("Ingrese la contraseña: ");
                    String contraseñaAdmin = scanner.nextLine();
                    String rfcAdmin= " ";
                    while (true) {
                        System.out.print("Ingresa tu RFC: ");
                        rfcMedico = scanner.nextLine();


                        if (hospital.validarRfcUnicoMedico(rfcAdmin)) {

                            break;
                        } else {
                            System.out.println("Ya existe un Administrador con el mismo RFC. Intente de nuevo.");
                        }
                    }
                    scanner.nextLine();
                    Administrador administrador1 = new Administrador(idAmin,nombreAdmin, apellidosAdmin, fechaNacimientoAdmin, telefonoAdmin, rfcAdmin, contraseñaAdmin,anioAdmin,sueldoAdmin);
                    hospital.registrarAdministrador(administrador1);*/
                break;

            case 15:
                System.out.println("-- Ver mi información --");
                System.out.println(administrador.mostrarDatos());
                break;

            case 16:
                System.out.println("Hasta Luego");
                break;

            default:
                System.out.println("Opción no válida\n");
                break;
        }
    }

    private ArrayList<String> obtenerDatosComun(Rol rol, Hospital hospital) {
        String tipoUsuario = rol == Rol.PACIENTE ? "paciente" : rol == Rol.MEDICO ? "médico" : "administrador";
        ArrayList<String> datosEnComun = new ArrayList<>();

        System.out.print(String.format("Ingrese el Nombre del %s: ", tipoUsuario));
        String nombre = scanner.nextLine();
        datosEnComun.add(nombre);
        scanner.nextLine();

        System.out.print(String.format("Ingrese los apellidos del %s: ", tipoUsuario));
        String apellidos = scanner.nextLine();
        datosEnComun.add(apellidos);

        datosEnComun.add(obtenerFechaNacimientoUsuario(tipoUsuario));

        System.out.print(String.format("Ingrese la contraseña del %s: ", tipoUsuario));
        String contrasenia = scanner.nextLine();
        datosEnComun.add(contrasenia);

        boolean esTelefonoValido = false;
        String numeroTelefono = "";
        while(!esTelefonoValido){
        System.out.print(String.format("Ingrese el teléfono del %s: ", tipoUsuario));
       numeroTelefono = scanner.nextLine();
        datosEnComun.add(numeroTelefono);
        esTelefonoValido = validarTelefonoRepetido(rol == Rol.PACIENTE ? hospital.listaPacientes : hospital.listaMedicos ,tipoUsuario);
        }
        System.out.println(String.format("Ingrese el correo del %s", tipoUsuario));
        String correo = scanner.nextLine();
        datosEnComun.add(correo);
        return datosEnComun;
    }

    private String obtenerFechaNacimientoUsuario(String tipoUsuario){
        boolean esFechaValida = false;
        LocalDate fechaNacimiento = LocalDate.now();

        while(!esFechaValida){
            System.out.print(String.format("Ingresa el año de nacimiento del %s: ", tipoUsuario));
            int anio = scanner.nextInt();
            System.out.print(String.format("Ingresa el mes de nacimiento del %s: ", tipoUsuario));
            int mes = scanner.nextInt();
            System.out.print(String.format("Ingresa el día de nacimiento del %s: ", tipoUsuario));
            int dia = scanner.nextInt();

           fechaNacimiento = LocalDate.of(anio, mes, dia);
            scanner.nextLine();

            if (fechaNacimiento.isAfter(LocalDate.now())){
                System.out.println("La fecha de nacimiento no puede ser posterior al dia de hoy.");
            }
            else{
                esFechaValida = true;
            }
        }
        return fechaNacimiento.toString();
    }

    private boolean validarTelefonoRepetido(ArrayList<? extends Usuario> listaUsuarios,String telefono){
        for( Usuario usuario: listaUsuarios){
            if(usuario.getTelefono().equals(telefono)){
                System.out.println("Ya existe un usuario con ese telefono. Intenta de nuevo");
                return false;
            }
        }
        return true;
    }
}
