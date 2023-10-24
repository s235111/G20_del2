package game;

public class GameController {
	Player player1 = new Player();
	Player player2 = new Player();

	DiceCup diceCup = new DiceCup();

	Square[] squares = new Square[] {
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

	public void playGame() {
		boolean isPlayerTwo = false;
		Player currentPlayer;
		try {
			// Sets the names from the UI
			// player1.setName = (language.get("player1Name"));
			// player2.setName = (language.get("player2Name"));
			player1.setName("player1");
			player1.setName("player2");
			while (true) {
				currentPlayer = isPlayerTwo ? player2 : player1;
				// Something change label to currentplayer
				// Display current info

				playTurn(currentPlayer);
				if (checkWin(currentPlayer)) {
					// label change, to currentplayer wins
					// label change, to otherplayer looses
					break;
				}
				// Switches the turn
				isPlayerTwo = !isPlayerTwo;

			}

		} catch (java.util.NoSuchElementException e) {
			// This happens when you press Ctrl+C
			// Simply ignore the exception in this case
		} catch (Exception e) {
			System.err.println("\033[J\033[31mSomething went wrong\033[m");
			e.printStackTrace();
		} finally {
		}
	}

	public void playTurn(Player player) {

		diceCup.rollDice();
		var sum = diceCup.getSum();
		player.getAccount().deposit(squares[sum].moneyValue);
		// Label change to where they landed, and their new balance

	}

	public boolean checkWin(Player player) {
		// vind hvis der er flere penge end 3000
		return player.getAccount().getBalance() >= 3000;

	}

	public int getPlayer1Balance() {
		return player1.getAccount().getBalance();
	}

	public int getPlayer2Balance() {
		return player2.getAccount().getBalance();
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

	public static void main(String[] args) {
		var ui = new ui.UserInterface();
		var game = new GameController();
		game.playGame();
	}
}
