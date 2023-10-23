package ui;

import game.Languages;
import javax.swing.*;
import java.awt.event.ActionEvent;

class NewGamePanel extends JPanel {
	private LanguageProvider languageProvider;

	JLabel languageLabel;
	JComboBox<String> languageBox;
	JLabel player1NameLabel;
	JLabel player2NameLabel;
	JTextField player1NameField;
	JTextField player2NameField;
	JButton startButton;

	public NewGamePanel(LanguageProvider languageProvider) {
		this.languageProvider = languageProvider;

		languageLabel = new JLabel();
		languageBox = new JComboBox<String>(Languages.getAvailableLanguages());
		player1NameLabel = new JLabel();
		player2NameLabel = new JLabel();
		player1NameField = new JTextField();
		player2NameField = new JTextField();
		startButton = new JButton();

		languageBox.addActionListener((ActionEvent e) -> {
			languageProvider.setLanguage((String) languageBox.getSelectedItem());
			updateLanguage();
		});

		languageBox.setSelectedItem("English");

		add(languageLabel);
		add(languageBox);
		add(player1NameLabel);
		add(player1NameField);
		add(player2NameLabel);
		add(player2NameField);
		add(startButton);

		updateLanguage();
	}

	private void updateLanguage() {
		var language = languageProvider.getLanguage();

		languageLabel.setText(language.get("language"));
		player1NameLabel.setText(language.get("player1Name"));
		player2NameLabel.setText(language.get("player2Name"));
		startButton.setText(language.get("startGame"));
	}
}
