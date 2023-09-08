package Tarea01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author fredy
 */
public class DevTarea {    
    public static void main(String[] args) {
        ArrayList<almacen> data = new ArrayList<>();
        Scanner cn = new Scanner(System.in);
        
        while(true){
            System.out.println("""
|----------------------------------|
|-------INVENTARIO DE VENTAS-------|
|----------------------------------|
| [1] Agregar venta                |
| [2] Eliminar venta               |
| [3] Editar venta                 |
| [4] Listar ventas                |
| [5] Salir                        |
|----------------------------------|
            """);
            System.out.print("Ingrese la opcion: ");
            byte opcion = cn.nextByte();
            switch(opcion) {
                case 1: agregar(data, cn); break;
                case 2: eliminar(data, cn); break;
                case 3: editar(data, cn); break;
                case 4: mostrar(data, cn); break;
                case 5:
                    System.out.println("\n\n=> Gestion de ventas finalizada :D");
                    return;
                default: continuar("\n=> Opcion invalida D:");
            }
        }
    }
    
    static void continuar(String mensaje) {
        System.out.println(mensaje);
        System.out.print("Presione una tecla para continuar...");
        try{System.in.read();}
        catch(Exception e){}
        System.out.println("\n");
    }
    
    static almacen encontrarVenta(ArrayList<almacen> data, Scanner cn) {
        String codigo;
        System.out.print("~ Ingrese el codigo de la venta: ");
        codigo = cn.next();
        for(almacen venta: data) {
            if(venta.getCodigo().equals(codigo)) {
                return venta;
            }
        }
        return null;
    }
    
    static void mostrar(ArrayList<almacen> data, Scanner cn){
        int indice = 1;
        System.out.println("\n# LISTADO DE VENTAS");
        if(!data.isEmpty()) {
            for(almacen venta : data) {
                System.out.println("\n~ VENTA N°" + indice);
                System.out.println("~ Marca: " + venta.getMarca());
                System.out.println("~ Requerimiento: " + venta.getRequerimiento());
                System.out.println("~ Estado financiero: " + venta.getEstadoFinanciero());
                System.out.println("~ Vendendor: " + venta.getVendendor());
                System.out.println("~ Fecha de compra: " + venta.getFecha_compra());
                System.out.println("~ Sexo: " + venta.getSexo());
                System.out.println("~ Codigo: " + venta.getCodigo());
                indice+=1;
            }   
            continuar("\n=> Listado mostrado con exito :D");
        }else{
            continuar("\n=> El listado a mostrar esta vacio D:");
        }
    }
    
    static void agregar(ArrayList<almacen> data, Scanner cn){
        String marca, requerimiento, vendedor, fecha_compra, codigo;
        char sexo;
        float estado_financiero;
        System.out.println("\n# REGISTRO DE VENTAS");
        System.out.print("~ Ingrese la marca: ");
        marca = cn.next();
        System.out.print("~ Ingrese el requerimiento: ");
        requerimiento = cn.next();
        System.out.print("~ Ingrese el estado financiero (S/.): ");
        estado_financiero = cn.nextFloat();
        System.out.print("~ Ingrese el vendedor: ");
        vendedor = cn.next();
        System.out.print("~ Ingrese la fecha de compra: ");
        fecha_compra = cn.next();
        System.out.print("~ Ingrese el sexo (M/F): ");
        sexo = cn.next().charAt(0);
        System.out.print("~ Ingrese el codigo: ");
        codigo = cn.next();
        almacen nuevaVenta = new almacen(marca, requerimiento, estado_financiero, vendedor, fecha_compra, sexo, codigo);
        data.add(nuevaVenta);
        continuar("\n=> Venta registrada con exito :D");
    }

    static void editar(ArrayList<almacen> data, Scanner cn){
        almacen venta;
        String marca, requerimiento, vendedor, fecha_compra, codigo;
        char sexo;
        float estado_financiero;
        System.out.println("\n# EDICION DE VENTA");
        venta = encontrarVenta(data, cn);
        if(venta != null){
            System.out.print("~ Ingrese la marca [" + venta.getMarca() + "]: ");
            marca = cn.next();
            venta.setMarca(marca);
            System.out.print("~ Ingrese el requerimiento [" + venta.getRequerimiento()+ "]: ");
            requerimiento = cn.next();
            venta.setRequerimiento(requerimiento);
            System.out.print("~ Ingrese el estado financiero (S/.) [" + venta.getEstadoFinanciero() + "]: ");
            estado_financiero = cn.nextFloat();
            venta.setEstadoFinanciero(estado_financiero);
            System.out.print("~ Ingrese el vendendor [" + venta.getVendendor()+ "]: ");
            vendedor = cn.next();
            venta.setVendendor(vendedor);
            System.out.print("~ Ingrese la fecha de compra [" + venta.getFecha_compra()+ "]: ");
            fecha_compra = cn.next();
            venta.setFecha_compra(fecha_compra);
            System.out.print("~ Ingrese el sexo (M/F) [" + venta.getSexo()+ "]: ");
            sexo = cn.next().charAt(0);
            venta.setSexo(sexo);
            System.out.print("~ Ingrese el codigo [" + venta.getCodigo()+ "]: ");
            codigo = cn.next();
            venta.setCodigo(codigo);
            System.out.println(data.get(0).getEstadoFinanciero());
            continuar("\n=> Venta editada con exito :D");
        }else{
            continuar("\n=> La venta a editar no existe :D");
        }
    }
    
    static void eliminar(ArrayList<almacen> data, Scanner cn) {
        almacen venta;
        System.out.println("\n# ELIMINACION DE VENTA");
        venta = encontrarVenta(data, cn);
        if(venta != null) {
            data.remove(venta);
            continuar("\n=> Venta eliminada con exito :D");            
        }else {
            continuar("\n=> La venta a eliminar no existe D:");                        
        }
    }
}
