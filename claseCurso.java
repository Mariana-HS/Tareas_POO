public class Curso {
    public String nombreCurso;
    public String codigoCurso;
    public String instructor;

    public Curso(String nombreCurso, String codigoCurso, String instructor) {
        this.nombreCurso = nombreCurso;
        this.codigoCurso = codigoCurso;
        this.instructor = instructor;
    }

    public void mostrarInfoCurso() {
        System.out.println("Nombre del curso: " + nombreCurso);
        System.out.println("Código del curso: " + codigoCurso);
        System.out.println("Instructor: " + instructor);
    }

    // Getters y setters (opcional)
    public String getNombreCurso() {
        return nombreCurso;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public String getInstructor() {
        return instructor;
    }
}