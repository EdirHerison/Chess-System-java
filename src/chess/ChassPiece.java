package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChassPiece extends Piece {
	
	private Color color;

	public ChassPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	public ChassPosition getChessPosition() {
		return ChassPosition.fromPosition(position);
	}
	
	protected boolean isThereOpponentPiece(Position position) {
		ChassPiece p = (ChassPiece)getBoard().piece(position);
		return p != null && p.getColor() != color;
	}

}
