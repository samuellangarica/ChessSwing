package ChessGame.Board;

import ChessGame.Pieces.Piece;

public class Tile {
    Piece piece;
    public Tile(Piece piece){
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    @Override
    public String toString(){
        return piece.getName();
    }
}
