package com.example.snakeladder;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeLadder extends Application {

    public static final int width = 10 ,height = 10,tileSize = 50;
    public static final int buttonLine = tileSize * height + 43,infoLine = tileSize * height + 10;

    private Player playerOne,playerTwo;

    private boolean gameStarted = false,playerOneTurn=true, playerTwoTurn=false;
    private Dice dice = new Dice();
    private Pane createContent(){
        Pane root = new Pane();
        root.setPrefSize(width*tileSize,height*tileSize+80);



        for (int i = 0; i < height; i++) {
            for(int j = 0 ; j < width ; j++){
                Tile tile = new Tile(tileSize);
                tile.setTranslateX(j * tileSize);
                tile.setTranslateY(i * tileSize);
                root.getChildren().add(tile);
            }

        }

        Image img = new Image("C:\\Users\\zikra\\IdeaProjects\\SnakeLadder\\src\\main\\java\\img.png");
        ImageView board = new ImageView();
        board.setImage(img);
        board.setFitHeight(height*tileSize);
        board.setFitWidth(width*tileSize);

//        Creating buttons

        Button playerOneButton =new Button("Player One");
        Button playerTwoButton =new Button("Player Two");
        Button startButton = new Button("Start");


        playerOneButton.setTranslateY(buttonLine);
        playerOneButton.setTranslateX(25);

        playerTwoButton.setTranslateY(buttonLine);
        playerTwoButton.setTranslateX(400);

        startButton.setTranslateX(230);
        startButton.setTranslateY(buttonLine);

        Label playerOneLable =new Label("Your Turn! p1");
        Label playerTwoLable = new Label("Your Turn! p2");
        Label diceLabel= new Label("Start the Game");

        playerOneLable.setTranslateX(25);
        playerOneLable.setTranslateY(infoLine);

        playerTwoLable.setTranslateX(400);
        playerTwoLable.setTranslateY(infoLine);


        diceLabel.setTranslateX(230);
        diceLabel.setTranslateY(infoLine);


        playerOne =new Player(tileSize, "Zick", Color.BLACK);
        playerTwo=new Player(tileSize-5, "Zee", Color.WHITE);


//        Palyer Movement;


        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                gameStarted = true;
                startButton.setDisable(true);
                diceLabel.setText(" Game Started ");
                playerOneLable.setText("Your Turn ! " + playerOne.getName());
                playerTwoTurn = false;
                playerTwoLable.setText("");
                playerOneTurn = true;
                playerOne.startingPosition();
                playerTwo.startingPosition();
                playerOneButton.setDisable(false);
                playerTwoButton.setDisable(true);



            }
        });

        playerOneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStarted){
                    if(playerOneTurn){
                        int diceValue = dice.getRolledDiceValue();
                        diceLabel.setText("Dice value is : "+diceValue);
                        playerOne.movePlayer(diceValue);
                        if(playerOne.isWinner()){
                            diceLabel.setText("Waoo!The Winner is : "+playerTwo.getName()+"   ");

                            playerOneButton.setDisable(true);
                            playerTwoButton.setDisable(true);

                            playerOneLable.setText("");
                            playerTwoLable.setText("");

                            startButton.setDisable(false);

                        }else{
                            playerOneTurn = false;
                            playerTwoTurn = true;
                            playerOneButton.setDisable(true);
                            playerTwoButton.setDisable(false);
                            playerOneLable.setText("");
                            playerTwoLable.setText("Your Turn Zee !");
                        }

                    }

                }

            }
        });

        playerTwoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                if(gameStarted){
                    if(playerTwoTurn){
                        int diceValue = dice.getRolledDiceValue();
                        diceLabel.setText("Dice value is : "+diceValue);
                        playerTwo.movePlayer(diceValue);
                        if(playerTwo.isWinner()){

                            diceLabel.setText("Waoo!The Winner is : "+playerTwo.getName()+"   ");

                            playerOneButton.setDisable(true);
                            playerTwoButton.setDisable(true);

                            playerOneLable.setText("");
                            playerTwoLable.setText("");

                            startButton.setDisable(false);
                        }else{
                            playerTwoTurn = false;
                            playerOneTurn = true;
                            playerTwoButton.setDisable(true);
                            playerOneButton.setDisable(false);
                            playerTwoLable.setText("");
                            playerOneLable.setText("Your Turn Zick !");
                        }

                    }

                }

            }
        });









        root.getChildren().addAll(board,playerOneButton,playerTwoButton,startButton,
                playerOneLable,playerTwoLable,diceLabel,playerOne.getCoin(),playerTwo.getCoin()
        );





        return root;
    }

    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = new Scene(createContent());
        stage.setTitle("Snake & Ladder!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}