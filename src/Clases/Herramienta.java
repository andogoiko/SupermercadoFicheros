package Clases;

import Interfaces.Enviable;

import java.util.Scanner;

public class Herramienta extends NoPerecedero implements Enviable {

    private final double VALOR_IVA = 0.4;
    private final double TARIFA_ENVIO = 3.71;
    private final boolean esFragil = false;

    public Herramienta(){}

    public Herramienta(int codigo, String nombre, double precio, int cantidad, double peso) {
        super(codigo, nombre, precio, cantidad, peso);
        setIva(VALOR_IVA);
    }

    public Herramienta(Scanner in){
        super(in);
        setIva(VALOR_IVA);
    }

    @Override

    public boolean envioFragil(){

        return esFragil;
    }

    @Override

    public double tarifaEnvio(){

        return TARIFA_ENVIO;
    }

    @Override

    public String volcar(){

        return super.volcar() + " Herramienta\n";
    }

    @Override

    public void imprimir(){
        super.imprimir();
        System.out.printf("Herramienta\n");
    }

    @Override

    public void imprimirEnvio(){
        super.imprimirEnvio();
    }

    @Override

    public double getPeso(){

        return super.getPeso();
    }

}
