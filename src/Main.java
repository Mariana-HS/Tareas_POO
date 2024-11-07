import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Ingrese el nombre del producto");
            String producto1 = scanner.nextLine();

            System.out.println("Ingrese el precio del producto: ");
            double precio = scanner.nextDouble();

            System.out.println("Ingrese la cantidad en inventario: ");
            int cantidad = scanner.nextInt();

            Producto producto = new Producto(producto1, precio, cantidad);

            System.out.println(producto.mostrarInformacion());

        } catch (ProductoInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (PrecioInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (CantidadInvalidaException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

class ProductoInvalidoException extends Exception {
    public ProductoInvalidoException(String mensaje) {
        super(mensaje);
    }
}

class PrecioInvalidoException extends Exception {
    public PrecioInvalidoException(String mensaje) {
        super(mensaje);
    }
}

class CantidadInvalidaException extends Exception {
    public CantidadInvalidaException(String mensaje) {
        super(mensaje);
    }
}