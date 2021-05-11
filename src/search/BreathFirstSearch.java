package search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BreathFirstSearch {

	static final int MAX_N = 10;
	static int N, E;				//노드, 간선
	static int [][] Graph = new int[MAX_N][MAX_N];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		E = sc.nextInt();
		
		for(int i=0; i < E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			Graph[u][v] = Graph[v][u] = 1; //방향성이 없어기 때문에 같이 처리 
		}
		
		bfs(0);
		
		sc.close();
	}
	
	static void bfs(int node) {
		boolean[] visited = new boolean[MAX_N];
		
		Queue<Integer> q = new LinkedList<Integer>();
		visited[node] = true;
		q.offer(node);
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			System.out.print(curr+ " ");
			
			for(int next=0; next<N; next++) {
				if(!visited[next] && Graph[curr][next] != 0) {
					visited[next] = true;
					q.offer(next);
				}
			}
		}
	}

}
