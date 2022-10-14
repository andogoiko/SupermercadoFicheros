package Clases;

import Interfaces.Enviable;

import java.util.Scanner;

public abstract class Perecedero extends Producto implements Enviable {

    private String fechacad;
    private final double TARIFA_ENVIO = 1.71;
    private final boolean esFragil = false;

    public Perecedero(){

    }

    public Perecedero(int codigo, String nombre, double precio, int cantidad, double peso, String fechacad) {

        super(codigo, nombre, precio, cantidad, peso);
        this.fechacad = fechacad;
    }

    public Perecedero (Scanner in){
        super(in);

        System.out.println("Introduce la fecha de caducidad del producto (--/--/--):");

        while (true){

            try{
                fechacad = in.nextLine();
                break;
            }catch (Exception e){
                System.out.println("fecha incorrecta, vuelva a introducirla");
            }

        }

    }

    @Override

    public double tarifaEnvio(){

        return TARIFA_ENVIO;
    }

    @Override

    public void imprimir(){
        super.imprimir();

        System.out.printf("(Producto perecedero: %s), ", fechacad);
    }

    @Override

    public String volcar(){

        String respuesta = super.volcar();

        respuesta = respuesta + " " + fechacad;


        return respuesta;
    }

    @Override

    public void imprimirEnvio(){
        super.imprimirEnvio();
    }

    @Override

    public boolean envioFragil(){

        return esFragil;
    }

    @Override

    public double getPeso(){

        return super.getPeso();
    }

}
