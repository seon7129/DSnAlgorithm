import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DivideNetwork2 {

    public static void main(String[] args) {
        int[][] w = {{1,2},{2,3},{3,4}};
        System.out.println(solution(4, w));
    }
    
    static class TreeNode {
        int value;
        List<TreeNode> children;
        TreeNode parent;
        
        TreeNode(int value) {
            this.value = value;
            this.children = new ArrayList<>();
            this.parent = null;
        }
    }
    
    private static int[] subTreeCnt;
    private static int max = Integer.MIN_VALUE;

    public static int solution(int n, int[][] wires) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        subTreeCnt = new int[n];
        
        // 노드와 간선 정보를 기반으로 트리 구성
        for (int[] edge : wires) {
            int node1 = edge[0];
            int node2 = edge[1];
            
            TreeNode n1 = nodeMap.computeIfAbsent(node1, TreeNode::new);
            TreeNode n2 = nodeMap.computeIfAbsent(node2, TreeNode::new);
            
            n1.children.add(n2);
            n2.children.add(n1);
        }
        
        // 임의로 루트 노드를 선택
        TreeNode root = nodeMap.get(1);
        
        // 서브트리 크기를 저장할 맵
        Map<TreeNode, Integer> subtreeSize = new HashMap<>();
        
        // 서브트리 크기 계산
        computeSubtreeSizes(root, new HashSet<>(), subtreeSize);
        
        // 각 노드의 서브트리 크기 출력
        printSubtreeSizes(root, subtreeSize);
        
        int mid = max / 2;
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int s : subTreeCnt) {
        	int temp = Math.abs(s - mid);
        	if (min > temp) {
        		min = temp;
        		result = s;
        	}
        }
        
        System.out.println("max " + max);
        System.out.println("result " + result);
        return Math.abs(max - result - result);
    }
    
    // 서브트리의 크기를 계산
    private static int computeSubtreeSizes(TreeNode node, Set<TreeNode> visited, Map<TreeNode, Integer> subtreeSize) {
        if (node == null || visited.contains(node)) return 0;
        visited.add(node);
        
        int size = 1; // 현재 노드 자신을 포함
        
        for (TreeNode child : node.children) {
            if (child != node.parent) { // 부모 노드는 제외
                child.parent = node; // 부모 설정
                size += computeSubtreeSizes(child, visited, subtreeSize);
            }
        }
        
        subtreeSize.put(node, size - 1); // 자신을 제외한 자식 노드의 개수 저장
        return size;
    }
    
    // 서브트리 크기 출력
    private static void printSubtreeSizes(TreeNode node, Map<TreeNode, Integer> subtreeSize) {
        if (node == null) return;
        
        System.out.println("Node " + node.value + " has " + subtreeSize.get(node) + " descendants.");
        subTreeCnt[node.value-1] = subtreeSize.get(node) + 1;
        if (max < subTreeCnt[node.value-1])
        	max = subTreeCnt[node.value-1];
        
        for (TreeNode child : node.children) {
            if (child != node.parent) {
                printSubtreeSizes(child, subtreeSize);
            }
        }
    }
}
