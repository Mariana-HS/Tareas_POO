public class Habitacion {
    private String tipo;
    public double precioPorNoche;
    private boolean disponible;

    public Habitacion(String tipo, double precioPorNoche) {
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.disponible = true; // Inicialmente disponible
    }

    public void reservar(int noches) throws ExcepcionesPersonalizadas.HabitacionNoDisponibleException, ExcepcionesPersonalizadas.NumeroDeNochesInvalidoException {
        if (!disponible) {
            throw new ExcepcionesPersonalizadas.HabitacionNoDisponibleException("La habitación no está disponible para reserva.");
        }
        if (noches <= 0) {
            throw new ExcepcionesPersonalizadas.NumeroDeNochesInvalidoException("El número de noches debe ser mayor que 0.");
        }

        // Si la habitación está disponible y el número de noches es válido
        disponible = false;
        System.out.println("Reserva exitosa para " + noches + " noches.");
    }

    public void liberar() {
        disponible = true;
        System.out.println("La habitación ha sido liberada y está disponible nuevamente.");
    }

    public void mostrarDetalles() {
        System.out.println("Tipo de habitación: " + tipo);
        System.out.println("Precio por noche: " + precioPorNoche);
        System.out.println("Disponibilidad: " + (disponible ? "Disponible" : "No disponible"));
    }
}
