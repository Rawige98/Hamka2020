package Model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Timer;

import Utils.GameStatus;

public class Game {
	private static int Serial = 0;
	private int id;
	private Player player1;
	private Player player2;
	private Date gameDate;
	private Board board;
	private Player winner;
	private Timer gameDuration;
	private static boolean isP1Turn;

	public Game(Player player1, Player player2) {
		super();
		this.player1 = player1;
		this.player2 = player2;
		board = new Board();
		gameDate = java.util.Calendar.getInstance().getTime();
		id = ++Serial;
		isP1Turn = true;
	}

	public Game() {

	}

	// ------------------------Getters and Setters---------------------
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public Date getGameDate() {
		return gameDate;
	}

	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public Timer getGameDuration() {
		return gameDuration;
	}

	public void setGameDuration(Timer gameDuration) {
		this.gameDuration = gameDuration;
	}

	public boolean isP1Turn() {
		return isP1Turn;
	}

	public void setP1Turn(boolean isP1Turn) {
		this.isP1Turn = isP1Turn;
	}
	// ---------------------------------------------------

	public void pauseGame() {
	}

	/**
	 * we check if the game is finished by the number of Soldiers for the players
	 * @param isQuit	flag to know is the gamed had finished after a player quit
	 * @return
	 */
	public boolean finishGame(GameStatus status) {
		if(status.equals(GameStatus.QUIT)) {
			winner = isP1Turn ? player2 : player1;
			return true;
		}
		else if(status.equals(GameStatus.PAUSE))
			return true;
		else if (status.equals(GameStatus.FINISH) && board.checkAvailableMoves(isP1Turn).isEmpty()) {
			if (player1.getScore() > player2.getScore())
				winner = player1;
			else
				winner = player2;
			return true;
		}
		else return false;
	}

	public void popQuestion() {
	}

	public boolean move(int xStart, int yStart, int xEnd, int yEnd) {
		Player p=null;
		p = isP1Turn ? player1 : player2;
		if(board.move(xStart, yStart, xEnd, yEnd, isP1Turn,p)){
			isP1Turn = !isP1Turn;
			return true;
		}
		return false;
	}

	public String getGameState() {
		return board.toString();
	}

	@Override
	public String toString() {
		return "Game id=" + id + ", player1=" + player1 + ", player2=" + player2 + ",\ngameDate=" + gameDate
				+ ", winner=" + winner + ", gameDuration=" + gameDuration + "\n"+board ;
	}

	public String briefToString() {
		return "Game id=" + id + ", player1=" + player1 + ", player2=" + player2 + ",\ngameDate=" + gameDate +
				", winner=" + winner + ", gameDuration=" + gameDuration + "]";
	}

}