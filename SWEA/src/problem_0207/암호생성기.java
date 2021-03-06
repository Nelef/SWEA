package problem_0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 암호생성기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 0; tc < 10; tc++) {
			int tcn = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			ArrayList<Integer> queue = new ArrayList<Integer>();

			for (int data_n = 0; data_n < 8; data_n++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			int cycle = 0;
			while (true) {
				int queue_temp = queue.get(0);
				queue.remove(0);
				queue_temp -= ++cycle;
				
				if(cycle == 5) {
					cycle = 0;
				}

				if (queue_temp <= 0) {
					queue_temp = 0;
					queue.add(queue_temp);
					break;
				} else {
					queue.add(queue_temp);
				}
			}
			
			System.out.print("#" + tcn);
			for (int i : queue) {
				System.out.print(" " + i);
			}
			System.out.println();
		}
	}
}
