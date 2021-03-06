//1206
package problem_0126;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class View {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());

			int list_size = Integer.parseInt(st.nextToken());

			ArrayList<Integer> list = new ArrayList<Integer>();
			StringTokenizer st2 = new StringTokenizer(bf.readLine());

			for (int i2 = 0; i2 < list_size; i2++) {
				list.add(Integer.parseInt(st2.nextToken()));
			}
			int jo_count = 0;
			for (int i2 = 2; i2 < list_size - 2; i2++) { // 양쪽 2칸은 건물 없음
				while (true) {
					boolean jo = true; // 조망권
					if (list.get(i2) > 0) { // 건물이 1층이상일때,
						if (list.get(i2 - 2) >= list.get(i2)) { // -2칸 건물 조망권?
							jo = false;
						}
						if (list.get(i2 - 1) >= list.get(i2)) { // -1칸 건물 조망권?
							jo = false;
						}
						if (list.get(i2 + 1) >= list.get(i2)) { // +1칸 건물 조망권?
							jo = false;
						}
						if (list.get(i2 + 2) >= list.get(i2)) { // +2칸 건물 조망권?
							jo = false;
						}
					} else {
						jo = false;
					}
					if (jo == true) {
						list.set(i2, list.get(i2)-1);
						jo_count++;
					} else {
						break;
					}
				}
			}
			System.out.println("#" + (i + 1) + " " + jo_count);
		}
	}
}
