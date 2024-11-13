import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] inorder, postorder, idxInorder;
    static StringBuilder preorderResult = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        inorder = new int[n];
        postorder = new int[n];
        idxInorder = new int[n + 1]; // 1부터 시작

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            idxInorder[inorder[i]] = i; // 노드의 번호에 해당하는 idxInorder 인덱스에 inorder 인덱스 저장
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        // 프리오더 찾아서 출력
        findPreorder(0, n-1, 0, n-1);
        System.out.println(preorderResult.toString());
    }

    static void findPreorder(int inStart, int inEnd, int postStart, int postEnd) {
        if(inStart > inEnd || postStart > postEnd) return; // base case (재귀 종료 조건)

        int root = postorder[postEnd]; // postorder에서 마지막 값이 현재의 루트
        preorderResult.append(root).append(" ");

        int rootIdx = idxInorder[root];
        int leftSize = rootIdx - inStart; // 왼쪽 서브트리 크기

        // 왼쪽 서브트리 탐색
        findPreorder(inStart, rootIdx - 1, postStart, postStart + leftSize - 1);

        // 오른쪽 서브트리 탐색
        findPreorder(rootIdx + 1, inEnd, postStart + leftSize, postEnd - 1);
    }
}
