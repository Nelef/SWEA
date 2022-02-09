package problem_0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Node3 {
	String val;
	int left;
	int right;
}

public class 사칙연산_유효성검사 {
	static Node3[] tree;
	static int N;
	static ArrayList<Character> strlist;

	public static void inorder(int T) {
		if (T != 0) {
			inorder(tree[T].left);
			strlist.add(tree[T].val.charAt(0));
			inorder(tree[T].right);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			tree = new Node3[N + 1];
			strlist = new ArrayList<Character>();

			for (int i = 0; i <= N; i++) {
				tree[i] = new Node3();
			}

			for (int i = 1; i <= N; i++) {
				String line = br.readLine();
				String[] inputs = line.split(" ");
				tree[i].val = inputs[1];
				if (inputs.length >= 3) {
					tree[i].left = Integer.parseInt(inputs[2]);
				}
				if (inputs.length == 4) {
					tree[i].right = Integer.parseInt(inputs[3]);
				}
			}
			System.out.printf("#%d ", tc);
			inorder(1);

			char order;
			char cur;
			int result = 1;

			order = strlist.get(0);

			for (int i = 1; i < strlist.size(); i++) {
				cur = strlist.get(i);

				if ('0' <= order && order <= '9') {
					if ('0' <= cur && cur <= '9') {
						result = 0;
						break;
					}
				} else {
					if ('0' <= cur && cur <= '9') {

					} else {
						result = 0;
						break;
					}
				}
				order = cur;
			}
			System.out.println(result);
		}
	}
}
