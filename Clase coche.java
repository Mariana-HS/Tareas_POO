package coche;

public class coche {
    public String marca;
    public String modelo;
    public int año;
    public int añoactual;

    public coche(String marca, String modelo, int año) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
    }

    public void mostrarInformacion() {
        System.out.println("Marca: " + this.marca
                + " , Modelo: " + this.modelo
                + " , Año: " + this.año);
    }

    public int calcularedadcoche(int añoactual) {
       return añoactual-año;
    }
}
