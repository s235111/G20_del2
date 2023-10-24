package ui;

import game.*;
import javax.swing.*;
import java.util.HashMap;

class UserInterface extends JFrame implements LanguageProvider {
	private HashMap<String, String> language;

	public UserInterface() {
		setLanguage("English");
		setContentPane(new NewGamePanel(this));
		setTitle(language.get("gameTitle"));
		setVisible(true);
		var insets = getInsets();
		var innerWidth = 400;
		var innerHeight = 300;
		setSize(innerWidth + insets.left + insets.right, innerHeight + insets.top + insets.bottom);
		setMinimumSize(getSize());
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
		setContentPane(new GamePanel(this));
		revalidate();
	}

	public static void main(String[] args) {
		var ui = new UserInterface();
	}
}
