package calculadoraimpuestos;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Calculadora {
    public int ingresos;
    public Double porcentajeimpuestos;
    public Double dividendos;
    public Double execion;
    public Double impuestos;

    public Calculadora(){
        this.ingresos= ingresos;
        this.porcentajeimpuestos= porcentajeimpuestos;
        this.dividendos= dividendos;
        this.execion= execion;
        this.impuestos= impuestos;
    }
    public Double calcularImpuestos(int ingresos){
        return  (ingresos + 0.15);
    }
    public Double calcularImpuestos(int ingresos, Double porcentajeimpuestos){
        return ingresos * (porcentajeimpuestos/100);
    }
    public Double calcularImpuestos(Double porcentajeimpuestos, Double dividendos, Double execion){
        impuestos= dividendos*(porcentajeimpuestos/100);
        if(impuestos > execion){
         return impuestos-execion;
        }
        else {
         return impuestos-impuestos;
        }
    }
}