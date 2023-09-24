package ChessGame;

import ChessGame.Board.Board;
import ChessGame.Board.Tile;
import ChessGame.Pieces.Piece;

import java.util.ArrayList;

public class InputManager {
    Board board;
    public InputManager(Board board){
        this.board = board;
    }

    public void handleClick(int x, int y) {
        int pos = (y / 100 * 8) + x /100;
        int selectedPos = this.board.getSelectedTilePos();
        if (pos != selectedPos){
            this.board.setSelectedTilePos(pos);
        } else {
            this.board.setSelectedTilePos(64);
        }
        Piece selectedPiece = this.board.getSelectedPiece();
        if (selectedPiece != null){
            ArrayList<Integer> rangeOfSelectedPiece = selectedPiece.getRange(this.board);
            System.out.println(selectedPiece.getName() + ":"+selectedPiece.getPosition());
        }

    }
}
