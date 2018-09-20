package br.com.rede.gemstones;
import java.io.*;
import java.util.*;

/**
 * 
 * Juninho descobriu várias rochas. Cada rocha é composta por vários elementos, e cada elemento é representado por uma 
 * letra minúscula latina de 'a' a 'z'. Um elemento pode estar presente diversas vezes em uma rocha. 
 * Um elemento é chamado de "elemento-gema" se ocorrer pelo menos uma vez em cada uma das rochas.
 * 
 * Dada a lista de rochas com suas composições, você tem que imprimir quantos tipos diferentes de elementos-gema Juninho tem.
 * 
 * Formato de Entrada A primeira linha é constituída por N, o número de rochas. Cada uma das próximas N linhas contêm 
 * a composição da rocha. Cada composição é constituída por letras minúsculas do alfabeto latino.
 * 
 * Formato de saída Imprima o número de diferentes tipos de elementos-gema que ele tem.
 * 
 * Restrições 1 ≤ N ≤ 100 Cada composição é constituída apenas por letras minúsculas do alfabeto latino ('a'-'z')
 * . 1 ≤ Comprimento de cada composição ≤ 100
 * 
 * Exemplo de Entrada
 *      3      abcdde      baccd      eeabg
 * 
 * Exemplo de Saída
 *    2
 *    
 * Explicação Apenas "a", "b" são considerados elementos-gema, pois apenas eles estão presentes na composição de todas as rochas.
 * 
 * @author Guilherme Cruz
 *
 * Classe main, responsável pelas chamadas principais do programa
 * 
 */

public class Solution {

    private static char[] elementosGema = new char[26];
    
    // Complete the gemstones function below.
    static int gemstones(String[] arr) {
        
        int qtdRochas = 0;        
        qtdRochas = arr.length;
            
        if (qtdRochas < 1 || qtdRochas > 100){
            return 0;
        }else{
            
            int contadorPedrasComElementoGema = 0;
        
            for (String pedra : arr){

                for (int i = 0; i < pedra.length(); i++){

                    char elementoBusca = pedra.charAt(i);

                    if (ehElementoGema (arr, elementoBusca)
                       && !ehElementoGemaJaIdentificado(elementoBusca)){
                        contadorPedrasComElementoGema++;
                        inserirElementoGema(elementoBusca);
                        break;
                    }

                }

            }
            
            return contadorPedrasComElementoGema;
        }

    }
    
    private static boolean ehElementoGema(String[] pedras, char elementoBusca){
        
        int contadorElementoGema = 0;
        
        for (String pedra : pedras){
            
            for (int i = 0; i < pedra.length(); i++){
                
                char elemento = pedra.charAt(i);
                
                if (elementoBusca == elemento){
                    contadorElementoGema++;
                    break;
                }
                
            }
            
        }
        
        // Se existirem elementos gemas em todas pedras, entao é um elemento gema
        if (contadorElementoGema == pedras.length){
            return true;
        }else{
            return false;
        }
    }

	private static boolean ehElementoGemaJaIdentificado(char elementoBusca){
	    
	    for (int i = 0; i < elementosGema.length; i++){
	                        
	        if (elementoBusca == elementosGema[i]){
	           return true;
	        }
	        
	    }
	    
	    return false;
	}
	
	private static void inserirElementoGema(char elementoBusca){
	    
	    for (int i = 0; i < elementosGema.length; i++){
	                        
	        if (elementosGema[i] == '\u0000'){
	        	elementosGema[i] = elementoBusca;
	        	return;
	        }
	        
	    }
	    
	}
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String arrItem = scanner.nextLine();
            arr[i] = arrItem;
        }

        int result = gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
        
    }
}
