package sw_typeA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//백준 1339 단어 수학
public class prob1339 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		String[] array = new String[N];	
		int[] coeff = new int[26];
		for (int i = 0; i < N; i++) {
			array[i] = bf.readLine();
		}
		for(String i : array) {
			int size = 0;
			char[] tmp = i.toCharArray();
			for (int j = tmp.length - 1; j >= 0; j--) {
				coeff[tmp[j]-'A'] += Math.pow(10, size);
				size++;
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			if(coeff[i] != 0) list.add(coeff[i]);
		}
		Collections.sort(list,Collections.reverseOrder());
		int result = 0;
		int idx = 9;
		for(int i : list) {
			result += i * idx;
			idx--;
		}
		System.out.println(result);
	}

}
