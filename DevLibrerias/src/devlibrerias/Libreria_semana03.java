package devlibrerias;

/**
 *
 * @author Academico
 */
public class Libreria_semana03 {
    public void getEstadoNota(int nota) {
        String rst;
        if(nota <= 20 && nota > 18) {
            rst = "Excelente";
        }else if(nota <= 18 && nota > 15) {
            rst = "Muy bueno";
        }else if(nota <= 15 && nota > 13) {
            rst = "Bueno";
        }else if(nota <= 13 && nota > 11) {
            rst = "Regular";
        }else if(nota <= 11 && nota > 10) {
            rst = "Bajo";
        }else {
            rst = "Desaprobado";
        }
        System.out.println("El estado de su nota es: " + rst);
    }

    public void getMayorMenorNum(int num1, int num2, int num3) {
        int may = 0, men = 0;
        if(num1 > num2 && num1 > num3) {
            may = num1;
            men = num2 > num3 ? num3 : num2;
        }else if(num2 > num3 && num2 > num3) {
            may = num2;
            men = num1 > num3 ? num3 : num1;
        }else if(num3 > num1 && num3 > num2) {
            may = num3;
            men = num1 > num2 ? num2 : num1;
        }else {
            System.out.println("Son iguales ");
        }
        System.out.println("El mayor es: " + may + "\nEl menor es: " + men);        
    }
}
