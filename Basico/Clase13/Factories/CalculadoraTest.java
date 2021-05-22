package Basico.Clase13.Factories;

import org.testng.annotations.Test;

public class CalculadoraTest {

     int num1 = 0;
     int num2 = 0;
    public CalculadoraTest(int unNumero1, int unNumero2){
        num1 = unNumero1;
        num2 = unNumero2;
    }
    @Test
    public void sumar(){
        int suma = num1 + num2;

    }
    public void restar(){
        int suma = num1 - num2;

    }
}

