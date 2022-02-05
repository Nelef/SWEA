package problem_0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 계산기3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tn = 0; tn < 10; tn++) {
			int t_size = Integer.parseInt(br.readLine());
			String t_string = br.readLine();

			int s_top = -1;
			ArrayList<Character> stack = new ArrayList<Character>();
			ArrayList<Character> postfix = new ArrayList<Character>();

			for (int i = 0; i < t_string.length(); i++) {
				char temp = t_string.charAt(i);

				if ('0' <= temp && temp <= '9') { // 숫자일경우 후위식에 기록
					postfix.add(temp);
				} else if (s_top == -1) { // 연산자이고, 스택 첫번째일 경우 스택에 쌓기
					stack.add(++s_top, temp);
				} else { // 연산자일 경우
					if (temp == ')') {
						while (true) {
							postfix.add(stack.get(s_top));
							stack.remove(s_top--);
							if (stack.get(s_top) == '(') {
								stack.remove(s_top--);
								break;
							}
						}
					} else if (temp == '(') {
						stack.add(++s_top, temp);
					} else { // 서열 정해서 스택에 나보다 쎈 연산자가 있다면 파내고 후위식에 기록한다.
						while (true) {
							if (s_top == -1) {
								stack.add(++s_top, temp);
								break;
							}
							if (prec(stack.get(s_top)) >= prec(temp)) {
								postfix.add(stack.get(s_top));
								stack.remove(s_top--);
							} else {
								stack.add(++s_top, temp);
								break;
							}
						}
					}
				}
			}
			while (true) {
				if (s_top == -1) {
					break;
				}
				postfix.add(stack.get(s_top));
				stack.remove(s_top--);
			}

			int r_top = -1;
			ArrayList<Integer> r_stack = new ArrayList<Integer>();

			for (char cur : postfix) {
				if ('0' <= cur && cur <= '9') { // 숫자일경우 스택
					r_stack.add(++r_top, Character.getNumericValue(cur));
				} else {
					int t_prec = prec(cur); // 무슨 연산자인지 체크
					if(t_prec == 1) { // + 연산일경우
						r_stack.set(r_top-1, r_stack.get(r_top) + r_stack.get(r_top-1));
						r_stack.remove(r_top--);
					} else if(t_prec == 2) { // * 연산일경우
						r_stack.set(r_top-1, r_stack.get(r_top) * r_stack.get(r_top-1));
						r_stack.remove(r_top--);
					}
				}
			}
			System.out.println("#"+(tn+1)+" "+r_stack.get(0));
		}
	}

	private static int prec(char ch) {
		switch (ch) {
		case '(':
			return 0;
		case '+':
			return 1;
		case '*':
			return 2;
		}
		return 0;
	}
}
