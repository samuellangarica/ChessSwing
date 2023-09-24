package ChessGame.Pieces;

import ChessGame.Board.Board;

import java.util.ArrayList;

public class Pawn extends Piece {
    int startPos;

    public Pawn(int position, char color) {
        this.position = position;

        String pieceName = "";
        pieceName += color;
        pieceName += 'P';
        this.pieceName = pieceName;
    }

    public ArrayList<Integer> getRange(Board board) {
        ArrayList<Integer> range = new ArrayList<Integer>();
        int rowMin = (getColor() == 'w') ? 48 : 8;
        int rowMax = (getColor() == 'w') ? 55 : 15;
        int pawnAdvanceDirection = getColor() == 'w' ? -1 : 1;

        // Check if pawn is at start position
        if (getPosition() >= rowMin && getPosition() <= rowMax) {
            Piece checkingPiece = board.getPieceAt(getPosition() + 8 * pawnAdvanceDirection);
            if (checkingPiece != null) {
                if (checkingPiece.getType() == '-') {
                    range.add(8 * pawnAdvanceDirection + getPosition());
                    checkingPiece = board.getPieceAt(16 * pawnAdvanceDirection + getPosition());
                    if (checkingPiece != null) {
                        if (checkingPiece.getType() == '-') {
                            range.add(16 * pawnAdvanceDirection + getPosition());
                        }
                    }
                }
            }
        }
        else{
            Piece checkingPiece = board.getPieceAt(getPosition() + 8 * pawnAdvanceDirection);
            if (checkingPiece != null) {
                if (checkingPiece.getType() == '-') {
                    range.add(8 * pawnAdvanceDirection + getPosition());
                }
            }
        }

        // Captures
        Integer[] offsets = {7, 9};
        for (Integer offset : offsets){
            int checkPos = offset * pawnAdvanceDirection + getPosition();
            Piece checkingPiece = board.getPieceAt(checkPos);
            if (checkingPiece != null){
                if (checkingPiece.getType() != '-' && checkingPiece.getColor() != getColor()){
                    range.add(checkPos);
                }
            }
        }



        return range;
    }

}