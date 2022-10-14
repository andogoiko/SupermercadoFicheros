package Clases;

import java.util.Scanner;

public class Otros extends NoPerecedero{

    private String categoria;
    private final double VALOR_IVA = 0.16;

    public Otros(){}

    public Otros(int codigo, String nombre, double precio, int cantidad, double peso, String categoria) {

        super(codigo, nombre, precio, cantidad, peso);
        this.categoria = categoria;

        setIva(VALOR_IVA);

    }

    public Otros(Scanner in){
        super(in);

        System.out.println("Introduce la categoría del producto:");

        while (true){

            try{
                categoria = in.nextLine();
                break;
            }catch (Exception e){
                System.out.println("Categoria incorrecta, vuelva a introducirla");
            }

        }

        setIva(VALOR_IVA);
    }

    @Override

    public String volcar(){

        String respuesta = super.volcar();

        respuesta = respuesta + " " + categoria + " Otros\n";

        return respuesta;
    }

    @Override

    public void imprimir(){
        super.imprimir();

        System.out.printf("Producto de categoría: %s\n", categoria);
    }

}
