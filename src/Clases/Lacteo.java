package Clases;

import java.util.Scanner;

public class Lacteo extends  Perecedero{

    private String lote;
    private final double VALOR_IVA = 0.04;
    private final boolean esFragil = false;

    public Lacteo(){}

    public Lacteo(int codigo, String nombre, double precio, int cantidad, double peso, String fechacad, String lote) {
        super(codigo, nombre, precio, cantidad, peso, fechacad);
        this.lote = lote;

        setIva(VALOR_IVA);
    }

    public Lacteo(Scanner in) {
        super(in);

        System.out.println("Introduce el lote del producto:");

        while (true){

            try{
                lote = in.nextLine();
                break;
            }catch (Exception e){
                System.out.println("Lote incorrecto, vuelva a introducirlo");
            }

        }

        setIva(VALOR_IVA);
    }

    @Override

    public String volcar(){
        String respuesta = super.volcar();

        respuesta = respuesta + " " + lote + " Lacteo\n";

        return respuesta;
    }

    @Override

    public boolean envioFragil(){

        return esFragil;
    }

    @Override

    public void imprimir(){
        super.imprimir();

        System.out.printf("Producto Lácteo: %s\n", lote);
    }
}
