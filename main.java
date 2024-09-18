import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        while (opcion != 9) {
            System.out.println("\n** BIENVENIDO **");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Eliminar paciente");
            System.out.println("3. Mostrar pacientes");
            System.out.println("4. Registar medico");
            System.out.println("5. Eliminar medico");
            System.out.println("6. Mostrar medicos");
            System.out.println("7. Registrar consulta");
            System.out.println("8. Cancelar consulta ");
            System.out.println("9. Salir");


            System.out.println("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                      break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
            }
        }


    }
}