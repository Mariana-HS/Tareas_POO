public class SistemaReservas {
    public Habitacion[] habitaciones;

    public SistemaReservas() {
        habitaciones = new Habitacion[3];
        habitaciones[0] = new Habitacion("Individual", 50.0);
        habitaciones[1] = new Habitacion("Doble", 75.0);
        habitaciones[2] = new Habitacion("Suite", 150.0);
    }

    public void mostrarHabitaciones() {
        for (int i = 0; i < habitaciones.length; i++) {
            habitaciones[i].mostrarDetalles();
        }
    }

    public void reservarHabitacion(int numHabitacion, int noches) {
        try {
            habitaciones[numHabitacion].reservar(noches);
            double costoTotal = habitaciones[numHabitacion].precioPorNoche * noches;
            System.out.println("Costo total de la reserva: $" + costoTotal);
        } catch (ExcepcionesPersonalizadas.HabitacionNoDisponibleException e) {
            System.out.println(e.getMessage());
        } catch (ExcepcionesPersonalizadas.NumeroDeNochesInvalidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void liberarHabitacion(int numHabitacion) {
        habitaciones[numHabitacion].liberar();
    }

}
