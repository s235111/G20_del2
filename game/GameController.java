package game;

public class GameController {
	Player player1 = new Player();
	Player player2 = new Player();

	DiceCup diceCup = new DiceCup();
	boolean isPlayerTwo = false;
	Player currentPlayer;

	Square[] squares = new Square[] {
			null,
			null,
			new Square("square2", 250, false),
			new Square("square3", -100, false),
			new Square("square4", 100, false),
			new Square("square5", -20, false),
			new Square("square6", 180, false),
			new Square("square7", 0, false),
			new Square("square8", -70, false),
			new Square("square9", 60, false),
			new Square("square10", -80, true),
			new Square("square11", -50, false),
			new Square("square12", 650, false),
	};

	public void startGame() {
		player1.getAccount().setBalance(1000);
		player2.getAccount().setBalance(1000);
	}

	public void playNextTurn() {
		currentPlayer = isPlayerTwo ? player2 : player1;

		playTurn(currentPlayer);

		if (checkWin(currentPlayer)) {
			return;
		}

		isPlayerTwo = !isPlayerTwo;
	}

	public void playTurn(Player player) {

		diceCup.rollDice();
		var sum = diceCup.getSum();
		player.getAccount().deposit(squares[sum].moneyValue);
		// Label change to where they landed, and their new balance

	}

	public boolean checkWin(Player player) {
		// The player wins if they have a balance of at least 3000
		return player.getAccount().getBalance() >= 3000;
	}

	public void setPlayerNames(String player1Name, String player2Name) {
		player1.setName(player1Name);
		player2.setName(player2Name);
	}

	public int getPlayer1Balance() {
		return player1.getAccount().getBalance();
	}

	public int getPlayer2Balance() {
		return player2.getAccount().getBalance();
	}

	public boolean isPlayerTwo() {
		return isPlayerTwo;
	}

	public boolean hasCurrentPlayerWon() {
		return checkWin(currentPlayer);
	}

	public Square getSquare() {
		return squares[diceCup.getSum()];
	}

	public int getSum() {
		return diceCup.getSum();
	}

	public int getdie1() {
		return diceCup.getDie1();
	}

	public int getdie2() {
		return diceCup.getDie2();
	}
}
