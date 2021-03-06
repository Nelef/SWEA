package problem_0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
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
						ArrayList<Integer> temp = k.getAlist();
						temp.add(a);
						k.setAlist(temp);
					}
				}
			}

			// 정렬
			for (Vlist k : vlist) {
				ArrayList<Integer> temp = k.getAlist();
				temp.sort(Comparator.naturalOrder());
				k.setAlist(temp);
			}

			// 리스트 테스트
//			for (int temp = 0; temp < vlist.size(); temp++) {
//				System.out.print(vlist.get(temp).getNum() + " <- ");
//				for (int temp2 = 0; temp2 < vlist.get(temp).getAlist().size(); temp2++) {
//					System.out.print(vlist.get(temp).getAlist().get(temp2) + ", ");
//				}
//				System.out.println();
//			}

			ArrayList<Integer> resultlist = new ArrayList<Integer>();

			while (true) {
				if (vlist.size() == 0) { // 더 이상 삭제할 정점이 없다면 종료.
					break;
				}
				int delE = 0;// 삭제된 간선 index
				for (int k = 0; k < vlist.size(); k++) {
					if (vlist.get(k).getAlist().size() == 0) { // 연결된 간선이 없는 정점이라면
						delE = vlist.get(k).getNum();
						resultlist.add(delE);// 제거된 정점 결과에 추가
						vlist.remove(k);// 정점 삭제
						break;
					}
				}
				if (delE != 0) { // 간선 없는 정점이 발견 됬다면
					for (int i = 0; i < vlist.size(); i++) { // 삭제 한 정점과 연결된 정점 서치
						ArrayList<Integer> t_vlist = vlist.get(i).getAlist();
						for (int j = 0; j < t_vlist.size(); j++) {
							if (t_vlist.get(j) > delE) {
								break;
							} else if (t_vlist.get(j) == delE) {
								t_vlist.remove(j);
								vlist.get(i).setAlist(t_vlist);
								break;
							}
						}
					}
				}
			}
			System.out.print("#" + (tn + 1));
			for (int i : resultlist) {
				System.out.print(" " + i);
			}
			System.out.println();
		}
	}
}

class Vlist {
	int num;
	ArrayList<Integer> Alist = new ArrayList<Integer>();

	public Vlist(int num, ArrayList<Integer> alist) {
		super();
		this.num = num;
		Alist = alist;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public ArrayList<Integer> getAlist() {
		return Alist;
	}

	public void setAlist(ArrayList<Integer> alist) {
		Alist = alist;
	}
}