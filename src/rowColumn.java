import java.util.Arrays;

public class rowColumn {
    int[][] filed;

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int min = 0;
        int[][] filed = insertFiled(rows, columns);

        for (int i = 0; i < queries.length; i++) {
            answer[i] = spin(queries[i]);
        }

        return answer;
    }

    public int[][] insertFiled(int rows, int columns) {
        this.filed = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                filed[i][j] = i * columns + j + 1;
            }
        }
        return filed;
    }

    private int spin(int[] query) {
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;

        int tmp = this.filed[x1][y1];
        int min = tmp;
        int count = 0;

        for (int i = x1; i < x2; i++) {
            count++;
            this.filed[i][y1] = this.filed[i + 1][y1];
            if (min > this.filed[i][y1]) {
                min = this.filed[i][y1];
            }
        }

        count = 0;
        for (int i = y1; i < y2; i++) {
            count++;
            this.filed[x2][i] = this.filed[x2][i + 1];
            if (min > this.filed[x2][i]) {
                min = this.filed[x2][i];
            }
        }

        count = 0;
        for (int i = x2; i > x1; i--) {
            count++;
            this.filed[i][y2] = this.filed[i - 1][y2];
            if (min > this.filed[i][y2]) {
                min = this.filed[i][y2];
            }
        }

        count = 0;
        for (int i = y2; i > y1 + 1; i--) {
            count++;
            this.filed[x1][i] = this.filed[x1][i - 1];
            if (min > this.filed[x1][i]) {
                min = this.filed[x1][i];
            }
        }

        this.filed[x1][y1 + 1] = tmp;
        if (min > this.filed[x1][y1 + 1]) {
            min = this.filed[x1][y1];
        }
        return min;
    }

    public static void main(String[] args) {
        rowColumn rowColumn = new rowColumn();
        System.out.println(Arrays.toString(rowColumn.solution(6, 6,
                new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}})));
        System.out.println(Arrays.toString(rowColumn.solution(3, 3,
                new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}})));
        System.out.println(Arrays.toString(rowColumn.solution(100, 97,
                new int[][]{{1, 1, 100, 97}})));
    }

}
