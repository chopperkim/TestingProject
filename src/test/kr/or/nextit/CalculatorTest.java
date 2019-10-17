package kr.or.nextit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testSum() {
		double result = Calculator.sum(4, 5);
		assertTrue("9가 나와야 하는데...", result == 9);
	}

	@Test
	public void testSubtract() {
		double result = Calculator.subtract(4, 5);
		assertTrue("9가 나와야 하는데...", result == -1);
	}

	@Test
	public void testMultiply() {
		double result = Calculator.multiply(4, 5);
		assertTrue("9가 나와야 하는데...", result == 20);
	}

	@Test
	public void testDivide() {
		double result = Calculator.divide(10, 5);
		assertTrue("9가 나와야 하는데...", result == 2);
	}

}
