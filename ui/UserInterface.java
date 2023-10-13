package ui;

import javax.swing.*;

class UserInterface extends JFrame {
	public UserInterface() {
		setContentPane(new NewGamePanel());
		setTitle("Premonopoly");
		setLayout(null);
		setVisible(true);
		var insets = getInsets();
		var innerWidth = 400;
		var innerHeight = 300;
		setSize(innerWidth + insets.left + insets.right, innerHeight + insets.top + insets.bottom);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		var ui = new UserInterface();
	}
}
