//1213
package problem_0128;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class String_ {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int k = 0; k < 10; k++) {
			int p_n = Integer.parseInt(br.readLine());
			String test = br.readLine();
			String test_String = br.readLine();
			int count = 0;
			for (int i = 0; i < test_String.length() - test.length()+1; i++) {
				if (test_String.charAt(i) == test.charAt(0)) {
					boolean isSearch = true;
					for (int index = 0; index < test.length(); index++) {
						if (test_String.charAt(i + index) != test.charAt(index)) {
							isSearch = false;
							break;
						}
					}
					if (isSearch) {
						count++;
						i+=test.length();
					}
				}
			}
			bw.write("#" + (k + 1) + " " + count + "\n");
		}
		bw.flush();
	}
}
