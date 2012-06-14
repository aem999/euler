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
        return findLargestPalindrome(3);
    }

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
