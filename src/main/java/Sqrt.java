public class Sqrt {
    /**
     * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
     *
     * You must not use any built-in exponent function or operator.
     *
     * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
     *
     *
     * Example 1:
     *
     * Input: x = 4
     * Output: 2
     * Explanation: The square root of 4 is 2, so we return 2.
     * Example 2:
     *
     * Input: x = 8
     * Output: 2
     * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
     *
     *
     * Constraints:
     *
     * 0 <= x <= 231 - 1
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        /**
         * Returns the correctly rounded positive square root of a double value. Special cases:
         * If the argument is NaN or less than zero, then the result is NaN.
         * If the argument is positive infinity, then the result is positive infinity.
         * If the argument is positive zero or negative zero, then the result is the same as the argument.
         * Otherwise, the result is the double value closest to the true mathematical square root of the argument value.
         * Params:
         * a – a value.
         * Returns:
         * the positive square root of a. If the argument is NaN or less than zero, the result is NaN.
         */
       return (int) Math.sqrt(x);
    }
}
