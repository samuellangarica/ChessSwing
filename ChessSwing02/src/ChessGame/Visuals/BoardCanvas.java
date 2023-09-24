package ChessGame.Visuals;

import ChessGame.Board.Board;
import ChessGame.InputManager;
import ChessGame.Pieces.Piece;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BoardCanvas extends JPanel {
    Canvas canvas;
    Graphics g;
    InputManager inputManager;
    Board board;
    Color lightSquare = new Color(164, 94, 51);
    Color darkSquare = new Color(82, 41, 14);
    Color selectionColor = new Color(245, 91, 91);
    Color posLabelColor = new Color(0, 0, 0);
    int tileSize = 100;
    //images

    public BoardCanvas(Board board, InputManager inputManager) {
        this.inputManager = inputManager;
        this.board = board;
        this.setSize(800, 800);
        this.setVisible(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                inputManager.handleClick(x, y);
                repaint();
            }
        });
    }

    private void paintBoard(Graphics g) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Color paintColor = ((i + j) % 2 == 0) ? lightSquare : darkSquare;
                g.setColor(paintColor);
                g.fillRect(i * tileSize, j * tileSize, tileSize, tileSize);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintBoard(g);
        paintSelection(g);
        paintRangeOfSelectedPiece(g);
        paintPieces(g);


    }

    private void paintRangeOfSelectedPiece(Graphics g) {
        ArrayList<Integer> rangeOfSelectedPiece = this.board.getRangeOfSelectedPiece();
        if (rangeOfSelectedPiece != null){
            for(int rangePos : rangeOfSelectedPiece){
                g.setColor(selectionColor);
                int x = rangePos % 8;
                int y = rangePos / 8;
                g.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
            }
        }
    }

    private void paintSelection(Graphics g) {
        int selectionPos = this.board.getSelectedTilePos();
        if (selectionPos != 64) {
            g.setColor(selectionColor);
            int x = selectionPos % 8;
            int y = selectionPos / 8;
            g.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
        }
    }

    private void paintPieces(Graphics g) {
        ArrayList<Piece> pieces = this.board.getPieces();
        for (Piece piece : pieces) {
            BufferedImage pieceImage;
            String path = "src/ChessGame/PieceImages/";
            try {
                pieceImage = ImageIO.read(new File(path + piece.getName() + ".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            int x = (piece.getPosition() % 8);
            int y = piece.getPosition() / 8;
            g.drawImage(pieceImage, x * tileSize + tileSize / 4, y * tileSize + tileSize / 4, null);
        }
    }


}
