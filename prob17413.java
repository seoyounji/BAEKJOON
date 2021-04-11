package sw_typeIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

//백준 17413 단어 뒤집기 2
public class prob17413 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String tmp = bf.readLine();
		char[] input = tmp.toCharArray();
		char[] output = new char[input.length];
		Stack<Character> temp = new Stack<>();
		boolean flag = false;
		int index = 0;
		for (int i = 0; i < input.length; i++) {
			if(!flag) {
				if(input[i]=='<') {
					if(!temp.isEmpty()) {
						while(!temp.isEmpty()) {
							output[index++] = temp.pop();
						}
					}
					flag = true;
					output[index++] = input[i];
					continue;
				}
				else if(input[i]==' ') {
					if(!temp.isEmpty()) {
						while(!temp.isEmpty()) {
							output[index++] = temp.pop();
						}
					}		
					output[index++] = input[i];
					continue;
				}
				else { //스택에 넣는 과정
					temp.add(input[i]);
				}
			}
			else {
				if(input[i]=='>') {
					flag = false;
					output[index++] = input[i];
					continue;
				}
				else {
					output[index++] = input[i];
					continue;
				}
			}
		}
		if(!temp.isEmpty()) {
			while(!temp.isEmpty()) {
				output[index++] = temp.pop();
			}
		}
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i]);
		}
	}

}
