package sw_typeIM;

import java.util.Scanner;

//백준 1681 줄 세우기
public class prob1681 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int label = 1;
		int num = 1;
		boolean flag;
		
		while(num<=N) {
			String tmp = Integer.toString(label);
			flag = false;
			for (int j = 0; j < tmp.length(); j++) {
				int compare = (int)tmp.charAt(j)-'0';
				if(compare==L) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				//System.out.println(label);
				num++;
			}
			label++;
		}
		System.out.println(--label);
	}

}
