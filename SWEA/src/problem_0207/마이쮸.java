package problem_0207;

import java.io.InputStreamReader;
import java.util.ArrayList;

public class 마이쮸 {
	public static void main(String[] args) {
		int my = 20;

		ArrayList<Human> hu_list = new ArrayList<Human>();

		int num = 0;
		hu_list.add(new Human(++num, 1));
		while (true) {
			for (int i = 0; i < hu_list.size(); i++) {
				Human temp_Hu = hu_list.get(0);
				int temp_Hu_count = temp_Hu.getCount();
				System.out.print("["+temp_Hu.getNum()+"번, "+temp_Hu.getCount()+"]");
				my -= temp_Hu_count;
				if (my <= 0) {
					System.out.println("\n"+temp_Hu.getNum() + "번 학생이 마지막");
					break;
				}
				temp_Hu.setCount(++temp_Hu_count);
				hu_list.remove(0);
				hu_list.add(temp_Hu);
				hu_list.add(new Human(++num, 1));
			}
			System.out.println();
			if (my <= 0) {
				break;
			}
		}
	}
}

class Human {
	int num;
	int count;

	public Human(int num, int count) {
		super();
		this.num = num;
		this.count = count;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}