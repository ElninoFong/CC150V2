package chapter_4;

public class Question4_2Node {
	private Question4_2Node adjacent[];
    public int adjacentCount;
    private String vertex;
    
    public Question4_2Node(String vertex, int adjacentLength) {
        this.vertex = vertex;                
        adjacentCount = 0;        
        adjacent = new Question4_2Node[adjacentLength];
    }
    
    public void addAdjacent(Question4_2Node x) {
        if (adjacentCount < 30) {
            this.adjacent[adjacentCount] = x;
            adjacentCount++;
        } else {
            System.out.print("No more adjacent can be added");
        }
    }
    public Question4_2Node[] getAdjacent() {
        return adjacent;
    }
    public String getVertex() {
        return vertex;
    }
}
