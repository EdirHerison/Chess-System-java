package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;


public class ChassMatch {
 
	private int turn;
	private Color currentPlayer;
	private Board board;
	private boolean check;
	
	private List<Piece> piecesOnTheBoard = new ArrayList<>();
	private List<Piece> capturedPieces = new ArrayList<>();

	public ChassMatch() {
		board = new Board(8, 8);
		turn = 1;
		currentPlayer = Color.WHITE;
		initialSetup();
	}
	
	public int getTurn() {
		return turn;
	}
	
	public Color getCurrentPlayer() {
		return currentPlayer;
	}
	
	public boolean getCheck() {
		return check;
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
	
	public boolean [][] possibleMoves (ChassPosition sourcePosition){
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
	}
	
	public ChassPiece performChassMovie(ChassPosition sourcePosition, ChassPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source, target);
		
		if(testCheck(currentPlayer)) {
			undoMove(source, target, capturedPiece);
			throw new ChassException("Voce nao pode se colocar em xeque!!");
		}
		
		check = (testCheck(opponent(currentPlayer)))? true : false;
		
		nextTurn();
		return (ChassPiece)capturedPiece;
	}
	
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		
		if(capturedPiece != null) {
			piecesOnTheBoard.remove(capturedPiece);
			capturedPieces.add(capturedPiece);
		}
		
		return capturedPiece;
	}
	
	private void undoMove(Position source, Position target, Piece capturedPiece) {
		Piece p = board.removePiece(target);
		board.placePiece(p, source);
		
		if(capturedPiece != null) {
			board.placePiece(capturedPiece, target);
			capturedPieces.remove(capturedPiece);
			piecesOnTheBoard.add(capturedPiece);
		}
	}
	
	private void validateSourcePosition(Position position) {
		if(!board.thereIsPiece(position)) {
			throw new ChassException("Erro! N?o existe pe?a nessa posi??o");
		}
		
		if (currentPlayer != ((ChassPiece)board.piece(position)).getColor()) {
			throw new ChassException("Erro! A peca escolhida n?o peretence a voce.");
		}
		
		if(!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChassException("Erro! sem movimentos possiveis para a pe?a escolhida.");
		}
		
	}
	
	private void validateTargetPosition(Position source, Position target) {
		if (!board.piece(source).possibleMove(target)) {
			throw new ChassException("Erro! A peca nao pode se movida para posicao escolhida");
		}
	}
	
	private void nextTurn() {
		turn ++;
		currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}
	
	private Color opponent(Color color) {
		return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}
	
	private ChassPiece king (Color color) {
		List<Piece> list = piecesOnTheBoard.stream().filter(x ->((ChassPiece)x).getColor() == color).collect(Collectors.toList());
		 for(Piece p : list) {
			 if(p instanceof King) {
				 return (ChassPiece)p;
			 }
		 }
		 throw new IllegalStateException("Nao foi encontrado um rei " + color + " no tabauleiro");
	}
	
	private boolean testCheck(Color color) {
		Position kingPosition = king(color).getChessPosition().toPosition();
		List<Piece> opponentePieces = piecesOnTheBoard.stream().filter(x ->((ChassPiece)x).getColor() == opponent(color)).collect(Collectors.toList());
		 for(Piece p : opponentePieces) {
			 boolean[][] mat = p.possibleMoves();
			 if(mat[kingPosition.getLine()][kingPosition.getColumn()]) {
				 return true;
			 }
		 }
		 return false;
	}
	
	private void placeNewPiece(char column, int line, ChassPiece piece) {
		board.placePiece(piece, new ChassPosition(column, line).toPosition());
		piecesOnTheBoard.add(piece);
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
