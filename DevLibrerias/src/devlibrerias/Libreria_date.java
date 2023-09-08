package devlibrerias;

/**
 *
 * @author fredy
 */
public class Libreria_date {
    public String obtenerMes(int nmrMes) {
        try{
            int indice = nmrMes - 1;
            String[] meses = {
                "Enero", 
                "Febrero",
                "Marzo",
                "Abril",
                "Mayo",
                "Junio",
                "Julio",
                "Agosto",
                "Septiembre",
                "Octubre",
                "Noviembre",
                "Diciembre"
            };
        return meses[indice];
        }catch(Exception err) {
            System.out.println("El mes seleccionado no existe.");
            return "";
        }
    }
}
