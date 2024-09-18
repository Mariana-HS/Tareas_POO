package categoria;

import producto.Producto;

import java.util.ArrayList;
import java.util.Random;

public class Categoria {
    public int id;
    public String nombre;
    public ArrayList<Producto> listaProductos = new ArrayList<>();
    public Random random = new Random();

    public Categoria(String nombre) {
        this.id = this.random.nextInt(1000);
        this.nombre = nombre;
    }

    public void registrarProductoCategoria(Producto producto) {
        this.listaProductos.add(producto);
    }

    public void mostrarDatos() {
        System.out.println("Categoría: " + nombre + " (ID: " + id + ")");
        for (Producto producto : listaProductos) {
            System.out.println("\tProducto: " + producto.getNombre() + " - Precio: " + producto.getPrecio() + " - Stock: " + producto.getStock()  + " - ID: " + producto.getId());
        }
    }

    public void mostrarCategoriaBasica() {
        System.out.println("ID: " + id + ", Nombre: " + nombre);
    }
}