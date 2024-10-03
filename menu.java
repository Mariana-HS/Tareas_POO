package menu;

import consultas.Consulta;
import consultorios.Consultorio;
import hospital.Hospital;
import medicos.Medico;
import pacientes.Paciente;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
   private Scanner scanner = new Scanner(System.in);
   private Hospital hospital = new Hospital();
   public final String USUARIO_PACIENTE ="Juan123";
   private final String CONTRASENIA_PACIENTE = "12345*";
   private final String USUARIO_MEDICO = "Ale123" ;
   private final String CONTRASENIA_MEDICO ="54321*";
   private final String USUARIO_ADMIN ="Mario123";
   private final String CONTRASENIA_ADMIN ="2468*";

   public void login(){
       int intentosMaximos = 5, intentosUsuario =0;

       while(intentosUsuario < intentosMaximos){
           System.out.println("\n Bienvenido \n");
           System.out.println("Ingresa tu usuario: ");
           String usuario = scanner.nextLine();

           System.out.println("Ingresa tu contraseña: ");
           String contrasenia = scanner.nextLine();

           if(usuario.equals(this.USUARIO_PACIENTE)){
               if(contrasenia.equals(CONTRASENIA_PACIENTE)){
                   this.mostrarMenuPaciente();
                   intentosUsuario=0;
               }
               else {
                   intentosUsuario =mostrarErrorInicioSesion(intentosUsuario);
               }
           }
           else if (usuario.equals(this.USUARIO_MEDICO)) {
               if(contrasenia.equals(CONTRASENIA_MEDICO)){
                   this.mostrarMenuMedico();
                   intentosUsuario=0;
               }
               else {
                   intentosUsuario =mostrarErrorInicioSesion(intentosUsuario);
               }
           }
           else if(usuario.equals(this.USUARIO_ADMIN)){
               if(contrasenia.equals(CONTRASENIA_ADMIN)) {
                  this.mostrarMenuAdmin();
               }
               else {
                   intentosUsuario =mostrarErrorInicioSesion(intentosUsuario);
               }
           }
           else {
              intentosUsuario =mostrarErrorInicioSesion(intentosUsuario);
           }
       }
       System.out.println("Intentos maximos permitidos alcanzados.");
   }

   private int mostrarErrorInicioSesion(int intentosUsuario){
       System.out.println("Usuario o contraseña incorrectos, Intenta de nuevo");
       return intentosUsuario+1;
   }

   private void mostrarMenuPaciente(){
       int opcion = 0;

      while(opcion != 2){
          System.out.println("** SISTEMA DE HOSPITAL **");
          System.out.println("1. Ver citas");
          System.out.println("2. Salir");
          System.out.println("Selecciona una opcion");
          opcion = scanner.nextInt();
          scanner.nextLine();


          switch (opcion){
              case 1:
                  System.out.print("Ingresa el ID del paciente: ");
                  String idPaciente = scanner.nextLine();
                  hospital.mostrarCitasPaciente(idPaciente);
                  break;
              case 2:
                  System.out.println("Volviendo al menú principal...");
                  break;
              default:
                  System.out.println("Opción no válida, por favor seleccione de nuevo.");
          }
}
   }

    private void mostrarMenuMedico(){
     int opcion = 0;
     while(opcion != 4){
         System.out.println("** SISTEMA DE MEDICO **");
         System.out.println("1. Ver consultas");
         System.out.println("2. Ver mis pacientes");
         System.out.println("3. Consultar paciente");
         System.out.println("4. Salir");

         System.out.println("Selecciona una opcion");
         opcion = scanner.nextInt();
         scanner.nextLine();

         switch (opcion){
             case 1:
                 System.out.print("Ingresa el ID del médico: ");
                 String idMedicoConsulta = scanner.nextLine();
                 hospital.mostrarConsultasPorMedico(idMedicoConsulta);
                 break;
             case 2:
                 System.out.print("Ingresa el ID del médico: ");
                 String idMedico = scanner.nextLine();
                 hospital.mostrarPacientesPorMedico(idMedico);
                 break;
             case 3:
                 break;
             case 4:
                 System.out.println("Volviendo al menú principal...");
                 break;
             default:
                 System.out.println("Opción no válida, por favor seleccione de nuevo.");
         }
}
    }

    private void mostrarMenuAdmin(){
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
                    System.out.println("Ingrese el Nombre del Paciente: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese los apellidos: ");
                    String apellidos = scanner.nextLine();


                    System.out.println("Ingresa el año de nacimiento del paciente: ");
                    int anio = scanner.nextInt();
                    System.out.println("Ingresa el mes de nacimiento del paciente: ");
                    int mes = scanner.nextInt();
                    System.out.println("Ingresa el dia de nacimiento del paciente: ");
                    int dia = scanner.nextInt();

                    LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
                    scanner.nextLine();

                    System.out.println("Ingrese el tipo de sangre del Paciente: ");
                    String tipoSangre = scanner.nextLine();
                    System.out.println("Ingrese el Sexo del Paciente: H/M");
                    Character sexo = scanner.next().charAt(0);
                    scanner.nextLine();

                    String telefono;
                    while (true) {
                        System.out.print("Ingrese el teléfono del paciente: ");
                        telefono = scanner.nextLine();

                        if (hospital.validarTelefonoUnico(telefono)) {
                            Paciente paciente = new Paciente(id, nombre, apellidos, fechaNacimiento, tipoSangre, sexo, telefono);
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
                    System.out.println("Ingrese el Nombre del Médico: ");
                    String nombreMedico = scanner.nextLine();
                    System.out.println("Ingrese los apellidos: ");
                    String apellidosMedico = scanner.nextLine();
                    System.out.println("Ingresa el año de nacimiento del Medico: ");
                    int anioMedico = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingresa el mes de nacimiento del Médico: ");
                    int mesMedico = scanner.nextInt();
                    System.out.println("Ingresa el dia de nacimiento del Médico: ");
                    int diaMedico = scanner.nextInt();
                    LocalDate fechaNacimientoMedico = LocalDate.of(anioMedico, mesMedico, diaMedico);

                    String idMedico = hospital.generarIdMedico(apellidosMedico, fechaNacimientoMedico);
                    scanner.nextLine();

                    String telefonoMedico;
                    while (true) {
                        System.out.println("Ingrese el teléfono del Médico: ");
                        telefonoMedico = scanner.nextLine();

                        if (hospital.validarTelefonoUnicoMedico(telefonoMedico)) {

                            break;
                        } else {
                            System.out.println("Ya existe un Médico con el mismo número de teléfono. Intente de nuevo.");
                        }
                    }

                    String rfcMedico;
                    while (true) {
                        System.out.println("Ingrese el RFC del Médico: ");
                        rfcMedico = scanner.nextLine();


                        if (hospital.validarRfcUnicoMedico(rfcMedico)) {

                            break;
                        } else {
                            System.out.println("Ya existe un Médico con el mismo RFC. Intente de nuevo.");
                        }
                    }
                    scanner.nextLine();
                    Medico medico = new Medico(idMedico, nombreMedico, apellidosMedico, fechaNacimientoMedico, telefonoMedico, rfcMedico);
                    hospital.registrarMedico(medico);
                    break;
                case 3:
                    System.out.println("-- Seleccionaste Registrar Consultorio --\n");
                    String idConsultorio = hospital.generarIdConsultorio();
                    scanner.nextLine();
                    System.out.println("Ingrese el piso: ");
                    int piso = scanner.nextInt();
                    System.out.println("Ingrese el Número del Consultorio: ");
                    int numeroConsultorio = scanner.nextInt();

                    Consultorio consultorio = new Consultorio(idConsultorio, piso, numeroConsultorio);
                    hospital.registrarConsultorio(consultorio);
                    break;
                case 4:
                    System.out.println("* Seleccionaste Registrar Consulta *");
                    String idConsulta = hospital.generarIdConsulta();
                    LocalDateTime fechaConsulta;

                    while (true) {
                        System.out.println("Ingresa el día de la consulta deseada: ");
                        int diaConsulta = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Ingresa el mes de la consulta deseada: ");
                        int mesConsulta = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Ingresa el año de la consulta deseada: ");
                        int anioConsulta = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Ingresa la hora de la consulta: ");
                        int horaConsulta = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Ingresa los minutos de la consulta: ");
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
                        System.out.println("Ingresa el ID del paciente: ");
                        String pacienteId = scanner.nextLine();

                        pacienteConsulta = hospital.obtenerPacientePorId(pacienteId);
                        if (pacienteConsulta == null) {
                            System.out.println("\nPaciente no encontrado, intente de nuevo.\n");
                        }

                    }

                    Medico medicoConsulta = null;
                    while (medicoConsulta == null) {
                        System.out.println("Ingresa el ID del Médico: ");
                        String MedicoId = scanner.nextLine();
                        medicoConsulta = hospital.obtenerMedicoPorId(MedicoId);
                        if (medicoConsulta == null) {
                            System.out.println("\nMédico no encontrado, intente de nuevo.\n");
                        }
                    }

                    Consultorio consultorioConsulta = null;
                    while (consultorioConsulta == null) {
                        System.out.println("Ingresa el ID del consultorio: ");
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
                    System.out.println("Ingrese el ID del medico a buscar");
                    String idM = scanner.nextLine();
                    hospital.mostrarMedicoPorId(idM);
                    break;
                case 11:
                    System.out.println("-- Seleccionaste mostrar Consultorio por ID -- \n");
                    scanner.nextLine();
                    System.out.println("Ingrese el id del consultorio a buscar");
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

    public void mostrarMenu() {

    }

}