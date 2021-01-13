// ----------------------------------------------------------------
//                         ticTacToe.java
// ----------------------------------------------------------------
//File: ticTacToe
//Name: Gabriel Lasut



import java.util.Random;
import java.util.Scanner;

public class ticTacToe {
    static class Pos
    {
        int row, col;
    };
    public static char opponent = 'O', player = 'X';


    public static void main(String[] args) {
        char[][] tictactoeBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        Scanner scan = new Scanner(System.in);
        int[] array = new int[9];
        int nextIndex = 0;

        while(true) {

            int pos = scan.nextInt();
            nextIndex++;
            placePiece(tictactoeBoard, pos, "Player");
            if ( nextIndex >= 9 ) {
                printGameBoard(tictactoeBoard);
                endGame(tictactoeBoard);
                System.out.println("No Winner!");
                System.exit(0);
            }
            Pos bestMove = findBestMove(tictactoeBoard);
            tictactoeBoard[bestMove.row][bestMove.col] = 'O';
            nextIndex++;
            printGameBoard(tictactoeBoard);
            endGame(tictactoeBoard);

        }
    }
/*
  The method printGameBoard will print the array gameBoard along with the X and 0
 */

    public static void printGameBoard(char[][] tictactoeBoard) {
        for (char[] row : tictactoeBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }

    }
/*
   The method placePieve will fill in the GameBoard array with the pos that is slected, numbers 1-9
 */


    public static void placePiece(char[][] tictactoeBoard, int pos, String user) {

        char symbol = ' ';
        if (user.equals("Player")) {
            symbol = 'X';
        } else if (user.equals("cpu")) {
            symbol = '0';
        }


        switch (pos) {
            case 1:
                tictactoeBoard[0][0] = symbol;
                break;
            case 2:
                tictactoeBoard[0][2] = symbol;
                break;
            case 3:
                tictactoeBoard[0][4] = symbol;
                break;
            case 4:
                tictactoeBoard[2][0] = symbol;
                break;
            case 5:
                tictactoeBoard[2][2] = symbol;
                break;
            case 6:
                tictactoeBoard[2][4] = symbol;
                break;
            case 7:
                tictactoeBoard[4][0] = symbol;
                break;
            case 8:
                tictactoeBoard[4][2] = symbol;
                break;
            case 9:
                tictactoeBoard[4][4] = symbol;
                break;
            default:
                break;

        }





    }



/*
   The method endGame will check the who won
 */
   //check for player win , that means take out the cpu checker
    public static void endGame(char[][] tictactoeBoard) {

        String comparerowx = "XXX";
        String comparerowo = "OOO";
        String appendRowOne = "";
        String appendColumOne= "";
        String appendRowTwo = "";
        String appendColumTwo = "";
        String appendRowThree = "";
        String appendColumThree = "";
        String appendDashOne = "";
        String appendDashTwo = "";

        appendRowOne += tictactoeBoard[0][0];
        appendRowOne += tictactoeBoard[0][2];
        appendRowOne += tictactoeBoard[0][4];
        if (appendRowOne.equals(comparerowx)) {
            System.out.println("Player wins");
            System.exit(0);
        } else if (appendRowOne.equals(comparerowo)) {
            System.out.println("CPU wins");
            System.exit(0);
        }
        appendRowTwo += tictactoeBoard[2][0];
        appendRowTwo += tictactoeBoard[2][2];
        appendRowTwo += tictactoeBoard[2][4];
        if (appendRowTwo.equals(comparerowx)) {
            System.out.println("Player wins");
            System.exit(0);
        } else if (appendRowTwo.equals(comparerowo)) {
            System.out.println("CPU wins");
            System.exit(0);
        }

        appendRowThree += tictactoeBoard[4][0];
        appendRowThree += tictactoeBoard[4][2];
        appendRowThree += tictactoeBoard[4][4];

        if (appendRowThree.equals(comparerowx)) {
            System.out.println("Player wins");
            System.exit(0);
        } else if (appendRowThree.equals(comparerowo)) {
            System.out.println("CPU wins");
            System.exit(0);
        }
        appendColumOne += tictactoeBoard[0][0];
        appendColumOne += tictactoeBoard[2][0];
        appendColumOne += tictactoeBoard[4][0];

        if (appendColumOne.equals(comparerowx)) {
            System.out.println("Player wins");
            System.exit(0);
        } else if (appendColumOne.equals(comparerowo)) {
            System.out.println("CPU wins");
            System.exit(0);
        }
        appendColumTwo += tictactoeBoard[0][2];
        appendColumTwo += tictactoeBoard[2][2];
        appendColumTwo +=  tictactoeBoard[4][2];

        if (appendColumTwo.equals(comparerowx)) {
            System.out.println("Player wins");
            System.exit(0);
        } else if (appendColumTwo.equals(comparerowo)) {
            System.out.println("CPU wins");
            System.exit(0);
        }
        appendColumThree += tictactoeBoard[0][4];
        appendColumThree += tictactoeBoard[2][4];
        appendColumThree += tictactoeBoard[4][4];

        if (appendColumThree.equals(comparerowx)) {
            System.out.println("Player wins");
            System.exit(0);
        } else if (appendColumThree.equals(comparerowo)) {
            System.out.println("CPU wins");
            System.exit(0);
        }
        appendDashOne += tictactoeBoard[0][0];
        appendDashOne += tictactoeBoard[2][2];
        appendDashOne += tictactoeBoard[4][4];   // different fromappendDashOne += gameBoard[0][0]

        if (appendDashOne.equals(comparerowx)) {
            System.out.println("Player wins");
            System.exit(0);
        } else if (appendDashOne.equals(comparerowo)) {
            System.out.println("CPU wins");
            System.exit(0);
        }


        appendDashTwo +=  tictactoeBoard[0][4];
        appendDashTwo +=  tictactoeBoard[2][2];
        appendDashTwo +=  tictactoeBoard[4][0];   // different fromappendDashOne += gameBoard[0][0]

        if (appendDashTwo.equals(comparerowx)) {
            System.out.println("Player wins");
            System.exit(0);
        } else if (appendDashTwo.equals(comparerowo)) {
            System.out.println("CPU wins");
            System.exit(0);
        }


    }










