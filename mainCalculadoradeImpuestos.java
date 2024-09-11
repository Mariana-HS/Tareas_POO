import calculadoraimpuestos.Calculadora;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calculadora = new Calculadora();

        System.out.println("Ingresar ingresos: ");
        int ingresos = scanner.nextInt();
        System.out.println("Ingresar porcentaje de impuestos: ");
        Double porcentajeimpuestos = scanner.nextDouble();
        System.out.println("Ingresar dividendos: ");
        Double dividendos = scanner.nextDouble();
        System.out.println("Ingresar execión: ");
        Double execion = scanner.nextDouble();

        if(porcentajeimpuestos <= 0 && dividendos <= 0 && execion <= 0){
            System.out.println("Tu ingreso queda en: "+ calculadora.calcularImpuestos(ingresos));
        }
        else if (dividendos <= 0 && execion <= 0) {
            System.out.println("Tu ingreso con porcentaje de impuesto es: "+ calculadora.calcularImpuestos(ingresos, porcentajeimpuestos));
        }
        else {
            System.out.println("Tus impuestos son: "+ calculadora.calcularImpuestos(porcentajeimpuestos, dividendos, execion) );
        }
    }
}