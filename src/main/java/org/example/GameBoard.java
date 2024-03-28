package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameBoard {

    int size;

    PlayingPiece[][] board;

    public GameBoard(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public boolean insertSymbol(int row, int column, PlayingPiece piece){
        if(row<0 || column<0 || row>=size || column>=size){
            return false;
        }
        if(null!=board[row][column]){
            return false;
        }
        board[row][column] = piece;
        return true;
    }

    public List<List<Integer>> getFreeCells(){
        List<List<Integer>> freeCells=new ArrayList<>();
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(null == board[i][j]){
                    freeCells.add(Arrays.asList(i, j));
                }
            }
        }
        return freeCells;
    }

    public void printBoard(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(null!=board[i][j]){
                    System.out.print(" "+ board[i][j].symbol.toString() + " ");
                }
                else {
                    System.out.print("   ");
                }
                System.out.print("|");
            }
            System.out.println();
            System.out.println("____________");
        }
    }

    public boolean isWinner(int row, int column, PlayingPiece piece){
        boolean isRowMatch=true;
        boolean isCoulmnMatch=true;
        boolean isDiagonalMatch=true;
        boolean isAntiDiagonalMatch=true;

        for(int i=0; i<size; i++){
            if(null==board[row][i] || !board[row][i].equals(piece)){
                isRowMatch=false;
            }
        }

        for(int i=0; i<size; i++){
            if(null==board[i][column] || !board[i][column].equals(piece)){
                isCoulmnMatch=false;
            }
        }

        for(int i=0,j=0; i<size && j<size; i++,j++){
            if(null==board[i][j] || !board[i][j].equals(piece)){
                isDiagonalMatch=false;
            }
        }

        for(int i=size-1,j=0; i>=0 && j<size; i--,j++ ){
            if(board[i][j]==null || !board[i][j].equals(piece)){
                isAntiDiagonalMatch=false;
            }
        }

        return isRowMatch || isCoulmnMatch || isDiagonalMatch || isAntiDiagonalMatch;
    }
}
