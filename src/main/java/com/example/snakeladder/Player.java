package com.example.snakeladder;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

//public class Player {
//    private static Board gameBoard = new Board();
//    private Circle coin;
//    private int currentPosition;
//    private String name;
//
//
//    public Player(int tileSize, Color coinColor, String playerName) {
//        coin = new Circle(tileSize / 2.5);
//        coin.setFill(coinColor);
//        currentPosition = 0;
//        movePlayer(1);
//        name = playerName;
//
//    }
//
//    public void movePlayer(int pos) {
//        if (currentPosition + pos <= 100) {
//            currentPosition += pos;
//
////        int x = gameBoard.getXCoordinate(currentPosition);
////         int y = gameBoard.getYCoordinate(currentPosition);
////        coin.setTranslateX(x);
////        coin.setTranslateY(y);
//
//
//            TranslateTransition firstMove = translateAnimation(pos), secondMove = null;
//
//            int newPosition = gameBoard.getNewPosition(currentPosition);
//            if (newPosition != currentPosition && currentPosition != -1) {
//                currentPosition = newPosition;
//                translateAnimation(6);
//            }
//            if (secondMove == null) {
//                firstMove.play();
//            } else {
//                SequentialTransition sequentialTransition = new SequentialTransition(firstMove,
//                        new PauseTransition(Duration.millis(500)), secondMove);
//                sequentialTransition.play();
//            }
//
//
//        }
//    }
//
//
//    public TranslateTransition translateAnimation(int diceValue) {
//        TranslateTransition animate = new TranslateTransition(Duration.millis(4*200), coin);
//        animate.setToX(gameBoard.getXCoordinate(currentPosition));
//        animate.setToY(gameBoard.getYCoordinate(currentPosition));
//        animate.setAutoReverse(false);
//        return animate;
//        // animate.play();
//    }
//
//
//    public void startingPosition() {
//        currentPosition = 1;
//        movePlayer(0);
//    }
//
//    boolean isWinner() {
//        if (currentPosition == 100) {
//
//
//            return true;
//        }else{
//        return false;
//    }
//
//}
//    public Circle getCoin() {
//        return coin;
//    }
//
//    public int getCurrentPosition() {
//
//        return currentPosition;
//    }
//
//    public String getName() {
//        return name;
//    }
//}

public class Player {

    private static Board gameBoard = new Board();
    private Circle coin;

    private String Name;

    private int currPos;

    public Player(int tileSize, String name, Color color){
        coin = new Circle(tileSize/2.5);
        currPos = 0;
        Name = name;
        coin.setFill(color);
        movePlayer(1);

    }


    public Circle getCoin() {
        return coin;
    }

    public String getName() {
        return Name;
    }

    public int getCurrPos() {
        return currPos;
    }

    public boolean isWinner(){
        if(currPos == 100){
            return true;
        }else{
            return false;
        }
    }

    public  void  movePlayer(int pos){
        if(pos+currPos <=100){
            currPos +=pos;
            TranslateTransition firstMove = animateTranslate(pos),secondMove = null;

            int newPos = gameBoard.getNewPosition(currPos);
            if(newPos != currPos && newPos != -1){
                currPos = newPos;
                secondMove = animateTranslate(6);
            }

            if(secondMove ==null){
                firstMove.play();
            }else{
                SequentialTransition seq = new SequentialTransition(firstMove,new PauseTransition(Duration.millis(500)),
                        secondMove);
                seq.play();
            }
        }
    }

    public void startingPosition(){
        currPos = 1;
        movePlayer(0);
    }

    private TranslateTransition animateTranslate(int pos){
        TranslateTransition animate = new TranslateTransition(Duration.millis(4*200),coin);
        animate.setToX(gameBoard.getXCoordinate(currPos));
        animate.setToY(gameBoard.getYCoordinate(currPos));
        animate.setAutoReverse(false);
        return  animate;
    }


}
