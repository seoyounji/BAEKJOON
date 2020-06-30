package baekjoon;

import java.util.Scanner;

public class prob1003 {

	private static point[] value;
	
	private static class point {
		int zero; int one;
		point(int zero,int one) {
			this.zero = zero;
			this.one = one;
		}
	}
	
	public static void main(String[] args) throws Exception{
		value = new point[41];
		for (int i = 0; i < 41; i++) {
			value[i] = new point(0,0);
		}
		value[0] = new point(1,0);
		value[1] = new point(0,1);
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int x = sc.nextInt();
			point result = count(x);
			System.out.println(result.zero+" "+result.one);
		}
	}

	private static point cal(int x) {
		int a = 0;
		while(value[a].zero != 0 || value[a].one != 0) {
			a++;
		}
		for (int i = a; i <= x; i++) {
			value[i].zero = value[i-2].zero + value[i-1].zero;
			value[i].one = value[i-2].one + value[i-1].one;
		}
		return value[x];
	}
	
	private static point count(int x) {
		if(value[x].zero == 0 && value[x].one == 0) {
			point result = cal(x);
			return result;
		}
		else {
			return value[x];
		}
	}

}
