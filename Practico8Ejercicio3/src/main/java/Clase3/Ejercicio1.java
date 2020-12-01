package Clase3;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String args[]){

        System.out.println("Ingrese un numero");
        Scanner teclado = new Scanner(System.in);
        int numeroDelUsuario = teclado.nextInt();

        float doble = calcularDoble(numeroDelUsuario);
        System.out.println("el doble es " + doble);

    }

    //retorno entero
    //calcularDoble >> Nombre del metodo
    //int num >> es el parametro
    public static int calcularDoble(int unNumero){
        return (int) unNumero * 2;
    }


}
