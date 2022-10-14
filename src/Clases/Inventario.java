package Clases;

import Interfaces.Enviable;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

public class Inventario implements Iterable<Producto>{

    private static ArrayList<Producto> listaProductos;

    private static String ficheroInventario;
    private static int ultimoCodigo;

    private static  Inventario instance;

    private Inventario(){
        listaProductos = new ArrayList<Producto>();
    }

    public static Inventario getInstance(){

        if(instance == null){
            instance = new Inventario();
        }

        return instance;
    }

    public static void cargarProductos(){

        System.out.println("========================================================================");
        System.out.println("=                        CARGANDO PRODUCTOS ...                        =");
        System.out.println("========================================================================");

        ArrayList<Producto> desrializaedClubs = new ArrayList<Producto>();

        try{

            FileInputStream fichero = new FileInputStream("src/data/productosSave.txt");

            /* deserializar XML a objeto */

            /*ObjectInputStream lectorObjeto = new ObjectInputStream(fichero);

            listaProductos = (ArrayList<Producto>)lectorObjeto.readObject();*/

            /* deserializar XML a objeto */

            XMLDecoder lectorXML = new XMLDecoder(new BufferedInputStream(fichero));

            listaProductos = (ArrayList<Producto>)lectorXML.readObject();

        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("========================================================================");
        System.out.println("=                     CARGA DE PRODUCTOS COMPLETA                      =");
        System.out.println("========================================================================");

    }

    public static void guardarProductos(){

        try  {

            FileOutputStream  archivo = new FileOutputStream ("src/data/productosSave.txt");

            /* serializar objeto a binario */

            /*ObjectOutputStream serializadorObjetos = new ObjectOutputStream(archivo);

            serializadorObjetos.writeObject(listaProductos);

            serializadorObjetos.close();
            archivo.close();*/

            /* serializar objeto a XML */

            XMLEncoder serializadorXML = new XMLEncoder(new BufferedOutputStream(archivo));

            serializadorXML.writeObject(listaProductos);
            serializadorXML.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addNuevoProducto(Producto producto){

        listaProductos.add(producto);
    }

    public static void mostrarProductos(){
        listaProductos.forEach(producto -> {
            if(producto != null){
                producto.imprimir();
            }
        });

    }

    public static Producto getProducto(int id){

        return listaProductos.get(id - 1);
    }

    public static void actualizarCantidad(int codigo, int cantidad){

        listaProductos.get(codigo).setCantidad(cantidad);
    }

    public static int tamanyo(){

        return listaProductos.size();
    }

    public static void mostrarProductosEnviables(){
        listaProductos.forEach(producto -> {
            if(producto != null &&  producto instanceof Enviable){
                if(!((Enviable) producto).envioFragil()){
                    System.out.printf("Id: %d, Nombre: %s, peso: %.1f, IVA (%.2f%s), tarifa de envío: %.2f, PRECIO-TOTAL: %.2f\n", producto.getCodigo(), producto.getNombre(), producto.getPeso(), producto.getIva(), new String(new char[] { 37 }), ((Enviable) producto).tarifaEnvio(), (producto.calcularPrecioIVA() + ((Enviable) producto).tarifaEnvio()));
                }else{
                    System.out.printf("Id: %d, Nombre: %s, peso: %.1f, IVA (%.2f%s), tarifa de envío: %.2f, Producto frágil, PRECIO-TOTAL: %.2f\n", producto.getCodigo(), producto.getNombre(), producto.getPeso(), producto.getIva(), new String(new char[] { 37 }), ((Enviable) producto).tarifaEnvio(), (producto.calcularPrecioIVA() + ((Enviable) producto).tarifaEnvio()));
                }

            }
        });
    }

    public static void eliminarProducto(int id){
        listaProductos.set(id, null);
    }

    @Override
    public Iterator iterator() {
        return listaProductos.iterator();
    }
}
