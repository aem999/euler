package com.aem999.euler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit
 * numbers is 9009 = 91 * 99.
 * <p>
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * </p>
 */
public class Problem4 implements EulerProblem<Integer> {
    private static final Logger LOG = LoggerFactory.getLogger(Problem4.class);

    @Override
    public Integer findAnswer() {
        return findLargestPalindromeUsingOptimizedAlgorithm();
    }

    /**
     * Find the largest palindrome made from the product of two numbers containing {@code noOfDigits} digits.
     */
    public Integer findLargestPalindrome(int noOfDigits) {
        int max = (int) Math.pow(10, noOfDigits) - 1;
        int min = (int) Math.pow(10, noOfDigits - 1);
        int largestPalindrome = 0;
        int product;
        for (int i = max; i > min; i--) {
            for (int j = max; j > min; j--) {
                product = i * j;
                if (isPalindrome(product) && product > largestPalindrome) {
                    largestPalindrome = product;
                    LOG.debug("Palindrome [{}] found for factors [{} * {}]", new Object[]{product, i, j});
                }
            }
        }
        return largestPalindrome;
    }

    /**
     * Find the largest palindrome made from the product of two numbers containing 3 digits.
     * We know that the palindrome must be at least 6 digits long since the palindrome 111111 = 143×777
     * i.e. the product of two 3-digit integers. Since P is palindromic:
     * <pre>
     * P = 100000x + 10000y + 1000z + 100z + 10y + x
     * P = 100001x + 10010y + 1100z
     * P = 11(9091x + 910y + 100z)
     * </pre>
     * Since 11 is prime, at least one of the integers a or b must have a factor of 11.
     * So if a is not divisible by 11 then we know b must be. Using this information
     * we can determine what values of b we check depending on a.
     */
    public Integer findLargestPalindromeUsingOptimizedAlgorithm() {
        int largestPalindrome = 0;
        int a = 999;
        int b;
        int decrement;
        while (a >= 100) {
            if (a % 11 == 0) {
                b = 999;
                decrement = 1;
            } else {
                b = 990; //The largest number less than or equal 999 and divisible by 11
                decrement = 11;
            }
            while (b >= a) {
                int product = a * b;
                if (product <= largestPalindrome) {
                    break;
                }
                if (isPalindrome(product)) {
                    largestPalindrome = product;
                    LOG.debug("Palindrome [{}] found for factors [{} * {}]", new Object[]{product, a, b});
                }
                b -= decrement;
            }
            a -= 1;
        }
        return largestPalindrome;
    }

    public boolean isPalindrome(Integer product) {
        char[] chars = String.valueOf(product).toCharArray();
        int midPoint = chars.length / 2;
        for (int i=0; i <= midPoint; i++) {
            int j = chars.length - i - 1;
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }
}
