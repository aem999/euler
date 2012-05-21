package com.aem999.euler;

import java.util.List;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * the first 10 terms will be:
 * <pre>1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...</pre>
 * <p>
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the
 * even-valued terms.</p>
 */
public class Problem2 implements EulerProblem<Long> {
    private static final Logger LOG = LoggerFactory.getLogger(Problem2.class);
    private static final int FOUR_MILLION = 4_000_000;

    /**
     * Solves the problem and returns the answer
     */
    @Override
    public Long solve() {
        return findSumOfEvenTermsInFibonacciSequenceUsingOptimizedAlgorithm(FOUR_MILLION);
    }

    /**
     * Finds the the Fibonacci sequence starting at 1, 2 and terminating at {@code maxValue}
     */
    public List<Integer> findFibonacciSequence(int maxValue) {
        LOG.debug("Finding the fibonacci sequence up to term [{}]", maxValue);

        int previous = 1;
        int current = 2;
        int term = current + previous;
        List<Integer> sequence = Lists.newArrayList(previous, current);

        while (term <= maxValue)  {
            sequence.add(term);
            previous = current;
            current = term;
            term = current + previous;
        }

        LOG.debug("The fibonacci sequence terminating at [{}] is {}", maxValue, sequence);
        return sequence;
    }

    /**
     * Finds the sum of even terms in the Fibonacci sequence terminating at {@code maxValue}
     */
    public long findSumOfEvenTermsInFibonacciSequence(int maxValue) {
        LOG.debug("Finding the sum of even terms in the fibonacci sequence up to term [{}]", maxValue);

        List<Integer> sequence = findFibonacciSequence(maxValue);
        long sum = 0;

        for (int term: sequence) {
            if (term % 2 == 0) {
                sum+= term;
                LOG.debug("Summing term [{}]", term);
            }
        }

        LOG.debug("The sum of even terms in the fibonacci sequence terminating at [{}] is [{}]", maxValue, sum);
        return sum;
    }

    /**
     * Finds the sum of even terms in the Fibonacci sequence terminating at {@code maxValue},
     * using the knowledge that every 3rd term in a Fibonacci sequence is even:
     * <pre>1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...</pre>
     * we can generalise this to:
     * <pre>x, y, x+y, x+2y, 2x+3y, 3x+5y</pre>
     * so given the starting values of x=1, y=2, the next 2 even terms will be:
     * <pre>x+2y and 2x+3y</pre>
     */
    public long findSumOfEvenTermsInFibonacciSequenceUsingOptimizedAlgorithm(int maxValue) {
        LOG.debug("Finding the sum of even terms in the fibonacci sequence up to term [{}] using an optimized algorithm", maxValue);

        long sum = 0;
        int x = 1;
        int y = 2;

        while (y <= maxValue) {
            LOG.debug("Summing term [{}]", y);
            sum += y;
            int new_x = x + (2 * y);
            int new_y = (2 * x) + (3 * y);
            x = new_x;
            y = new_y;
        }

        LOG.debug("The sum of even terms in the fibonacci sequence terminating at [{}] is [{}]", maxValue, sum);
        return sum;
    }

    public static void main(String[] args) {
        long answer = new Problem2().solve();
        LOG.info("The answer is {}", answer);
    }
}