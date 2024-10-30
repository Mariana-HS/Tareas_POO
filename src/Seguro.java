public abstract class Seguro {
    public String nombreTitular;
    public double valorAsegurado;

    public Seguro(String nombreTitular, double valorAsegurado) {
        this.nombreTitular = nombreTitular;
        this.valorAsegurado = valorAsegurado;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public double getValorAsegurado() {
        return valorAsegurado;
    }

    public abstract double calcularPrima();

    public void detallesSeguro() {
        System.out.println("Titular: " + nombreTitular);
        System.out.println("Valor Asegurado: $" + valorAsegurado);
        System.out.println("Prima Anual: $" + calcularPrima());
    }
}
