import java.util.*;
class Solution {
    static class Node{
        public int value;
        public int x;
        public int y;
        public Node right;
        public Node left;

        public Node(int value, int x, int y, Node right, Node left) {
            this.value = value;
            this.x = x;
            this.y = y;
            this.right = right;
            this.left = left;
        }
    }

    static int index;
    static int[][] answer;

    public static int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];
        Node[] node = new Node[nodeinfo.length];

        for(int i = 0; i < nodeinfo.length; i++){
            node[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1], null, null);
        }

        Arrays.sort(node, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.y == o2.y){
                    return o1.x - o2.x;
                } else {
                    return o2.y - o1.y;
                }
            }
        });

        Node root = node[0];
        for(int i = 1; i < nodeinfo.length; i++){
            makeTree(root, node[i]);
        }

        index = 0;
        preorder(root);
        index = 0;
        postorder(root);
        return answer;
    }

    public static void makeTree(Node parent, Node child){
        if(parent.x > child.x){
            if(parent.left == null){
                parent.left = child;
            } else {
                makeTree(parent.left, child);
            }
        } else {
            if(parent.right == null){
                parent.right = child;
            } else {
                makeTree(parent.right, child);
            }
        }
    }

    public static void preorder(Node root){
        if(root != null){
            answer[0][index++] = root.value;
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void postorder(Node root){
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            answer[1][index++] = root.value;
        }
    }
}