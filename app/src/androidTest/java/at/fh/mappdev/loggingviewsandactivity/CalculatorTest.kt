package at.fh.mappdev.loggingviewsandactivity

import Calculator
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CalculatorTest {
    @Test
    fun testMul2By2() {
        val calculator = Calculator()
        val result = calculator.parse("2 * 2")
        assertThat<Int>(4).isEqualTo(result)
    }

    @Test
    fun testAdd2By2() {
        val calculator = Calculator()
        val result = calculator.parse("2 + 2")
        assertThat<Int>(4).isEqualTo(result)
    }

    @Test
    fun testDiv2By2() {
        val calculator = Calculator()
        val result = calculator.parse("2 / 2")
        assertThat<Int>(1).isEqualTo(result)
    }

    @Test
    fun testSub2By2() {
        val calculator = Calculator()
        val result = calculator.parse("2 - 2")
        assertThat<Int>(0).isEqualTo(result)
    }
}

