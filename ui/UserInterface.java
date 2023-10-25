package ui;

import game.*;
import javax.swing.*;
import java.util.HashMap;

public class UserInterface extends JFrame {
	private HashMap<String, String> language;
	private GameController game;

	public UserInterface(GameController game) {
		this.game = game;
		setLanguage("English");
		setContentPane(new NewGamePanel(this));
		setTitle(language.get("gameTitle"));
		setVisible(true);
		// To get the inner size to 400x300 and not the total size of the window
		var insets = getInsets();
		var innerWidth = 400;
		var innerHeight = 300;
		setSize(innerWidth + insets.left + insets.right, innerHeight + insets.top + insets.bottom);
		// Make sure the window has a minimum size, and just set it to the current size
		setMinimumSize(getSize());
		// The application should quit when the user closes the window
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public HashMap<String, String> getLanguage() {
		return language;
	}

	public void setLanguage(HashMap<String, String> language) {
		this.language = language;
		setTitle(language.get("gameTitle"));
	}

	public void setLanguage(String language) {
		setLanguage(Languages.getLanguage(language));
	}

	public void startButtonPressed(String player1Name, String player2Name) {
		game.setPlayerNames(player1Name, player2Name);
		game.startGame();
		GamePanel gamePanel = new GamePanel(this);
		gamePanel.updatePlayerNames(player1Name, player2Name);
		gamePanel.updatePlayerBalances(game.getPlayer1Balance(), game.getPlayer2Balance());
		gamePanel.updatePlayerTurn(game.isPlayerTwo());
		setContentPane(gamePanel);
		revalidate();
	}

	protected void playTurnButtonPressed() {
		game.playNextTurn();
		GamePanel gamePanel = (GamePanel) getContentPane();
		gamePanel.updatePlayerBalances(game.getPlayer1Balance(), game.getPlayer2Balance());
		gamePanel.updatePlayerTurn(game.isPlayerTwo());
		gamePanel.updateFeedback(language.get(game.getSquare().getNameToken() + "Description"));
		if (game.hasCurrentPlayerWon()) {
			gamePanel.gameOver();
		}
	}

	public static void main(String[] args) {
		var game = new GameController();
		var ui = new UserInterface(game);
	}
}
