//1208
package problem_0126;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Flatten {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());

			int dump_size = Integer.parseInt(st.nextToken());

			ArrayList<Integer> list = new ArrayList<Integer>();
			StringTokenizer st2 = new StringTokenizer(bf.readLine());

			int st2_size = st2.countTokens();
			for (int i2 = 0; i2 < st2_size; i2++) {
				list.add(Integer.parseInt(st2.nextToken()));
			}

			int result = 0;

			for (int k = 0; k < dump_size; k++) {
				// max와 min을 구함.
				int max = 0;
				int max_index = 0;
				int min = 101;
				int min_index = 0;
								
				for (int i3 = 0; i3 < st2_size; i3++) {
					int temp_num = list.get(i3);
					if (max < temp_num) {
						max = temp_num;
						max_index = i3;
					}
					if (min > temp_num) {
						min = temp_num;
						min_index = i3;
					}
				}
				result = max - min;
				list.set(max_index, list.get(max_index)-1);
				list.set(min_index, list.get(min_index)+1);
				if(result <= 1) {
					break;
				}
			}
			// 평탄화 후 다시 구함.
			int max = 0;
			int min = 101;
							
			for (int i3 = 0; i3 < st2_size; i3++) {
				int temp_num = list.get(i3);
				if (max < temp_num) {
					max = temp_num;
				}
				if (min > temp_num) {
					min = temp_num;
				}
			}
			result = max - min;

			System.out.println("#"+(i+1)+" "+result);
		}
	}
}
