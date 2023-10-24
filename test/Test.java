class Test {
	public static void main(String[] args){
			var account = new game.Account();
			System.out.println("start balance: " + account)
			account.deposit(3000)
			System.out.println("test deposit 3000: " + account);
			account.withdraw(3400);
			System.out.println("test withdraw 3400: " + account);
			System.out.println("withdraw overdraw true or false: " + account.withdraw(1000));
			System.out.println("test withdraw 1000: " + account);

		}
}
