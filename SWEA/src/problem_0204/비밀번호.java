package problem_0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 비밀번호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 0; tc < 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int tn = Integer.parseInt(st.nextToken());
			String t_string = st.nextToken();

			ArrayList<Character> list = new ArrayList<Character>();
			int top = -1;

			for (int i = 0; i < t_string.length(); i++) {
				if (top > -1) {
					if (list.get(top) == t_string.charAt(i)) {
						list.remove(top--);
					} else {
						list.add(++top, t_string.charAt(i));
					}
				} else {
					list.add(++top, t_string.charAt(i));
				}
			}

			System.out.print("#" + (tc + 1) + " ");
			for (char c : list) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
}
