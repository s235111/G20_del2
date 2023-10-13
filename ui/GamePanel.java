package ui;

import javax.swing.*;

public class GamePanel extends JPanel {
	private JLabel player1Label;
	private JLabel player2Label;
	private JButton playTurnButton;

	public GamePanel() {
		player1Label = new JLabel();
		player2Label = new JLabel();
		playTurnButton = new JButton();

		add(player1Label);
		add(player2Label);
		add(playTurnButton);
	}
}
