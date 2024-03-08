package aplicacion;
import java.util.Scanner;

import mates.Matematicas;

public class Principal{

    //En principal impriminos el valor de PI siendo calculado con el método de Montecarlo con 1000 de pasos, los pasos son el número de puntos generados y dara la cantidad de decimales que se quieren calcular
  
    public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese el número de decimales en funcion de potencias de 10 para calcular el número PI(Ejemplo: 1000000):");
    
    long pasos = sc.nextLong();
      
    System.out.println("El numero PI es " +Matematicas.generarNumeroPiLambda(pasos));
    }
}