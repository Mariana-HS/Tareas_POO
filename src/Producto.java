public class Producto {
    String nombre;
    double precio;
    int cantidad;

    public Producto(String nombre, double precio, int cantidad)
            throws ProductoInvalidoException, PrecioInvalidoException, CantidadInvalidaException {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ProductoInvalidoException("El nombre del producto no puede estar vacío o ser nulo.");
        }
        this.nombre = nombre;

        if (precio <= 0) {
            throw new PrecioInvalidoException("El precio del producto debe ser mayor a cero.");
        }
        this.precio = precio;

        if (cantidad < 0) {
            throw new CantidadInvalidaException("La cantidad del producto no puede ser negativa.");
        }
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double calcularValorTotal(int cantidad, double precio){
        return cantidad * precio;
    }

    public String mostrarInformacion(){
        String datosProducto = String.format("Nombre: %s, Precio: %.2f, Cantidad: %d, Total: %.2f",
                nombre, precio, cantidad, calcularValorTotal(cantidad, precio));
        return datosProducto;
    }
}