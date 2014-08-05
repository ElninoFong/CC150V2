package chapter_4;

public class Question4_2Graph {
	private Question4_2Node vertices[];
    public int count;
    public Question4_2Graph() {
            vertices = new Question4_2Node[6];
            count = 0;
    }
    
	public void addNode(Question4_2Node x) {
	            if (count < 30) {
	                    vertices[count] = x;
	                    count++;
	            } else {
	                    System.out.print("Graph full");
	            }
	}
	
	public Question4_2Node[] getNodes() {
	    return vertices;
	}
}
