package com.example.decimaabinario;
import java.util.ArrayList;
import java.util.Collections;

public class test {

    public static void main(String[] args) {

        int numeroDecimal = 10;

//        ArrayList<Integer> multiplos = obtenerMultiplosDeDos(numeroDecimal);
        ArrayList<Integer> divisiones = new ArrayList<>();


        divisiones.add(numeroDecimal); // Agrega el número original al array

        while (numeroDecimal > 1) {
            numeroDecimal /= 2;
            divisiones.add(numeroDecimal);
        }

        Collections.reverse(divisiones);

        // Convertir el último valor del array a binario
        int ultimoResultado = divisiones.get(divisiones.size() - 1);
        StringBuilder resultadoBinario = new StringBuilder();

        while (ultimoResultado > 0) {
            int residuo = ultimoResultado % 2;
            resultadoBinario.insert(0, residuo);
            ultimoResultado /= 2;
        }



        Collections.reverse(divisiones);

        // Imprimir los resultados de las divisiones
        System.out.println("Resultados de las divisiones sobre 2:\n" + divisiones);
//        System.out.println("Multiplos de 2: \n"+multiplos);
        System.out.println("El número binario es: " + resultadoBinario);
    }

    public static ArrayList<Integer> obtenerMultiplosDeDos(int decimal) {
        ArrayList<Integer> multiplos = new ArrayList<>();

        // Encuentra el múltiplo de 2 más próximo hacia arriba
        int siguienteMultiplo = 2;
        while (siguienteMultiplo <= decimal) {
            siguienteMultiplo *= 2;
        }

        // Almacenar los múltiplos de 2 en el rango
        for (int i = 2; i <= siguienteMultiplo; i *= 2) {
            multiplos.add(i);
        }
        Collections.reverse(multiplos);
        return multiplos;
    }
}






