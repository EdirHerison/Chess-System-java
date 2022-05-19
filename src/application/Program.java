package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChassException;
import chess.ChassMatch;
import chess.ChassPiece;
import chess.ChassPosition;


public class Program {

	public static void main(String[] args) {
			
	Scanner sc = new Scanner(System.in);
	 ChassMatch chassMacth = new ChassMatch();
	 List<ChassPiece> captured = new ArrayList<>();
	 
	 while (true) {
		try {
			UI.clearScreen();
			UI.printMatch(chassMacth, captured);
			System.out.println();
			System.out.print("Origem(source): ");
			ChassPosition source = UI.readChassPosition(sc);
			
			boolean[][] possibleMoves = chassMacth.possibleMoves(source);
			UI.clearScreen();
			UI.printBoard(chassMacth.getPieces(), possibleMoves);
		    System.out.println();
		    System.out.print("Destino(target): ");
		    ChassPosition target = UI.readChassPosition(sc);
		    
		    ChassPiece capturedPiece = chassMacth.performChassMovie(source, target);
		    if(capturedPiece != null) {
		    	captured.add(capturedPiece);
		    }
		}
		catch(ChassException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		}
		catch(InputMismatchException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		}
				
	 }
	}

}