  public   static Boolean isMovesLeft(char  tictactoeBoard[][])
    {
        for (int i = 0; i < 5; i+=2)
            for (int j = 0; j < 5; j+=2)
                if ( tictactoeBoard[i][j] == ' ')
                    return true;
        return false;
    }


// This function returns true if there are moves
// remaining on the board. It returns false if
// there are no moves left to play.

// This is the evaluation function as discussed
// in the previous article ( http://goo.gl/sJgv68 )
public static int algoScreener( char[][] gb ) {
    // Checking for Rows for X or O victory.
    for (int row = 0; row < 5; row += 2) {
        if (gb[row][0] == gb[row][2] &&
                gb[row][2] == gb[row][4]) {
            if (gb[row][0] == opponent)
                return 10;
            else if (gb[row][0] == player)
                return -10;
        }
    }

        // Checking for Columns for X or O victory.
        for (int col = 0; col < 5; col += 2) {
            if (gb[0][col] == gb[2][col] &&
                    gb[2][col] == gb[4][col]) {
                if (gb[0][col] == opponent)
                    return 10;

                else if (gb[0][col] == player)
                    return -10;
            }
        }

            // Checking for Diagonals for X or O victory.
            if (gb[0][0] == gb[2][2] && gb[2][2] == gb[4][4]) {
                if (gb[0][0] == opponent)
                    return 10;
                else if (gb[0][0] == player)
                    return -10;
            }

            if (gb[0][4] == gb[2][2] && gb[2][2] == gb[4][0]) {
                if (gb[0][4] == opponent)
                    return 10;
                else if (gb[0][4] == player)
                    return -10;
            }

            // Else if none of them have won then return 0
            return 0;


}

// This is the minimax function. It considers all
// the possible ways the game can go and returns
// the value of the board
    public static int algo( char  tictactoeBoard[][], int depth, boolean isMax)
    {
        int score = algoScreener(tictactoeBoard);

        // If Maximizer has won the game
        // return his/her evaluated score
        if (score == 10)
            return score;

        // If Minimizer has won the game
        // return his/her evaluated score
        if (score == -10)
            return score;

        // If there are no more moves and
        // no winner then it is a tie
        if (isMovesLeft( tictactoeBoard) == false)
            return 0;

        // If this maximizer's move
        if (isMax) {
            int best = -1000;

            // Traverse all cells
            for (int i = 0; i < 5; i += 2) {
                for (int j = 0; j < 5; j += 2) {
                    // Check if cell is empty
                    if ( tictactoeBoard[i][j] == ' ') {
                        // Make the move
                        tictactoeBoard[i][j] = opponent;

                        // Call minimax recursively and choose
                        // the maximum value
                        best = Math.max(best, algo( tictactoeBoard, depth + 1, !isMax));

                        // Undo the move
                        tictactoeBoard[i][j] = ' ';
                    }
                }
            }
            return best;
        }

        // If this minimizer's move
        else {
            int best = 1000;

            // Traverse all cells
            for (int i = 0; i < 5; i += 2) {
                for (int j = 0; j < 5; j += 2) {
                    // Check if cell is empty
                    if ( tictactoeBoard[i][j] == ' ') {
                        // Make the move
                        tictactoeBoard[i][j] = player;

                        // Call minimax recursively and choose
                        // the minimum value
                        best = Math.min(best, algo( tictactoeBoard, depth + 1, !isMax));

                        // Undo the move
                        tictactoeBoard[i][j] = ' ';
                    }
                }
            }
            return best;
        }
    }


// This will return the best possible
// move for the player
    public static Pos findBestMove ( char tictactoeBoard[][])
    {
        int bestVal = -1000;
        Pos moveSelect = new Pos();
        moveSelect.row = -1;
        moveSelect.col = -1;

        // Traverse all cells, evaluate minimax function
        // for all empty cells. And return the cell
        // with optimal value.
        for (int i = 0; i < 5; i += 2) {
            for (int j = 0; j < 5; j += 2) {
                // Check if cell is empty
                if ( tictactoeBoard[i][j] == ' ') {
                    // Make the move
                    tictactoeBoard[i][j] = opponent;

                    // compute evaluation function for this
                    // move.
                    int moveVal = algo(tictactoeBoard, 0, false);

                    // Undo the move
                    tictactoeBoard[i][j] = ' ';

                    // If the value of the current move is
                    // more than the best value, then update
                    // best/
                    if (moveVal > bestVal) {
                        moveSelect.row = i;
                        moveSelect.col = j;
                        bestVal = moveVal;
                    }
                }
            }
        }


        return moveSelect;
    }
}


