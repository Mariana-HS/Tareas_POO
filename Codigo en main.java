import coche.coche;

import coche.coche;

public class Main {
    public static void main(String[] args) {
        System.out.println("Coche UNO:");
        coche cocheUno= new coche ( "Audi", "R8", 2013);
        cocheUno.mostrarInformacion();
        System.out.println("La edad del coche es: "+ cocheUno.calcularedadcoche(2024));

        System.out.println("\n");
        System.out.println("Coche DOS:");
        coche cocheDos = new coche( "Ferrari", "962", 2005);
        cocheDos.mostrarInformacion();
        System.out.println("La edad del coche es: "+ cocheDos.calcularedadcoche(2024));

        System.out.println("\n");
        System.out.println("Coche TRES:");
        coche cocheTres = new coche( "Mazda", "MK600", 1998);
        cocheTres.mostrarInformacion();
        System.out.println("La edad del coche es: "+ cocheTres.calcularedadcoche(2024));
    }
}