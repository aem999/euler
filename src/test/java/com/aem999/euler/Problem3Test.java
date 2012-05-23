package com.aem999.euler;

import java.util.Arrays;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Problem3Test {

    @Test
    public void canSolveProblem() throws Exception {
        assertThat(new Problem3().findAnswer(), is(6857));
    }

    @Test
    public void canFindPrimes() {
        assertThat(new Problem3().findPrimes(10), is(Arrays.asList(2, 3, 5, 7)));
        assertThat(new Problem3().findPrimes(19), is(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19)));
    }

    @Test
    public void canFindPrimeFactors() {
        assertThat(new Problem3().findPrimeFactors(15L), is(Arrays.asList(3, 5)));
        assertThat(new Problem3().findPrimeFactors(13195L), is(Arrays.asList(5, 7, 13, 29)));
        assertThat(new Problem3().findPrimeFactors(600851475143L), is(Arrays.asList(71, 839, 1471, 6857)));
    }

    @Test
    public void canFindPrimeFactorsUsingOptimizedAlgorithm() {
        assertThat(new Problem3().findPrimeFactorsUsingOptimizedAlgorithm(15L), is(Arrays.asList(3, 5)));
        assertThat(new Problem3().findPrimeFactorsUsingOptimizedAlgorithm(13195L), is(Arrays.asList(5, 7, 13, 29)));
        assertThat(new Problem3().findPrimeFactorsUsingOptimizedAlgorithm(600851475143L), is(Arrays.asList(71, 839, 1471, 6857)));
    }
}
