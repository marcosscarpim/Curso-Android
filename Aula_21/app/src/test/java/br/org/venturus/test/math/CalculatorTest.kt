package br.org.venturus.test.math

import org.junit.Assert
import org.junit.Test

internal class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun `test if adding two numbers returns the correct result`() {
        val result = calculator.sum(first = 2, second = 2)
        Assert.assertEquals(4, result)
    }

    @Test
    fun `test if subtracting two numbers returns the correct result`() {
        val result = calculator.sub(first = 3, second = 2)
        Assert.assertEquals(1, result)
    }

    @Test
    fun `test if 10 divided by 2 returns 5`() {
        val result = calculator.divide(dividend = 10.0, divisor = 2.0)
        Assert.assertEquals(5.0, result, 0.0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `test if any number divided by 0 throws error`() {
        calculator.divide(dividend = 1000.0, divisor = 0.0)
    }

    @Test
    fun `test if an even number returns true`() {
        val result = calculator.isEven(number = 2)
        Assert.assertTrue(result)
    }

    @Test
    fun `test if an odd number returns false`() {
        val result = calculator.isEven(number = 3)
        Assert.assertFalse(result)
    }

    @Test
    fun `test if 2 raised to 2nd power returns 4`() {
        val result = calculator.exponentiation(base = 2.0, exponent = 2.0)
        Assert.assertEquals(4.0, result, 0.0)
    }

    @Test
    fun `test if 2 raised to 10 power returns 1024`() {
        val result = calculator.exponentiation(base = 2.0, exponent = 10.0)
        Assert.assertEquals(1024.0, result, 0.0)
    }

    @Test
    fun `test if a prime number returns true`() {
        val result = calculator.isPrimeNumber(number = 7)
        Assert.assertTrue(result)
    }

    @Test
    fun `test if a composite number returns false`() {
        val result = calculator.isPrimeNumber(number = 10)
        Assert.assertFalse(result)
    }
}