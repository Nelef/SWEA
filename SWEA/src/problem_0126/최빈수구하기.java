//1204
package problem_0126;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Num {
	int num;
	int size;

	public Num(int num, int size) {
		super();
		this.num = num;
		this.size = size;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}

public class 최빈수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int case_all_num = Integer.parseInt(st.nextToken());

		for (int i = 0; i < case_all_num; i++) {
			StringTokenizer st2 = new StringTokenizer(bf.readLine());
			int case_num = Integer.parseInt(st2.nextToken());
			StringTokenizer st3 = new StringTokenizer(bf.readLine(), " ");
			
			ArrayList<Num> list = new ArrayList<Num>();
			int st3_tokens_size = st3.countTokens();
			
			for (int j = 0; j < st3_tokens_size; j++) {
				int temp_token = Integer.parseInt(st3.nextToken());
				
				boolean test = false;
				// 리스트에 똑같은 거 있으면 +1
				for (int k = 0; k < list.size(); k++) {
					if (list.get(k).getNum() == temp_token) {
						list.get(k).setSize(list.get(k).getSize() + 1);
						test = true;
						break;
					}
				}
				// 리스트에 똑같은 거 없으면 새로 만듬.
				if (test == false) {
					Num temp = new Num(temp_token, 1);
					list.add(temp);
				}
			}
			
			int big = 0;
			int answer = 0;
			
			for (int k = 0; k < list.size(); k++) {
				if (list.get(k).getSize() > big) {
					big = list.get(k).getSize();
					answer = list.get(k).getNum();
				} else if (list.get(i).getSize() == big) {
					answer = list.get(k).getNum();
				}
			}
			System.out.println("#"+case_num+" "+answer);
		}
	}
}
