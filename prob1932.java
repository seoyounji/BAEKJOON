package BAEKJOON;

import java.util.ArrayList;
import java.util.Scanner;

//백준 1932 정수 삼각형
public class prob1932 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		ArrayList<Integer>[] list = new ArrayList[n];
		ArrayList<Integer>[] result = new ArrayList[n];
		
		int size = 1;
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> tmp = new ArrayList<>();
			for (int j = 0; j < size; j++) {
				tmp.add(sc.nextInt());
			}
			size++;
			list[i] = tmp;
		}
		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(list[0].get(0));
		result[0] = temp;
		
		for (int i = 1; i < n; i++) {
			ArrayList<Integer> tmp = result[i-1];
			ArrayList<Integer> tt = list[i];
			ArrayList<Integer> t = new ArrayList<>();
			for (int j = 0; j < i+1; j++) {
				if(j == 0) {
					t.add(tmp.get(0) + tt.get(j));
				}
				else if(j == i) {
					t.add(tmp.get(i-1) + tt.get(j));
				}
				else {
					t.add(Math.max(tmp.get(j-1), tmp.get(j)) + tt.get(j));
				}
			}
			result[i] = t;
		}
		
		int answer = 0;
		ArrayList<Integer> last = result[n-1];
		for (int i = 0; i < n; i++) {
			answer = Math.max(answer, last.get(i));
		}
		
		System.out.println(answer);
	}

}
