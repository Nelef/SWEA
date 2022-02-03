package problem_0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 길찾기 {
	static int[][] a;
	static int[] v;
	static int find;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int tc = Integer.parseInt(st.nextToken());

			int n = Integer.parseInt(st.nextToken());

			a = new int[100][100];
			v = new int[100];
			find = 0;
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				a[x][y] = 1;
			}
			
			dfs(0); // 0에서 시작
			System.out.println("#" + t + " " + find);

		}
	}

	public static void dfs(int x) {
		if (find == 1) { // 길이 있다면
			return;
		}
		if (x == 99) { // 마지막에 도달했다면
			find = 1;
			return;
		}
		v[x] = 1;
		for (int i = 0; i < 100; i++) {
			if (v[i] == 0 && a[x][i] == 1) {
				dfs(i);
			}
		}
		v[x] = 0;
	}
}
