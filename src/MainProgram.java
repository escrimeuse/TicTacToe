/**
 * Tic Tac Toe Game
 * Author: Cathryn Griffiths
 *          cathryn.griffiths@gmail.com
 *          cathryn.dersam.net
 *
 * Description of program:
 *      This is a classic Tic Tac Toe game for two players.
 */

import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {

        // Variables
        //==========
        Scanner keyboard = new Scanner(System.in);
        String player1;
        String player2;
        int row=0;
        char column=' ';
        String playAgain=" ";

        // Welcome message
        //================
        System.out.println("*********************************************************");
        System.out.println("**                                                     **");
        System.out.println("**                     TIC TAC TOE                     **");
        System.out.println("**                                                     **");
        System.out.println("*********************************************************");
        System.out.println();
        System.out.println("Welcome to Cathryn's two player Tic-Tac-Toe game!");
        System.out.println();
        System.out.print("Player 1, what is your name? ");
        player1=keyboard.next();
        System.out.print("Player 2, what is your name? ");
        player2=keyboard.next();
        System.out.println();
        System.out.println(player1 + ", you will be playing as X.");
        System.out.println(player2 + ", you will be playing as O.");
        System.out.println();

        // Gameplay
        //===========
        do {

            TicTacToe game=new TicTacToe(); // create new TicTacToe board
            int turnNumber=1; // set to indicate that this is the first turn of the game

            do {
                game.displayBoard();
                System.out.println();

                if (turnNumber % 2 == 0) // if it is player2's turn
                {
                    System.out.print(player2 + ", where would you like to place 'O' (ex: A 2)? ");
                    column = keyboard.next().charAt(0);
                    row = keyboard.nextInt();

                    // Checks that keyboard input was correct
                    while (column != 'A' && column != 'B' && column != 'C' && column != 'a' && column != 'b' && column != 'c' || row != 1 && row != 2 && row != 3) {
                        System.out.println("**ERROR: Incorrect column and row entered.");
                        System.out.print(player2 + ", where would you like to place 'O' (ex: A 2)? ");
                        column = keyboard.next().charAt(0);
                        row = keyboard.nextInt();

                    }

                    // Checks if the space is already filled with an X or an O
                    while (game.checkSpaceIsTaken(row, column)) {
                        System.out.println("**ERROR: That space is taken.");
                        System.out.print(player2 + ", where would you like to place 'O'? ");
                        column = keyboard.next().charAt(0);
                        row = keyboard.nextInt();
                    }

                    // Put O in space
                    game.placeO(row, column);
                }
                else // player1's turn
                {
                    System.out.print(player1 + ", where would you like to place 'X' (ex: B 3)? ");
                    column = keyboard.next().charAt(0);
                    row = keyboard.nextInt();

                    // Checks if keyboard input is correct
                    while (column != 'A' && column != 'B' && column != 'C' && column != 'a' && column != 'b' && column != 'c' || row != 1 && row != 2 && row != 3) {
                        System.out.println("**ERROR: Incorrect column and row entered.");
                        System.out.print(player1 + ", where would you like to place 'X' (ex: B 3)? ");
                        column = keyboard.next().charAt(0);
                        row = keyboard.nextInt();
                    }

                    // Checks if space is already filled with an X or an O
                    while (game.checkSpaceIsTaken(row, column)) {
                        System.out.println("**ERROR: That space is taken.");
                        System.out.print(player1 + ", where would you like to place 'X'? ");
                        column = keyboard.next().charAt(0);
                        row = keyboard.nextInt();
                    }

                    // places an X in the space
                    game.placeX(row, column);
                }

                turnNumber++;

            } while (!game.winner() && turnNumber<=9); // continues to ask for player input as long as no winner is detected

            // Winner message
            // ==============
            System.out.println();
            game.displayBoard();
            System.out.println();
            if (game.winner())
                System.out.println("Congratulations " + ((turnNumber - 1) % 2 == 0 ? player2 : player1) + ", you won!!");
            else
                System.out.println(player1 + " and " + player2 + ", you have TIED! Nobody wins!");


            // Check if players want to play again
            //====================================
            System.out.println();
            System.out.print("Do you want to play again (YES or NO)? ");
            playAgain=keyboard.next();
            while (playAgain.equalsIgnoreCase("yes")==false && playAgain.equalsIgnoreCase("no")==false)
            {
                System.out.println("**ERROR: You did not enter YES or NO.");
                System.out.print("Do you want to play again (YES or NO)? ");
                playAgain=keyboard.next();
            }

        } while(playAgain.equalsIgnoreCase("yes"));

        // Exit message
        //=============
        System.out.println("Thank you for playing! Goodbye!");



    }
}
