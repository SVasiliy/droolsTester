package droolscours;

public class Account {

	private long accountNo;
	private double balance;
	
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountno) {
		this.accountNo = accountno;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
		
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", balance=" + balance + "]";
	}
}
