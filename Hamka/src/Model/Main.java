package Model;

import java.util.Scanner;

import Utils.JsonParser;

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
			scanner.nextLine();
			switch (option) {
			case 1:
				System.out.println("Enter player1 username:");
				String p1 = scanner.nextLine();
				Player player1 = new Player(p1);
				System.out.println("Enter player2 username:");
				String p2 = scanner.nextLine();
				Player player2 = new Player(p2);
				System.out.println();
				System.out.println("Let's start the game ===>");
				System.out.println(player1.getUsername() + " => White (1) , " + player2.getUsername() + " => Black (2)");
				System.out.println();
				main.runGame(player1, player2);
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
				scanner.close();
				System.out.println("Game ended.\nSee you later");
				SysData.getInstance().writePausedGames();
				break;
			default:
				System.err.println("Illegal option! Try again.");
				break;
			}
		}
	}
	
	private void runGame(Player player1, Player player2) {
		// TODO Auto-generated method stub
		Game game = new Game(player1, player2);
		boolean finished = false;
		Scanner scanner = new Scanner(System.in);
		String turnString, scoresStatus, moveInput;
		Player playerToPlay;
		int fromX, fromY, toX, toY;
		while(!finished) {
			System.err.println("NOTE:\nIn each turn the player should enter the indexes of the soldier he wants to move, then the indexes of the new tile.\nBut he also can write: quit, pause, resume");
			System.out.println();
			playerToPlay = game.isP1Turn() ? player1 : player2;
			turnString = String.format("%s's turn:", playerToPlay.getUsername());
			System.out.println(turnString);
			
			scoresStatus = "Current scores status: "+ player1.getUsername() +": " + player1.getScore() + " , " +  player2.getUsername() +": " + player2.getScore();
			System.out.println(scoresStatus);
			System.out.println();
			
			System.out.println(game.getGameState());
			System.out.println("");
			System.out.println("Please enter the indexes (row,col) of the soldier that you want to move:");
			moveInput = scanner.nextLine();
			if(moveInput.equals("exit")) {
				//game.finishGame();
				Player winPlayer = game.isP1Turn() ? player2 : player1;
				game.setWinner(winPlayer);
				System.out.println("Game finished. " + playerToPlay.getUsername() + " had quited");
				System.out.println(winPlayer.getUsername() + " wins !!!");
				finished = true;
				SysData.getInstance().getPausedGames().add(game);
//				for(int i=0 ; i<8 ; i++) {
//					for(int j=0 ; j<8 ; j++) {
//						System.out.println(JsonParser.getInstance().parseObjectToJsonObject(game.getBoard().getMyBoard()[i][j]));
//					}
//				}
			}else {
				if(validateMoveInput(moveInput)) {
					char[] moveArr = moveInput.toCharArray(); 
					fromX = Integer.parseInt(String.valueOf(moveArr[1]));
					fromY = Integer.parseInt(String.valueOf(moveArr[3]));
					System.out.println("Please enter the indexes (row,col) of the distination tile:");
					moveInput = scanner.nextLine();
					if(validateMoveInput(moveInput)) {
						moveArr = moveInput.toCharArray(); 
						toX = Integer.parseInt(String.valueOf(moveArr[1]));
						toY = Integer.parseInt(String.valueOf(moveArr[3]));
						game.move(fromX, fromY, toX, toY);
					}
				}
			}
		}
	}

	private boolean validateMoveInput(String moveInput) {
		// TODO Auto-generated method stub
		// format (x,y)
		return true;
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
