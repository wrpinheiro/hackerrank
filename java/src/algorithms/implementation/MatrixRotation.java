package algorithms.implementation;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class MatrixRotation {
    public static void main(String[] args) {
        int[][] matrix;
        
        Scanner sc = new Scanner(System.in);
        
        int m = sc.nextInt();
        int n = sc.nextInt();
        int r = sc.nextInt();
        
        matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        
        int rotations;
        
        for (int innerIdx = 0; innerIdx < Math.min(m, n) / 2; innerIdx++) {
            int minX = innerIdx;
            int minY = innerIdx;
            int maxX = matrix.length - innerIdx - 1;
            int maxY = matrix[0].length - innerIdx - 1;
            
            int maxRotations = (m - (2 * innerIdx)) * 2 + ((n - (2 * innerIdx)) - 2) * 2;
            rotations = r % maxRotations;

            while(rotations-- > 0) {

                int[] pos, prev = {minX, minY};
                
                int temp, current = matrix[minX][minY];

                do {
                    pos = shift(matrix, prev[0], prev[1], minX, minY, maxX, maxY);
                    temp = matrix[pos[0]][pos[1]];
                    matrix[pos[0]][pos[1]] = current;
                    current = temp;
                    prev = pos;
                } while (prev[0] != minX || prev[1] != minY);
            }
        }
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                ps.printf("%d ", matrix[i][j]);
                
            }
            ps.println();
        }
        
        System.out.println(baos.toString());

        ps.close();
        sc.close();
    }
    
    private static int[] shift(int[][] a, int x, int y, int minX, int minY, int maxX, int maxY) {
        int newX = 0, newY = 0;

        if (y == minY) {
            if (x < maxX) {
                newX = x + 1;
                newY = minY;
            } else {
                newX = maxX;
                newY = y + 1;
            }
        } else if (x == maxX) {
            if (y < maxY) {
                newX = maxX;
                newY = y + 1;
            } else {
                newX = x - 1;
                newY = maxY;
            }
        } else if (y == maxY) {
            if (x > minX) {
                newX = x -1;
                newY = maxY;
            } else {
                newX = minX;
                newY = y - 1;
            }
        } else if (x == minX) {
            if (y > minY) {
                newX = minX;
                newY = y - 1;
            }
        }
        
        return new int[] {newX, newY};
    }
}
