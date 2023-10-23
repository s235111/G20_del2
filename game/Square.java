package game;

public class Square {

	String nameToken;
	int moneyValue;
	boolean extraTurn;

	public String getNameToken() {
		return this.nameToken;
	}

	public void setNameToken(String newName) {
		this.nameToken = newName;
	}

	public int getMoneyValue() {
		return this.moneyValue;
	}

	public void setMoneyValue(int newValue) {
		this.moneyValue = newValue;
	}

	public boolean getExtraTurn() {
		return this.extraTurn;
	}

	public void setExtraTurn(boolean newTurn) {
		this.extraTurn = newTurn;

	}

}
