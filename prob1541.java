package sw_typeA;

import java.util.ArrayList;
import java.util.Scanner;
import javax.script.ScriptException;

//백준 1541 잃어버린 괄호
public class prob1541 {

	public static void main(String[] args) throws ScriptException {
		Scanner sc = new Scanner(System.in);	
		String input = sc.next();
		String[] array = input.split("\\+|-");
		char[] tmp = input.toCharArray();
		ArrayList<Character> cal = new ArrayList<>();
		for(char n:tmp) {
			if(n=='+' || n=='-') cal.add(n);
		}
		int size = array.length;
		int[] num = new int[size];
		for (int i = 0; i < size; i++) {
			num[i] = Integer.parseInt(array[i]);
		}
		ArrayList<Integer> fin = new ArrayList<>();
		fin.add(num[0]);
		
		for (int i = 1; i < size; i++) {
			if(cal.get(i-1)=='-') fin.add(num[i]);
			else {
				int t = fin.get(fin.size()-1);
				t += num[i];
				fin.remove(fin.size()-1);
				fin.add(t);
			}
		}
		int result = fin.get(0);
		for (int i = 1; i < fin.size(); i++) {
			result -= fin.get(i);
		}
		System.out.println(result);
	}

}
