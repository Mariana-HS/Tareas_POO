public class SeguroAuto extends Seguro {
    private int edadTitular;

    public SeguroAuto(String nombreTitular, double valorAsegurado, int edadTitular) {
        super(nombreTitular, valorAsegurado);
        this.edadTitular = edadTitular;
    }

    @Override
    public double calcularPrima() {
        double prima = 300 + (0.05 * valorAsegurado);
        if (edadTitular < 25) {
            prima += prima * 0.15;
        }
        return prima;
    }

    @Override
    public void detallesSeguro() {
        super.detallesSeguro();
        System.out.println("Tipo de Seguro: Auto");
        System.out.println("Edad del Titular: " + edadTitular + " años");
    }
}

