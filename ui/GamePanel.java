package ui;

import javax.swing.*;

public class GamePanel extends JPanel {
	private JLabel player1Label;
	private JLabel player2Label;
	private JLabel feedbackLabel;
	private JButton playTurnButton;

	public GamePanel(LanguageProvider languageProvider) {
		var language = languageProvider.getLanguage();

		player1Label = new JLabel();
		player2Label = new JLabel();
		feedbackLabel = new JLabel();
		playTurnButton = new JButton(language.get("playTurn"));

		add(player1Label);
		add(player2Label);
		add(feedbackLabel);
		add(playTurnButton);
	}
}
