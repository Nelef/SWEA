//1216
package problem_0128;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 회문2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int k = 0; k < 10; k++) {
			br.readLine();

			char[][] list = new char[100][100];

			for (int i = 0; i < 100; i++) {
				String temp = br.readLine();
				for (int j = 0; j < 100; j++) {
					list[i][j] = temp.charAt(j);
				}
			}

			int max = 0;

			for (int i = 0; i < 100; i++) { // y축
				for (int size = 30; size > 0; size--) { // 길이
					if (max < size) { // max보다 큰것만 진행
						int index_x = 0;
						while (true) {
							boolean isPalindrome_1 = true; // 회문 판별값을 저장할 변수, 초깃값은 true
							boolean isPalindrome_2 = true; // 회문 판별값을 저장할 변수, 초깃값은 true
							// 0부터 문자열 길이의 절반만큼 반복
							for (int j = 0; j < size / 2; j++) { // 가로 체크
								// 왼쪽 문자와 오른쪽 문자를 비교하여 문자가 다르면
								if (list[i][index_x + j] != list[i][index_x + size - 1 - j]) {
									// 회문이 아님
									isPalindrome_1 = false;
								}
								if (list[index_x + j][i] != list[index_x + size - 1 - j][i]) {
									// 회문이 아님
									isPalindrome_2 = false;
								}
								if ((isPalindrome_1 || isPalindrome_2) == false) {
									break;
								}
							}
							if (isPalindrome_1 || isPalindrome_2) {
								max = size;
								break;
							} else if (index_x + size < 100) {
								index_x++;
							} else {
								break;
							}
						}
					} else if (max <= size) {
						break;
					}
				}
			}
			bw.write("#" + (k + 1) + " " + max + "\n");
		}
		bw.flush();
	}
}
