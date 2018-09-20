package br.com.rede.minimaxsum;

import java.util.*;

/**
 * 
 * Dado cinco inteiros positivos, encontre os valores mínimo e máximo que podem ser calculados somando exatamente quatro dos cinco inteiros.
 * Em seguida, imprima os respectivos valores mínimo e máximo como uma única linha de dois inteiros longos separados por espaço.
 * 
 * Exemplo de Entrada
 *  1 2 3 4 5
 * 
 * Exemplo de Saída
 * 10 14
 * 
 * @author Guilherme Cruz
 *
 * Classe main, responsável pelas chamadas principais do programa
 * 
 */

public class Solution {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {

    	long min = 0;
    	long max = 0;
    	
    	arr = ordenacaoBolha(arr);
    	
    	for (int i = 0; i < arr.length - 1; i++) {
			min += arr[i];
		}
    	
    	for (int i = 1; i < arr.length; i++) {
			max += arr[i];
		}

    	System.out.println(min + " " + max);
    	
    }

    // Ordenação BubbleSort O(n^2)
    private static int[] ordenacaoBolha(int[] vet) {
        
    	for (int i = vet.length; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                if (vet[j - 1] > vet[j]) {
                    int aux = vet[j];
                    vet[j] = vet[j - 1];
                    vet[j - 1] = aux;
                }
            }
        }
    	
    	return vet;
        
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
