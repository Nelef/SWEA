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
				vlist.add(new Vlist((Vn+1), 0, 0));
			}
			
			st = new StringTokenizer(br.readLine());
			
			
		}
	}
}
class Vlist{
	int num;
	int a;
	int b;
	
	public Vlist(int num, int a, int b) {
		super();
		this.num = num;
		this.a = a;
		this.b = b;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
}