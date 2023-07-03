import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class KnightsTour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        int[][] board = new int[M][N];

        int blocked = sc.nextInt();
        while (blocked-- > 0) {
            int bx = sc.nextInt();
            int by = sc.nextInt();

            board[bx][by] = -1;
        }

        tour(board, 0, 0, 1);
        
//        for (int i = 0; i < M; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(board[i][j] + "\t");
//            }
//            System.out.println();
//        }

        extractTour(board);

        sc.close();
    }

    private static void extractTour(int[][] board) {
        int maxX = 0, maxY = 0;
        int current = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    System.out.println("No");
                    return;
                }

                if (board[i][j] > current) {
                    current = board[i][j];
                    maxX = i;
                    maxY = j;
                }
            }
        }

        List<String> steps = new LinkedList<String>();

        while (current > 0) {
            steps.add(0, "" + maxX + " " + maxY);

            current--;
            
            int[][] positions = positions(maxX, maxY);
            for (int i = 0; i < positions.length; i++) {
                if (validPositions(board, positions[i][0], positions[i][1]) && board[positions[i][0]][positions[i][1]] == current) {
                    maxX = positions[i][0];
                    maxY = positions[i][1];
                }
            }
        }
        
        for (String s : steps) {
            System.out.println(s);
        }
    }
    
    private static final boolean validPositions(int[][] board, int x, int y) {
        if (x < 0 || y < 0)
            return false;
        if (x > board.length - 1 || y > board[0].length - 1)
            return false;
        
        return true;
    }
    
    private static final int[][] positions(int x, int y) {
        List<int[]> positions = new LinkedList<>();
        
        positions.add(new int[] {x + 1, y + 2});
        positions.add(new int[] {x + 2, y + 1});
        positions.add(new int[] {x - 1, y - 2});
        positions.add(new int[] {x - 2, y - 1});
        positions.add(new int[] {x - 2, y - 1});
        positions.add(new int[] {x + 1, y - 2});
        positions.add(new int[] {x + 2, y - 1});
        positions.add(new int[] {x - 1, y + 2});
        positions.add(new int[] {x - 2, y + 1});
        
        

        return positions.toArray(new int[0][0]);
    }

    private static void tour(int[][] board, int x, int y, int position) {
        if (x < 0 || y < 0)
            return;
        if (x > board.length - 1 || y > board[0].length - 1)
            return;
        if (board[x][y] != 0)
            return;

        board[x][y] = position;
        tour(board, x + 1, y + 2, position + 1);
        tour(board, x + 2, y + 1, position + 1);
        tour(board, x - 1, y - 2, position + 1);
        tour(board, x - 2, y - 1, position + 1);
        tour(board, x + 1, y - 2, position + 1);
        tour(board, x + 2, y - 1, position + 1);
        tour(board, x - 1, y + 2, position + 1);
        tour(board, x - 2, y + 1, position + 1);
    }
}
