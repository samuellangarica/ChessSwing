package ChessGame.Board;

import ChessGame.Pieces.Piece;

import java.time.Year;
import java.util.ArrayList;

public class Board {
    private Tile[] tiles;
    private int selectedTilePos = 64;
    public Board(){
        this.tiles = generateStartBoard();
    }

    private Tile[] generateStartBoard() {
        String[] startPosition = {
                "bR","bN","bB","bQ","bK","bB","bN","bR",
                "bP","bP","bP","bP","bP","bP","bP","bP",
                "--","--","--","--","--","bP","wP","--",
                "wN","bP","--","wN","bN","--","--","wN",
                "wN","--","bP","bN","wN","--","wN","wN",
                "--","--","--","--","--","bP","bP","--",
                "wP","wP","wP","wP","wP","wP","wP","wP",
                "wR","wN","wB","wQ","wK","wB","wN","wR",

        };
        Tile[] tiles = new Tile[64];
        for (int i = 0; i < 64;i++){
            Piece piece = Piece.createPiece(startPosition[i], i);
            tiles[i] = new Tile(piece);
        }
        return tiles;
    }

    public void print() {
        int position = 0;
        for (int x = 0; x < 8; x++){
            for (int y = 0; y < 8; y++){
                System.out.print(this.tiles[position].toString() + " ");
                position++;
            }
            System.out.println();
        }
    }

    public ArrayList<Piece> getPieces() {
        ArrayList<Piece> pieces = new ArrayList<Piece>();
        for (int i = 0; i < 64; i++){
            Piece piece = this.tiles[i].getPiece();
            if (piece.getType() != '-'){ // Check if not EmptyPiece
                pieces.add(piece);
            }
        }
        return pieces;
    }

    public Tile getTile(int pos){
        return this.tiles[pos];
    }

    public int getSelectedTilePos() {
        return this.selectedTilePos;
    }

    public void setSelectedTilePos(int selectedTilePos) {
        this.selectedTilePos = selectedTilePos;
    }
    public Piece getPieceAt(int pos){
        if (0 <= pos && pos <= 63) {
            return this.tiles[pos].getPiece();
        }
        return null;
    }
    public Piece getSelectedPiece(){
        if (getSelectedTilePos() != 64){
            return getPieceAt(getSelectedTilePos());
        } return null;
    }

    public ArrayList<Integer> getRangeOfSelectedPiece() {
        if(selectedTilePos != 64){
            Piece selectedPiece = tiles[selectedTilePos].getPiece();
            if (selectedPiece.getType() != '-'){
                return selectedPiece.getRange(this);
            }
        }
        return null;

    }

    public static Integer[] getXYFromPos(int pos){
        int row = pos / 8;
        int col = pos % 8;
        return new Integer[] {row, col};
    }
    public static int getPosFromXY(Integer[] xy){
        return xy[0] * 8 + xy[1];
    }

}
