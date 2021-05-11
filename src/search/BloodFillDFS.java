package search;

import java.util.Scanner;
import java.util.Stack;

public class BloodFillDFS {

	static final int MAX_N = 10;
	static int [][] D = {{-1,0},{1,0},{0,-1},{0,1}};	//위, 아래, 좌, 우 이동
	static int N;										//좌우길이
	static int [][] Board = new int[MAX_N][MAX_N];
	
	static class Point{	//위치 클래스
		int row, col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		} 			
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		int row, col, color;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				Board[i][j] = sc.nextInt();
			}
		}
		
		//시작위치
		row = sc.nextInt();
		col = sc.nextInt();
		
		//변경할 색상
		color = sc.nextInt();
		
		dfs(row, col, color);
		
		//변경된 보드 출력
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(Board[i][j] +" ");
			}
			System.out.println();
		}
		
		sc.close();

	}
	
	
	static void dfs(int row, int col, int color) {
		boolean[][] visited = new boolean[MAX_N][MAX_N];
		Stack<Point> s = new Stack<Point>();
		s.push(new Point(row, col));
			
		while(!s.empty()) {
			Point curr = s.pop();
			
			if(visited[curr.row][curr.col]) continue;
			
			visited[curr.row][curr.col] = true;
			Board[curr.row][curr.col] = color;
			
			for(int i=0; i<4; i++) {
				int nr = curr.row + D[i][0], nc = curr.col + D[i][1];	//위치 이동
				
				//예외 상황
				if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1) continue;	//위치가 보드 영역을 벗어 난 경우
				if(visited[nr][nc]) continue;							//이 위치에 온적이 있는 경우
				if(Board[nr][nc] == 1) continue;						//이 위치가 막힌경우
				
				s.push(new Point(nr, nc));
			}
		}
	}

}
