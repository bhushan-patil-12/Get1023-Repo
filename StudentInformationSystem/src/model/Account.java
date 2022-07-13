package model;

import java.time.LocalDate;

public class Account {
	int accountNo;
	double balance;
	LocalDate transactionDate;
	
	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
