package problem_0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 작업순서 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tn = 0; tn < 10; tn++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			ArrayList<Vlist> vlist = new ArrayList<Vlist>();

			for (int Vn = 0; Vn < V; Vn++) {
				ArrayList<Integer> a = new ArrayList<Integer>();
				vlist.add(new Vlist((Vn + 1), a));
			}

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < E; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				for (Vlist k : vlist) {
					if (k.getNum() == b) {
						Arraylist<Integer> temp = k.getA();
						k.setA(.add(a));
					}
				}
			}

			for (int temp = 0; temp < vlist.size(); temp++) {
				for (int temp2 = 0; temp2 < vlist.get(temp).size(); temp2++) {
					System.out.println(vlist.get(temp).get(temp2));
				}
			}
		}
	}
}

class Vlist {
	int num;
	ArrayList<Integer> a = new ArrayList<Integer>();

	public Vlist(int num, ArrayList<Integer> a) {
		super();
		this.num = num;
		this.a = a;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public ArrayList<Integer> getA() {
		return a;
	}

	public void setA(ArrayList<Integer> a) {
		this.a = a;
	}
}