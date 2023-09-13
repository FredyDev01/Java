
package Console;
import java.util.Scanner;
import Cajero.Cajero;

public class CajeroConsole {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Cajero cajero = new Cajero();
        
        boolean on = false, check;
        String user = "";
        double cash = 0, mount;
        int value;
        
        System.out.println("+-------------------------------------+");
        System.out.println("           CAJERO AUTOMATICO ");
        System.out.println("+-------------------------------------+");
        
        try{
            
            System.out.print(">> User: "); 
            user = sc.nextLine();

            System.out.println("+-------------------------------------+");
            System.out.print("Cash S/: ");
            cash = sc.nextDouble();
                       
            on = true;
        } catch(Exception e){
            System.out.println("Error: " + e);
        }
        
        while(on){
        
            System.out.println("+-------------------------------------+");
            System.out.println("| 1. DEPOSITAR");
            System.out.println("| 2. RETIRAR");
            System.out.println("| 3. CONSULTAR");
            System.out.println("| 4. SALIR");
            System.out.println("+-------------------------------------+");
            System.out.print(">> OPTION: ");
            value = sc.nextInt();
            
            switch(value){
                case 1:
                    System.out.println("+-------------------------------------+");
                    System.out.print("| Monto: S/ ");
                    mount = sc.nextDouble();
                    
                    check = (mount<=0) ? false : true;
                    
                    if(check){
                        cash = cajero.Depositar(cash, mount);
                        System.out.println("+-------------------------------------+");
                        System.out.println(">> DEPOSITO EXITOSO");
                    } else{
                        System.out.println(">> SOLO SE ADMITE DEPOSITO DE CANTIDADES POSITIVAS");
                    }
                    break;
                    
                case 2:
                    System.out.println("+-------------------------------------+");
                    System.out.print("| Retiro: S/ ");
                    mount = sc.nextDouble();
                    
                    check = (mount>cash) ? false : true;
                    
                    if(check){
                        cash = cajero.Retirar(cash, mount);
                        System.out.println(">> RETIRO EXITOSO");
                    } else{
                        System.out.println(">> NO SE PUEDE RETIRAR MAS DEL MONTO ACTUAL");
                    }
                    break;
                    
                case 3:
                    cajero.getCash(cash);
                    break;
                    
                case 4:
                    on = cajero.exit(on);
                    break;
                   
            }

        }
                   
    }
}
