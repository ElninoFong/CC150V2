package chapter_4;

import java.util.*;

/*
 * 4.2 
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */
public class Question4_2 {
	// TC:O(n), SC:O(n)
	// DFS
	public static boolean isConnectedDFS(Question4_2Node start, Question4_2Node end) {
		if (start == end) return true;
		for (Question4_2Node n : start.getAdjacent()) {		// err: no loop check
			if (isConnectedDFS(n, end)) return true;	
		}
		return false;
	}
	
	// TC:O(n), SC:O(n)
	// BFS
	public static boolean isConnectedBFS(Question4_2Node start, Question4_2Node end) {
		if (start == end) return true;
		LinkedList<Question4_2Node> queue = new LinkedList<Question4_2Node>();
		HashSet<Question4_2Node> visited = new HashSet<Question4_2Node>();
		queue.add(start);
		visited.add(start);
		
		while (!queue.isEmpty()) {
			Question4_2Node curr = queue.removeFirst();
			for (Question4_2Node n : curr.getAdjacent()) {
				if (n == end) return true;
				if (!visited.contains(n)) {
					queue.add(n);
					visited.add(n);
				}
			}
		}
		
		return false;
	}
	
	
	public static void main(String a[]) {
		Question4_2Graph g = createNewGraph();
		Question4_2Node[] n = g.getNodes();
		Question4_2Node start = n[0];
		Question4_2Node end = n[5];
        System.out.println(isConnectedDFS(start, end));
        System.out.println(isConnectedBFS(start, end));
    }
    
    public static Question4_2Graph createNewGraph() {
    	Question4_2Graph g = new Question4_2Graph();        
    	Question4_2Node[] temp = new Question4_2Node[6];

        temp[0] = new Question4_2Node("a", 3);
        temp[1] = new Question4_2Node("b", 0);
        temp[2] = new Question4_2Node("c", 0);
        temp[3] = new Question4_2Node("d", 1);
        temp[4] = new Question4_2Node("e", 1);
        temp[5] = new Question4_2Node("f", 0);

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[0].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[4]);
        temp[4].addAdjacent(temp[5]);
        for (int i = 0; i < 6; i++) {
                g.addNode(temp[i]);
        }
        return g;
    }
}
