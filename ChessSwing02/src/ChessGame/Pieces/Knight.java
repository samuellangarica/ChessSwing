package ChessGame.Pieces;

import ChessGame.Board.Board;

import java.util.ArrayList;

public class Knight extends Piece {
    public Knight(int position, char color) {
        this.position = position;

        String pieceName = "";
        pieceName += color;
        pieceName += 'N';
        this.pieceName = pieceName;
    }

    public ArrayList<Integer> getRange(Board board) {
        ArrayList<Integer> range = new ArrayList<Integer>();
        Integer[] pieceXY = Board.getXYFromPos(getPosition());

        Integer[][] offsets = new Integer[][]{
                new Integer[]{-2, -1}, new Integer[]{-2, 1},
                new Integer[]{-1, 2}, new Integer[]{1, 2},
                new Integer[]{2, -1}, new Integer[]{2, 1},
                new Integer[]{1, -2}, new Integer[]{-1, -2},
        };

        for (Integer[] offset : offsets) {
            int rowOffset = offset[0];
            int colOffset = offset[1];

            int pieceRow = pieceXY[0];
            int pieceCol = pieceXY[1];

            Integer[] checkingXY = {pieceRow + rowOffset, pieceCol + colOffset};
            if (checkingXY[0] >= 0 && checkingXY[0] <= 7){
                if (checkingXY[1] >= 0 && checkingXY[1] <= 7){
                    int checkingPos = Board.getPosFromXY(checkingXY);
                    Piece checkingPiece = board.getPieceAt(checkingPos);
                    if (checkingPiece.getColor() != getColor()){
                        range.add(checkingPos);
                    }
                }
            }


        }


        return range;
    }

}
