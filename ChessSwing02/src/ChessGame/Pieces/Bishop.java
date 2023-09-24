package ChessGame.Pieces;

import ChessGame.Board.Board;

import java.util.ArrayList;

public class Bishop extends Piece {
    public Bishop(int position, char color) {
        this.position = position;

        String pieceName = "";
        pieceName += color;
        pieceName += 'B';
        this.pieceName = pieceName;
    }

    public ArrayList<Integer> getRange(Board board) {
        ArrayList<Integer> range = new ArrayList<Integer>();

        // Up Left
        int upLeft = this.position - 9;
        while (upLeft > 7 && (upLeft + 9) % 8 != 0) {
            Piece pieceUpLeft = board.getPieceAt(upLeft);
            if (pieceUpLeft.getColor() != getColor()) {
                range.add(upLeft);
            } else {
                break;
            }
            upLeft -= 9;
        }
        // Up Right
        int upRight = this.position - 7;
        while (upRight > 7 && (upRight + 8) % 8 != 0) {
            Piece pieceUpRight = board.getPieceAt(upRight);
            if (pieceUpRight.getColor() != getColor()) {
                range.add(upRight);
            } else {
                break;
            }
            upRight -= 7;
        }
        // Down Left
        int downLeft = this.position + 7;
        while (downLeft < 56 && (downLeft - 7) % 8 != 0) {
            Piece pieceDownLeft = board.getPieceAt(downLeft);
            if (pieceDownLeft.getColor() != getColor()) {
                range.add(downLeft);
            } else {
                break;
            }
            downLeft += 7;
        }
        // Down Right
        int downRight = this.position + 9;
        while (downRight < 56 && (downRight - 8) % 8 != 0) {
            Piece pieceDownRight = board.getPieceAt(downRight);
            if (pieceDownRight.getColor() != getColor()) {
                range.add(downRight);
            } else {
                break;
            }
            downRight += 9;
        }

        return range;
    }

}