/**
 * Tic Tac Toe Class
 * Author: Cathryn Griffiths
 *          cathryn.griffiths@gmail.com
 *          cathryn.dersam.net
 *
 * Description of class:
 *      This class is used by MainProgram.java.
 *      It has one attribute: a tic tac toe board.
 *      It has a constructor to fill the board with blank spaces.
 *      It also has a method for placing an X and a Y in te board, for checking for a win, to display the board,
 *      and to check if a space has already been filled with an X or an O.
 */
public class TicTacToe {

    // Attributes
    //===========
    char[][] board = new char[3][3]; // tic tac toe board

    // Methods
    //========
    public TicTacToe()  // constructor, sets the board with blank spaces
    {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void placeX(int row, char column) // places an X on the board in the specified location
    {
        int col=0;

        switch(column) {
            case 'A':
            case 'a':
                col = 0;
                break;
            case 'b':
            case 'B':
                col=1;
                break;
            case 'c':
            case 'C':
                col=2;
                break;
        }


        board[row-1][col] = 'X';
    }

    public void placeO(int row, char column)  // places an O on the board in the specific location
    {
        int col=0;

        switch(column) {
            case 'a':
            case 'A':
                col = 0;
                break;
            case 'B':
            case 'b':
                col=1;
                break;
            case 'C':
            case 'c':
                col=2;
                break;
        }


        board[row-1][col] = 'O';
    }

    public void displayBoard() // displays the board to the screen
    {
        System.out.println("\tA\t\tB\t\tC");
        System.out.println("\t\t|\t\t|");
        System.out.println("1\t" + board[0][0]+ "\t|\t" + board[0][1]+ "\t|\t" + board[0][2]);
        System.out.println("\t\t|\t\t|");
        System.out.println("  ----------------------");
        System.out.println("\t\t|\t\t|");
        System.out.println("2\t" + board[1][0]+ "\t|\t" + board[1][1]+ "\t|\t" + board[1][2]);
        System.out.println("\t\t|\t\t|");
        System.out.println("  ----------------------");
        System.out.println("\t\t|\t\t|");
        System.out.println("3\t" + board[2][0]+ "\t|\t" + board[2][1]+ "\t|\t" + board[2][2]);
        System.out.println("\t\t|\t\t|");

    }

    public boolean winner() // checks if any winning conditions are met
    {
        // check rows for win
        if (board[0][0]=='X' && board[0][1]=='X' && board[0][2]=='X' || board[0][0]=='O' && board[0][1]=='O' && board[0][2]=='O')
            return true;
        else if (board[1][0]=='X' && board[1][1]=='X' && board[1][2]=='X' || board[1][0]=='O' && board[1][1]=='O' && board[1][2]=='O')
            return true;
        else if (board[2][0]=='X' && board[2][1]=='X' && board[2][2]=='X' || board[2][0]=='O' && board[2][1]=='O' && board[2][2]=='O')
            return true;
        // check columns for win
        else if (board[0][0]=='X' && board[1][0]=='X' && board[2][0]=='X' || board[0][0]=='O' && board[1][0]=='O' && board[2][0]=='O')
            return true;
        else if (board[0][1]=='X' && board[1][1]=='X' && board[2][1]=='X' || board[0][1]=='O' && board[1][1]=='O' && board[2][1]=='O')
            return true;
        else if (board[0][2]=='X' && board[1][2]=='X' && board[2][2]=='X' || board[0][2]=='O' && board[1][2]=='O' && board[2][2]=='O')
            return true;
        // check diagonals
        else if (board[0][0]=='X' && board[1][1]=='X' && board[2][2]=='X' || board[0][0]=='O' && board[1][1]=='O' && board[2][2]=='O')
            return true;
        else if (board[0][2]=='X' && board[1][1]=='X' && board[2][0]=='X' || board[0][2]=='O' && board[1][1]=='O' && board[2][0]=='O')
            return true;
        else
            return false;
    }

    public boolean checkSpaceIsTaken(int row, char column) // checks if a space is filled with an X or an O
    {
        int col=0;

        switch(column) {
            case 'A':
            case 'a':
                col = 0;
                break;
            case 'b':
            case 'B':
                col=1;
                break;
            case 'c':
            case 'C':
                col=2;
                break;
        }


        if (board[row-1][col] =='X' || board[row-1][col]=='O')
            return true;
        else
            return false;
    }

}