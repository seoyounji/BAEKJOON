package sw_typeIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 2527 직사각형
public class prob2527 {

	private static char check(int[] tmp1,int[] tmp2) {
		char tmp = 'a';
		if(tmp1[2]==tmp2[0]) {
			if(tmp1[3]==tmp2[1] || tmp1[1]==tmp2[3]) tmp='c';
			else tmp='b';
		}
		else if(tmp1[0]==tmp2[2]) {
			if(tmp1[3]==tmp2[1]) tmp='c';
			else tmp='b';
		}
		else if(tmp1[1]==tmp2[3]) {
			if(tmp1[2]==tmp2[0]) tmp='c';
			else tmp='b';
		}
		else if(tmp1[3]==tmp2[1]) {
			if(tmp1[2]==tmp2[0]) tmp='c';
			else tmp='b';
		}		
		else if(tmp1[2]<tmp2[0] || tmp2[2]<tmp1[0] || tmp1[3]<tmp2[1] || tmp2[3]<tmp1[1]) tmp='d';
		return tmp;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int[] temp = new int[8];
			for (int j = 0; j < 8; j++) {
				temp[j] = Integer.parseInt(st.nextToken());
			}
			int[] t1 = new int[4];
			int[] t2 = new int[4];
			if(temp[0]<=temp[4]) {
				for (int j = 0; j < 4; j++) {
					t1[j] = temp[j];
				}
				for (int j = 0; j < 4; j++) {
					t2[j] = temp[j+4];
				}
			}
			if(temp[0]>temp[4]) {
				for (int j = 0; j < 4; j++) {
					t2[j] = temp[j];
				}
				for (int j = 0; j < 4; j++) {
					t1[j] = temp[j+4];
				}
			}
			char result = check(t1,t2);
			System.out.println(result);
		}
	}

}
