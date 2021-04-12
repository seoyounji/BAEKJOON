package Algorithm_0922;

import java.util.Scanner;

//백준 1463 1로 만들기
public class prob1463 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] result = new int[N+1];

		for (int i = 2; i <= N; i++) {
			if(i%2==0 && i%3==0) {
				result[i]=Math.min(result[i/2]+1, result[i/3]+1);
				result[i]=Math.min(result[i], result[i-1]+1);
			}
			else {
				if(i%2==0) {
					result[i]=Math.min(result[i/2]+1,result[i-1]+1);
				}
				else if(i%3==0) {
					result[i]=Math.min(result[i/3]+1,result[i-1]+1);
				}
				else {
					result[i]=result[i-1]+1;
				}
			}
		}
		System.out.println(result[N]);
	}

}
