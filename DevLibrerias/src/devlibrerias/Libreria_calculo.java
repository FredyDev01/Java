package devlibrerias;

/**
 *
 * @author fredy
 */
public class Libreria_calculo {
    public float calcularMonto(float precio, int cantidad) {
        if(precio > 10) {
            precio = precio - (precio * 0.02f);
        }
        return precio * cantidad;
    }
    
    public float calcularIgv(float precio) {
        return precio * 0.18f;
    }
}
