package problem_0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
	String val;
	int left;
	int right;
}

public class 사칙연산 {
	static Node[] tree;
	static int N;

	public static void inorder_traverse(int T) {
		if (T != 0) {
			inorder_traverse(tree[T].left);
			System.out.print(tree[T].val);
			inorder_traverse(tree[T].right);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());

			tree = new Node[N + 1];
			for (int i = 0; i <= N; i++) {
				tree[i] = new Node();
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
            inorder_traverse(1);
            System.out.println();
		}
	}
}
