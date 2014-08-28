package chapter_17;

/*
 * 17.13
 * Implement a method to convert a binary search tree (implemented with BiNode) into a doubly linked list.
 * The values should be kept in order and the operation should be performed in place (that is, on the original data structure).
 */
public class Question17_13 {
	// method 1:
	static int count = 0; 	// count for getTail
	public static BiNode convert(BiNode root) {
		if (root == null) return null;
		
		BiNode left = convert(root.node1);
		BiNode right = convert(root.node2);
		
		if (left != null) {
			concat(getTail(left), root);
		}
		if (right != null) {
			concat(root, right);
		}
		
		return left == null ? root : left;
	}
	
	static BiNode getTail(BiNode node) {
		if (node == null) return null;
		
		while (node.node2 != null) {
			node = node.node2;
			count++;
		}
		
		return node;
	}
	
	static void concat(BiNode n1, BiNode n2) {
		n1.node2 = n2;
		n2.node1 = n1;
	}
	
	
	// method 2:
	public static BiNode convertToCircular(BiNode root) {
		BiNode head = convertToCircularHelper(root);
		head.node1.node2 = null;
		head.node1 = null;
		return head;
	}
	
	
	static BiNode convertToCircularHelper(BiNode root) {
		if (root == null) return null;
		
		BiNode left = convertToCircularHelper(root.node1);
		BiNode right = convertToCircularHelper(root.node2);
		
		if (left == null && right == null) {
			root.node1 = root;
			root.node2 = root;
			return root;
		}
		
		BiNode tail = right == null ? null : right.node1;
		if (left != null) {
			concat(left.node1, root);
		} else {
			concat(right.node1, root);
		}
		if (right != null) {
			concat(root, right);
		} else {
			concat(root, left);
		}
		if (left != null && right != null) {
			concat(tail, left);
		}
		
		return left == null ? root : left;
	}
	
	
	/////////////////
	public static void printLinkedListTree(BiNode root) {
        for (BiNode node = root; node != null; node = node.node2) {
                if (node.node2 != null && node.node2.node1 != node) {
                        System.out.print("inconsistent node: " + node);
                }
                System.out.print(node.data + "->");
        }
        System.out.println("null");
        System.out.println();
	}
	
	public static BiNode createTree() {
	        BiNode[] nodes = new BiNode[7];
	        for (int i = 0; i < nodes.length; i++) {
	                nodes[i] = new BiNode(i);
	        }
	        nodes[4].node1 = nodes[2];
	        nodes[4].node2 = nodes[5];
	        nodes[2].node1 = nodes[1];
	        nodes[2].node2 = nodes[3];
	        nodes[5].node2 = nodes[6];
	        nodes[1].node1 = nodes[0];
	        return nodes[4];
	}
	
	public static void printAsTree(BiNode root, String spaces) {
	        if (root == null) {
	                System.out.println(spaces + "- null");
	                return;
	        }
	        System.out.println(spaces + "- " + root.data);
	        printAsTree(root.node1, spaces + "   ");
	        printAsTree(root.node2, spaces + "   ");
	}
	
	public static void main(String[] args) {
	        BiNode root = createTree();
	        printAsTree(root, "");
//	        BiNode n = convert(root);
	        BiNode n = convertToCircular(root);
	        printLinkedListTree(n);
	        System.out.println(count);
	}
}
