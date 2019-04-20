package roundB.problem1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // t = number of test cases
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int q = in.nextInt();
            int result = 0;

            // Get the letters used in this test case
            String letters = in.next();
            char[] l = letters.toCharArray();

            // Create a caching mechanism to improve speed with repeated questions.
            // Probably still not good enough for the hidden set, probably need something which can combine subsets to increase speed.
            TreeMap<Integer, TreeMap<Integer, Integer>> cache = new TreeMap<>();

            // Loop over each substring
            for(int j = 1; j <= q; j++){
                int start = in.nextInt();
                int end = in.nextInt();

                // Check if this case is already in the cache.
                if(cache.containsKey(start) && cache.get(start).containsKey(end)){
                    result += cache.get(start).get(end);
                    continue;
                }

                // Count occurrences of each character in the substring
                TreeMap<Character, Integer> occurrences = new TreeMap<>();
                for(int k = start; k <= end; k++){
                    char x = l[k-1];
                    if(occurrences.containsKey(x))
                        occurrences.put(x, occurrences.get(x)+1);
                    else
                        occurrences.put(x, 1);
                }

                // Count the number of uneven occurrences
                int unevens = 0;
                for(char k: occurrences.keySet()){
                    if(occurrences.get(k)%2 != 0)
                        unevens++;
                }

                // Check if the number of uneven characters match evenness of the substring length.
                // Length is distance+1, so modulo has to be 1 for it to be of even length
                int tmp = 0;
                if((end-start)%2 != 0){
                    if(unevens == 0)
                        tmp = 1;
                }
                else{
                    if(unevens == 1)
                        tmp = 1;
                }

                // Save the result to the cache
                if(cache.containsKey(start)){
                    TreeMap<Integer, Integer> x = cache.get(start);
                    x.put(end, tmp);
                    cache.put(start, x);
                }
                else{
                    TreeMap<Integer, Integer> x = new TreeMap<>();
                    x.put(end, tmp);
                    cache.put(start, x);
                }

                // Add result to the count
                result += tmp;
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}
