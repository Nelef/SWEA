//1210
package problem_0127;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ladder1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int k = 0; k < 10; k++) {
			String case_num = br.readLine();

			ArrayList<Integer>[][] list = new ArrayList[100][100];

			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					list[i][j] = new ArrayList<Integer>();
					list[i][j].add(Integer.parseInt(st.nextToken()));
				}
			}
			int index_j = 0;

			// index_j 시작점 지정
			for (int j = 0; j < 100; j++) {
				if (list[99][j].get(0) == 2) {
					index_j = j;
					break;
				}
			}
			for (int i = 0; i < 100; i++) {
				boolean search_comlete = false; // 서치 완료했나?

				int whereigo = 0; // 0=어디든 가는거 가능, 1=왼쪽만 가능 2=오른쪽만 가능

				if (index_j == 0) { // 젤 왼쪽일 경우
					whereigo = 2; // 오른쪽만 가능
				} else if (index_j == 99) { // 제일 오른쪽일 경우
					whereigo = 1; // 왼쪽만 가능
				}

				if (whereigo != 2 && search_comlete == false) { // 왼쪽 서치
					if (list[99 - i][index_j - 1].get(0) == 1) {// 왼쪽에 길이 있는가?
						while (true) {
							index_j--;
							if (index_j == 0) { // 제일 왼쪽에 도달했을 경우
								search_comlete = true;
								break;
							}
							if (list[99 - i][index_j - 1].get(0) != 1) {// 이제 왼쪽에 길이 없는가?
								search_comlete = true;
								break;
							}
						}
					}
				}

				if (whereigo != 1 && search_comlete == false) { // 오른쪽 서치
					if (list[99 - i][index_j + 1].get(0) == 1) {// 오른쪽에 길이 있는가?
						while (true) {
							index_j++;
							if (index_j == 99) { // 제일 오른쪽에 도달했을 경우
								search_comlete = true;
								break;
							}
							if (list[99 - i][index_j + 1].get(0) != 1) {// 이제 오른쪽에 길이 없는가?
								search_comlete = true;
								break;
							}
						}
					}
				}
			}
			System.out.println("#" + case_num + " " + index_j);
		}
	}
}
