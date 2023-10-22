public class GameController {
	Player player1 = new Player();
	Player player2 = new Player();

	DiceCup diceCup = new DiceCup();

	Square[] squares = new Square[11];
	// Need to add in all the squares in the array, but it dont work for me so
	// please NOAH FIX IT I BEG

	public void playGame() {
		boolean isPlayerTwo = false;
		Player currentPlayer;
		try {
			// Sets the names from the UI
			player1.setName = (language.get("player1Name"));
			player2.setName = (language.get("player2Name"));

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
		player.getAccount.deposit(squares[sum].moneyValue);
		// Label change to where they landed, and their new balance

	}

	public boolean checkWin(Player player) {
		// vind hvis der er flere penge end 3000
		return player.getAccount.getBalance() >= 3000;

	}

	public static void main(String[] args) {
		var game = new GameController();
		game.playGame();
	}
}
