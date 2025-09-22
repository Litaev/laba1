package demo.parallel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Complex Number Operations Tests")
class ComplexTest {

    private static final double DELTA = 0.0001;

    @Nested
    @DisplayName("Basic Arithmetic Operations")
    class BasicArithmeticTests {

        @Test
        @DisplayName("Addition of complex numbers")
        void testPlus() {
            Complex a = new Complex(3, 4);
            Complex b = new Complex(1, 2);
            a.plus(b);

            assertAll("Addition results",
                    () -> assertEquals(4, a.getRe(), DELTA, "Real part"),
                    () -> assertEquals(6, a.getIm(), DELTA, "Imaginary part")
            );
        }

        @Test
        @DisplayName("Multiplication of complex numbers")
        void testTimes() {
            Complex a = new Complex(2, 3);
            Complex b = new Complex(4, 5);
            a.times(b);

            assertAll("Multiplication results",
                    () -> assertEquals(-7, a.getRe(), DELTA, "Real part"),
                    () -> assertEquals(22, a.getIm(), DELTA, "Imaginary part")
            );
        }

        @Test
        @DisplayName("Subtraction of complex numbers")
        void testMinus() {
            Complex a = new Complex(5, 7);
            Complex b = new Complex(2, 3);
            a.minus(b);

            assertAll("Subtraction results",
                    () -> assertEquals(3, a.getRe(), DELTA, "Real part"),
                    () -> assertEquals(4, a.getIm(), DELTA, "Imaginary part")
            );
        }

        @Test
        @DisplayName("Division of complex numbers")
        void testDivide() {
            Complex a = new Complex(3, 2);
            Complex b = new Complex(1, 1);
            a.divide(b);

            assertAll("Division results",
                    () -> assertEquals(2.5, a.getRe(), DELTA, "Real part"),
                    () -> assertEquals(-0.5, a.getIm(), DELTA, "Imaginary part")
            );
        }
    }

    @Nested
    @DisplayName("Power Operations")
    class PowerTests {

        @Test
        @DisplayName("Zero power of complex number")
        void testPowerZero() {
            Complex a = new Complex(2, 3);
            a.power(0);

            assertAll("Zero power results",
                    () -> assertEquals(1, a.getRe(), DELTA, "Real part"),
                    () -> assertEquals(0, a.getIm(), DELTA, "Imaginary part")
            );
        }

        @Test
        @DisplayName("Square of complex number")
        void testPowerTwo() {
            Complex a = new Complex(2, 3);
            a.power(2);

            assertAll("Square results",
                    () -> assertEquals(-5, a.getRe(), DELTA, "Real part"),
                    () -> assertEquals(12, a.getIm(), DELTA, "Imaginary part")
            );
        }
    }

    @Nested
    @DisplayName("Exponential and Logarithmic Functions")
    class ExponentialLogarithmicTests {

        @Test
        @DisplayName("Exponential of zero")
        void testExpZero() {
            Complex a = new Complex(0, 0);
            a.exp();

            assertAll("Exponential of zero results",
                    () -> assertEquals(1, a.getRe(), DELTA, "Real part"),
                    () -> assertEquals(0, a.getIm(), DELTA, "Imaginary part")
            );
        }

        @Test
        @DisplayName("Exponential of real number")
        void testExpReal() {
            Complex a = new Complex(1, 0);
            a.exp();

            assertAll("Exponential of real number results",
                    () -> assertEquals(Math.E, a.getRe(), DELTA, "Real part"),
                    () -> assertEquals(0, a.getIm(), DELTA, "Imaginary part")
            );
        }

        @Test
        @DisplayName("Logarithm of one")
        void testLogOne() {
            Complex a = new Complex(1, 0);
            a.log();

            assertAll("Logarithm of one results",
                    () -> assertEquals(0, a.getRe(), DELTA, "Real part"),
                    () -> assertEquals(0, a.getIm(), DELTA, "Imaginary part")
            );
        }
    }

    @Nested
    @DisplayName("Trigonometric Functions")
    class TrigonometricTests {

        @Test
        @DisplayName("Sine of zero")
        void testSinZero() {
            Complex a = new Complex(0, 0);
            a.sin();

            assertAll("Sine of zero results",
                    () -> assertEquals(0, a.getRe(), DELTA, "Real part"),
                    () -> assertEquals(0, a.getIm(), DELTA, "Imaginary part")
            );
        }

        @Test
        @DisplayName("Cosine of zero")
        void testCosZero() {
            Complex a = new Complex(0, 0);
            a.cos();

            assertAll("Cosine of zero results",
                    () -> assertEquals(1, a.getRe(), DELTA, "Real part"),
                    () -> assertEquals(0, a.getIm(), DELTA, "Imaginary part")
            );
        }
    }

    @Nested
    @DisplayName("Utility Methods")
    class UtilityTests {

        @Test
        @DisplayName("Absolute value calculation")
        void testAbs() {
            Complex a = new Complex(3, 4);
            double abs = a.abs();

            assertEquals(5, abs, DELTA, "Absolute value of 3+4i");
        }

        @Test
        @DisplayName("Squared length calculation")
        void testLengthSQ() {
            Complex a = new Complex(3, 4);
            double lengthSQ = a.lengthSQ();

            assertEquals(25, lengthSQ, DELTA, "Squared length of 3+4i");
        }

        @Test
        @DisplayName("Copy creation")
        void testCopy() {
            Complex original = new Complex(2, 3);
            Complex copy = original.copy();

            assertAll("Copy results",
                    () -> assertEquals(original.getRe(), copy.getRe(), DELTA, "Real part equality"),
                    () -> assertEquals(original.getIm(), copy.getIm(), DELTA, "Imaginary part equality")
            );
        }
    }

    @Test
    @DisplayName("Test mathematical identity: ln(e^z) = z")
    void testExponentialLogarithmIdentity() {
        Complex z = new Complex(2, 3);
        Complex expZ = z.copy().exp();
        Complex lnExpZ = expZ.copy().log();

        assertAll("Exponential-logarithm identity",
                () -> assertEquals(z.getRe(), lnExpZ.getRe(), DELTA, "Real part identity"),
                () -> assertEquals(z.getIm(), lnExpZ.getIm(), DELTA, "Imaginary part identity")
        );
    }

    @Test
    @DisplayName("Test complex conjugate multiplication")
    void testConjugateMultiplication() {
        Complex a = new Complex(3, 4);
        Complex conjugate = new Complex(3, -4);

        Complex product = a.copy().times(conjugate);

        assertAll("Conjugate multiplication results",
                () -> assertEquals(25, product.getRe(), DELTA, "Real part should be sum of squares"),
                () -> assertEquals(0, product.getIm(), DELTA, "Imaginary part should be zero")
        );
    }
}