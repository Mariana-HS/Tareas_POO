import empleado.Empleado;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empleado empleado = new Empleado();

        System.out.println("Ingresar sueldo: ");
        Double sueldo = scanner.nextDouble();
        System.out.println("Ingresar bonificación: ");
        Double bonificacion = scanner.nextDouble();
        System.out.println("Ingresar horas extras: ");
        Double horas = scanner.nextDouble();

        if(bonificacion <= 0 && horas <= 0){
            System.out.println("Tu sueldo queda en: "+ empleado.calcularSalario(sueldo));
        }
        else if (horas <= 0) {
            System.out.println("Tu sueldo mas bonificaión es: "+ empleado.calcularSalario(sueldo, bonificacion));
        }
        else {
            System.out.println("Tu salario final es de: "+ empleado.calcularSalario(sueldo, bonificacion, horas));
        }

    }

    }