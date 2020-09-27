package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//백준 1759 암호 만들기
public class prob1759 {

	private static ArrayList<String> answer;
	
	private static boolean judge(boolean[] visited,char[] string) {
		int num1 = 0;
		int num2 = 0;
		for (int i = 0; i < string.length; i++) {
			if(!visited[i]) continue;
			if(string[i]=='a' || string[i]=='e' || string[i]=='i' || string[i]=='o' || string[i]=='u') num1++;
			else num2++;
		}
		if(num1>=1 && num2>=2) return true;
		else return false;
	}
	
	private static void combi(int n,int r,boolean[] visited,int start,char[] string) {
		if(r==0) {
			if(judge(visited,string)) {
				String tmp = "";
				for (int i = 0; i < n; i++) {
					if(visited[i]) tmp+=string[i];
				}
				answer.add(tmp);
			}
			return;
		}
		for (int i = start; i < n; i++) {
			visited[i] = true;
			combi(n,r-1,visited,i+1,string);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int C = sc.nextInt();
		char[] string = new char[C];
		for (int i = 0; i < C; i++) {
			string[i] = sc.next().charAt(0);
		}

		Arrays.sort(string);
		answer = new ArrayList<>();
		
		boolean[] visited = new boolean[C];
		combi(C,L,visited,0,string);
		
		for (int i = 0; i < answer.size(); i++) {
			System.out.println(answer.get(i));
		}
	}

}
