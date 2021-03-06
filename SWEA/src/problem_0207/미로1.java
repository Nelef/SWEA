package problem_0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 미로1 {
	static int N = 16;
	static char[][] arr;
	// 상하좌우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static ArrayList<pair> queue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 0; tc < 10; tc++) {
			arr = new char[N][N];
			queue = new ArrayList<pair>();
			int tcn = Integer.parseInt(br.readLine());

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			
            System.out.print("#" + tcn + " ");
            bfs(1,1);
		}
	}

	public static void bfs(int x, int y) {
		queue.add(new pair(x, y));
		arr[x][y] = '1'; // 방문처리

		while (queue.size() != 0) {
			pair cur = queue.get(0);
			queue.remove(0);

			for (int i = 0; i < 4; i++) {
				int curX = cur.x + dx[i];
				int curY = cur.y + dy[i];

				if (arr[curX][curY] == '0') { // 갈 수 있다?
					queue.add(new pair(curX, curY));
					arr[curX][curY] = '1';
				}
				if (arr[curX][curY] == '3') { // 목적지 도달?
					System.out.println("1");
					return;
				}
			}
		}
		System.out.println("0");
	}
}

class pair {
	int x;
	int y;

	public pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}