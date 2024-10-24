package menu;

import hospital.Hospital;
import usuarios.medicos.Medico;

import java.util.Scanner;

public class MenuMedico {
    Scanner scanner = new Scanner(System.in);

    public int mostrarmenu () {

        System.out.println("\n*SISTEMA HOSPITAL*");
        System.out.println("1. Ver mis Consultas Actuales");// TAREA
        System.out.println("2. Ver mis Datos");// TAREA
        System.out.println("3. Ver mis pacientes");
        System.out.println("4. Consultar paciente");
        System.out.println("5. Consultar expediente de paciente");
        System.out.println("6. Completar Consulta");
        System.out.println("7. Salir");


        System.out.println("Selecciona una opción");
        int opcion = scanner.nextInt();
        return opcion;


    }
    public void procesarDatosMenu(int opcion, Medico medico, Hospital hospital){
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