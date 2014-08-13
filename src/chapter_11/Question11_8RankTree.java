package chapter_11;

public class Question11_8RankTree {
	public Question11_8RankNode root;

	public void insert(int d) {
		if (root == null) {
			root = new Question11_8RankNode(d);
		} else {
			insert(root, d);
		}
	}
	
	void insert(Question11_8RankNode node, int d) {
		if (d <= node.data) {
			// insert left and update leftSize
			node.leftSize++;
			if (node.left == null) {
				node.left = new Question11_8RankNode(d);
			} else {
				insert(node.left, d);
			}
		} else {
			// insert right
			if (node.right == null) {
				node.right = new Question11_8RankNode(d);
			} else {
				insert(node.right, d);
			}
		}
	}
	
	public int getRankOfNumber(int d) {
		Question11_8RankNode curr = root;
		int res = 0;
		
		while (curr != null) {
			if (curr.data == d) return res + curr.leftSize;
			if (curr.data > d) {
				// search left
				curr = curr.left;
			} else {
				// search right and add res
				res += curr.leftSize + 1;
				curr = curr.right;
			}
		}
		
		// not found
		return -1;
	}
}
