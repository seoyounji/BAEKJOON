package Algorithm_0815;

import java.math.BigInteger;
import java.util.Scanner;

//백준 2407 조합
public class prob2407 {

	private static BigInteger facto(int a) {
		if(a==0) return BigInteger.valueOf(1);
		BigInteger start = new BigInteger("1");
		for (int i = 0; i < a; i++) {
			start = start.multiply(BigInteger.valueOf(i+1));
		}
		return start;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		
		BigInteger bn = facto(n);
		BigInteger br = facto(r);
		BigInteger tmp = facto(n-r);
		System.out.println(bn.divide(br.multiply(tmp)));
	}

}
