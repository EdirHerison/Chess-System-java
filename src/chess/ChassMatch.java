package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChassMatch {
 
	private Board board;

	public ChassMatch() {
		board = new Board(8, 8);
		initialSetup();
	}
	
	public ChassPiece[][] getPieces(){
		ChassPiece[][] mat = new ChassPiece[board.getLines()][board.getColumns()];
		 for(int i=0; i<board.getLines();i++) {
			 for(int j=0; j<board.getColumns();j++) {
				 mat[i][j] = (ChassPiece) board.piece(i, j);
			 }
		 }
		 return mat;
	}
	
	private void placeNewPiece(char column, int line, ChassPiece piece) {
		board.placePiece(piece, new ChassPosition(column, line).toPosition());
	}
	
	private void initialSetup() {
		placeNewPiece('e', 1, new Rook(board, Color.WHITE));
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
	
}
