package sw_typeA;

import java.util.Scanner;

//백준 2839 설탕 배달
public class prob2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int a = N/5;
		int b = 0;
		while(a>=0) {
			b = 0;
			while(true) {
				int tmp = (a*5) + (b*3);
				if(tmp > N) break;
				if(tmp == N) {
					System.out.println(a+b);
					System.exit(0);
				}
				b++;
			}
			a--;
		}
		System.out.println(-1);
		System.exit(0);
	}

}
