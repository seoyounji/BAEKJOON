package baekjoon;

import java.util.Scanner;
import java.util.Stack;

//백준 1662 압축
public class prob1662 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		char[] string = input.toCharArray();
		int answer = 0;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < string.length; i++) {
			stack.add(string[i]);
		}
		Stack<String> temp = new Stack<>();
		
		while(!stack.isEmpty()) {
			char now = stack.pop();
			if(now==')') temp.add(Character.toString(now));
			else if(now=='(') {
				int gop = stack.pop()-'0';
				int t = 0;
				while(true) {
					String tmp = temp.pop();
					if(tmp.equals(")")) break;
					t += Integer.parseInt(tmp);
				}
				temp.add(Integer.toString(gop*t));
			}
			else {
				temp.add("1");
			}
		}
		while(!temp.isEmpty()) answer += Integer.parseInt(temp.pop());
		System.out.println(answer);
	}

}
