package application;

import java.util.Scanner;

import chess.ChassMatch;
import chess.ChassPiece;
import chess.ChassPosition;


public class Program {

	public static void main(String[] args) {
			
	Scanner sc = new Scanner(System.in);
	 ChassMatch chassMacth = new ChassMatch();
	 
	 while (true) {
		UI.printBoard(chassMacth.getPieces());
		System.out.println();
		System.out.print("Origem(source): ");
		ChassPosition source = UI.readChassPosition(sc);
		
	    System.out.println();
	    System.out.print("Destino(target): ");
	    ChassPosition target = UI.readChassPosition(sc);
	    
	    ChassPiece capturedPiece = chassMacth.performChassMovie(source, target);		
	 }
	}

}
