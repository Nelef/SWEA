//1209
package problem_0127;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sum {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int k = 0; k < 10; k++) {
			int problem_num = Integer.parseInt(bf.readLine());

			ArrayList<Integer>[][] myList = new ArrayList[100][100];

			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < 100; j++) {
					int n = Integer.parseInt(st.nextToken());
					myList[i][j] = new ArrayList<Integer>();
					myList[i][j].add(n);
				}
			}
			int max = 0; // 최대값
			int sum3 = 0; // 대각선
			int sum4 = 0; // 대각선
			for (int i = 0; i < 100; i++) {
				sum3 += myList[i][i].get(0);
				sum4 += myList[99-i][i].get(0);
				int sum1 = 0; // 가로
				int sum2 = 0; // 세로
				for (int j = 0; j < 100; j++) {
					sum1 += myList[j][i].get(0);
					sum2 += myList[i][j].get(0);
				}
				if (max < sum1) {
					max = sum1;
				}
				if (max < sum2) {
					max = sum2;
				}
			}
			if (max < sum3) {
				max = sum3;
			}
			if (max < sum4) {
				max = sum4;
			}

			System.out.println("#" + problem_num + " " + max);
		}
	}
}
