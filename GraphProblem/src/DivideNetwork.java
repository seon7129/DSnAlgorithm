import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class DivideNetwork {

	public static void main(String[] args) {
		int[][] w = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};
		System.out.println(solution(7,w));
	}
	
	
	static class TreeNode {
	    int value;
	    List<TreeNode> children;
	    
	    TreeNode(int value) {
	        this.value = value;
	        this.children = new ArrayList<>();
	    }
	}

	
	
	public static int solution(int n, int[][] wires) {
		// 노드와 간선 정보를 저장할 맵
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        
        // 간선에 따라 트리 구성
        for (int[] edge : wires) {
            int node1 = edge[0];
            int node2 = edge[1];
            
            // 노드1과 노드2를 얻거나 생성
            TreeNode n1 = nodeMap.computeIfAbsent(node1, TreeNode::new);
            TreeNode n2 = nodeMap.computeIfAbsent(node2, TreeNode::new);
            
            // 연결 추가
            n1.children.add(n2);
            n2.children.add(n1);
        }
        
        // 트리의 루트 노드를 찾는 것은 여러 방법이 있지만, 
        // 여기서는 임의로 루트를 선택하여 출력
        TreeNode root = nodeMap.get(1);  // 예를 들어, 1번 노드를 루트로 설정
        
        // 트리 출력 (간단한 DFS)
        printTree(root, new HashSet<>());
        
     // 자식 노드의 개수 출력
        printChildCounts(root, new HashSet<>());
        
        return 0;
    }
	
	// 트리를 DFS 방식으로 출력
    private static void printTree(TreeNode node, Set<TreeNode> visited) {
        if (node == null || visited.contains(node)) return;
        visited.add(node);
        
        System.out.println("Node: " + node.value + " -> " + node.children.stream().map(n -> n.value).toList());
        for (TreeNode child : node.children) {
            printTree(child, visited);
        }
    }
    
 // 트리의 각 노드에서 자식 노드의 개수를 출력
    private static void printChildCounts(TreeNode node, Set<TreeNode> visited) {
        if (node == null || visited.contains(node)) return;
        visited.add(node);
        
        // 자식 노드의 개수 출력
        System.out.println("Node " + node.value + " has " + node.children.size() + " children.");
        
        // 자식 노드들을 재귀적으로 방문
        for (TreeNode child : node.children) {
            printChildCounts(child, visited);
        }
    }
}
