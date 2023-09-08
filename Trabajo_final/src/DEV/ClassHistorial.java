package DEV;

/**
 *
 * @author fredy
 */
public class ClassHistorial {
    private float monto;
    public enum TipoTransaccion {
        DEPOSITO,
        RETIRO
    }
    private TipoTransaccion tipo;

    public ClassHistorial(float monto, TipoTransaccion tipo) {
        this.monto = monto;
        this.tipo = tipo;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public TipoTransaccion getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransaccion tipo) {
        this.tipo = tipo;
    }
}