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
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getLines()][getBoard().getColumns()];
		return mat;
	}
    
}
