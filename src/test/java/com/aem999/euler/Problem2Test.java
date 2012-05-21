package com.aem999.euler;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Problem2Test {

    @Test
    public void canFindFibonacciSequence() {
        assertThat(new Problem2().findFibonacciSequence(89), is(asList(1, 2, 3, 5, 8, 13, 21, 34, 55, 89)));
    }

    @Test
    public void canFindSumOfEvenTermsInFibonacciSequence() {
        assertThat(new Problem2().findSumOfEvenTermsInFibonacciSequence(10), is(2 + 8L));
        assertThat(new Problem2().findSumOfEvenTermsInFibonacciSequence(100), is(2 + 8 + 34L));
        assertThat(new Problem2().findSumOfEvenTermsInFibonacciSequence(4000000), is(4613732L));
    }

    @Test
    public void canFindSumOfEvenTermsInFibonacciSequenceUsingOptimizedAlgorithm() {
        assertThat(new Problem2().findSumOfEvenTermsInFibonacciSequenceUsingOptimizedAlgorithm(10), is(2 + 8L));
        assertThat(new Problem2().findSumOfEvenTermsInFibonacciSequenceUsingOptimizedAlgorithm(100), is(2 + 8 + 34L));
        assertThat(new Problem2().findSumOfEvenTermsInFibonacciSequenceUsingOptimizedAlgorithm(4000000), is(4613732L));
    }

}
