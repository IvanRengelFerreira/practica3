package mates;
import java.util.stream.*;

public class Matematicas {
      /*** Genera una aproximació n al número pi mediante el método de* Montecarlo. El parámetro ` pasos` indica el número de puntos generado.*/
    //El método es estático, ya que no necesitamos crear un objeto de la clase Matematicas para poder usarlo
    //Estamos usando flujos y lambda
    
    /**
     * Genera una aproximación al número pi mediante el método de Montecarlo. El parámetro `pasos` indica el número de puntos generados.
     * 
     * @param pasos El número de puntos generados.
     * @return Una aproximación al número pi.
     */

    public static double generarNumeroPiLambda(long pasos) {
        long dentroCirculo = IntStream
        //Generamos un rango de 0 a pasos usamos closed para que incluya el valor de pasos
            .rangeClosed(0, (int) pasos)
        //Usamos parallel para que se ejecute en paralelo y sea más rápido por la cantidad de datos que se generan, 
        //De forma secuencial se tarda mucho más
            .parallel()
        //Usamos un mapToObj para convertir los valores de i a un array de dos posiciones con valores aleatorios entre 0 y 1
            .mapToObj(i -> new double[] {
                    Math.random(), Math.random() })
        //Filtramos los valores que estén dentro del círculo, es decir, que cumplan con la condición de que x^2 + y^2 <= 1
            .filter(par -> par[0] * par[0] + par[1] * par[1] <= 1)
        //Contamos los valores que cumplen con la condición, usamos el metodo count que es terminal en un flujo
            .count();
        return 4.0 * dentroCirculo / pasos;
    }
}
