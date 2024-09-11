package rectangulo;

public class Rectangulo {

    public Double base;
    public Double altura;


    public Rectangulo() {
        base = base;
        altura = altura;
    }

    public Double calcularArea(Double base, Double altura){
        return base * altura;
    }
    public Double calcularPerimetro(Double base, Double altura){
        return (base + altura)*2;
    }

    public int calcularArea(int base, int altura){
        return  base * altura;
    }
    public int calcularPerimetro (int base, int altura){
        return  (base + altura)*2;
    }

}
