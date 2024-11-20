import java.util.*;

class Solution {
    static final int SIZE = 51;
    static int[][] parent;
    static String[][] table;

    public static String[] solution(String[] commands) {
        List<String> result = new ArrayList<>();
        parent = new int[SIZE][SIZE];
        table = new String[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                parent[i][j] = i * SIZE + j;
                table[i][j] = null;
            }
        }

        for (String command : commands) {
            String[] tokens = command.split(" ");
            switch (tokens[0]) {
                case "UPDATE":
                    if (tokens.length == 4) {
                        int r = Integer.parseInt(tokens[1]);
                        int c = Integer.parseInt(tokens[2]);
                        String value = tokens[3];
                        update(r, c, value);
                    } else {
                        String oldValue = tokens[1];
                        String newValue = tokens[2];
                        updateAll(oldValue, newValue);
                    }
                    break;
                case "MERGE":
                    int r1 = Integer.parseInt(tokens[1]);
                    int c1 = Integer.parseInt(tokens[2]);
                    int r2 = Integer.parseInt(tokens[3]);
                    int c2 = Integer.parseInt(tokens[4]);
                    merge(r1, c1, r2, c2);
                    break;
                case "UNMERGE":
                    int r = Integer.parseInt(tokens[1]);
                    int c = Integer.parseInt(tokens[2]);
                    unmerge(r, c);
                    break;
                case "PRINT":
                    int rPrint = Integer.parseInt(tokens[1]);
                    int cPrint = Integer.parseInt(tokens[2]);
                    result.add(print(rPrint, cPrint));
                    break;
            }
        }

        return result.toArray(new String[0]);
    }

    public static int find(int r, int c) {
        int id = r * SIZE + c;
        if (parent[r][c] != id) {
            int pr = parent[r][c] / SIZE;
            int pc = parent[r][c] % SIZE;
            parent[r][c] = find(pr, pc);
        }
        return parent[r][c];
    }

    public static void update(int r, int c, String value) {
        int root = find(r, c);
        int rr = root / SIZE, rc = root % SIZE;
        table[rr][rc] = value;
    }

    public static void updateAll(String oldValue, String newValue) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (table[i][j] != null && table[i][j].equals(oldValue)) {
                    table[i][j] = newValue;
                }
            }
        }
    }

    public static void merge(int r1, int c1, int r2, int c2) {
        int root1 = find(r1, c1);
        int root2 = find(r2, c2);

        if (root1 != root2) {
            int rr1 = root1 / SIZE, rc1 = root1 % SIZE;
            int rr2 = root2 / SIZE, rc2 = root2 % SIZE;

            // root1의 값을 우선시
            if (table[rr1][rc1] == null && table[rr2][rc2] != null) {
                table[rr1][rc1] = table[rr2][rc2];
            }

            // root2의 모든 노드를 root1으로 갱신
            updateParent(root2, root1);
        }
    }

    public static void unmerge(int r, int c) {
        int root = find(r, c);
        int rr = root / SIZE, rc = root % SIZE;
        String value = table[rr][rc];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (find(i, j) == root) {
                    parent[i][j] = i * SIZE + j;
                    table[i][j] = null;
                }
            }
        }

        table[r][c] = value;
    }

    public static void updateParent(int oldRoot, int newRoot) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (find(i, j) == oldRoot) {
                    parent[i][j] = newRoot;
                }
            }
        }
    }

    public static String print(int r, int c) {
        int root = find(r, c);
        int rr = root / SIZE, rc = root % SIZE;
        return table[rr][rc] == null ? "EMPTY" : table[rr][rc];
    }
}
