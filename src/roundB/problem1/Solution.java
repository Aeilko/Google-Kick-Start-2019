package roundB.problem1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // t = number of testcases
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int q = in.nextInt();
            int result = 0;

            String letters = in.next();
            char[] l = letters.toCharArray();

            for(int j = 1; j <= q; j++){
                int start = in.nextInt();
                int end = in.nextInt();

                TreeMap<Character, Integer> occurences = new TreeMap<>();
                for(int k = start; k <= end; k++){
                    char x = l[k-1];
                    if(occurences.containsKey(x))
                        occurences.put(x, occurences.get(x)+1);
                    else
                        occurences.put(x, 1);
                }

                int unevens = 0;
                for(char k: occurences.keySet()){
                    if(occurences.get(k)%2 != 0)
                        unevens++;
                }

                // Length is distance+1, so modulo has to be 1 for it to be of even length
                if((end-start)%2 != 0){
                    if(unevens == 0)
                        result++;
                }
                else{
                    if(unevens == 1)
                        result++;
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}
