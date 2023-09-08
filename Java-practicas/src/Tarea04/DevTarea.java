package Tarea04;
import devlibrerias.Libreria_semana03;
import java.util.Scanner;

/**
 *
 * @author Academico
 */
public class DevTarea {
    public static void main(String[] args) {
        //EJEMPLOS
        System.out.println("::: Laboratorio 01 :::");
        System.out.println("\n=> EJEMPLOS");
        String respuesta = "Si";
        if(respuesta.equals("Si")) {
            System.out.println("Entre al trabajo :D");
        }else {
            System.out.println("No entre al trabajo D:");
        }
        if(2 == 2) {
            System.out.println("Siuu");
        }
        
        //Ejercicio 1
        Scanner sc = new Scanner(System.in);
        Libreria_semana03 lbNotas = new Libreria_semana03();
        int num1, num2, num3;
        System.out.println("\n=> Ejercicio 1");
        System.out.print("Ingrese el primer numero: ");
        num1 = sc.nextInt();
        System.out.print("Ingrese el segundo numero: ");
        num2 = sc.nextInt();
        System.out.print("Ingrese el tercer numero: ");
        num3 = sc.nextInt();
        lbNotas.getMayorMenorNum(num1, num2, num3);
        //Ejercicio 2
        int nota = 15;
        System.out.println("\n=> Ejercicio 2");
        lbNotas.getEstadoNota(nota);
    }
}
