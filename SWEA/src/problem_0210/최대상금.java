package problem_0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 최대상금 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(br.readLine());

		for (int i = 0; i < a; i++) {
			ArrayList<Character> list = new ArrayList<Character>();

			StringTokenizer st = new StringTokenizer(br.readLine());

			String str = st.nextToken();

			int num = Integer.parseInt(st.nextToken());

			for (int j = 0; j < str.length(); j++) {
				list.add(str.charAt(j));
			}

			int cur = 0;

			while (num != 0) { // 바꾸는 횟수
				char max = 0;
				int max_index = -1;

				for (int cur_k = cur; cur_k < list.size(); cur_k++) { // 현재 위치부터 바꿀거 찾아본다.
					if (list.get(cur_k) >= max) {
						max = list.get(cur_k);
						max_index = cur_k;
					}
				}
				if (max_index != -1 && list.get(cur) < list.get(max_index)) { // 현재자리보다 큰 것을 발견 했다면
					int start_max_index = 0;
					// 제일 큰자리와 같은 수가 이전에 붙어 있을 경우 후에 재정렬을 해야 정확하게 나옴.
					for (int cur_k = max_index; cur_k >= 0; cur_k--) {
						if (list.get(cur_k) == list.get(max_index)) {
							start_max_index = cur_k;
						} else {
							break;
						}
					}
					// 큰자리와 붙어있는 개수만큼 변경
					int end_max_index = max_index;
					for (int j = 0; j <= end_max_index - start_max_index + 1; j++) {
						char temp = list.get(cur);
						list.set(cur, list.get(end_max_index));
						list.set(end_max_index, (char) temp);
						cur++;
						num--;
						if (num == 0) {
							break;
						}
						end_max_index--;
					}
					// 변경된 개수만큼 재정렬 123 -> 321
					for (int j = start_max_index; j <= max_index - 1; j++) {
						int idx = j;
						for (int k = j + 1; k <= max_index; k++) {
							if (list.get(k) > list.get(idx)) {
								idx = k;
							}
						}
						char temp = list.get(j);
						list.set(j, list.get(idx));
						list.set(idx, temp);
					}
				} else {
					if (cur == list.size()) {
						break;
					} else {
						cur++;
					}
				}
			}
			if (num != 0) { // 최대값이 나왔는데 수가 남았다면 거꾸로 탐색하여 바꿔치기하며 남은 수 소진
				cur = list.size() - 1; // 마지막에서부터 탐색

				// 100, 110 처럼 원소가 같은것이 2개 존재한다면 2회이상 남았을 경우 무조건 최대값으로 만들 수 있다.
				// ex) 100 2회 = 100 -> 001 -> 100
				// ex) 100 3회 = 100 -> 010 -> 001 -> 100
				// 따라서 맨끝에서부터 세자리를 검색하여 같은 수 2개가 존재하는지 확인한다.

				boolean isEqual = false;
				if (list.size() >= 3) {
					if (list.get(list.size() - 1) == list.get(list.size() - 2)
							|| list.get(list.size() - 1) == list.get(list.size() - 3)
							|| list.get(list.size() - 2) == list.get(list.size() - 3)) {
						isEqual = true;
					}
				}

				if (isEqual == false) {
					while (true) { // 바꿀 수 있는 걸 찾는다.
						if (list.get(cur) != list.get(list.size() - 1)) {
							break;
						}
						cur--;
					}
					while (num != 0) { // 서로 바꿔치기하며 남은 수 소진
						char temp = list.get(cur);
						list.set(cur, list.get(list.size() - 1));
						list.set(list.size() - 1, (char) temp);
						num--;
					}
				} else { // 같은게 존재한다면,
					num = 0; // 굳이 바꾸지 말고 탈출
				}
			}

			System.out.printf("#%d ", i + 1);
			for (char result_char : list) {
				System.out.print(result_char);
			}
			System.out.println();
		}
	}
}
