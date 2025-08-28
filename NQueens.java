package Projects.N_Queens;
import java.util.Scanner;
public class NQueens {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Enter the size of the board if it's a 4x4 then enter 4.
        System.out.print("Enter board size: ");
        int n = scanner.nextInt();
        boolean[][] board = new boolean[n][n];
        System.out.println(queens(board, 0));

        System.out.println(find(0, board));
    }


    static int queens(boolean[][] board, int row) {
        if (board.length == row) {
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += queens(board, row + 1);
                board[row][col] = false;
            }
        }
        return count;
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        //checking vertically
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // checking diagonal left
        int maxLeft = Math.min(row, col);
        for (int i = 0; i <= maxLeft; i++) {
            if (board[row - i][col - i]) return false;
        }

        //checking diagonal right
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 0; i <= maxRight; i++) {
            if (board[row - i][col + i]) return false;
        }
        return true;

    }

    static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("Q ");
                } else {
                    System.out.print("x ");
                }
            }
            System.out.println();
        }
    }


    static int find(int n, boolean[][] mat) {
        if (mat.length == n) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            if (isSafee(mat, n, i)) {
                mat[n][i] = true;
                count += find(n + 1, mat);
                mat[n][i] = false;
            }
        }
        return count;
    }

    static boolean isSafee(boolean[][] mat, int row, int col) {
        //checking vertically
        for (int i = 0; i < row; i++) {
            if (mat[i][col]) return false;
        }

        //cheking diagonal left
        int minLeft = Math.min(row, col);
        for (int i = 0; i <= minLeft; i++) {
            if (mat[row - i][col - i]) return false;
        }

        //checking diagonal right
        int minRight = Math.min(row, mat.length - col - 1);
        for (int i = 0; i <= minRight; i++) {
            if (mat[row - i][col + i]) return false;
        }

        return true;
    }

}
