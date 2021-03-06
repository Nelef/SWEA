package problem_0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 암호코드스캔 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tsize = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= tsize; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			boolean is_t_str = false;
			String t_str = null;

			for (int i = 0; i < N; i++) { // 1이 포함된 열만 추출
				String str = br.readLine();
				if (is_t_str == false) {
					boolean is_1 = false;
					for (int i2 = 0; i2 < M; i2++) {
						if (str.charAt(i2) == '1') {
							is_1 = true;
							t_str = str;
						}
					}
					if (is_1) {
						is_t_str = true;
					}
				}
			}

			ArrayList<Character> str_list = new ArrayList<Character>();
			for (int i = 0; i < M; i++) { // 56개 추출
				if (t_str.charAt(M - 1 - i) == '1') {
					for (int i2 = 0; i2 < 56; i2++) {
						str_list.add(t_str.charAt(M - 1 - i - 55 + i2));
					}
					break;
				}
			}

			String[] pass = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
					"0110111", "0001011" };
			StringBuilder pass_num = new StringBuilder("");

			for (int i = 0; i < 8; i++) { // 검증코드 추출
				StringBuilder sb = new StringBuilder("");
				for (int j = 0; j < 7; j++) {
					sb.append(str_list.get((i * 7) + j));
				}
				for (int j = 0; j < pass.length; j++) {
					if (pass[j].equals(sb.toString())) {
						pass_num.append(j);
						break;
					}
				}
			}

			int[] p_arr = new int[8];
			for (int i = 0; i < 8; i++) {
				p_arr[i] = (int) pass_num.charAt(i) - '0';
			}

			// (홀수 자리의 합 x 3) + 짝수 자리의 합 + 검증 코드” 가 10의 배수가 되어야 한다.
			int temp = ((((p_arr[0] + p_arr[2] + p_arr[4] + p_arr[6]) * 3) + (p_arr[1] + p_arr[3] + p_arr[5]))
					+ p_arr[7]) % 10;
			int result = 0;

			System.out.printf("#%d ", tc);
			if (temp == 0) {
				for (int i = 0; i < 8; i++) {
					result += p_arr[i];
				}
				System.out.println(result);
			} else {
				System.out.println(0);
			}
		}
	}
}