public class Producto {
    private String nombre;
    private Double precio;
    private int stock;

    public Producto(String nombre, Double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public Producto(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = 0;
    }

    public void aumentarStock( int cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor que 0");
        } else {
            stock = stock + cantidad;
            System.out.println("Stock correctamente aumentado");
        }
    }

    public void reducirStock( int cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor que 0");
        }
        else if (cantidad > stock){
            System.out.println("La cantidad a reducir no puede ser mayor que "+ stock+ "que es el stock actual.");
        }
        else {
             stock = stock - cantidad;
             System.out.println("Stock correctamente reducido");
        }
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        if (nombre == null) {
            System.out.println("El nombre no puede ser nulo");
        }
        else{
            this.nombre = nombre;
        }
    }

    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        if (precio < 0) {
            System.out.println("El precio no puede ser negativo");
        }
        else{
            this.precio = precio;
        }
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        if (stock < 0) {
            System.out.println("El stock no puede ser negativo");
        }
        else{
            this.stock = stock;
        }
    }
}
