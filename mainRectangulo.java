import rectangulo.Rectangulo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Rectangulo rectangulo = new Rectangulo();

        System.out.println("Desea los datos del rectangulo en enteros o decimales?");
        String respuesta = scanner.nextLine();

        System.out.println("Ingresa los datos del rectángulo: ");


        if(respuesta == "decimal"){
            System.out.println("Lado horizontal: ");
            Double base= scanner.nextDouble();
            System.out.println("Lado veritical: ");
            Double altura= scanner.nextDouble();

            System.out.println("El área del rectángulo es: " +  rectangulo.calcularArea(base, altura));
            System.out.println("El perímetro del rectángulo es: " + rectangulo.calcularPerimetro(base, altura));
        }
        else{
            System.out.println("Lado horizontal: ");
            int base= scanner.nextInt();
            System.out.println("Lado veritical: ");
            int altura= scanner.nextInt();

            System.out.println("El area de rectangulo es: "+ rectangulo.calcularArea(base, altura));
            System.out.println("El perimetro del rectangulo es: "+ rectangulo.calcularPerimetro(base,altura));
        }


    }
}