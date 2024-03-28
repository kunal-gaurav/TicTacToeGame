package org.example;

import java.util.*;

public class Game {

    Deque<Player> players;
    GameBoard board;

    public Game(List<String> playersList, int size) {
        players=new LinkedList<>();
        Player player1=new Player(playersList.get(0), new PlayingPiece(PlayingSymbol.O));
        Player player2=new Player(playersList.get(1), new PlayingPiece(PlayingSymbol.X));
        this.players.add(player1);
        this.players.add(player2);
        board=new GameBoard(size);
    }

    public void startGame(){
        System.out.println("------------Round Started-----------");
        boolean isAnyWinner=false;
        Scanner sc=new Scanner(System.in);
        String input;
        while (!isAnyWinner){
            Player currPlayer = players.pollFirst();
            board.printBoard();
            List<List<Integer>> freeCells = board.getFreeCells();
            if(freeCells.isEmpty()){
                System.out.println("Round Finished : NO WINNER!!!");
                return;
            }
            System.out.println(currPlayer.playerName + " turns:");
            System.out.print("Enter row and column: ");
            input = sc.nextLine();
            String[] inputArray = input.split(" ");
            int row=Integer.parseInt(inputArray[0]);
            int column=Integer.parseInt(inputArray[1]);

            boolean isPieceInserted = board.insertSymbol(row, column, currPlayer.playingPiece);
            if (!isPieceInserted){
                System.out.println("Invalid Cell!!!");
                players.addFirst(currPlayer);
                continue;
            }
            if(board.isWinner(row, column, currPlayer.playingPiece)){
                System.out.println("Round Finished : " + currPlayer.playerName + " Is Winner!!!");
                board.printBoard();
                isAnyWinner=true;
            }
            players.addLast(currPlayer);
        }
    }
}
