package ChessGame.Pieces;

import ChessGame.Board.Board;
import ChessGame.Board.Tile;

import java.util.ArrayList;

public abstract class Piece {
    public String pieceName;
    public int position;
    public static Piece createPiece(String pieceName, int position) {
        Piece piece = null;
        char pieceColor = pieceName.charAt(0);
        char pieceType = pieceName.charAt(1);
        switch (pieceType){
            case '-':
                piece = new EmptyPiece(position);
                break;
            case 'R':
                piece = new Rook(position, pieceColor);
                break;
            case 'N':
                piece = new Knight(position, pieceColor);
                break;
            case 'B':
                piece = new Bishop(position, pieceColor);
                break;
            case 'Q':
                piece = new Queen(position, pieceColor);
                break;
            case 'K':
                piece = new King(position, pieceColor);
                break;
            case 'P':
                piece = new Pawn(position, pieceColor);
                break;
        }
        return piece;
    }

    public char getColor(){
        return this.pieceName.charAt(0);
    }
    public char getType(){
        return this.pieceName.charAt(1);
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return this.pieceName;
    }
    public static Piece EMPTY(int pos){
        return new EmptyPiece(pos);
    }
    public ArrayList<Integer> getRange(Board board){
        return null;
    }
}
