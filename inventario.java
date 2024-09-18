package inventario;

import producto.Producto;
import categoria.Categoria;

import java.util.ArrayList;

public class Inventario {
    public ArrayList<Producto> listaProductos = new ArrayList<>();
    public ArrayList<Categoria> listaCategorias = new ArrayList<>();

    public void registrarProducto(Producto producto) {
        boolean categoriaExiste = false;
        for (Categoria categoria : this.listaCategorias) {
            if (categoria.id == producto.getidCategoria()) {
                categoria.registrarProductoCategoria(producto);
                categoriaExiste = true;
                break;
            }
        }

        if (categoriaExiste) {
            this.listaProductos.add(producto);
            System.out.println("\nProducto registrado correctamente");
        } else {
            System.out.println("\nID de categoría no existe. Inténtalo de nuevo.");
        }
    }

    public void mostrarCategoriasConProductos() {
        System.out.println("\n** CATEGORÍAS Y SUS PRODUCTOS **");

        if (this.listaCategorias.size() == 0) {
            System.out.println("\nNo existen categorías en el sistema.");
            return;
        }

        for (Categoria categoria : this.listaCategorias) {
            categoria.mostrarDatos();
        }
    }

    public void mostrarCategoriasBasicas() {
        System.out.println("\n** CATEGORÍAS **");

        if (this.listaCategorias.size() == 0) {
            System.out.println("\nNo existen categorías en el sistema.");
            return;
        }

        for (Categoria categoria : this.listaCategorias) {
            categoria.mostrarCategoriaBasica();
        }
    }

    public void registrarCategoria(Categoria categoria) {
        this.listaCategorias.add(categoria);
    }

    public void eliminarProducto(int idProductoEliminar) {
        int longitudOriginal = this.listaProductos.size();

        this.listaProductos.removeIf((producto) -> producto.getId() == idProductoEliminar);

        if (longitudOriginal != this.listaProductos.size()) {
            System.out.println("Se eliminó el producto con el ID: " + idProductoEliminar);
        } else {
            System.out.println("No existe un producto con el ID: " + idProductoEliminar);
        }
    }

    public void mostrarProductos() {
        System.out.println("\n** PRODUCTOS EN EL SISTEMA **");

        if (this.listaProductos.size() == 0) {
            System.out.println("\nNo existen productos en el sistema");
            return;
        }

        int iterador = 1;
        for (Producto producto : this.listaProductos) {
            System.out.println("\nEste es el producto: " + iterador);
            System.out.println(producto.mostrarProducto());
            iterador++;
        }
    }

    public boolean validarExistenciadeCategorias() {
        return this.listaCategorias.size() > 0;
    }
}