package ChessGame.Pieces;

import ChessGame.Board.Board;

import java.util.ArrayList;

public class King extends Piece{
    public King(int position, char color) {
        this.position = position;

        String pieceName = "";
        pieceName += color;
        pieceName += 'K';
        this.pieceName = pieceName;
    }
    public ArrayList<Integer> getRange(Board board){
        ArrayList<Integer> range = new ArrayList<Integer>();

        Integer[] offsets = {9, 8, 7, 1};
        for(Integer offset : offsets){
            Piece checkingPiece = board.getPieceAt(getPosition() + offset);
            if (checkingPiece != null){
                if (checkingPiece.getColor() != getColor()){
                    range.add(getPosition() - offset);
                }
            }
            checkingPiece = board.getPieceAt(getPosition() - offset);
            if (checkingPiece != null){
                if (checkingPiece.getColor() != getColor()){
                    range.add(getPosition() - offset);
                }
            }

        }

        return range;
    }

}
