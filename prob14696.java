package sw_typeIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 14696 딱지놀이
public class prob14696 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			int numa = Integer.parseInt(st.nextToken());
			int[] A = new int[numa];
			for (int j = 0; j < numa; j++) {
				A[j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(bf.readLine());
			int numb = Integer.parseInt(st.nextToken());
			int[] B = new int[numb];
			for (int j = 0; j < numb; j++) {
				B[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(A);
			Arrays.sort(B);
			int num = Math.min(numa, numb);
			boolean flag = false;
			for (int j = 0; j < num; j++) {
				if(A[numa-1-j]>B[numb-1-j]) {
					System.out.println('A');
					flag = true;
					break;
				}
				else if(A[numa-1-j]<B[numb-1-j]) {
					System.out.println('B');
					flag = true;
					break;
				}
			}
			if(!flag) {
				if(numa==numb) {
					System.out.println('D');
				}
				else if(numa > numb) System.out.println('A');
				else if(numb > numa) System.out.println('B');
			}
		}
		
	}

}
