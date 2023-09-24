package ChessGame.Pieces;

import ChessGame.Board.Board;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Queen extends Piece{
    public Queen(int position, char color) {
        this.position = position;

        String pieceName = "";
        pieceName += color;
        pieceName += 'Q';
        this.pieceName = pieceName;
    }
    public ArrayList<Integer> getRange(Board board){
        ArrayList<Integer> rookRange = new Rook(getPosition(), getColor()).getRange(board);
        ArrayList<Integer> bishopRange = new Bishop(getPosition(), getColor()).getRange(board);
        ArrayList<Integer> totalRange = rookRange;
        totalRange.addAll(bishopRange);
        return totalRange;
    }

}