/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trabajoaleatorio2;

import java.util.Random;

/**
 *
 * @author asus
 */
public class TrabajoAleatorio2 {

   public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean esSimetrica(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        if (filas != columnas) {
            return false;
        }

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] != matriz[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int filas = 5;
        int columnas = 5;

        int[][] matriz = new int[filas][columnas];
        Random random = new Random();

        // Llenar la matriz con números aleatorios
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = random.nextInt(100); // Generar números aleatorios entre 0 y 99
            }
        }

        // Calcular el promedio y encontrar los números primos y pares
        int suma = 0;
        int maximo = Integer.MIN_VALUE;
        int vecesMaximo = 0;
        int[] primos = new int[filas * columnas];
        int[] pares = new int[filas * columnas];
        int primosCount = 0;
        int paresCount = 0;
        int repeticionesUno = 0;
        int sumaUltimaFila = 0;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int numero = matriz[i][j];
                suma += numero;

                if (numero > maximo) {
                    maximo = numero;
                    vecesMaximo = 1;
                } else if (numero == maximo) {
                    vecesMaximo++;
                }

                if (esPrimo(numero)) {
                    primos[primosCount] = numero;
                    primosCount++;
                }
                if (numero % 2 == 0) {
                    pares[paresCount] = numero;
                    paresCount++;
                }

                if (numero == 1) {
                    repeticionesUno++;
                }

                if (i == filas - 1) {
                    sumaUltimaFila += numero;
                }
            }
        }

        // Calcular el promedio
        double promedio = (double) suma / (filas * columnas);

        // Imprimir la matriz
         System.out.println("-------------------------------------");
        System.out.println("Matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        // Imprimir el promedio
         System.out.println("-------------------------------------");
        System.out.println("El promedio de la matriz es: " + promedio);

        // Imprimir el número máximo y su cantidad de repeticiones
         System.out.println("-------------------------------------");
        System.out.println("El número máximo en la matriz es: " + maximo);
         System.out.println("-------------------------------------");
        System.out.println("Se repite " + vecesMaximo + " veces.");

        // Imprimir números primos ordenados
         System.out.println("-------------------------------------");
        System.out.println("Números primos ordenados:");
        for (int i = 0; i < primosCount; i++) {
            System.out.print(primos[i] + " ");
        }
        System.out.println();

        // Imprimir números pares ordenados
         System.out.println("-------------------------------------");
        System.out.println("Números pares ordenados:");
        for (int i = 0; i < paresCount; i++) {
            System.out.print(pares[i] + " ");
        }
        System.out.println();
        
        // Imprimir la cantidad de veces que se repite el número 1
         System.out.println("----------------------------------------------------------------");
        System.out.println("El número 1 se repite " + repeticionesUno + " veces en la matriz.");
        
        // Calcular y mostrar la suma de las diagonales
        int sumaDiagonalPrincipal = 0;
        int sumaDiagonalSecundaria = 0;

        for (int i = 0; i < filas; i++) {
            sumaDiagonalPrincipal += matriz[i][i];
            sumaDiagonalSecundaria += matriz[i][columnas - 1 - i];
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("La suma de la diagonal principal es: " + sumaDiagonalPrincipal);
        System.out.println("La suma de la diagonal secundaria es: " + sumaDiagonalSecundaria);
        
        // Imprimir la suma de la última fila
         System.out.println("-------------------------------------------------");
        System.out.println("La suma de la última fila es: " + sumaUltimaFila);
        
        // Verificar si es un cuadrado mágico
        boolean esCuadradoMagico = true;
        int sumaPrimeraFila = 0;
        
        for (int j = 0; j < columnas; j++) {
            sumaPrimeraFila += matriz[0][j];
        }
        
        if (sumaPrimeraFila != sumaUltimaFila) {
            esCuadradoMagico = false;
        }
        
        // Verificar si es simétrica
        boolean esSimetrica = esSimetrica(matriz);

        // Mostrar mensaje "CUADRADO MAGICO" si aplica
        if (esCuadradoMagico) {
             System.out.println("-------------------------------------");
            System.out.println("CUADRADO MAGICO");
        } else {
             System.out.println("-------------------------------------");
            System.out.println("NO ES CUADRADO MAGICO");
        }

        // Mostrar mensaje "SIMETRICA" si es simétrica
        if (esSimetrica) {
             System.out.println("-------------------------------------");
            System.out.println("SIMETRICA");
        } else {
             System.out.println("-------------------------------------");
            System.out.println("NO ES SIMETRICA");
        }
    }
}