package DEV;

import java.util.ArrayList;

/**
 *
 * @author fredy
 */
public class ClassCajero {
    //-----Atributos para la gestion del cajero-----//
    private String usuario;
    private float monto;
    public enum EstadoActual {
        LOGIN,
        CAJERO,
        TRANSACCION
    }
    private EstadoActual estadoActual = EstadoActual.LOGIN;
    private boolean depositando;
    private final ArrayList<ClassHistorial> historial = new ArrayList();
    
    //-----Metodos getters y setter-----//
    public ClassCajero(String usuario, float saldo) {
        this.usuario = usuario;
        this.monto = saldo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    } 
    
    //-----Estados del cajero-----//
    public boolean getDepositando() {
        return depositando;
    }
    
    public void setDepositando(boolean depositando) {
        this.depositando = depositando;
    }
    
    public EstadoActual obtenerEstadoActual() {
        return estadoActual;
    }
    
    public void cambiarEstadoLogin() {
        this.estadoActual = EstadoActual.LOGIN;
    }
    
    public void cambiarEstadoCajero() {
        this.estadoActual = EstadoActual.CAJERO;
    }
    
    public void cambiarEstadoTransaccion () {
        this.estadoActual = EstadoActual.TRANSACCION;
    }
    
    //-----Metodos del historial-----//
    public void agregarHistorial(ClassHistorial transaccion) {
        this.historial.add(transaccion);
    }
    
    public ArrayList<ClassHistorial> obtenerHistorial() {
        return historial;
    }
}