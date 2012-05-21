package com.aem999.euler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.
 * <p>
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * </p>
 */
public class Problem1 implements EulerProblem<Long> {
    private static final Logger LOG = LoggerFactory.getLogger(Problem1.class);


    @Override
    public Long findAnswer() {
        return findSumOfTermsUsingCalculus(1000);
    }

    /**
     * Finds the sum of all multiples of 3 and 5 below {@code maxNumber}
     */
    public long findSumOfTerms(int maxNumber) {
        long sum = 0;
        for (int i = 3; i < maxNumber; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
                LOG.debug("[{}] is a multiple of 3 or 5", i);
            }
        }
        LOG.info("sum=[{}]", sum);
        return sum;
    }

    /**
     * Finds the sum of all multiples of 3 and 5 below {@code maxNumber}
     * <p>
     * This version used calculus to provide a better performing solution than {@link #findSumOfTerms(int)}
     * </p>
     */
    public long findSumOfTermsUsingCalculus(int maxNumber) {
        return findSumOfTerms(3, maxNumber) +
               findSumOfTerms(5, maxNumber) -
               findSumOfTerms(15, maxNumber);
    }

    /**
     * Returns the last term in the arithmetic sequence with difference {@code d},
     * up to but not including {@code maxNumber}
     */
    public int findLastTerm(int divisor, int maxNumber) {
        return (maxNumber - 1) / divisor * divisor;
    }

    /**
     * To find the sum of a certain number of terms of an arithmetic sequence:
     *
     * <pre>
     * S<sub>n</sub> = n(a<sub>1</sub> + a<sub>n</sub>) / 2</pre>
     *
     * where:
     *
     * <pre>
     * S<sub>n</sub> is the sum of n terms (nth partial sum),
     * a<sub>1</sub> is the first term
     * a<sub>n</sub> is the nth term</pre>
     *
     * @return the sum of the terms
     */
    public long findSumOfTerms(int a1, int an, int n) {
        return n * (a1 + an) / 2;
    }

    /**
     * To find any term of an arithmetic sequence:
     *
     * <pre>
     * a<sub>n</sub> = a<sub>1</sub> + (n - 1)d</pre>
     *
     * so to find the number of terms in an arithmetic sequence:
     *
     * <pre>
     * n = (a<sub>n</sub> - a<sub>1</sub> + d) / d</pre>
     *
     * where:
     *
     * <pre>
     * a1 is the first term of the sequence,
     * d is the common difference
     * n is the number of the term to find.</pre>
     */
    public int findNumberOfTerms(int a1, int an, int d) {
        return (an - a1 + d) / d;
    }


    private long findSumOfTerms(int d, int maxNumber) {
        int lastTerm = findLastTerm(d, maxNumber);
        int noOfTerms = findNumberOfTerms(d, lastTerm, d);
        return findSumOfTerms(d, lastTerm, noOfTerms);
    }


    public static void main(String[] args) {
        long answer = new Problem1().findAnswer();
        LOG.info("The answer is {}", answer);
    }
}
