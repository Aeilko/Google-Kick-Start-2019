package roundB.problem3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeMap;

// Never mind, misunderstood the problem set and attempted to solve something else.
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // t = number of test cases
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int s = in.nextInt();

            int[] types = new int[n];
            for(int j = 0; j < n; j++){
                types[j] = in.nextInt();
            }

            int startIndex = 0;
            int maxLenght = 0;
            while(startIndex < n){
                // Starting from startIndex, what is the max length.
                TreeMap<Integer, Integer> occurrences = new TreeMap<>();
                for(int j = startIndex; j < n; j++){
                    int type = types[j];
                    if(occurrences.containsKey(type))
                        occurrences.put(type, occurrences.get(type)+1);
                    else
                        occurrences.put(type, 1);

                    // Check if we exceeded the limits, if so reset.
                    if(occurrences.get(type) > s){
                        // Check if we have a new best length
                        int curLength = j-startIndex;
                        if(curLength > maxLenght)
                            maxLenght = curLength;

                        // find the first occurrence of the current type, than restart after this occurrence
                        for(int k = startIndex; k < j; k++){
                            if(types[k] == type){
                                startIndex = k+1;
                                break;
                            }
                        }

                        break;
                    }
                    else if(j == n-1){
                        // If we reached the end we should also reset.
                        int curLength = j-startIndex;
                        if(curLength > maxLenght)
                            maxLenght = curLength;

                        // Reached the end, so we stop searching
                        startIndex = n;
                        break;
                    }

                    // Check if it is even possible to find a new longest string, if not there is no use in checking
                    if(n-startIndex < maxLenght)
                        startIndex = n;
                }
            }


            System.out.println("Case #" + i + ": " + maxLenght);
        }
    }
}
