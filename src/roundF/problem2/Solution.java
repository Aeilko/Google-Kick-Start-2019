package roundF.problem2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		// t = number of test cases
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int result = 0;

			int N = in.nextInt();
			int S = in.nextInt();

			ArrayList<ArrayList<Integer>> persons = new ArrayList<>();

			for(int j = 0; j < N; j++){
				ArrayList<Integer> skills = new ArrayList<>();

				int s = in.nextInt();
				for(int k = 0; k < s; k++){
					int skill = in.nextInt();
					skills.add(skill);
				}

				persons.add(skills);
			}

			for(int j = 0; j < N; j++){
				ArrayList<Integer> a = persons.get(j);
				for(int k = j+1; k < N; k++){
					ArrayList<Integer> b = persons.get(k);
					if(a.size() > b.size()){
						result++;
					}
					else{
						for(int as: a){
							if(!b.contains(as)){
								result++;
								break;
							}
						}
					}

					if(b.size() > a.size()){
						result++;
					}
					else{
						for(int bs: b){
							if(!a.contains(bs)){
								result++;
								break;
							}
						}
					}
				}
			}

			System.out.println("Case #" + i + ": " + result);
		}
	}
}
