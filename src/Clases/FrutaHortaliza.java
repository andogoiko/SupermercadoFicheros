package Clases;

import java.util.Scanner;

public class FrutaHortaliza extends Perecedero{

    private String origen;
    private final double VALOR_IVA = 0.16;
    private final boolean esFragil = false;

    public FrutaHortaliza(){}

    public FrutaHortaliza(int codigo, String nombre, double precio, int cantidad, double peso, String fechacad, String origen) {
        super(codigo, nombre, precio, cantidad, peso, fechacad);
        this.origen = origen;

        setIva(VALOR_IVA);
    }

    public FrutaHortaliza(Scanner in) {
        super(in);

        System.out.println("Introduce el origen del producto:");

        while (true){

            try{
                origen = in.nextLine();
                break;
            }catch (Exception e){
                System.out.println("Origen incorrecto, vuelva a introducirlo");
            }

        }

        setIva(VALOR_IVA);
    }

    @Override

    public String volcar(){

        String respuesta = super.volcar();

        respuesta = respuesta + " " + origen + " FrutaHortaliza\n";

        return respuesta;
    }

    @Override

    public void imprimir(){
        super.imprimir();

        System.out.printf("Fruta de origen: %s\n", origen);
    }

    @Override

    public boolean envioFragil(){
        return esFragil;
    }

    public void calcularPrecioEnvio(){
        Double precioEnvio = super.tarifaEnvio();
    }
}
