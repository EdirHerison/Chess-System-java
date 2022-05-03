package chess.pieces;

import boardgame.Board;
import chess.ChassPiece;
import chess.Color;

public class King extends ChassPiece{

	public King(Board board, Color color) {
		super(board, color);
	}
	
	public String toString() {
		return "K";
	}

}
