import consultorios.Consultorio;
import hospital.Hospital;
import medicos.Medico;
import pacientes.Paciente;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hospital hospital = new Hospital();

        System.out.println("*** Hospital ***");


        int opcion = 0;
        while (opcion != 12) {
            System.out.println("\n**Bienvenido**");
            System.out.println("1. Registrar paciente. ");
            System.out.println("2. Registrar medico.");
            System.out.println("3. Registrar consultorio.");
            System.out.println("4. Registrar consulta.");
            System.out.println("5. Mostrar pacientes.");
            System.out.println("6. Mostrar medicos.");
            System.out.println("7. Mostrar consultorios.");
            System.out.println("8. Mostrar consultas.");
            System.out.println("9. Mostrar paciente por ID");
            System.out.println("10. Mostrar medico por ID");
            System.out.println("11. Mostrar consultorio por ID");
            System.out.println("12. Salir");

            System.out.print("\nSelecciona una opcion: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("*** Registrar paciente ***\n");
                    String id = hospital.generarIdPaciente();
                    sc.nextLine();
                    System.out.println("Ingresa el nombre del paciente: ");
                    String nombre = sc.nextLine();
                    System.out.println("Ingresa los apellidos: ");
                    String apellidos = sc.nextLine();
                    System.out.println("Ingresa su fecha de nacimiento: ");
                    String fechaNacimiento = sc.nextLine();
                    System.out.println("Ingresa el tipo de sangre: ");
                    String tipoSangre = sc.nextLine();
                    System.out.println("Ingresa el sexo del pasiente: H/M");
                    Character sexo = sc.next().charAt(0);
                    sc.nextLine();
                    System.out.println("Ingresa el telefono del paciente: ");
                    String telefono = sc.nextLine();

                    Paciente paciente = new Paciente(id, nombre, apellidos, fechaNacimiento, tipoSangre, sexo, telefono);
                    hospital.registrarPaciente(paciente);
                    break;
                case 2:
                    System.out.println("*** Registrar medico ***\n");

                    sc.nextLine();
                    System.out.println("Ingresa el nombre del medico: ");
                    String nombreMedico = sc.nextLine();
                    System.out.println("Ingresa los apellidos: ");
                    String apellidosMedico = sc.nextLine();
                    System.out.println("Ingresa su fecha de nacimiento: ");
                    String fechaNacimientoMedico = sc.nextLine();
                    String idMedico = hospital.generarIdMedico(apellidosMedico, fechaNacimientoMedico);
                    System.out.println("Ingresa el telefono del medico: ");
                    String telefonoMedico = sc.nextLine();
                    System.out.println("Ingresa el RFC del paciente: ");
                    String rfc = sc.nextLine();

                    Medico medico = new Medico(idMedico, nombreMedico, apellidosMedico, fechaNacimientoMedico, telefonoMedico, rfc);
                    hospital.registrarMedico(medico);
                    break;
                case 3:
                    System.out.println("***Registrar consultorio***\n");
                    String idConsultorio = hospital.generarIdConsultorio();
                    sc.nextLine();
                    System.out.println("Ingresa el piso donde se encuentra: ");
                    int piso = sc.nextInt();
                    System.out.println("Ingresa el número de consultorio: ");
                    int numeroConsultorio = sc.nextInt();

                    Consultorio consultorio = new Consultorio(idConsultorio, piso, numeroConsultorio);
                    hospital.registrarConsultorio(consultorio);
                    break;
                case 4:
                    System.out.println("***Registrar consulta***\n");
                    break;
                case 5:
                    System.out.println("***Mostrar pacientes***\n");
                    hospital.mostrarPaciente();
                    break;
                case 6:
                    System.out.println("*** Mostrar medicos ***\n");
                    hospital.mostrarMedico();
                    break;
                case 7:
                    System.out.println("*** Mostrar consultorios ***\n");
                    hospital.mostrarConsultorio();
                    break;
                case 8:
                    System.out.println("*** Mostrar consultas ***\n");
                    hospital.mostrarConsulta();
                    break;
                case 9:
                    System.out.println("*** Mostrar paciente por ID ***\n");
                    sc.nextLine();
                    System.out.println("Ingresa el id del paciente a buscar");
                    String idPaciente = sc.nextLine();
                    hospital.mostrarPacientePorId(idPaciente);
                    break;
                case 10:
                    System.out.println("*** Mostrar medico por ID ***\n");
                    sc.nextLine();
                    System.out.println("Ingresa el id del medico a buscar");
                    String idM = sc.nextLine();
                    hospital.mostrarMedicoPorId(idM);
                    break;
                case 11:
                    System.out.println("*** Mostrar consultorio por ID ***\n");
                    sc.nextLine();
                    System.out.println("Ingresa el id del consultorio a buscar");
                    String id_Consultorio = sc.nextLine();
                    hospital.mostrarConsultorioPorId(id_Consultorio);
                    break;
                case 12:
                    System.out.println("*** Salir ***");
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("*** Opción no valida ***\n");
                    break;
            }
        }
    }
}