package hw.date0124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_J1341_구구단2_임예찬 {

	// 구구단의 시작 범위 s와 끝 범위 e (2부터 9사이의 정수)
	static int s;
	static int e;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			// 시작범위와 끝 범위를 입력 받는다.
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			if ((s >= 2 && s <= 9) && (e >= 2 && e <= 9)) {
				// 올바른 범위에 있는 경우
				break;
			} else {
				// 주어진 범위를 벗어날 경우
				System.out.println("INPUT ERROR!");
			}
		}
		
		if (s < e) {
			printGugudan(s, e);
		} else {
			// 역순으로 구구단 출력
			printGugudanDesc(s, e);
		}
	}
	
	private static void printGugudan(int s, int e) {
		for (int dan = s; dan <= e; dan++) {
			for (int j = 1; j <=9; j++) {
				System.out.printf("%d * %d = %2d", dan, j, dan * j);
				System.out.print("   ");
				if (j % 3 == 0) System.out.println();
			}
			System.out.println();
		}
	}

	private static void printGugudanDesc(int s, int e) {
		for (int dan = s; dan >= e; dan--) {
			for (int j = 1; j <=9; j++) {
				System.out.printf("%d * %d = %2d", dan, j, dan * j);
				System.out.print("   ");
				if (j % 3 == 0) System.out.println();
			}
			System.out.println();
		}
	}
}
