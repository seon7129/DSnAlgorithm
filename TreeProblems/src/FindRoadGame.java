import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindRoadGame {

	public static void main(String[] args) {
		int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};

		// [[7,4,6,9,1,8,5,2,3],[9,6,5,8,1,4,3,2,7]]
		for (int[] a : solution(nodeinfo))
			System.out.println(Arrays.toString(a));
	}
	
	static class Node {
        int val;
        int x; // x 좌표 저장
        Node left;
        Node right;

        public Node(int val, int x) {
            this.val = val;
            this.x = x;
            this.left = null;
            this.right = null;
        }

        public void addLeft(Node left) {
            this.left = left;
        }

        public void addRight(Node right) {
            this.right = right;
        }
    }

    private static Node root = null;

    public static int[][] solution(int[][] nodeinfo) {
        List<int[]> nodes = new ArrayList<>();

        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new int[]{nodeinfo[i][0], nodeinfo[i][1], i + 1});
        }

        // y 좌표로 내림차순, y가 같으면 x 좌표로 오름차순 정렬
        nodes.sort((a, b) -> (b[1] == a[1]) ? a[0] - b[0] : b[1] - a[1]);

        for (int[] node : nodes) {
            if (root == null) {
                root = new Node(node[2], node[0]);
            } else {
                insertNode(root, node[0], node[2]);
            }
        }

        int[][] result = {preorder().stream().mapToInt(i -> i).toArray(),
                postorder().stream().mapToInt(i -> i).toArray()};

        return result;
    }

    private static void insertNode(Node current, int x, int value) {
        if (x < current.x) {
            if (current.left == null) {
                current.addLeft(new Node(value, x));
            } else {
                insertNode(current.left, x, value);
            }
        } else {
            if (current.right == null) {
                current.addRight(new Node(value, x));
            } else {
                insertNode(current.right, x, value);
            }
        }
    }

    // Preorder 순회
    public static List<Integer> preorder() {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }

    private static void preorderTraversal(Node node, List<Integer> result) {
        if (node == null) return;

        result.add(node.val);  // 현재 노드 방문
        preorderTraversal(node.left, result);  // 왼쪽 서브트리 순회
        preorderTraversal(node.right, result);  // 오른쪽 서브트리 순회
    }

    // Postorder 순회
    public static List<Integer> postorder() {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }

    private static void postorderTraversal(Node node, List<Integer> result) {
        if (node == null) return;

        postorderTraversal(node.left, result);  // 왼쪽 서브트리 순회
        postorderTraversal(node.right, result);  // 오른쪽 서브트리 순회
        result.add(node.val);  // 현재 노드 방문
    }

}
