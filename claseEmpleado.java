package empleado;

public class Empleado {
    public Double sueldo;
    public Double bonificacion;
    public Double horas;

   public Empleado(){
       sueldo=sueldo;
       bonificacion=bonificacion;
       horas=horas;
}

    public Double calcularSalario(Double sueldo){
        return sueldo;
    }
    public Double calcularSalario(Double sueldo, Double bonificacion){
        return sueldo + bonificacion;
    }
    public Double calcularSalario(Double sueldo, Double bonificacion, Double horas){
        return sueldo + bonificacion + (horas * 20);
    }
}