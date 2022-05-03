package chess.pieces;

import boardgame.Board;
import chess.ChassPiece;
import chess.Color;

public class Rook extends ChassPiece{

	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "R";
	}
    
}
