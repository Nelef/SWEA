package problem_0207;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연습문제3 {
	public static void main(String[] args) {
		ArrayList<A> Alist = new ArrayList<A>();

		for (int i = 1; i <= 7; i++) {
			Alist.add(new A(i, new ArrayList<Integer>()));
		}
		StringTokenizer st = new StringTokenizer("1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7");
		int st_size = st.countTokens() / 2;

		for (int i = 0; i < st_size; i++) {
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			for (A a_temp : Alist) {
				if (a_temp.getNum() == a) {
					ArrayList<Integer> temp_list = a_temp.getList();
					temp_list.add(b);
					a_temp.setList(temp_list);
					break;
				}
			}
		}
		for (A a_temp : Alist) {
			System.out.print(a_temp.getNum()+"-> ");
			for (int a : a_temp.getList()) {
				System.out.print(a+", ");
			}
			System.out.println();
		}
		
	}
}

class A {
	int num;
	ArrayList<Integer> list = new ArrayList<Integer>();
	
	public A(int num, ArrayList<Integer> list) {
		super();
		this.num = num;
		this.list = list;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public ArrayList<Integer> getList() {
		return list;
	}
	public void setList(ArrayList<Integer> list) {
		this.list = list;
	}
}