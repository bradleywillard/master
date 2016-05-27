package org.bwillard.ccsf.course.cs211s.assn14.code_from_class;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BankAccountTest {
	
	private BankAccount account;
	private final static int INITIAL_BALANCE = 100;
	private final static double THRESHOLD = 0.0001;
	
	private double afterBalance, depositAmount;
	//private double afterBalanceW, withdrawAmount;
	
	public BankAccountTest(double afterBalance, double depositAmount) {
		this.afterBalance = afterBalance;
		this.depositAmount = depositAmount;
	}
	
	@Parameters
	public static Collection<Object[]> getInputs() {
		return Arrays.asList(new Object[][] {
			{100, 0},
			{100, -100},
			{150, 50}
			});
	}
	
	@Test
	public void testDepositParameterized() {
		System.out.println("inside test deposit with " + depositAmount);
		account.deposit(depositAmount);
		double result = account.getBalance();
		assertEquals(afterBalance, result, THRESHOLD);
	}
	
	@Before
	public void setup() {
		account = new BankAccount(INITIAL_BALANCE);
		System.out.println("In setup with new account");
	}
	
	//@Ignore
	@Test
	public void testDepositPositive() {
		int posValue = 50;
		
		double beforeBalance = account.getBalance();
		account.deposit(posValue);
		double afterBalance = account.getBalance();
		assertEquals(beforeBalance+posValue, afterBalance, THRESHOLD);
	}
	//@Ignore
	@Test
	public void testDepositNegative() {
		int negValue = -50;
		
		double beforeBalance = account.getBalance();
		account.deposit(negValue);
		double afterBalance = account.getBalance();
		assertEquals(beforeBalance, afterBalance, THRESHOLD);
	
	}
	
	@Test
	public void testWithdrawNegative() {
		System.out.println("testing withdraw negative");
		int negValue = -50;
		
		double beforeBalance = account.getBalance();
		account.withdraw(negValue);
		double result = account.getBalance();
		assertEquals(beforeBalance, result, THRESHOLD);
	}
	
	//
	
	@Ignore
	@Test
	public void testWithdrawBalance() {
		double beforeBalance = account.getBalance();
		account.withdraw(beforeBalance);
		double afterBalance = account.getBalance();
		assertEquals(0, afterBalance, THRESHOLD);
	}



}
