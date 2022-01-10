package com.bridgelabz;
import javax.swing.*;
import java.sql.SQLOutput;
import java.util.*;
public class Main {

    private static char[] Board = new char[10];
   // private static char playingSybmol;
    private static char player1,player2;
    private static int player1Play = 1;
    static Scanner sc = new Scanner(System.in);

    //UC 1 Method for initializing board position
    private static void initializeBoard() {
        for(int i=1; i<10; i++) {
            Board[i]=' ';
        }
    }
    private static void showBoard1() {
        for (int i = 1; i < 10; i++) {
            if ((i) % 3 == 0) {
                System.out.println(Board[i]);
                if (i != 10 - 1) {
                    System.out.println("-----");
                }
            } else {
                System.out.print(Board[i] + "|");
            }
        }    }
       //UC 2 Method
       public static void playerChoice()
       {

           System.out.println("Enter Player 1 choice (X / O) :");
           char choice=sc.next().toUpperCase().charAt(0);
           if(choice == 'X') {
               player1 = choice;
               player2 = 'O';
           } else if(choice == 'O') {
               player1 = choice;
               player2 = 'X';
           } else {
               System.out.println("Wrong Choice Entered.");
               playerChoice();
           }
       }
       //UC-3 Showing current board status
    public static void showBoard() {
        System.out.println(" ----------- ");
        System.out.println("| " + Board[1] + " | " + Board[2] + " | " + Board[3] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + Board[4] + " | " + Board[5] + " | " + Board[6] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + Board[7] + " | " + Board[8] + " | " + Board[9] + " |");
        System.out.println(" ----------- ");
    }
    //UC -4 Set player chance
    private static void getUserInput(int i) {
        System.out.println("Player "+ i +" Enter the Position for Your Symbol :");
        int position = sc.nextInt();
        if(i == 1) {
            Board[position] = player1;
        } else {
            Board[position] = player2;
        }
    }
    private static int flipToss() {
        Random toss = new Random();
        int tossValue = toss.nextInt(2)+1;
        return tossValue;
    }
    private static void gamePlay(int tossValue) {
        for(int i=1;i<10;i++) {
            if(i % 2 == 0) {
                if(tossValue == 2) {
                    getUserInput(1);
                } else {
                    getUserInput(2);
                }
            } else {
                getUserInput(tossValue);
            }
            showBoard();
        }
    }
    //UC 7 Check for Winner or Draw
    private static boolean checkWin() {
        if(checkDiagonal() || checkColumnWin() || checkRowWin()) {
            if(player1Play == 0) {
                System.out.println("Player 1 WON THE GAME !!!!");
            } else {
                System.out.println("Player 2 WON THE GAME !!!!");
            }
            showBoard();
            return true;
        } else {
                if(checkDraw()) {
                    System.out.println("The Game is DRAW. As there is no any location for Player Symbol.");
                    showBoard();
                    return true;
            }
        }
        return false;
    }

    //Method to check for Game Draw
    private static boolean checkDraw() {
        boolean flag = true;
        for(int i = 1; i <= 9; i++) {
            if(Board[i] == '_') {
                flag = false;
            }
        }
        return flag;
    }

    //Method to check for Diagonal Win
    private static boolean checkDiagonal() {
        if(!(Board[1] == '_') && Board[1] == Board[5] && Board[1] == Board[9]
                || !(Board[3] == '_') && Board[3] == Board[5] && Board[3] == Board[7]) {
            return true;
        }
        return false;
    }

    //Method to Check for Row Win
    private static boolean checkRowWin() {
        for( int i = 1; i < Board.length; i += 3) {
            if(!(Board[i] == '_') && Board[i] == Board[i+1] && Board[i] == Board[i+2]) {
                return true;
            }
        }
        return false;
    }

    //Method to Check for Column Win
    private static boolean checkColumnWin() {
        for(int i = 1; i <= 3; i++) {
            if(!(Board[i] == '_') && Board[i] == Board[i+3] && Board[i] == Board[i+6]) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe Game Simulator.");
        char userChoice;
        do {
        initializeBoard();
        playerChoice();
        showBoard1();
        int tossValue = flipToss();
        gamePlay(tossValue);
        checkWin();

        System.out.println("Do you want to continue.");
        userChoice = sc.next().toUpperCase().charAt(0);
    }
        while(userChoice == 'Y');


    }
}



