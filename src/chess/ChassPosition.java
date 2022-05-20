package chess;

import boardgame.Position;

public class ChassPosition {
    private char column;
    private int line;
	public ChassPosition(char column, int line) {
		if(column < 'a' || column > 'h' || line < 1 || line > 8) {
			throw new ChassException("Erro !!! Limites do tabuleiro exedido valore aceitos vão de a1 até h8.");
		}
		this.column = column;
		this.line = line;
	}
	public char getColumn() {
		return column;
	}
	public int getLine() {
		return line;
	}
	protected Position toPosition() {
		return new Position(8 - line, column - 'a');
	}
    
	protected static ChassPosition fromPosition(Position position) {
		return new ChassPosition((char)('a' + position.getColumn()), 8 - position.getLine());
	}
    
	@Override
	public String toString() {
		return "" + column + line;
	}
}
