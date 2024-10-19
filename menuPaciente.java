package menu;

import hospital.Hospital;
import usuarios.pacientes.Paciente;

import java.util.Scanner;

public class MenuPaciente {
    Scanner scanner = new Scanner(System.in);

    public int mostrarmenu() {
        System.out.println("\n*SISTEMA HOSPITAL*");
        System.out.println("1. Ver mis consultas ");
        System.out.println("2. Ver mis datos");// tarea
        System.out.println("3. Ver mi expediente");
        System.out.println("4. Salir");
        System.out.println("Selecciona una opción");
        int opcion = scanner.nextInt();
        return opcion;

    }


    public void procesarDatosMenu(int opcion, Hospital hospital, Paciente paciente) {
        Scanner scanner = new Scanner(System.in);
        switch (opcion) {
            case 1:
                System.out.println("-- Seleccionaste Ver Consultas --\n");
                System.out.print("Ingresa tu ID: ");
                String idPaciente = scanner.nextLine();
                hospital.mostrarConsultasPaciente(idPaciente);
                break;
            case 2:
                System.out.println("-- Seleccionaste Ver mis Datos --\n");
                System.out.print("Ingresa tu ID: ");
                String idPaciente2 = scanner.nextLine();
                hospital.mostrarPacientePorId(idPaciente2);
                break;
            case 3:
                System.out.println("Hasta luego ");
                break;
        }

    }
}