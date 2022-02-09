package problem_0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Node2 {
	String val;
	int left;
	int right;
}

public class 중위순회 {
	static Node2[] tree;
	static int N;
	static ArrayList<Integer> queue = new ArrayList<Integer>();
	static int top = -1;

	public static void postorder_traverse(int T) {
		if (T != 0) {
			postorder_traverse(tree[T].left);
			postorder_traverse(tree[T].right);
			if (tree[T].val.equals("+") || tree[T].val.equals("-") || tree[T].val.equals("*")
					|| tree[T].val.equals("/")) {
				int a = queue.get(top - 1);
				int b = queue.get(top);

				queue.remove(top--);

				if (tree[T].val.equals("+"))
					queue.set(top, a + b);
				else if (tree[T].val.equals("-"))
					queue.set(top, a - b);
				else if (tree[T].val.equals("*"))
					queue.set(top, a * b);
				else if (tree[T].val.equals("/"))
					queue.set(top, a / b);
			} else {
				queue.add(++top, Integer.parseInt(tree[T].val));
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());

			tree = new Node2[N + 1];
			for (int i = 0; i <= N; i++) {
				tree[i] = new Node2();
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
			postorder_traverse(1);
			System.out.println(queue.get(top));
		}
	}
}