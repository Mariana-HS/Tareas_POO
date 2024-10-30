public class SeguroHogar extends Seguro {
    private boolean zonaDeRiesgo;

    public SeguroHogar(String nombreTitular, double valorAsegurado, boolean zonaDeRiesgo) {
        super(nombreTitular, valorAsegurado);
        this.zonaDeRiesgo = zonaDeRiesgo;
    }

    @Override
    public double calcularPrima() {
        double prima = 500 + (0.02 * valorAsegurado);
        if (zonaDeRiesgo) {
            prima += prima * 0.20;
        }
        return prima;
    }

    @Override
    public void detallesSeguro() {
        super.detallesSeguro();
        System.out.println("Tipo de Seguro: Hogar");
        System.out.println("Zona de Riesgo: " + (zonaDeRiesgo ? "Sí" : "No"));
    }
}
