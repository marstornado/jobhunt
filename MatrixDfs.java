import java.util.*;

/**
 * Created by marstornado on 15/10/27.
 */
public class MatrixDfs {

    public MatrixDfs() {

    }

    public static ArrayList<int[]> matrixDfs(int[][] matrix, int[] start, int[] end) {

        ArrayList<int[]> res = new ArrayList<int[]>();

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] table = new int[m][n];

        LinkedList<int[]> queue = new LinkedList<int[]>();
        queue.add(start);

        if(matrix[start[0]][start[1]] != -1) {
            table[start[0]][start[1]] = 1;
        }


        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int i = tmp[0];
            int j = tmp[1];

            if(i-1 >=0 && matrix[i-1][j] != -1 && table[i-1][j] == 0) {
                table[i-1][j] = table[i][j]+1;
                int[] tmp2 = new int[2];
                tmp2[0] = i-1;
                tmp2[1] = j;
                queue.add(tmp2);
            }
            if(j-1 >=0 && matrix[i][j-1] != -1 && table[i][j-1] == 0 ) {
                table[i][j-1] = table[i][j]+1;
                int[] tmp2 = new int[2];
                tmp2[0] = i;
                tmp2[1] = j-1;
                queue.add(tmp2);
            }
            if(i+1 < m && matrix[i+1][j] != -1 && table[i+1][j] == 0) {
                table[i+1][j] = table[i][j]+1;
                int[] tmp2 = new int[2];
                tmp2[0] = i+1;
                tmp2[1] = j;
                queue.add(tmp2);
            }
            if(j+1 < n && matrix[i][j+1]!=-1 && table[i][j+1] == 0) {
                table[i][j+1] = table[i][j]+1;
                int[] tmp2 = new int[2];
                tmp2[0] = i;
                tmp2[1] = j+1;
                queue.add(tmp2);

            }
        }

        if(table[end[0]][end[1]] < 1) {
            return res;
        }

        res.add(end);
        int i = end[0];
        int j = end[1];
        while(table[i][j] != 1) {
            int step = table[i][j];
            if(i-1 >=0 &&  table[i-1][j] == step - 1) {
                int[] tmp2 = new int[2];
                tmp2[0] = i-1;
                tmp2[1] = j;
                res.add(tmp2);
                i = i-1;
                continue;
            }
            if(j-1 >=0 && table[i][j-1] == step - 1 ) {

                int[] tmp2 = new int[2];
                tmp2[0] = i;
                tmp2[1] = j-1;
                res.add(tmp2);
                j = j-1;
                continue;
            }
            if(i+1 < m && table[i+1][j] == step - 1) {

                int[] tmp2 = new int[2];
                tmp2[0] = i+1;
                tmp2[1] = j;
                res.add(tmp2);
                i = i+1;
                continue;
            }
            if(j+1 < n && table[i][j+1] == step - 1) {

                int[] tmp2 = new int[2];
                tmp2[0] = i;
                tmp2[1] = j+1;
                res.add(tmp2);
                j = j+1;
                continue;

            }
        }


        return res;
    }


    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0, -1, 0}, {0, -1, 0, 0, 0}, {0, -1, -1, -1, 0}, {0,0,-1,0,0}, {0,0,-1,0,0}, {0,0,-1,0,0} };
        int[] start = {3, 1};
        int[] end = {1, 3};


        ArrayList<int[]> res = matrixDfs(matrix, start, end);

        for(int[] arr:res) {
            System.out.println(Integer.toString(arr[0]) + " " + Integer.toString(arr[1]));
        }
    }
}
