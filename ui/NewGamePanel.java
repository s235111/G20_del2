package ui;

import javax.swing.*;

class NewGamePanel extends JPanel {
	public NewGamePanel() {
		JLabel player1NameLabel = new JLabel("Player 1 name");
		JLabel player2NameLabel = new JLabel("Player 2 name");
		JTextField player1NameField = new JTextField("Alice");
		JTextField player2NameField = new JTextField("Bob");
		JButton startButton = new JButton("Start Game");

		add(player1NameLabel);
		add(player1NameField);
		add(player2NameLabel);
		add(player2NameField);
		add(startButton);
	}
}
