package problem_0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 거듭제곱 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			int case_num = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());

			System.out.println("#" + case_num + " " + pow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
	}

	public static int pow(int n, int m) {
		if (m == 1) {
			return n;
		}
		return n * pow(n, m - 1);
	}
}
