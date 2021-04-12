package Algorithm_0806;

import java.util.Scanner;

//백준 5585 거스름돈
public class ws02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int result = 1000 - num;
		int cnt = 0;
		while(true) {
			if(result>=500) {
				result -= 500; cnt++;
			}
			else break;
		}
		while(true) {
			if(result>=100) {
				result -= 100; cnt++;
			}
			else break;
		}
		while(true) {
			if(result>=50) {
				result -= 50; cnt++;
			}
			else break;
		}
		while(true) {
			if(result>=10) {
				result -= 10; cnt++;
			}
			else break;
		}
		while(true) {
			if(result>=5) {
				result -= 5; cnt++;
			}
			else break;
		}
		cnt += result;
		System.out.println(cnt);
	}

}
