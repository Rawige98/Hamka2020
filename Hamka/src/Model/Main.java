package Model;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		int option;
		System.out.println("~~ Welcome to Hamka ~~");
		System.out.println();
		boolean exit = false;
		while(!exit) {
			main.printDashboard();
			option = scanner.nextInt();
			
			switch (option) {
			case 1:
				
				break;
			case 2:
				main.printRules();
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				exit = true;
				System.out.println("Game ended.\nSee you later");
				break;
			default:
				System.err.println("Illegal option! Try again.");
				break;
			}
		}
	}
	
	public void printDashboard() {
		String toPrint = String.format("Please choose a game option:\n\t1.Play\n\t2.Game Rules\n\t3.Questions\n\t4.View History\n\t5.Exit");
		System.out.println(toPrint);
	}
	
	public void printRules() {
		String rule1, rule2, rule3, rule4, rule5, rule6, rule7;
		rule1 = "- If a player is able to make a capture, there is no option; the jump must be made. If more than one capture is available, the player is free to choose whichever he or she prefers.";
		rule2 = "- Kings may combine jumps in several directions, forward and backward, on the same turn. Single pieces may shift direction diagonally during a multiple capture turn, but must always jump forward (toward the opponent).";
		rule3 = "- When a piece is captured, it is removed from the board.";
		rule4 = "- When a piece reaches the furthest row from the player who controls that piece, it is crowned and becomes a king. One of the pieces which had been captured is placed on top of the king so that it is twice as high as a single piece.";
		rule5 = "- LabKings are limited to moving diagonally but may move both forward and backward. (Remember that single pieces, i.e. non-kings, are always limited to forward moves.)el";
		rule6 = "- A piece making a capturing move (a jump) leaps over one of the opponent's pieces, landing in a straight diagonal line on the other side. Only one piece may be captured in a single jump; however, multiple jumps are allowed during a single turn.";
		rule7 = "- Moves are allowed only on the dark squares, so pieces   always move diagonally. Single pieces are always limited to forward moves (toward the opponent).";
		System.out.println("Game rules:");
		System.out.println("\t"+rule1);
		System.out.println();
		System.out.println("\t"+rule2);
		System.out.println();
		System.out.println("\t"+rule3);
		System.out.println();
		System.out.println("\t"+rule4);
		System.out.println();
		System.out.println("\t"+rule5);
		System.out.println();
		System.out.println("\t"+rule6);
		System.out.println();
		System.out.println("\t"+rule7);
		System.out.println();
		
	}
}
