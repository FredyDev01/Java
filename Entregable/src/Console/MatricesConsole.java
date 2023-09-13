
package Console;

public class MatricesConsole {
    public static void main(String[] args) {
        
        String[][] matriz = {
            {"N", "24", "2"}, 
            {"L", "25", "1"},
            {"S", "30", "3"}
        };

        int value = 0;
   
        System.out.println("+---------------------------------------+");
        System.out.println("| Terminacion | Horas Taller | Horas A. |");
        System.out.println("+---------------------------------------+");
        
        for(int i=0;i<3;i++){
            System.out.print("| ");
            for(int j=0;j<3;j++){
 
                if(j!=0){
                    value += Integer.parseInt(matriz[i][j]);
                }
                
                System.out.print(matriz[i][j] + "           | ");
            }
            System.out.println("Horas Totales: " + value);
            System.out.println(" ");
            value = 0;
        }
        
    }
}
