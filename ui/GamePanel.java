package ui;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GamePanel extends JPanel {
	private UserInterface userInterface;

	private JPanel player1Panel;
	private JPanel player2Panel;
	private JLabel player1NameLabel;
	private JLabel player2NameLabel;
	private JLabel player1BalanceLabel;
	private JLabel player2BalanceLabel;
	private JLabel feedbackLabel;
	private JButton playTurnButton;

	public GamePanel(UserInterface userInterface) {
		this.userInterface = userInterface;
		var language = userInterface.getLanguage();

		player1Panel = new JPanel(new GridBagLayout());
		player2Panel = new JPanel(new GridBagLayout());
		player1NameLabel = new JLabel("Player 1", SwingConstants.CENTER);
		player2NameLabel = new JLabel("Player 2", SwingConstants.CENTER);
		player1BalanceLabel = new JLabel("400$", SwingConstants.CENTER);
		player2BalanceLabel = new JLabel("300$", SwingConstants.CENTER);
		feedbackLabel = new JLabel("You landedn on ediei", SwingConstants.CENTER);
		playTurnButton = new JButton(language.get("playTurn"));

		playTurnButton.addActionListener((ActionEvent e) -> {
			this.userInterface.playTurnButtonPressed();
		});

		setBorder(new EmptyBorder(40, 40, 40, 40));
		player1Panel.setBorder(new EtchedBorder());
		player2Panel.setBorder(new EtchedBorder());
		playTurnButton.setMargin(new Insets(6, 14, 6, 14));

		var layout = new GridBagLayout();
		var constraints = new GridBagConstraints();

		layout.columnWeights = new double[] { 1.0, 1.0 };
		layout.rowWeights = new double[] { 0.5, 1.0, 0.5 };
		constraints.fill = GridBagConstraints.HORIZONTAL;

		setLayout(layout);

		constraints.insets = new Insets(10, 40, 10, 40);
		constraints.gridx = 0;
		player1Panel.add(player1NameLabel, constraints);
		player1Panel.add(player1BalanceLabel, constraints);
		player2Panel.add(player2NameLabel, constraints);
		player2Panel.add(player2BalanceLabel, constraints);
		constraints.gridx = GridBagConstraints.RELATIVE;

		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.gridy = 0;
		add(player1Panel, constraints);
		add(player2Panel, constraints);
		constraints.gridy++;
		constraints.gridwidth = 2;
		add(feedbackLabel, constraints);
		constraints.gridy++;
		add(playTurnButton, constraints);
	}

	public void updatePlayerNames(String player1Name, String player2Name) {
		player1NameLabel.setText(player1Name);
		player2NameLabel.setText(player2Name);
	}
}
