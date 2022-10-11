package br.org.venturus.test.math

import kotlin.math.pow

internal class Calculator {

    fun sum(first: Int, second: Int): Int {
        return first + second
    }

    fun sub(first: Int, second: Int): Int {
        return first - second
    }

    fun divide(dividend: Double, divisor: Double): Double {
        if (divisor == 0.0) {
            throw IllegalArgumentException("Divisor can not be zero.")
        }
        return dividend / divisor
    }

    fun isEven(number: Int): Boolean {
        return number % 2 == 0
    }

    fun exponentiation(base: Double, exponent: Double): Double {
        return base.pow(exponent)
    }

    fun isPrimeNumber(number: Int): Boolean {
        for (i in 2..number / 2) {
            if (number % i == 0) {
                return false
            }
        }
        return true
    }
}