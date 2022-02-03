package problem_0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 괄호짝짓기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 10; i++) {
			int case_size = Integer.parseInt(br.readLine());

			String case_string = br.readLine();

			ArrayList<Character> list = new ArrayList<Character>();
			int top = -1;
			int test_result = 1;

			for (int i2 = 0; i2 < case_size; i2++) {
				if (case_string.charAt(i2) == "(".charAt(0) || case_string.charAt(i2) == "[".charAt(0)
						|| case_string.charAt(i2) == "{".charAt(0) || case_string.charAt(i2) == "<".charAt(0)) {
					list.add(++top, case_string.charAt(i2));
				} else {
					if (case_string.charAt(i2) == ")".charAt(0)) {
						if (list.get(top) == "(".charAt(0)) {
							list.remove(top--);
						} else {
							test_result = 0;
							break;
						}
					} else if (case_string.charAt(i2) == "]".charAt(0)) {
						if (list.get(top) == "[".charAt(0)) {
							list.remove(top--);
						} else {
							test_result = 0;
							break;
						}
					} else if (case_string.charAt(i2) == "}".charAt(0)) {
						if (list.get(top) == "{".charAt(0)) {
							list.remove(top--);
						} else {
							test_result = 0;
							break;
						}
					} else if (case_string.charAt(i2) == ">".charAt(0)) {
						if (list.get(top) == "<".charAt(0)) {
							list.remove(top--);
						} else {
							test_result = 0;
							break;
						}
					}
				}
			}
			System.out.println("#" + (i + 1) + " " + test_result);
		}
	}
}
