package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("--------Welcome To TicTacToe Game----------");
        Scanner sc=new Scanner(System.in);
        boolean continueGame=true;
        String continueGameString;
        while (continueGame) {
            System.out.print("Enter Size : ");
            String size = sc.nextLine();
            if (Integer.parseInt(size)!=3){
                System.out.println("Currently game is supported for size 3!!!"); 
            }
            else {
                System.out.println();
                System.out.print("Enter player names : ");
                String playerName = sc.nextLine();
                Game game = new Game(Arrays.asList(playerName.split(" ")), Integer.parseInt(size));
                game.startGame();
            }
            System.out.print("One more round: y/Y[YES], n/N[NO] ");
            continueGameString= sc.nextLine();
            if(continueGameString.equalsIgnoreCase("n")){
                continueGame=false;
            }
        }
        System.out.println("-----------Game Finished-------------");
    }
}