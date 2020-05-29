package study.date0529;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거DFS {

	// 상 우 하 좌
	static final int[] dy4 = {-1, 0, 1, 0};
	static final int[] dx4 = {0, 1, 0, -1};
	
	static final int[][] typeTunnel = {	// 터널 종류별로 4방향에 대해 뚫려 있는지 여부
			{0, 0, 0, 0},
			{1, 1, 1, 1},	// 모든 방향 가능
			{1, 0, 1, 0},	
			{0, 1, 0, 1},	
			{1, 1, 0, 0},	
			{0, 1, 1, 0},	
			{0, 0, 1, 1},	
			{1, 0, 0, 1},	
	};
	
	static int N, M, holeY, holeX, L;
	static int[][] map;
	static boolean[][] visited;
	static boolean[][] mark;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/s1953.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			answer = 0;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			holeY = Integer.parseInt(st.nextToken());
			holeX= Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			mark = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력 끝
			
			dfs(holeY, holeX, 1);
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (mark[i][j]) ++answer;
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	private static void dfs(int sy, int sx, int hours) {
		mark[sy][sx] = true;
		
		if (hours == L) {
			return;
		}
		
		// 터널별로 갈 수 있는 방향이 전부 다르다.
		int[] dirs = typeTunnel[map[sy][sx]];
		for (int dir = 0; dir < dirs.length; dir++) {
			if (dirs[dir] == 0) continue;
			int ny = sy + dy4[dir];
			int nx = sx + dx4[dir];
			if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
			if (map[ny][nx] == 0) continue;	// 다음칸에 터널이 아예 없는 경우
			if (visited[ny][nx]) continue;	// 이미 방문한 경우 
			
			if (typeTunnel[map[ny][nx]][(dir + 2) % 4] == 1) { // 다음 칸에서 터널이 이어지는 경우에만 진행
				visited[ny][nx] = true;
				dfs(ny, nx, hours + 1);
				visited[ny][nx] = false;
			}
		}
	}
	
	
	static class Pos {
		int y, x;
		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
