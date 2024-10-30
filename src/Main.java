public class Main {
    public static void main(String[] args) {
        Seguro seguroAuto = new SeguroAuto("Mariana Herrejon", 15000, 22);
        Seguro seguroHogar = new SeguroHogar("Abraham Herrejon", 300000, true);
        Seguro seguroVida = new SeguroVida("Miriam Silva", 100000, 53);

        System.out.println("Detalles del Seguro de Auto:");
        seguroAuto.detallesSeguro();

        System.out.println("\nDetalles del Seguro de Hogar:");
        seguroHogar.detallesSeguro();

        System.out.println("\nDetalles del Seguro de Vida:");
        seguroVida.detallesSeguro();
    }
}