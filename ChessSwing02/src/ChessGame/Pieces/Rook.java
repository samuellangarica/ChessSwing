package ChessGame.Pieces;

import ChessGame.Board.Board;

import java.util.ArrayList;

public class Rook extends Piece {
    public Rook(int position, char color) {
        this.position = position;

        String pieceName = "";
        pieceName += color;
        pieceName += 'R';
        this.pieceName = pieceName;
    }

    public ArrayList<Integer> getRange(Board board) {
        ArrayList<Integer> range = new ArrayList<Integer>();

        // Look Up
        int upPos = this.position - 8;
        while (upPos > 7) {
            Piece pieceUp = board.getPieceAt(upPos);
            if (pieceUp.getColor() != getColor()) {
                range.add(upPos);
            } else {
                break;
            }
            upPos -= 8;
        }
        // Look Down
        int downPos = this.position + 8;
        while (downPos < 56) {
            Piece pieceDown = board.getPieceAt(downPos);
            if (pieceDown.getColor() != getColor()) {
                range.add(downPos);
            } else {
                break;
            }
            downPos += 8;
        }
        // Look Left
        int leftPos = this.position - 1;
        while ((leftPos + 1) % 8 != 0) { // check if is on 1st column
            Piece pieceLeft = board.getPieceAt(leftPos);
            if (pieceLeft.getColor() != getColor()) {
                range.add(leftPos);
            } else {
                break;
            }
            leftPos -= 1;
        }
        // Look Left
        int rightPos = this.position + 1;
        while (rightPos % 8 != 0){
            Piece pieceRight = board.getPieceAt(rightPos);
            if (pieceRight.getColor() != getColor()){
                range.add(rightPos);
            }else {
                break;
            }
            rightPos += 1;
        }

        return range;
    }
}
