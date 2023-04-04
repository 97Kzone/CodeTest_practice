package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 2638 - 치즈
 * 
 * N x M 격자판
 * 격자판 위에 치즈가 존재
 * 각 칸의 치즈는 적어도 2변 이상이 실내 온도의 공기과 접촉하면 한시간 뒤에 없어짐
 * 치즈 내부의 공간은 외부 공기와 접촉하지 않음.
 * 
 * 치즈가 모두 녹아 없어지는데 걸리는 정확한 시간을 구하라
 * 
*/
public class G3_2638_2 {

	static class Cheese{
		int r, c;

		public Cheese(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static class Hole {
		int r, c;

		public Hole(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M;
	static int[][] map;
	//상 우 하 좌
	static int[] dr1 = {-1, 0, 1, 0};
	static int[] dc1 = {0, 1, 0, -1};
	static boolean[][] findHoleVisited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		findHoleVisited = new boolean[N][M];
		
		Queue<Cheese> q = new LinkedList<>();
		
		for(int i=0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) q.offer(new Cheese(i, j)); //치즈가 있는 곳이면 q에 담기
			}
		}
		
		//구멍 찾기
		for(int i=1; i < N - 1; i++) for(int j=1; j < M - 1; j++) if( !findHoleVisited[i][j] && map[i][j] == 0) findHole(i, j);
		
		//치즈 녹이기 시작
		int time = 0;
		
		int nr, nc;
		Cheese cur;
		List<Cheese> removeList = new ArrayList<>();
		List<Hole> holeList = new ArrayList<>();
		List<Hole> tempHole = new ArrayList<>(); 
		while(!q.isEmpty()) {
            // for (int[] n : map) {
            //     System.out.println(Arrays.toString(n));
            // }
            // System.out.println("---------------------");

            int size = q.size();
			removeList.clear();
			holeList.clear();
			tempHole.clear();
			
			for(int i=0; i < size; i++) {
				cur = q.poll();
				int airCnt = 0;
				for(int d=0; d < 4; d++) {
					nr = cur.r + dr1[d];
					nc = cur.c + dc1[d];
					if(map[nr][nc] == 0) airCnt++;
					else if(map[nr][nc] == 2) tempHole.add(new Hole(nr, nc));
				}
				
				//사라져야하는 치즈인 경우
				if(airCnt > 1) {
					removeList.add(cur);
					for(int h=0; h < tempHole.size(); h++) holeList.add(tempHole.get(h));
				} else q.offer(cur);
			}
			
			time++;
			
			//치즈 삭제
			for(int i=0; i < removeList.size(); i++) map[removeList.get(i).r][removeList.get(i).c] = 0;
			
			//구멍 삭제
			for(int i=0; i < holeList.size(); i++) removeHole(holeList.get(i).r, holeList.get(i).c);
			
		}
		
		//출력
		System.out.println(time);
		
		br.close();
	}
	
	//구멍을 공기로 바꾸는 함수
	private static void removeHole(int r, int c) {
		if(map[r][c] == 0) return; // 이미 바뀐 곳이면
		
		Queue<Hole> q = new LinkedList<>();
		q.offer(new Hole(r, c));
		int nr, nc;
		Hole cur;
		while(!q.isEmpty()) {
			cur = q.poll();
			map[cur.r][cur.c] = 0;
			for(int d=0; d < 4; d++) {
				nr = cur.r + dr1[d];
				nc = cur.c + dc1[d];
				if(map[nr][nc] == 2) {
                    q.offer(new Hole(nr, nc));
                }
            }
		}

	}
	
	//구멍을 찾아 표시해주는 함수
	private static void findHole(int r, int c) {
		findHoleVisited[r][c] = true; //방문처리
		Queue<Hole> q = new LinkedList<>();
		q.offer(new Hole(r, c));
		int nr, nc;
		Hole cur;
		boolean flag = true;
		while(!q.isEmpty()) {
			cur = q.poll();
			for(int d=0; d < 4; d++) {
				nr = cur.r + dr1[d];
				nc = cur.c + dc1[d];
				if(outMap(nr, nc)) flag = false; //가장자리를 만난 경우 구멍이 아닌 것으로 판단
				else if(map[nr][nc] == 0 && !findHoleVisited[nr][nc]) {
					findHoleVisited[nr][nc] = true;
					q.offer(new Hole(nr, nc)); //빈 곳인 경우 추가
				}
			}
		}
		
		//구멍임이 확인되었을 때
		if(flag) {
			map[r][c] = 2;
			q.offer(new Hole(r, c));
			while(!q.isEmpty()) {
				cur = q.poll();
				for(int d=0; d < 4; d++) {
					nr = cur.r + dr1[d];
					nc = cur.c + dc1[d];
					if(map[nr][nc] == 0) {
						map[nr][nc] = 2;
						q.offer(new Hole(nr, nc)); //빈 곳인 경우 추가
					}
				}
			}
		}
		
	}
	
	//가장자리에서 벗어나는지 확인하는 함수
	private static boolean outMap(int r, int c) {
		return (0 <= r && r < N) && (0 <= c && c < M);
	}
}
