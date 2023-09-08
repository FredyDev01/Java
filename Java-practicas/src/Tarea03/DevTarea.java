package Tarea03;
import devlibrerias.Libreria_calculo;
import devlibrerias.Libreria_date;

/**
 *
 * @author fredy
 */
public class DevTarea {
    public static void main(String[] args) {
        //Generar calculos de venta
        Libreria_calculo lb1 = new Libreria_calculo();
        System.out.println(String.format("El precio final es: %.2f", lb1.calcularMonto(12, 5)));
        System.out.println(String.format("EL igv es: %.2f", lb1.calcularIgv(12)));
        //Imprimir los meses
        Libreria_date lb2 = new Libreria_date();
        System.out.println("\nEl primer mes es " + lb2.obtenerMes(1));
        System.out.println("El cuarto mes es " + lb2.obtenerMes(4));
        System.out.println("El ultimo mes es " + lb2.obtenerMes(12));
        lb2.obtenerMes(13);
    }
}
