class Account {

	private int balance;

	public static Account(){
		this.balance = 0;
	}

	public static int getBalance(){
		return this.balance;
	}

	public static void deposit(int amount){
		this.balance += amount;
	}

	public static void withdraw(int amount){
		this.balance -= amount;
	}

	public static void setBalance(int amount){
		this.balance = amount;
	}
}
