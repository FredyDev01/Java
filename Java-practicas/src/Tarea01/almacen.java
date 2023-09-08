package Tarea01;

import java.util.Date;


/**
 *
 * @author fredy
 */
public class almacen {
    private String marca;
    private String requerimiento;
    private float estado_financiero;
    private String vendendor;
    private String fecha_compra;
    private char sexo;
    private String codigo;

    public almacen(String marca, String requerimiento, float estado_financiero, String vendendor, String fecha_compra, char sexo, String codigo) {
        this.marca = marca;
        this.requerimiento = requerimiento;
        this.estado_financiero = estado_financiero;
        this.vendendor = vendendor;
        this.fecha_compra = fecha_compra;
        this.sexo = sexo;
        this.codigo = codigo;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getRequerimiento() {
        return requerimiento;
    }

    public void setRequerimiento(String requerimiento) {
        this.requerimiento = requerimiento;
    }

    public float getEstadoFinanciero() {
        return estado_financiero;
    }

    public void setEstadoFinanciero(float estado_financiero) {
        this.estado_financiero = estado_financiero;
    }

    public String getVendendor() {
        return vendendor;
    }

    public void setVendendor(String vendendor) {
        this.vendendor = vendendor;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
