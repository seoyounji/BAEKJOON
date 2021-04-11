package Algorithm_0825;

import java.util.Scanner;

//백준 1074 Z
public class prob1074 {

	private static int N,r,c;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		int count = 0;
		int x = 0;
		int y = 0;
		int n = (int) Math.pow(2, N);
		while(n>0) {
			n = n/2;
			if(r < x+n && c < y+n) {
				count += n*n*0;
			}
			else if(r < x+n) {
				count += n*n*1;
				y += n;
			}
			else if(c < y+n) {
				count += n*n*2;
				x += n;
			}
			else {
				count += n*n*3;
				x += n;
				y += n;
			}
			if(n==1) {
				System.out.println(count);
				break;
			}
		}
		
	}

}
