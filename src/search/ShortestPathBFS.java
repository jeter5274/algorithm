package search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPathBFS {

	static final int MAX_N = 10;
	static int [][] D = {{-1,0},{1,0},{0,-1},{0,1}};	//위, 아래, 좌, 우 이동
	static int N;										//좌우길이
	static int [][] Board = new int[MAX_N][MAX_N];
	
	static class Point{	//위치 클래스
		int row, col, dist;

		public Point(int row, int col, int dist) {
			this.row = row;
			this.col = col;
			this.dist = dist;
		} 			
	}
	
	public static void main(String[] args) {
		
		int sRow, sCol, dRow, dCol;
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				Board[i][j] = sc.nextInt();
			}
		}
		
		//시작위치
		sRow = sc.nextInt();
		sCol = sc.nextInt();
		
		//끝 위치
		dRow = sc.nextInt();
		dCol = sc.nextInt();
		
		System.out.println(bfs(sRow, sCol, dRow, dCol));
		
		sc.close();
	}

	static int bfs(int sRow, int sCol, int dRow, int dCol) {
		
		boolean[][] visited = new boolean[MAX_N][MAX_N];
		Queue<Point> q = new LinkedList<Point>();
		int result = 0;
				
		//시작위치를 입력
		q.offer(new Point(sRow, sCol, 0));
		//시작위치 방문여부 
		visited[sRow][sCol] = true;
		
		
		while(!q.isEmpty()) {
			Point curr = q.poll();
			
			//현재 위치가 도착지점이면 거리를 리턴하여라
			if (curr.row == dRow && curr.col == dCol) result = curr.dist;
			
			//4방향으로 갈 수 있음
			for(int i=0; i<4; i++) {
				int nr = curr.row + D[i][0], nc = curr.col + D[i][1];	//위치 이동
				
				//예외 상황
				if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1) continue;	//위치가 보드 영역을 벗어 난 경우
				if(visited[nr][nc]) continue;							//이 위치에 온적이 있는 경우
				if(Board[nr][nc] == 1) continue;						//이 위치가 막힌경우
				
				visited[nr][nc] = true;
				q.offer(new Point(nr, nc, curr.dist+1));
			}
		}
		
		return result;
	}
}
