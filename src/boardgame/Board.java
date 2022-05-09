package boardgame;

public class Board {
  
	private int lines;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int lines, int columns) {
		if(lines < 1 || columns < 1) {
			throw new BoardException("Erro !!  O tabuleiro deve ter no minimo 1X1 de tamanho.");	
		}
		this.lines = lines;
		this.columns = columns;
		pieces = new Piece [lines][columns];
	}
	public int getLines() {
		return lines;
	}
	public int getColumns() {
		return columns;
	}
	
	public Piece piece(int lines, int columns) {
		if(!positionExists(lines, columns)) {
			throw new BoardException("Essa posição não existe");
		}
		return pieces[lines][columns];
	}
	
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Essa posição não existe");
		}
		return pieces[position.getLine()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if(thereIsPiece(position)) {
			throw new BoardException("Já existe uma peça nessa posição " + position);
		}
		pieces[position.getLine()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Erro! Esta peça não existe");
		}
		if(piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position =null;
		pieces[position.getLine()][position.getColumn()] = null;
		return aux;
	}
	
	private boolean positionExists(int line, int column) {
		return line >= 0 && line <lines && column >= 0 && column < columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getLine(),position.getColumn());
	}
	
	public boolean thereIsPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Essa posição não existe");
		}
		return piece(position) != null;
	}
}
