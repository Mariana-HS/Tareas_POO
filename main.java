import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> productos = new ArrayList<>();


        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n*** BIEVENIDO ***");
            System.out.println("1. Registrar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Aumentar stock del producto");
            System.out.println("4. Disminuir stock del producto");
            System.out.println("5. Salir");

            System.out.println("Selecciona una opción: ");
            opcion = scanner.nextInt();

            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el precio del producto: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Ingrese el stock del producto: ");
                    int stock = scanner.nextInt();
                    productos.add(new Producto(nombre, precio, stock));
                    System.out.println("Producto creado exitosamente.");
                    break;
                case 2:

                    System.out.println("\nLista de productos:");
                    for (int i = 0; i < productos.size(); i++) {
                        Producto p = productos.get(i);
                        System.out.println((i + 1) + ". " + p.getNombre() + " - Precio: " + p.getPrecio() + " - Stock: " + p.getStock());
                    }
                break;
                case 3:
                    System.out.println("Seleccione el número del producto para aumentar el stock:");
                    for (int i = 0; i < productos.size(); i++) {
                        System.out.println((i + 1) + ". " + productos.get(i).getNombre());
                    }
                    int numProducto = scanner.nextInt();

                    if (numProducto > 0 && numProducto <= productos.size()) {
                        Producto producto = productos.get(numProducto - 1);
                        System.out.print("Ingrese la cantidad a aumentar: ");
                        int cantidad = scanner.nextInt();
                        producto.aumentarStock(cantidad);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Seleccione el número del producto para disminuir el stock:");
                    for (int i = 0; i < productos.size(); i++) {
                        System.out.println((i + 1) + ". " + productos.get(i).getNombre());
                    }
                    int num2Producto = scanner.nextInt();

                    if (num2Producto > 0 && num2Producto <= productos.size()) {
                        Producto producto = productos.get(num2Producto - 1);
                        System.out.print("Ingrese la cantidad a disminuir: ");
                        int cantidad = scanner.nextInt();
                        producto.reducirStock(cantidad);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        }
    }
}