package com.bridgelabz;
import java.util.*;
public class Main {

    private static char[] Board = new char[10];
    private static char playingSybmol;

    //UC 1 Method for initializing board position
    private static void initializeBoard() {
        for(int i=1; i<10; i++) {
            Board[i]=' ';
        }
    }
    private static void showBoard() {
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
       private static void setPlayingSymbol() {
           while(playingSybmol != 'X' && playingSybmol != 'O') {
               System.out.println("Please Select the Symbol for Play: X or O");
               //Scanner Method for User Input
               Scanner sc = new Scanner(System.in);
               playingSybmol = sc.next().charAt(0);
               switch (playingSybmol) {
                   case 'X':
                       System.out.println("Player Selected " + playingSybmol + " Symbol");
                       break;
                   case 'O':
                       System.out.println("Player Selected " + playingSybmol + " Symbol");
                       break;
                   default:
                       System.out.println("Please Select the Symbol From X or O only");
                       break;
               }
           }
       }
    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe Game Simulator.");

        initializeBoard();
        setPlayingSymbol();
    }
}
