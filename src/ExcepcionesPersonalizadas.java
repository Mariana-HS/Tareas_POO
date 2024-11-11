public class ExcepcionesPersonalizadas {

    public static class HabitacionNoDisponibleException extends Exception {
        public HabitacionNoDisponibleException(String mensaje) {
            super(mensaje);
        }
    }

    public static class NumeroDeNochesInvalidoException extends Exception {
        public NumeroDeNochesInvalidoException(String mensaje) {
            super(mensaje);
        }
    }
}
