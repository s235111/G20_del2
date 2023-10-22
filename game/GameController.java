public class GameController {
	Player player1 = new Player();
	Player player2 = new Player();

	DiceCup diceCup = new DiceCup();

	Square[] squares = new Square[11];

	public void playGame() {
		boolean isPlayerTwo = false;
		Player currentPlayer;

		player1.setName = (language.get("player1Name"));
		player2.setName = (language.get("player2Name"));



		while (true) {
			currentPlayer = isPlayerTwo ? player2 : player1;
			//Something change label to currentplayer
			//Display current info

			playTurn(currentPlayer) {

			}



		}



	}

	public void playTurn(Player player) {

		diceCup.rollDice();
		var sum = diceCup.getSum();
		player.getAccount.deposit(squares[sum].moneyValue);

		player.addPoints(sum);

	}

	public boolean checkWin(Player player) {
		// vind hvis der er flere penge end 3000
		return player.getAccount.getBalance() >= 3000;

	}

	public static void main(String[] args) {

	}
}
