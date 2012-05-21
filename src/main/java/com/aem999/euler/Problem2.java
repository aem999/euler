package com.aem999.euler;

import java.util.List;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Finds the sum of the even-valued terms in the Fibonacci sequence whose values do not exceed four million.
 */
public class Problem2 {
    private static final Logger LOG = LoggerFactory.getLogger(Problem2.class);

    public List<Integer> findFibonacciSequence(int maxValue) {
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

        return sequence;
    }

    public long findSumOfEvenTermsInFibonacciSequence(int maxValue) {
        LOG.debug("Finding sum of fibonacci sequence up to term [{}]", maxValue);
        List<Integer> sequence = findFibonacciSequence(maxValue);

        long sum = 0;
        for (int term: sequence) {
            if (term % 2 == 0) {
                sum+= term;
                LOG.debug("Summing term [{}]", term);
            }
        }
        return sum;
    }
}
