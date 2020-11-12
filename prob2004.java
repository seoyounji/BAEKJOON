package Algorithm_0806;

import java.util.Scanner;

//백준 2004 조합 0의 개수
public class test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long r = sc.nextInt();
		int s = 0; int f = 0;
		for (long i = 2; i <= n; i=i*2) {
			s += n/i;
		}
		for (long i = 5; i <= n; i=i*5) {
			f += n/i;
		}
		for (long i = 2; i <= (n-r); i=i*2) {
			s -= (n-r)/i;
		}
		for (long i = 5; i <= (n-r); i=i*5) {
			f -= (n-r)/i;
		}
		for (long i = 2; i <= r; i=i*2) {
			s -= r/i;
		}
		for (long i = 5; i <= r; i=i*5) {
			f -= r/i;
		}
		System.out.println(s+" "+f);
		if(s>0 && f>0) {
			if(s>f) System.out.println(f);
			else System.out.println(s);
		}
		else System.out.println(0);
    }
}
