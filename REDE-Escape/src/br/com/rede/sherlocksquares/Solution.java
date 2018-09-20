package br.com.rede.sherlocksquares;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the squares function below.
    static long squares(long a, long b) {
        
        long raizMin = (long) Math.sqrt(a);
        long raizMax = (long) Math.sqrt(b);
        long contadorRaizes = 0L;
        
        for (long i = raizMin; i <= raizMax; i++) {
            
            // Se estiver dentro dos limites das raízes, é uma raiz "perfeita" como número inteiro
            if ((i * i) <= b && (i * i) >= a) {
                contadorRaizes++;
            }
            
        }
        
        return contadorRaizes;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] ab = scanner.nextLine().split(" ");

            long a = Long.parseLong(ab[0]);

            long b = Long.parseLong(ab[1]);

            long result = squares(a, b);
            
            System.out.println(result);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
