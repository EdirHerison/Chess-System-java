package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChassPiece;
import chess.Color;

public class King extends ChassPiece{

	public King(Board board, Color color) {
		super(board, color);
	}
	
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Position position) {
		ChassPiece p = (ChassPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getLines()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		//acima
		p.setValues(position.getLine() - 1, position.getColumn());
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getLine()][p.getColumn()] = true;
		}
		
		//acima
		p.setValues(position.getLine() + 1, position.getColumn());
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getLine()][p.getColumn()] = true;
		}
		
		//direita
		p.setValues(position.getLine(), position.getColumn() + 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getLine()][p.getColumn()] = true;
		}
		
		//esquerda
		p.setValues(position.getLine(), position.getColumn() - 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getLine()][p.getColumn()] = true;
		}
		
		//nw
		p.setValues(position.getLine() -1, position.getColumn() - 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getLine()][p.getColumn()] = true;
		}
		
		//ne
		p.setValues(position.getLine() -1, position.getColumn() + 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getLine()][p.getColumn()] = true;
		}
		
		//sw
		p.setValues(position.getLine() + 1, position.getColumn() -1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getLine()][p.getColumn()] = true;
		}
		
		//se
		p.setValues(position.getLine() + 1, position.getColumn() + 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getLine()][p.getColumn()] = true;
		}
		
		
		
		
		return mat;
	}

}
