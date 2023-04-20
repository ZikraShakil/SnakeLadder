package com.example.snakeladder;

import javafx.util.Pair;

import java.util.ArrayList;

public class Board {

    public ArrayList<Pair<Integer,Integer>> posCord ;

    public ArrayList<Integer> map;

    public Board(){
        posCord = new ArrayList<>();
        populateBoard();
        map = new ArrayList<>();
        populateMap();

    }



    public void populateBoard(){
        posCord.add(new Pair<>(0,0));

        for (int i = 0; i < SnakeLadder.height ; i++) {
            for (int j = 0; j < SnakeLadder.width ; j++) {
//              xcord
                int xCord = 0;
                if( i % 2 == 0){
                    xCord = j*SnakeLadder.tileSize + SnakeLadder.tileSize/2;
                }else{
                    xCord = SnakeLadder.height*SnakeLadder.tileSize - j*SnakeLadder.tileSize - SnakeLadder.tileSize/2;
                }
//              ycord
                int yCord = SnakeLadder.height*SnakeLadder.tileSize - i*SnakeLadder.tileSize - SnakeLadder.tileSize/2;
                posCord.add(new Pair<>(xCord,yCord));
            }

        }
    }

    int getXCoordinate(int position) {
        if (position >= 1 && position <= 100){
            return posCord.get(position).getKey();
    }
        return -1;
    }

    int getYCoordinate(int position) {
        if (position >= 1 && position <= 100) {
            return posCord.get(position).getValue();
        }
        return -1;

    }
    private void populateMap(){

        for (int i = 0; i < 101; i++) {
            map.add(i);
        }

        map.set(4,25);
        map.set(13,46);
        map.set(27,5);
        map.set(33,49);
        map.set(40,3);
        map.set(42,63);
        map.set(43,18);
        map.set(50,69);
        map.set(54,31);
        map.set(62,81);
        map.set(66,45);
        map.set(76,58);
        map.set(74,92);
        map.set(89,53);
        map.set(99,41);

    }

    public int getNewPosition(int pos){
        if(pos >= 0 && pos<=100){
            return map.get(pos);
        }
        return -1;
    }

//    public static void main(String[] args) {
//        Board board = new Board();
//
//
//        for(int i = 0 ; i < board.posCord.size();i++){
//            System.out.println(i+" $ "+" x : "+board.posCord.get(i).getKey()+" "
//                    +" y : "+board.posCord.get(i).getValue()+" ");
//        }
//
//    }


}