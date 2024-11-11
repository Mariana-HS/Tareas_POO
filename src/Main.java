import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaReservas sistema = new SistemaReservas();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Sistema de Reservas de Habitaciones ---");
            System.out.println("1. Mostrar detalles de las habitaciones");
            System.out.println("2. Realizar una reserva");
            System.out.println("3. Liberar una habitación");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    sistema.mostrarHabitaciones();
                    break;
                case 2:
                    System.out.print("\nIngrese el número de habitación (1: Individual, 2: Doble, 3: Suite): ");
                    int numHabitacion = scanner.nextInt() - 1;
                    System.out.print("Ingrese el número de noches a reservar: ");
                    int noches = scanner.nextInt();
                    sistema.reservarHabitacion(numHabitacion, noches);
                    break;
                case 3:
                    System.out.print("\nIngrese el número de habitación para liberar (1: Individual, 2: Doble, 3: Suite): ");
                    int numHabitacionLiberar = scanner.nextInt() - 1;
                    sistema.liberarHabitacion(numHabitacionLiberar);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema.");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 4);

        scanner.close();
    }
}
