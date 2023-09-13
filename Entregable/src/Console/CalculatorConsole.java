
package Console;

import Calculator.Calculator;
import Cajero.Cajero;

import java.util.Scanner;

public class CalculatorConsole {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Calculator calculator = new Calculator();
        Cajero cajero = new Cajero();
        
        double num1 = 0, num2 = 0;
        boolean on = true;
        int value;
        
        System.out.println("+-----------------+");
        System.out.println("|    CALCULATOR   |");
        System.out.println("+-----------------+");
        
        while(on){
            
            try{
                System.out.print("Number: ");
                num1 = sc.nextDouble();
                System.out.print("Number: ");
                num2 = sc.nextDouble();

            } catch(Exception e){
                System.out.println("Error: " + e);
                break;
            }
            
            System.out.println("+-----------------+");
            System.out.println("| OPTIONS");
            System.out.println("+-----------------+");
            System.out.println("| 1. SUMAR");
            System.out.println("| 2. RESTAR");
            System.out.println("| 3. MULTIPLICAR");
            System.out.println("| 4. DIVIDIR");
            System.out.println("| 5. EXIT");
            System.out.println("+-----------------+");
            System.out.print(">> ");
            value = sc.nextInt();
            
            switch(value){
                case 1:
                    System.out.println("Suma: " + calculator.sumar(num1, num2));
                    System.out.println("+-----------------+");
                    break;
                case 2:
                    System.out.println("Resta: " + calculator.restar(num1, num2));
                    System.out.println("+-----------------+");
                    break;
                case 3:
                    System.out.println("Multiplicacion: " + calculator.multiplicar(num1, num2));
                    System.out.println("+-----------------+");
                    break;
                case 4:
                    
                    if(num2 != 0){
                        System.out.println("Division: " + calculator.dividir(num1, num2));
                        System.out.println("+-----------------+");
                    } else{
                        System.out.println(">> NO SE PUEDE DIVIDIR ENTRE 0");
                        System.out.println("+-----------------+");
                    }

                    break;
                case 5:
                    on = cajero.exit(on);
                    break;
                default:
                    System.out.println(">> Ingrese alguna de las Opciones");
                    System.out.println("+-----------------+");
                    break;
            }
            
        }
        
    }
}
