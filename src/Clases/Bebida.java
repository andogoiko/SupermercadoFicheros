package Clases;

import java.util.Scanner;

public class Bebida extends Perecedero{

    private String graduacion;
    private final double VALOR_IVA = 0.16;
    private final boolean esFragil = false;

    public Bebida(){}

    public Bebida(int codigo, String nombre, double precio, int cantidad, double peso, String fechacad, String graduacion) {
        super(codigo, nombre, precio, cantidad, peso, fechacad);
        this.graduacion = graduacion;

        setIva(VALOR_IVA);
    }

    public Bebida(Scanner in) {
        super(in);

        System.out.println("Introduce la graduación del producto:");

        while (true){

            try{
                graduacion = in.nextLine();
                break;
            }catch (Exception e){
                System.out.println("Graduación incorrecta, vuelva a introducirla");
            }

        }

        setIva(VALOR_IVA);
    }

    @Override

    public String volcar(){
        String respuesta = super.volcar();

        respuesta = respuesta + " " + graduacion + " Bebida\n";


        return respuesta;
    }

    @Override

    public void imprimir(){

        super.imprimir();

        System.out.printf("Bebida de graduación: %s\n", graduacion);
    }

    @Override

    public boolean envioFragil(){
        return esFragil;
    }
}
