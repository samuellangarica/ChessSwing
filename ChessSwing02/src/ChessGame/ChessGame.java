package ChessGame;

import ChessGame.Board.Board;
import ChessGame.Visuals.BoardCanvas;

import javax.swing.*;
import java.awt.*;

public class ChessGame {

    static Board board = new Board();
    static InputManager inputManager = new InputManager(board);
    static BoardCanvas boardCanvas = new BoardCanvas(board, inputManager);
    public static void main(String[] args) {
        JFrame frame = new JFrame("Chess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.add(boardCanvas);
        frame.setVisible(true);



    }
}
