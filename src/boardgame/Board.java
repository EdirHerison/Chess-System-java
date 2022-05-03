package boardgame;

public class Board {
  
	private int lines;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int lines, int columns) {
		this.lines = lines;
		this.columns = columns;
		pieces = new Piece [lines][columns];
	}
	public int getLines() {
		return lines;
	}
	public void setLines(int lines) {
		this.lines = lines;
	}
	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	public Piece piece(int lines, int columns) {
		return pieces[lines][columns];
	}
	
	public Piece piece(Position position) {
		return pieces[position.getLine()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		pieces[position.getLine()][position.getColumn()] = piece;
		piece.position = position;
	}
	
}
