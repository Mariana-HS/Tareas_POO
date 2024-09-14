public class Main {
    public static void main(String[] args) {

        Curso curso1 = new Curso("Programacion", "PROG1201", "Ing. Eder Rivera");
        Curso curso2 = new Curso("Matematicas Discretas", "M4T3S1", "Ing. Alfredo Murillo");
        Curso curso3 = new Curso("Algebra lineal", "ALG3BR4", "Oskar Gonzalez");


        Estudiante alumnoUno = new Estudiante("Mariana Herrejon Silva", "l24120365");
        Estudiante alumnoDos = new Estudiante("Leslye Ayala Magaña", "l24120363");



        alumnoUno.agregarCurso(curso3);
        alumnoDos.agregarCurso(curso1);

        alumnoUno.agregarCurso(curso2);
        alumnoDos.agregarCurso(curso3);

        alumnoUno.mostrarInformacion();
        System.out.println("\n");
        alumnoDos.mostrarInformacion();

    }
}
