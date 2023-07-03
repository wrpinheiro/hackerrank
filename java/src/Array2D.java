
public class Array2D {

    public static void main(String[] args) {
        int[][] arr = { 
                { 1, 1, 1, 0, 0, 0 }, 
                { 0, 1, 0, 0, 0, 0 }, 
                { 1, 1, 1, 0, 0, 0 }, 
                { 0, 0, 2, 4, 4, 0 },
                { 0, 0, 0, 2, 0, 0 }, 
                { 0, 0, 1, 2, 4, 0 } 
                };
        
        int maxHourglass = Integer.MIN_VALUE;
        int temp;
        
        for (int row = 0; row <= 3; row++) {
            for (int col = 0; col <= 3; col++) {
                temp = sumHourglass(arr, row, col);
                if (temp > maxHourglass) {
                    maxHourglass = temp;
                }
            }
        }
        System.out.println(maxHourglass);
    }

    private static int sumHourglass(int[][] a, int row, int col) {
        return a[row][col] + a[row][col + 1] + a[row][col + 2] +
                a[row + 1][col + 1] +
                a[row + 2][col] + a[row + 2][col + 1] + a[row + 2][col + 2];
    }
}
