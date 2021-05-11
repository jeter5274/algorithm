package search;

import java.util.Scanner;

public class DepthFirstSearch {

	static final int MAX_N = 10;
	static int N, E;				//노드, 간선
	static int [][] Graph = new int[MAX_N][MAX_N];
	static boolean[] Visited = new boolean[MAX_N];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		E = sc.nextInt();
		
		for(int i=0; i < E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			Graph[u][v] = Graph[v][u] = 1; //방향성이 없어기 때문에 같이 처리 
		}
		
		dfs(0);
		
		sc.close();
	}
	
	static void dfs(int node) {
		Visited[node] = true;
	
		System.out.print(node+ " ");
			
		for(int next=0; next<N; next++) {
			if(!Visited[next] && Graph[node][next] != 0) {
				dfs(next);
			}
		}
	}

}
