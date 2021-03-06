//1220
package problem_0127;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Magnetic {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int k = 0; k < 10; k++) {
			int size = Integer.parseInt(br.readLine());

			ArrayList<Integer>[][] list = new ArrayList[size][size];

			for (int i = 0; i < size; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < size; j++) {
					list[i][j] = new ArrayList<Integer>();
					list[i][j].add(Integer.parseInt(st.nextToken()));
				}
			}

			int result = 0;
			for (int j = 0; j < size; j++) {
				boolean test = false; // 현재상태? false = N없음, true = N있음.
				for (int i = 0; i < size; i++) {
					if (list[i][j].get(0) != 0) { // 자석인가?
						if (list[i][j].get(0) == 1) { // N인가? 
							if(test == false) { // 원래 N이 없나?
								test = true; // N 가진것으로 변경
							}
						} else { //S인가?
							if(test == true) { // 원래 N이 있나?
								result++;
								test = false;
							}
						}
					}
				}
			}
			
			System.out.println("#"+(k+1)+" "+result);
		}
	}
}